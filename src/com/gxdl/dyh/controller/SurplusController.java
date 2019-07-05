package com.gxdl.dyh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gxdl.dyh.service.PowerFullService;
import com.gxdl.dyh.utils.ResPouseUtil;

import net.sf.json.JSONObject;
/**
 * 余量信息Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/surplus")
public class SurplusController {
	/**
	 * 电量、金额 余量信息
	 */
	@RequestMapping(value="/surplusInfo")
	public ModelAndView surplusInfo(HttpServletRequest request,ModelMap modelMap){
		ModelAndView mav = new ModelAndView();
		//1.接收参数
		String userToken = (String) request.getSession().getAttribute("userToken");
		if(userToken != null && userToken.length() > 0){
			mav.setViewName("main/surplusInfo");
			
		} else {
			mav.setViewName("userlogin/login");
		}
		return mav;
	}
}
