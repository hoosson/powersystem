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
	//跳转至商品页
	@RequestMapping(value="/toShopingJsp")
	public String toShopingJsp() {
		return "userlogin/shoping";
	}
	/**
	 * 用户登录成功以后跳转到系统的主页面
	 */
	@RequestMapping(value="/toMainPageJsp")
	public String toMainPageJsp(ModelMap modelMap,String userToken){
		if(userToken.length() > 5)
			modelMap.put("modelMap",modelMap);
		return "main/mainPage";
	}
	
	/**
	 * 主页面加载的时候对子页面进行初始化操作--初始化顶部的页面
	 */
	@RequestMapping(value="/toMainHeadPage")
	public String toMainHeadPage(HttpServletRequest request,String userToken,ModelMap modelMap){
		if(userToken != null && userToken.length() > 0){
			request.getSession().setAttribute("userToken", userToken);
		}
		return "main/mainHead";
	}
	
	/**
	 * 主页面加载的时候对子页面进行初始化操作--初始化左部的页面
	 */
	@RequestMapping(value="/toMainLeftPage")
	public String toMainLeftPage(String userToken,ModelMap modelMap){
		if(userToken != null && userToken.length() > 0){
			modelMap.put("userToken", userToken);
		}
		return "main/mainLeft";
	}
	
	/**
	 * 跳转到用户的立即冲值页面
	 */
	@RequestMapping(value="/toFullMoneyPageJsp")
	public String toFullMoneyPageJsp(String userToken,ModelMap modelMap){
		if(userToken != null && userToken.length() > 0){
			modelMap.put("userToken", userToken);
		}
		return "main/instantFull";
	}
	
	/**
	 * 跳转到用户的充值记录的页面
	 */
	@RequestMapping(value="/toFullMoneyLogPageJsp")
	public String toFullMoneyLogPageJsp(String userToken,ModelMap modelMap){
		if(userToken != null && userToken.length() > 0){
			modelMap.put("userToken", userToken);
		}
		return "main/fullMoney";
	}
}
