package com.gxdl.dyh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �����Ĺ�����
 * @author chendawei
 * @date 2019��3��24��14:11:03 
 *
 */
public final class CommonUtil {
	
	//�����ַ���
	private static final String BASE_STR = "0aoei9ubpmf8d7t6n5lgkhj3qxrz4c2sy1w";
	
	//Token�����ַ���
	private static final String BASE_TOKEN_STR = "A0aoQAeCi9DuRbQDDXpmNVTFfXR8dG7DZMQEYDXGt6nFTIASSG5lJgVDkYSCDGPhj3qxrGz4c2sy1w";
	
	//�����ֻ����ַ���
	private static final String BASE_NUMBER = "0192837465";
	
	/**
	 * ��ȡָ��λ����Сд��ĸ��������ϵ��ַ���,Ĭ��16λ
	 * @param digit
	 * @return ����ַ���
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
	 * �����û�TokenValue
	 * @param digit
	 * @return 32λTokenֵ
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
	 * �����û��Ե�ǰ���Ϊ��ͷ��8λ�������
	 * @param digit
	 * @return �Ե�ǰ���Ϊ��ͷ��8λ�������
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
	 * ���û������֤����������ȡ�û�������
	 * 622301 1982 10 02 0538
	 * @param idNumber �û������֤����
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

