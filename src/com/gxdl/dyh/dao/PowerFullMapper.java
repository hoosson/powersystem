package com.gxdl.dyh.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gxdl.dyh.po.PsFullmoneyLog;
import com.gxdl.dyh.po.UserMsgAndMoney;
import com.gxdl.dyh.po.Userfullmoney;
import com.gxdl.dyh.po.SelectUserInfoandfullmoneylog;
import com.gxdl.dyh.po.UseConumer;

@Repository("powerFullMapper")
public interface PowerFullMapper {
	//在页面加载的时候获取用户的昵称 账户名 所剩余额
	public UserMsgAndMoney getUserMsgAndMoney(@Param("userToken")String userToken);
	/**
	 * 用户对账户进行充值
	 * @param username
	 * @param accounts
	 * @param fullMoney
	 */
	public Integer insertFullMoney(@Param("userId")String userId,@Param("username")String username,
			@Param("accounts")String accounts,@Param("fullMoney")String fullMoney,@Param("powerNumber")String powerNumber);
	
	/**
	 * 查询出原来的电量和余额
	 */
	public UseConumer getOriginalPowerMoney(@Param("userId")String userId,@Param("accounts")String accounts);
	/*
	 * 插入一条充值记录
	 */
	public void insertFullMoneylog(@Param("userfullmoney")Userfullmoney userfullmoney);
	
	/*
	 * 查询所有记录
	 */
	//public SelectUserInfoandfullmoneylog selectFullMoneylog(@Param("userToken")String userToken,@Param("currentPage")Integer currentPage); 
	public PsFullmoneyLog selectFullMoneylog(HashMap <String,Object> datamap); 
	/*
	 * 查询所有记录的条数
	 */
	public String selectFullMoneycount(@Param("accounts")String accounts);
}
