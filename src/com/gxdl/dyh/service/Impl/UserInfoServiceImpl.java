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
	//��־�����ӡ
	private Logger logger=LoggerFactory.getLogger(UserInfoServiceImpl.class);
	/*
	 * �û���¼��֤
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
	 * �û�ע������û�����Ϣ
	 * @param userInfo
	 * @return
	 */
	@Override
	public String addUserMassage(String username, String mobile, String emaile, 
				  String idnumber, String password,String yearday) {
		try {
			String salt = CommonUtil.getRandomString(null);
			//����UserInfo���󣬷�װ�ӿ��Ʋ㴫��Ĳ���
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
			userinfo.setNationality("�й�");
			userinfo.setProvince("����");
			userinfo.setCity("����");
			userinfo.setAddress("����׳�����������������������������15��");
			userinfo.setCreateTime(new Date());
			userinfo.setLastLoginTime(null);
			userinfo.setCurrentLoginFlag("0");
			userinfo.setRemark(null);
			
			if(userinfo != null){
				//�����û���Ϣ
				this.userLoginMapper.addUserMassage(userinfo);
				//�������ɹ��򷵻����ݿ����ɵ�����Ҳ����userid
				Long userid = 0L;
				userid = userinfo.getUserid();
				if(userid > 0){
					 //�û�ע��ɹ��Ժ�ʼ���û��ĵ����������г�ʼ������
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


	//�û���¼��֤�߼������
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
							logger.info("/UserInfoServiceImpl/userLoginSubmit:"+username+"�û���¼�ɹ�");
							return map;
						}else {
								//�鲻���û�����Ϣ�󷵻�С�ڵ�����Ľ��
								map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.SUCCESS);
								map.put(ResPouseUtil.SUCCESS, ResPouseUtil.FAIL_Flag);
								logger.info("/UserInfoServiceImpl/userLoginSubmit :"+username+"�û����û��������������");
								return map;
						}
					}else {
							map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
							map.put(ResPouseUtil.SUCCESS, ResPouseUtil.FAIL_Flag);
							logger.info("/UserInfoServiceImpl/userLoginSubmit "
									+ "Exception:"+username+"��Salt��ȡʧ�ܣ����ܵ�ԭ�����û�δע��������ERROR");
							return map;
					}
				}else {
					map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
					map.put(ResPouseUtil.SUCCESS, ResPouseUtil.FAIL_Flag);
					logger.info("/UserInfoServiceImpl/userLoginSubmit Exception:����Ϊ��");
					return map;
				}
			}else {
				map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
				map.put(ResPouseUtil.SUCCESS, ResPouseUtil.FAIL_Flag);
				logger.info("/UserInfoServiceImpl/userLoginSubmit Exception: �û���Ϊ��!");
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
	 * ��¼�ɹ��Ժ��ȡ�û�����
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
	 *    У���û�����
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
					//��ѯ�û���salt
					String salt = this.userLoginMapper.getUserInfoSalt(username);
					if(salt.length() > 0 ){
						//���û������������������ٴβ�ѯ
						UserInfo userinfo = this.userLoginMapper.getUserMassageFlag(username, password+salt);
						//�鵽�û�����Ϣ�󷵻ش�����Ľ��
						if(userinfo != null && userinfo.getUserToken().length() > 0){
							map.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.SUCCESS);
							return map;
						}else{//�鲻���û�����Ϣ�󷵻�С�ڵ�����Ľ��
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

