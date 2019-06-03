package com.gxdl.dyh.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gxdl.dyh.po.UserMsgAndMoney;
import com.gxdl.dyh.po.Userfullmoney;
import com.gxdl.dyh.po.SelectUserInfoandfullmoneylog;
import com.gxdl.dyh.po.UseConumer;

@Repository("powerFullMapper")
public interface PowerFullMapper {
	//��ҳ����ص�ʱ���ȡ�û����ǳ� �˻��� ��ʣ���
	public UserMsgAndMoney getUserMsgAndMoney(@Param("userToken")String userToken);
	/**
	 * �û����˻����г�ֵ
	 * @param username
	 * @param accounts
	 * @param fullMoney
	 */
	public Integer insertFullMoney(@Param("userId")String userId,@Param("username")String username,
			@Param("accounts")String accounts,@Param("fullMoney")String fullMoney,@Param("powerNumber")String powerNumber);
	
	/**
	 * ��ѯ��ԭ���ĵ��������
	 */
	public UseConumer getOriginalPowerMoney(@Param("userId")String userId,@Param("accounts")String accounts);
	/*
	 * ����һ����ֵ��¼
	 */
	public void insertFullMoneylog(@Param("userfullmoney")Userfullmoney userfullmoney);
	
	/*
	 * ��ѯ���м�¼
	 */
	public SelectUserInfoandfullmoneylog selectFullMoneylog(@Param("userToken")String userToken,@Param("currentPage")Integer currentPage); 
	
	/*
	 * ��ѯ���м�¼������
	 */
	public String selectFullMoneycount(@Param("accounts")String accounts);
}
