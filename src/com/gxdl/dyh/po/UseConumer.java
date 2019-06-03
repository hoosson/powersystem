package com.gxdl.dyh.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * �û�����������ʼ����
 * @author Administrator
 *
 */
public class UseConumer implements Serializable{

	/**
	 * @see
	 */
	private static final long serialVersionUID = -4115938535957591781L;
	
	private Long id;//����
	private Long userId;//�û���userid
	private String accounts;//�û��˺�
	private BigDecimal electricitynumber;//�û���ʣ����
	private BigDecimal surplus_money;//�û��˻���ʣ���
	private BigDecimal balance_warning;//���澯����ֵ
	private BigDecimal power_warning;//���澯����ֵ
	
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
