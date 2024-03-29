package com.gxdl.dyh.service;

import java.util.List;
import java.util.Map;

import com.gxdl.dyh.po.PageBean;
import com.gxdl.dyh.po.PsFullmoneyLog;

import net.sf.json.JSONObject;

public interface PowerFullService {
	/**
	 * 在页面加载的时候获取用户的昵称、账户名、所剩余额
	 */
	public JSONObject getUserMsgAndMoney(String userToken);
	
	/**
	 * 用户对账户进行充值
	 * @param username
	 * @param accounts
	 * @param fullMoney
	 * @return
	 */
	public JSONObject insertFullMoney(String userId,String username,String accounts,String fullMoney,String password);
	
	/*
	 * 查询0-4条数据返回界面
	 */
	public List<Map<String, Object>> selectFullMoneymsg(String userToken,Integer param);
	
	/**
	 * 分页查询
	 */
	public PageBean<Map<String, Object>> pageQuery(int currentPage,int pageSize,String userToken);
}
