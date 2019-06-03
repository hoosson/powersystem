package com.gxdl.dyh.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gxdl.dyh.po.UserInfo;

@Repository("userLoginMapper")
public interface UserLoginMapper {
	/*
	 * �û���¼��֤�Ƿ�Ψһ
	 */
	public UserInfo getUserNameOnly(@Param("username")String username);
	/*
	 * �ύע����Ϣ
	 */
	public void addUserMassage(@Param("userInfo")UserInfo userInfo);
	/*
	 * ��ȡ�û�����ʱ��ȡ����
	 */
	public String getUserInfoSalt(@Param("username")String username);
	/*
	 * ��֤��¼ʱ��������û��� 
	 * ����=������ʾ+��
	 */
	public UserInfo getUserMassageFlag(@Param("username")String username,@Param("password")String passwordSalt);
	/*
	 *userInfo��������������õ�¼��ʱ��͵�¼�ı�־������������һ��Ϊ�� 
	 */
	public void addUserLoginSuccessData(@Param("userInfo")UserInfo userInfo);
	/**
	 * ��¼�ɹ��Ժ��ȡ�û�����
	 */
	public UserInfo getUserName(@Param("userToken")String userToken);
	//ע��ɹ���ʼ�����
	public void insertUserPowerAndMoneyInit(@Param("userinfo")UserInfo userInfo);

}
