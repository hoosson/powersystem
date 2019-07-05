package com.gxdl.dyh.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 用电分析Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/useAna")
public class UseAnalysisController {
	/**
	 * 用电分析饼状图
	 */
	@RequestMapping(value="/useAnalysis")
	public ModelAndView useAnalysis(HttpServletRequest request,ModelMap modelMap){
		ModelAndView mav = new ModelAndView();
		String userToken = (String) request.getSession().getAttribute("userToken");
		if(userToken != null && userToken.length() > 0){
			mav.setViewName("main/useAnalysis");
		} else {
			mav.setViewName("userlogin/login");
		}
		return mav;
	}
}
