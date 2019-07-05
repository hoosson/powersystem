package com.gxdl.dyh.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 告警设置Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/warnning")
public class WarnningController {
	/**
	 * 告警设置展示页
	 */
	@RequestMapping(value="/warnningSetting")
	public ModelAndView warnningSetting(HttpServletRequest request,ModelMap modelMap){
		ModelAndView mav = new ModelAndView();
		String userToken = (String) request.getSession().getAttribute("userToken");
		if(userToken != null && userToken.length() > 0){
			mav.setViewName("main/warnningSetting");
		} else {
			mav.setViewName("userlogin/login");
		}
		return mav;
	}
}
