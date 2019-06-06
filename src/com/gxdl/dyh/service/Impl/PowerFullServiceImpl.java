package com.gxdl.dyh.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxdl.dyh.dao.PowerFullMapper;
import com.gxdl.dyh.service.PowerFullService;
import com.gxdl.dyh.service.UserInfoService;
import com.gxdl.dyh.utils.ResPouseUtil;

import net.sf.json.JSONObject;

import com.gxdl.dyh.po.PageBean;
import com.gxdl.dyh.po.PsFullmoneyLog;
import com.gxdl.dyh.po.SelectUserInfoandfullmoneylog;
import com.gxdl.dyh.po.UseConumer;
import com.gxdl.dyh.po.UserMsgAndMoney;
import com.gxdl.dyh.po.Userfullmoney;


@Service("powerFullService")
public class PowerFullServiceImpl implements PowerFullService {
	/**
	 * 日志输出
	 */
	private Logger logger = LoggerFactory.getLogger(PowerFullServiceImpl.class);
	
	@Autowired
	private PowerFullMapper powerFullMapper;
	@Autowired
	private UserInfoService userInfoService;
	/**
	 * 在页面加载的时候获取用户的昵称、账户名、所剩余额
	 */
	@Override
	public JSONObject getUserMsgAndMoney(String userToken) {
		JSONObject jsonObject = new JSONObject();
		try {
			if(userToken != null && userToken.length() > 0){
				UserMsgAndMoney userMsgAndMoney=this.powerFullMapper.getUserMsgAndMoney(userToken);
				if(userMsgAndMoney == null){
					jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.FAIL);
					logger.info("/UserInfoServiceImpl/getUserMsgAndMoney UserMsgAndMoney Object is NULL");
					return jsonObject;
				}
				jsonObject.put("userid",userMsgAndMoney.getUsedId());
				jsonObject.put("username",userMsgAndMoney.getUsername());
				jsonObject.put("accounts", userMsgAndMoney.getAccounts());
				jsonObject.put("surplusMoney", userMsgAndMoney.getSurplusMoney());
				jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.SUCCESS);
				return jsonObject;
			}else{
				jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.FAIL);
				logger.info("/UserInfoServiceImpl/getUserMsgAndMoney userToken is NULL");
				return jsonObject;
			}
		} catch (Exception e) {
			System.out.println("/UserInfoServiceImpl/getUserMsgAndMoney Exception : "+e.getMessage());
			logger.error("/UserInfoServiceImpl/getUserMsgAndMoney Exception:"+e.getMessage());
			return null;
		}
	}

	
	/**
	 * 用户对账户进行充值
	 * @param username
	 * @param accounts
	 * @param fullMoney
	 * @return
	 */
	@Override
	public JSONObject insertFullMoney(String userId,String username, String accounts, String fullMoney,String password) {
		JSONObject jsonObject = new JSONObject();
		try {
			//校验用户的身份
			if(username != null && password != null) {
				Map<String,String> map = this.userInfoService.verifyPassword(username, password);
				if(map == null || map.get(ResPouseUtil.SUCCESS_KRY).equals(ResPouseUtil.FAIL)) {
					jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.FAIL);
					return jsonObject;
				}
			}
			//查询一下用户的此次没有充值之前的剩余电量和剩余金额
			if(userId != null && accounts != null && fullMoney != null){
				UseConumer useConumer = this.powerFullMapper.getOriginalPowerMoney(userId, accounts);
				if(useConumer == null) {
					jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.FAIL);
					return jsonObject;
				}
				//此处的数据从系统参数表中获得
			    BigDecimal param = new BigDecimal(0.5); //这每度点的价钱
			    BigDecimal fullMoneyDecimal = new BigDecimal(fullMoney); ///当前充值的金额
			    BigDecimal powerNumber = fullMoneyDecimal.divide(param,2,BigDecimal.ROUND_HALF_UP);//powerNumber是根据用户的充值金额和每度点的价钱计算出来的总电量
			    BigDecimal finalMoney = fullMoneyDecimal.add(useConumer.getSurplus_money());//当前充值的金额加上原来剩余的金额就是目前总共的金额
			    BigDecimal finalpowerNumber=powerNumber.add(useConumer.getElectricitynumber());//当前计算出来的充值电量加上原来剩余的电量就是目前总共的电量
				Integer result = this.powerFullMapper.insertFullMoney(userId,username, accounts, finalMoney.toString(),finalpowerNumber.toString());
				//添加支付记录信息
				Userfullmoney userfullmoney = new Userfullmoney(Long.parseLong(userId),accounts,useConumer.getSurplus_money(),fullMoneyDecimal,new Date());
				this.powerFullMapper.insertFullMoneylog(userfullmoney);
				if(result <= 0) {
					jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.FAIL);
					System.out.println("/UserInfoServiceImpl/insertFullMoney "+username+" fullMoney not Successfaully");
					logger.error("/UserInfoServiceImpl/insertFullMoney "+username+" fullMoney not Successfaully");
					return jsonObject;
				}
				jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.SUCCESS);
				return jsonObject;
			}else{
				jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.FAIL);
				System.out.println("/UserInfoServiceImpl/insertFullMoney Exception Param value is NUll");
				logger.error("/UserInfoServiceImpl/insertFullMoney Exception Param value is NUll");
				return jsonObject;
			}
		} catch (Exception e) {
			jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.FAIL);
			System.out.println("/UserInfoServiceImpl/insertFullMoney Exception : "+e.getMessage());
			logger.error("/UserInfoServiceImpl/insertFullMoney Exception:"+e.getMessage());
			return jsonObject;
		}
	}


	@Override
	public List<Map<String,Object>> selectFullMoneymsg(String userToken,Integer currentPage) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

		Map <String,Object> datamap=new HashMap<String,Object>();//把数据封装到map
		datamap.put("userToken", userToken);
		datamap.put("currentPage", currentPage);
		List<Map<String,Object>> selectuam=powerFullMapper.selectFullMoneylog(datamap);
		System.out.println(selectuam);
