package com.gxdl.dyh.po;

import java.io.Serializable;

/**
 * ר�����ڷ�װ���ݵ�po����������󲻺��κ����ݿ�ı��Ӧ��
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
	//�û�����
	private String username;
	//�û��˻�
	private String accounts;
	//�û��˻����
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
