package com.gxdl.dyh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 公共的工具类
 * @author chendawei
 * @date 2019年3月24日14:11:03 
 *
 */
public final class CommonUtil {
	
	//基础字符串
	private static final String BASE_STR = "0aoei9ubpmf8d7t6n5lgkhj3qxrz4c2sy1w";
	
	//Token基础字符串
	private static final String BASE_TOKEN_STR = "A0aoQAeCi9DuRbQDDXpmNVTFfXR8dG7DZMQEYDXGt6nFTIASSG5lJgVDkYSCDGPhj3qxrGz4c2sy1w";
	
	//纯数字基础字符串
	private static final String BASE_NUMBER = "0192837465";
	
	/**
	 * 获取指定位数的小写字母、数字组合的字符串,默认16位
	 * @param digit
	 * @return 随机字符串
	 */
	public static String getRandomString(Integer digit){
		if(digit == null){
			digit = 16;
		}
		if(digit > Integer.MAX_VALUE)
			throw new IndexOutOfBoundsException("/CommonUtil Class/getRandomString Method param exceed Integer type MAX_VALUE");
		if(digit < Integer.MIN_VALUE)
			throw new IndexOutOfBoundsException("/CommonUtil Class/getRandomString Method param exceed Integer type MIN_VALUE");
		StringBuffer sb = new StringBuffer();
		for(int index = 0 ; index < digit ; index++){
			int randomIndex =  (int)(Math.random() * digit);
			sb.append(BASE_STR.charAt(randomIndex));
		}
		return sb.toString();
	}
	
	/**
	 * 生成用户TokenValue
	 * @param digit
	 * @return 32位Token值
	 */
	public static String getUserTokenValue(){
		final Integer digit = 32;
		StringBuffer sb = new StringBuffer();
		for(int index = 0 ; index < digit ; index++){
			int randomIndex =  (int)(Math.random() * digit);
			sb.append(BASE_TOKEN_STR.charAt(randomIndex));
		}
		return sb.toString();
	}
	
	/**
	 * 生成用户以当前年份为开头的8位随机工号
	 * @param digit
	 * @return 以当前年份为开头的8位随机工号
	 */
	public static String getUserJobNumber(){
		final Integer digit = 4;
		StringBuffer sb = new StringBuffer();
		sb.append(new SimpleDateFormat("Y").format(new Date()).toString());
		for(int index = 0 ; index < digit ; index++){
			int randomIndex =  (int)(Math.random() * digit);
			sb.append(BASE_NUMBER.charAt(randomIndex));
		}
		return sb.toString();
	}
	
	/**
	 * 从用户的身份证号码里面提取用户的年龄
	 * 622301 1982 10 02 0538
	 * @param idNumber 用户的身份证号码
	 * @return
	 */
	public static String getUserMassageInAge(String idNumber){
		final Integer indexStart = 6;
		final Integer indexEnd = 10;
		if(idNumber.length() != 18)
			throw new IndexOutOfBoundsException("/CommonUtil/getUserMassageInAge Exception:IndexOutOfBounds");
		String year = idNumber.substring(indexStart, indexEnd);
		String currentYear = new SimpleDateFormat("Y").format(new Date()).toString();
		Integer age = Integer.parseInt(currentYear) - Integer.parseInt(year);
		return age.toString();
	}
}

