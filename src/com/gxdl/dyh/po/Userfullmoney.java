package com.gxdl.dyh.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Userfullmoney implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;//����
	private Long userId;//�û���userid
	private String accounts;//�û��˺�
	private BigDecimal surplusmoney;//��ֵǰ���
	private BigDecimal fullmoney;//��ֵ���
	private Date fulltime;//��ֵʱ��
	
	public Userfullmoney(Long userId, String accounts, BigDecimal surplusmoney, BigDecimal fullmoney,
			Date fulltime) {
		super();
		this.userId = userId;
		this.accounts = accounts;
		this.surplusmoney = surplusmoney;
		this.fullmoney = fullmoney;
		this.fulltime = fulltime;
	}
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
		return "Userfullmoney [id=" + id + ", userId=" + userId + ", accounts=" + accounts + ", surplusmoney="
				+ surplusmoney + ", fullmoney=" + fullmoney + ", fulltime=" + fulltime + "]";
	}
	
	
}
