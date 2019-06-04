package com.gxdl.dyh.po;

import java.math.BigDecimal;
import java.util.Date;

public class PsFullmoneyLog {
	private Long id;
	private Long userid;
	private String accounts;//用户账号
	private BigDecimal surplusmoney;//充值前余额
	private BigDecimal fullmoney;//充值金额
	private Date fulltime;//充值时间
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
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
		return "PsFullmoneyLog [id=" + id + ", userid=" + userid
				+ ", accounts=" + accounts + ", surplusmoney=" + surplusmoney
				+ ", fullmoney=" + fullmoney + ", fulltime=" + fulltime + "]";
	}
	public PsFullmoneyLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PsFullmoneyLog(Long id, Long userid, String accounts,
			BigDecimal surplusmoney, BigDecimal fullmoney, Date fulltime) {
		super();
		this.id = id;
		this.userid = userid;
		this.accounts = accounts;
		this.surplusmoney = surplusmoney;
		this.fullmoney = fullmoney;
		this.fulltime = fulltime;
	}
	
	
}
