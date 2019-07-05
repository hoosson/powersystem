package com.gxdl.dyh.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 年度账单Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/year")
public class YearController {
	/**
	 * 年度账单柱状折线图
	 */
	@RequestMapping(value="/yearBill")
	public ModelAndView yearBill(HttpServletRequest request,ModelMap modelMap){
		ModelAndView mav = new ModelAndView();
		String userToken = (String) request.getSession().getAttribute("userToken");
		if(userToken != null && userToken.length() > 0){
			mav.setViewName("main/yearBill");
			
		} else {
			mav.setViewName("userlogin/login");
		}
		return mav;
	}
}
