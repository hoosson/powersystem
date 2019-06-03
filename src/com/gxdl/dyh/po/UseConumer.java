package com.gxdl.dyh.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户电量和余额初始化表
 * @author Administrator
 *
 */
public class UseConumer implements Serializable{

	/**
	 * @see
	 */
	private static final long serialVersionUID = -4115938535957591781L;
	
	private Long id;//主键
	private Long userId;//用户的userid
	private String accounts;//用户账号
	private BigDecimal electricitynumber;//用户所剩电量
	private BigDecimal surplus_money;//用户账户所剩余额
	private BigDecimal balance_warning;//余额告警设置值
	private BigDecimal power_warning;//余额告警设置值
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAccounts() {
		return accounts;
	}
	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}
	public BigDecimal getElectricitynumber() {
		return electricitynumber;
	}
	public void setElectricitynumber(BigDecimal electricitynumber) {
		this.electricitynumber = electricitynumber;
	}
	public BigDecimal getSurplus_money() {
		return surplus_money;
	}
	public void setSurplus_money(BigDecimal surplus_money) {
		this.surplus_money = surplus_money;
	}
	public BigDecimal getBalance_warning() {
		return balance_warning;
	}
	public void setBalance_warning(BigDecimal balance_warning) {
		this.balance_warning = balance_warning;
	}
	public BigDecimal getPower_warning() {
		return power_warning;
	}
	public void setPower_warning(BigDecimal power_warning) {
		this.power_warning = power_warning;
	}
	
	@Override
	public String toString() {
		return "UseConumer [id=" + id + ", userId=" + userId + ", accounts=" + accounts + ", electricitynumber="
				+ electricitynumber + ", surplus_money=" + surplus_money + ", balance_warning=" + balance_warning
				+ ", power_warning=" + power_warning + "]";
	}
}
