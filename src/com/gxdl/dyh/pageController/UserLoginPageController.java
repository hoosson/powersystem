package com.gxdl.dyh.pageController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/UserLoginPageController")
public class UserLoginPageController {
	
	@RequestMapping(value="/toUserLoginControllerJsp")
	public String toUserLoginControllerJsp(){
		return "userlogin/login";
	}
	@RequestMapping(value="/toUserRegisterJsp")
	public String toUserRegisterJsp() {
		return "userlogin/userRegister";
	}
	//��ת����Ʒҳ
	@RequestMapping(value="/toShopingJsp")
	public String toShopingJsp() {
		return "userlogin/shoping";
	}
	/**
	 * �û���¼�ɹ��Ժ���ת��ϵͳ����ҳ��
	 */
	@RequestMapping(value="/toMainPageJsp")
	public String toMainPageJsp(ModelMap modelMap,String userToken){
		if(userToken.length() > 5)
			modelMap.put("modelMap",modelMap);
		return "main/mainPage";
	}
	
	/**
	 * ��ҳ����ص�ʱ�����ҳ����г�ʼ������--��ʼ��������ҳ��
	 */
	@RequestMapping(value="/toMainHeadPage")
	public String toMainHeadPage(HttpServletRequest request,String userToken,ModelMap modelMap){
		if(userToken != null && userToken.length() > 0){
			request.getSession().setAttribute("userToken", userToken);
		}
		return "main/mainHead";
	}
	
	/**
	 * ��ҳ����ص�ʱ�����ҳ����г�ʼ������--��ʼ���󲿵�ҳ��
	 */
	@RequestMapping(value="/toMainLeftPage")
	public String toMainLeftPage(String userToken,ModelMap modelMap){
		if(userToken != null && userToken.length() > 0){
			modelMap.put("userToken", userToken);
		}
		return "main/mainLeft";
	}
	
	/**
	 * ��ת���û���������ֵҳ��
	 */
	@RequestMapping(value="/toFullMoneyPageJsp")
	public String toFullMoneyPageJsp(String userToken,ModelMap modelMap){
		if(userToken != null && userToken.length() > 0){
			modelMap.put("userToken", userToken);
		}
		return "main/instantFull";
	}
	
	/**
	 * ��ת���û��ĳ�ֵ��¼��ҳ��
	 */
	@RequestMapping(value="/toFullMoneyLogPageJsp")
	public String toFullMoneyLogPageJsp(String userToken,ModelMap modelMap){
		if(userToken != null && userToken.length() > 0){
			modelMap.put("userToken", userToken);
		}
		return "main/fullMoney";
	}
}
