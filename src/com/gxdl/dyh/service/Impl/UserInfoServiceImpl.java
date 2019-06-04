package com.gxdl.dyh.service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxdl.dyh.dao.UserLoginMapper;
import com.gxdl.dyh.po.UserInfo;
import com.gxdl.dyh.service.UserInfoService;
import com.gxdl.dyh.utils.ResPouseUtil;

import net.sf.json.JSONObject;

import com.gxdl.dyh.utils.CommonUtil;



@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	//日志输出打印
	private Logger logger=LoggerFactory.getLogger(UserInfoServiceImpl.class);
	/*
	 * 用户登录验证
	 */
	@Autowired
	UserLoginMapper userLoginMapper;
	@Override
	public String getUserNameOnly(String username) {
		// TODO Auto-generated method stub
		try {
			if(username!=null&&username.length()>0) {
				UserInfo userInfo=this.userLoginMapper.getUserNameOnly(username);
				Long userId = 0L;
				if(userInfo==null) {
					return ResPouseUtil.SUCCESS;
				}
				userId=userInfo.getUserid();
				if(userId>0) {
					return ResPouseUtil.FAIL;
				}
				return ResPouseUtil.SUCCESS;
			}else {
				return ResPouseUtil.FAIL;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("UserInfoServiceImpl/getUserNameOnly/"+e.getMessage());
			return ResPouseUtil.FAIL;
		}
	}

	/**
	 * 用户注册添加用户的信息
	 * @param userInfo
	 * @return
	 */
	@Override
	public String addUserMassage(String username, String mobile, String emaile, 
				  String idnumber, String password,String yearday) {
		try {
			String salt = CommonUtil.getRandomString(null);
			//创建UserInfo对象，封装从控制层传入的参数
			UserInfo userinfo = new UserInfo();
			userinfo.setUsername(username);
			userinfo.setPasswords(password+salt);
			userinfo.setSalt(salt);
			userinfo.setUserToken(CommonUtil.getUserTokenValue());
			userinfo.setAccounts(CommonUtil.getUserJobNumber());
			userinfo.setHandPic("/images/head.jpg");
			userinfo.setEmail(emaile);
			userinfo.setAge(CommonUtil.getUserMassageInAge(idnumber));
			userinfo.setMobile(mobile);
			userinfo.setIdentity(idnumber);
			userinfo.setBirthday(yearday);
			userinfo.setNationality("中国");
			userinfo.setProvince("广西");
			userinfo.setCity("南宁");
			userinfo.setAddress("广西壮族自治区南宁市西乡塘区安吉大道15号");
			userinfo.setCreateTime(new Date());
			userinfo.setLastLoginTime(null);
			userinfo.setCurrentLoginFlag("0");
			userinfo.setRemark(null);
			
			if(userinfo != null){
				//保存用户信息
				this.userLoginMapper.addUserMassage(userinfo);
				//如果保存成功则返回数据库生成的主键也就是userid
				Long userid = 0L;
				userid = userinfo.getUserid();
				if(userid > 0){
					 //用户注册成功以后开始对用户的电量和余额进行初始化操作
					 this.userLoginMapper.insertUserPowerAndMoneyInit(userinfo);
					 return ResPouseUtil.SUCCESS;
				}else{
					return ResPouseUtil.FAIL;
				}
			}
			return ResPouseUtil.FAIL;

		} catch (Exception e) {
			System.out.println("/UserInfoServiceImpl/addUserMassage Exception : "+e.getMessage());
			return ResPouseUtil.FAIL;
		}
		
	}


	//用户登录验证逻辑代码块
	@Override
	public Map userLoginSubmit(String username, String password) {
		// TODO Auto-generated method stub
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			if(username != null && username.length() > 0) {
				if(password != null && password.length() > 0){
					String salt =this.userLoginMapper.getUserInfoSalt(username);
					if(salt.length()>0) {
						UserInfo userinfo=this.userLoginMapper.getUserMassageFlag(username, password+salt);
						if(userinfo != null && userinfo.getUserToken().length() > 0) {
							map.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.SUCCESS);
							map.put(ResPouseUtil.SUCCESS, ResPouseUtil.SUCCESS_Flag);
							map.put("userinfo", userinfo);
							userinfo.setLastLoginTime(new Date());
							userinfo.setCurrentLoginFlag("1");
							this.userLoginMapper.addUserLoginSuccessData(userinfo);
							logger.info("/UserInfoServiceImpl/userLoginSubmit:"+username+"用户登录成功");
							return map;
						}else {
								//查不到用户的信息后返回小于等于零的结果
								map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.SUCCESS);
								map.put(ResPouseUtil.SUCCESS, ResPouseUtil.FAIL_Flag);
								logger.info("/UserInfoServiceImpl/userLoginSubmit :"+username+"用户的用户名密码输入错误！");
								return map;
						}
					}else {
							map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
							map.put(ResPouseUtil.SUCCESS, ResPouseUtil.FAIL_Flag);
							logger.info("/UserInfoServiceImpl/userLoginSubmit "
									+ "Exception:"+username+"的Salt获取失败，可能的原因是用户未注册或服务器ERROR");
							return map;
					}
				}else {
					map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
					map.put(ResPouseUtil.SUCCESS, ResPouseUtil.FAIL_Flag);
					logger.info("/UserInfoServiceImpl/userLoginSubmit Exception:密码为空");
					return map;
				}
			}else {
				map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
				map.put(ResPouseUtil.SUCCESS, ResPouseUtil.FAIL_Flag);
				logger.info("/UserInfoServiceImpl/userLoginSubmit Exception: 用户名为空!");
				return map;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("/UserInfoServiceImpl/userLoginSubmit Exception : "+e.getMessage());
			logger.error("/UserInfoServiceImpl/userLoginSubmit Exception:"+e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * 登录成功以后获取用户姓名
	 */
	@Override
	public JSONObject getUserName(String userToken) {
		JSONObject jsonObject = new JSONObject();
		try {
			if(userToken != null && userToken.length() > 0){
				UserInfo userInfo = this.userLoginMapper.getUserName(userToken);
				if(userInfo != null && userInfo.getUsername().length() > 0){
					jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.SUCCESS);
					jsonObject.put("username", userInfo.getUsername());
					return jsonObject;
				}else{
					jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.FAIL);
					logger.info("/UserInfoServiceImpl/getUserName UserInfo Object is NULL");
					return jsonObject;
				}
			}else{
				jsonObject.put(ResPouseUtil.SUCCESS_KRY, ResPouseUtil.FAIL);
				logger.info("/UserInfoServiceImpl/getUserName userToken is NULL");
				return jsonObject;
			}
		} catch (Exception e) {
			System.out.println("/UserInfoServiceImpl/getUserName Exception : "+e.getMessage());
			logger.error("/UserInfoServiceImpl/getUserName Exception:"+e.getMessage());
			return null;
		}
	}
	
	/**
	 *    校验用户密码
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public Map verifyPassword(String username, String password) {
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			if(username != null && username.length() > 0){
				if(password != null && password.length() > 0){
					//查询用户的salt
					String salt = this.userLoginMapper.getUserInfoSalt(username);
					if(salt.length() > 0 ){
						//将用户的密码和盐组合起来再次查询
						UserInfo userinfo = this.userLoginMapper.getUserMassageFlag(username, password+salt);
						//查到用户的信息后返回大于零的结果
						if(userinfo != null && userinfo.getUserToken().length() > 0){
							map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.SUCCESS);
							return map;
						}else{//查不到用户的信息后返回小于等于零的结果
							map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
							return map;
						}
					}else{
						map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
						return map;
					}
				}else{
					map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
					return map;
				}
			}else{
				map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
				return map;
			}
		} catch (Exception e) {
			logger.error("/UserInfoServiceImpl/userLoginSubmit Exception:"+e.getMessage());
			return null;
		}
	}
}

