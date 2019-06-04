package com.gxdl.dyh.po;

import java.io.Serializable;

/**
 * 专门用于封装数据的po对象，这个对象不和任何数据库的表对应。
 * @author Administrator
 *
 */
public class UserMsgAndMoney implements Serializable{

	/**
	 * @see
	 * 
	 */
	private static final long serialVersionUID = -4248220962889292010L;

	private Long usedId;
	//用户姓名
	private String username;
	//用户账户
	private String accounts;
	//用户账户余额
	private String surplusMoney;
	
	public Long getUsedId() {
		return usedId;
	}
	public void setUsedId(Long usedId) {
		this.usedId = usedId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccounts() {
		return accounts;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}
	public String getSurplusMoney() {
		return surplusMoney;
	}
	public void setSurplusMoney(String surplusMoney) {
		this.surplusMoney = surplusMoney;
	}
	
	@Override
	public String toString() {
		return "UserMsgAndMoney [username=" + username + ", accounts=" + accounts + ", surplusMoney=" + surplusMoney
				+ "]";
	}
}
