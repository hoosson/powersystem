package com.gxdl.dyh.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public interface PowerFullService {
	/**
	 * ��ҳ����ص�ʱ���ȡ�û����ǳơ��˻�������ʣ���
	 */
	public JSONObject getUserMsgAndMoney(String userToken);
	
	/**
	 * �û����˻����г�ֵ
	 * @param username
	 * @param accounts
	 * @param fullMoney
	 * @return
	 */
	public JSONObject insertFullMoney(String userId,String username,String accounts,String fullMoney,String password);
	
	/*
	 * ��ѯ0-4�����ݷ��ؽ���
	 */
	public List<Map> selectFullMoneymsg(String userToken,Integer param);
}