//		String accounts=selectuam.getAccounts();
//		String countpage=this.powerFullMapper.selectFullMoneycount(accounts);
		/*for (Map<String, Object> map : selectuam) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", psFullmoneyLog.getId());
			map.put("userid", psFullmoneyLog.getUserid());
			map.put("accounts", psFullmoneyLog.getAccounts());
			map.put("fullmoney", psFullmoneyLog.getFullmoney());
			map.put("surplusmoney", psFullmoneyLog.getSurplusmoney());
			map.put("fulltime", psFullmoneyLog.getFulltime());
			list.add(map);
		}*/
		/*while (selectuam.next()) {
			Map map = new HashMap<>();
			String username = selectuam.getUsername();
			String accounts = selectuam.getAccounts();
			String surplusmoney = selectuam.getSurplusmoney();
			String fullmoney = selectuam.getFullmoney();
			String fulltime = selectuam.getFulltime();
			map.put("username", username);
			map.put("accounts", accounts);
			map.put("surplusmoney", surplusmoney);
			map.put("fullmoney", fullmoney);
			map.put("fulltime", fulltime);
			list.add(map);
		}*/
		 
		return selectuam;
	}


	@Override
	public PageBean<Map<String, Object>> pageQuery(int currentPage,int pageSize,String userToken) {
		//封装PageBean
        PageBean<Map<String, Object>> pb = new PageBean<Map<String, Object>>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        
        //设置总记录数
        int totalCount = powerFullMapper.findTotalCount(userToken);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;//开始的记录数
        
        Map <String,Object> datamap=new HashMap<String,Object>();//把数据封装到map
		datamap.put("userToken", userToken);
		datamap.put("start", start);
		datamap.put("pageSize", pageSize);
        List<Map<String, Object>> list = powerFullMapper.findByPage(datamap);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :(totalCount / pageSize) + 1 ;
        pb.setTotalPage(totalPage);
		return pb;
	}

}
