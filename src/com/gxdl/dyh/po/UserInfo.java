package com.gxdl.dyh.po;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7490443177015928851L;

	/** 主键  userid **/
    private Long userid;

    /** 用户姓名  username **/
    private String username;

    /** 密码加密存储  passwords **/
    private String passwords;

    /** 加密存储的salt  salt **/
    private String salt;

    /** 用户的token值  user_token **/
    private String userToken;

    /** 用户账户  accounts **/
    private String accounts;

    /** 用户头像地址  hand_pic **/
    private String handPic;

    /** 邮箱地址  email **/
    private String email;

    /** 年龄  age **/
    private String age;

    /** 用户的手机号码  mobile **/
    private String mobile;

    /** 用户的身份证号  identity **/
    private String identity;

    /** 出生日期  birthday **/
    private String birthday;

    /**   nationality **/
    private String nationality;

    /** 省份  province **/
    private String province;

    /** 城市  city **/
    private String city;

    /** 用户的详细地址  address **/
    private String address;

    /** 用户注册时间  create_time **/
    private Date createTime;

    /** 用户最后一次登录的时间  last_login_time **/
    private Date lastLoginTime;

    /** 用户是否在登录标志，退出登录时为0，登录时为1  current_login_flag **/
    private String currentLoginFlag;

    /** 备注  remark **/
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
