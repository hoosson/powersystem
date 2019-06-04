package com.gxdl.dyh.po;

import java.math.BigDecimal;
import java.util.Date;

public class SelectUserInfoandfullmoneylog {
	private String username;//用户姓名
	private String accounts;//用户账号
	private BigDecimal surplusmoney;//充值前余额
	private BigDecimal fullmoney;//充值金额
	private Date fulltime;//充值时间
	
	public SelectUserInfoandfullmoneylog(String username, String accounts, BigDecimal surplusmoney,
			BigDecimal fullmoney, Date fulltime) {
		super();
		this.username = username;
		this.accounts = accounts;
		this.surplusmoney = surplusmoney;
		this.fullmoney = fullmoney;
		this.fulltime = fulltime;
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
	public BigDecimal getSurplusmoney() {
		return surplusmoney;
	}
	public void setSurplusmoney(BigDecimal surplusmoney) {
		this.surplusmoney = surplusmoney;
	}
	public BigDecimal getFullmoney() {
		return fullmoney;
	}
	public void setFullmoney(BigDecimal fullmoney) {
		this.fullmoney = fullmoney;
	}
	public Date getFulltime() {
		return fulltime;
	}
	public void setFulltime(Date fulltime) {
		this.fulltime = fulltime;
	}
	@Override
	public String toString() {
		return "SelectUserInfoandfullmoneylog [username=" + username + ", accounts=" + accounts + ", surplusmoney="
				+ surplusmoney + ", fullmoney=" + fullmoney + ", fulltime=" + fulltime + "]";
	}
}
