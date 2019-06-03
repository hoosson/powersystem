package com.gxdl.dyh.service;

import java.util.Map;

import com.gxdl.dyh.po.UserInfo;

import net.sf.json.JSONObject;

public interface UserInfoService {
	//校验用户名是否唯一
	public String getUserNameOnly(String username);

    //注册提交
	public String addUserMassage(String username,String mobile,
			  String emaile,String idnumber,String password,String yearday);
	//校验登录时的账号密码
	public Map userLoginSubmit(String username,String password);

	
	//登录成功以后获取用户姓名	
	public JSONObject getUserName(String userToken);
	/**
	 *    校验用户密码
	 * @param username
	 * @param password
	 * @return
	 */
	public Map<String,String> verifyPassword(String username,String password);
}
