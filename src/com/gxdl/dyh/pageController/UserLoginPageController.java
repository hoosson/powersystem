package com.gxdl.dyh.pageController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gxdl.dyh.po.PageBean;
import com.gxdl.dyh.po.PsFullmoneyLog;
import com.gxdl.dyh.service.PowerFullService;

@Controller
@RequestMapping(value="/UserLoginPageController")
public class UserLoginPageController {
	
	@Autowired
	private PowerFullService powerFullService;
	
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
	public ModelAndView toFullMoneyLogPageJsp(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
		ModelAndView mav = new ModelAndView();
		//1.接收参数
		String userToken = (String) request.getSession().getAttribute("userToken");
		
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        
		if(userToken != null && userToken.length() > 0){
			//modelMap.put("userToken", userToken);
			
			int currentPage = 0;//当前页码，如果不传递，则默认为第一页
	        if(currentPageStr != null && currentPageStr.length() > 0){
	            currentPage = Integer.parseInt(currentPageStr);
	        }else{
	            currentPage = 1;
	        }
			
	        int pageSize = 0;//每页显示条数，如果不传递，默认每页显示5条记录
	        if(pageSizeStr != null && pageSizeStr.length() > 0){
	            pageSize = Integer.parseInt(pageSizeStr);
	        }else{
	            pageSize = 5;
	        }
	        PageBean<Map<String, Object>> aBean = powerFullService.pageQuery(currentPage, pageSize,userToken);
	        System.out.println(aBean);
			
//			List<Map<String,Object>> list = powerFullService.selectFullMoneymsg(userToken,1);
//			HashMap<Object, Object> currentPageMap = new HashMap<>();
			//currentPageMap.put("currentPage", "1");
			//map.add(currentPageMap);
			//request.getSession().setAttribute("data",map);
			mav.addObject("data", aBean);
			mav.setViewName("main/fullMoney");
			
		}else {
			mav.setViewName("userlogin/login");
		}
		return mav;
	}
}
