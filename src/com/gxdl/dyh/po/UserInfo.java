package com.gxdl.dyh.po;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7490443177015928851L;

	/** ����  userid **/
    private Long userid;

    /** �û�����  username **/
    private String username;

    /** ������ܴ洢  passwords **/
    private String passwords;

    /** ���ܴ洢��salt  salt **/
    private String salt;

    /** �û���tokenֵ  user_token **/
    private String userToken;

    /** �û��˻�  accounts **/
    private String accounts;

    /** �û�ͷ���ַ  hand_pic **/
    private String handPic;

    /** �����ַ  email **/
    private String email;

    /** ����  age **/
    private String age;

    /** �û����ֻ�����  mobile **/
    private String mobile;

    /** �û������֤��  identity **/
    private String identity;

    /** ��������  birthday **/
    private String birthday;

    /**   nationality **/
    private String nationality;

    /** ʡ��  province **/
    private String province;

    /** ����  city **/
    private String city;

    /** �û�����ϸ��ַ  address **/
    private String address;

    /** �û�ע��ʱ��  create_time **/
    private Date createTime;

    /** �û����һ�ε�¼��ʱ��  last_login_time **/
    private Date lastLoginTime;

    /** �û��Ƿ��ڵ�¼��־���˳���¼ʱΪ0����¼ʱΪ1  current_login_flag **/
    private String currentLoginFlag;

    /** ��ע  remark **/
    private String remark;

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", username=" + username + ", passwords=" + passwords + ", salt=" + salt
				+ ", userToken=" + userToken + ", accounts=" + accounts + ", handPic=" + handPic + ", email=" + email
				+ ", age=" + age + ", mobile=" + mobile + ", identity=" + identity + ", birthday=" + birthday
				+ ", nationality=" + nationality + ", province=" + province + ", city=" + city + ", address=" + address
				+ ", createTime=" + createTime + ", lastLoginTime=" + lastLoginTime + ", currentLoginFlag="
				+ currentLoginFlag + ", remark=" + remark + "]";
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getHandPic() {
		return handPic;
	}

	public void setHandPic(String handPic) {
		this.handPic = handPic;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getCurrentLoginFlag() {
		return currentLoginFlag;
	}

	public void setCurrentLoginFlag(String currentLoginFlag) {
		this.currentLoginFlag = currentLoginFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
