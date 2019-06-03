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

import com.gxdl.dyh.po.SelectUserInfoandfullmoneylog;
import com.gxdl.dyh.po.UseConumer;
import com.gxdl.dyh.po.UserMsgAndMoney;
import com.gxdl.dyh.po.Userfullmoney;


@Service("powerFullService")
public class PowerFullServiceImpl implements PowerFullService {
	/**
	 * ��־���
	 */
	private Logger logger = LoggerFactory.getLogger(PowerFullServiceImpl.class);
	
	@Autowired
	private PowerFullMapper powerFullMapper;
	@Autowired
	private UserInfoService userInfoService;
	/**
	 * ��ҳ����ص�ʱ���ȡ�û����ǳơ��˻�������ʣ���
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
	 * �û����˻����г�ֵ
	 * @param username
	 * @param accounts
	 * @param fullMoney
	 * @return
	 */
	@Override
	public JSONObject insertFullMoney(String userId,String username, String accounts, String fullMoney,String password) {
		JSONObject jsonObject = new JSONObject();
		try {
			//У���û������
			if(username != null && password != null) {
				Map<String,String> map = this.userInfoService.verifyPassword(username, password);
				if(map == null || map.get(ResPouseUtil.SUCCESS_KRY).equals(ResPouseUtil.FAIL)) {
					jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.FAIL);
					return jsonObject;
				}
			}
			//��ѯһ���û��Ĵ˴�û�г�ֵ֮ǰ��ʣ�������ʣ����
			if(userId != null && accounts != null && fullMoney != null){
				UseConumer useConumer = this.powerFullMapper.getOriginalPowerMoney(userId, accounts);
				if(useConumer == null) {
					jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.FAIL);
					return jsonObject;
				}
				//�˴������ݴ�ϵͳ�������л��
			    BigDecimal param = new BigDecimal(0.5); //��ÿ�ȵ�ļ�Ǯ
			    BigDecimal fullMoneyDecimal = new BigDecimal(fullMoney); ///��ǰ��ֵ�Ľ��
			    BigDecimal powerNumber = fullMoneyDecimal.divide(param,2,BigDecimal.ROUND_HALF_UP);//powerNumber�Ǹ����û��ĳ�ֵ����ÿ�ȵ�ļ�Ǯ����������ܵ���
			    BigDecimal finalMoney = fullMoneyDecimal.add(useConumer.getSurplus_money());//��ǰ��ֵ�Ľ�����ԭ��ʣ��Ľ�����Ŀǰ�ܹ��Ľ��
			    BigDecimal finalpowerNumber=powerNumber.add(useConumer.getElectricitynumber());//��ǰ��������ĳ�ֵ��������ԭ��ʣ��ĵ�������Ŀǰ�ܹ��ĵ���
				Integer result = this.powerFullMapper.insertFullMoney(userId,username, accounts, finalMoney.toString(),finalpowerNumber.toString());
				//���֧����¼��Ϣ
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
	public List<Map> selectFullMoneymsg(String userToken,Integer currentPage) {
		// TODO Auto-generated method stub
		List<Map> list = new ArrayList<Map>();
		SelectUserInfoandfullmoneylog selectuam=powerFullMapper.selectFullMoneylog(userToken,currentPage);
		System.out.println(selectuam);
		String accounts=selectuam.getAccounts();
		String countpage=this.powerFullMapper.selectFullMoneycount(accounts);
		/*
		 * while(selectuam.next()) { Map map = new HashMap<>(); String username =
		 * selectuam.getUsername(); String accounts = selectuam.getAccounts(); String
		 * surplusmoney = selectuam.getSurplusmoney(); String fullmoney =
		 * selectuam.getFullmoney(); String fulltime = selectuam.getFulltime();
		 * map.put("username",username); map.put("accounts",accounts);
		 * map.put("surplusmoney",surplusmoney); map.put("fullmoney",fullmoney);
		 * map.put("fulltime",fulltime); list.add(map); }
		 */
		return list;
	}

}
