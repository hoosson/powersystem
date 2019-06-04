package com.gxdl.dyh.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gxdl.dyh.po.UserInfo;

@Repository("userLoginMapper")
public interface UserLoginMapper {
	/*
	 * 用户登录验证是否唯一
	 */
	public UserInfo getUserNameOnly(@Param("username")String username);
	/*
	 * 提交注册信息
	 */
	public void addUserMassage(@Param("userInfo")UserInfo userInfo);
	/*
	 * 获取用户加密时获取的盐
	 */
	public String getUserInfoSalt(@Param("username")String username);
	/*
	 * 验证登录时的密码和用户名 
	 * 密码=明文显示+盐
	 */
	public UserInfo getUserMassageFlag(@Param("username")String username,@Param("password")String passwordSalt);
	/*
	 *userInfo对象里面仅仅设置登录的时间和登录的标志，其他的属性一律为空 
	 */
	public void addUserLoginSuccessData(@Param("userInfo")UserInfo userInfo);
	/**
	 * 登录成功以后获取用户姓名
	 */
	public UserInfo getUserName(@Param("userToken")String userToken);
	//注册成功初始化余额
	public void insertUserPowerAndMoneyInit(@Param("userinfo")UserInfo userInfo);

}
