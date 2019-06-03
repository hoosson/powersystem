package com.gxdl.dyh.service;

import java.util.Map;

import com.gxdl.dyh.po.UserInfo;

import net.sf.json.JSONObject;

public interface UserInfoService {
	//У���û����Ƿ�Ψһ
	public String getUserNameOnly(String username);

    //ע���ύ
	public String addUserMassage(String username,String mobile,
			  String emaile,String idnumber,String password,String yearday);
	//У���¼ʱ���˺�����
	public Map userLoginSubmit(String username,String password);

	
	//��¼�ɹ��Ժ��ȡ�û�����	
	public JSONObject getUserName(String userToken);
	/**
	 *    У���û�����
	 * @param username
	 * @param password
	 * @return
	 */
	public Map<String,String> verifyPassword(String username,String password);
}
