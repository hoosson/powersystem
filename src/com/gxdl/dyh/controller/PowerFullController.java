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

import com.gxdl.dyh.service.PowerFullService;
import com.gxdl.dyh.utils.ResPouseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/PowerFullController")
public class PowerFullController {
	/*
	 * ��־���
	 */
	private Logger logger = LoggerFactory.getLogger(PowerFullController.class);
	
	@Autowired
	private PowerFullService powerFullService;
	/*
	 * ҳ����ص�ʱ���ȡ�û��ǳ��˻�������ʣ���
	 */
	@RequestMapping("/getUserMsgAndMoney")
	public @ResponseBody JSONObject getUserMsgAndMoney(HttpServletRequest request,String userToken) {
		JSONObject jsonObject = new JSONObject();
		try {
			return this.powerFullService.getUserMsgAndMoney(userToken);
		} catch (Exception e) {
			System.out.println("/UserLoginController/getUserMsgAndMoney Exception:"+e.getMessage());
			logger.error("/UserLoginController/getUserMsgAndMoney Exception:"+e.getMessage());
			jsonObject.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
			return jsonObject;
		}
	}
	
	/**
	 * �û����˻����г�ֵ
	 * @param userInfo
	 * @return
	 */
	@RequestMapping("/insertFullMoney")
	public @ResponseBody  JSONObject insertFullMoney(HttpServletRequest request,String userToken,
			String userId,String username,String accounts,String fullMoney,String password,ModelMap modelMap){
		//����һ��json��ʽ�Ķ���
		JSONObject jsonObject = new JSONObject();
		try {
			modelMap.put("userToken", userToken);
			return this.powerFullService.insertFullMoney(userId,username,accounts,fullMoney,password);
		} catch (Exception e) {
			System.out.println("/UserLoginController/insertFullMoney Exception:"+e.getMessage());
			logger.error("/UserLoginController/insertFullMoney Exception:"+e.getMessage());
			jsonObject.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
			return jsonObject;
		}
	}
	
	/**
	 * �����ҳ���ܲ�ѯ�������͵�һ��
	 * @param userInfo
	 * @return
	 */
	@RequestMapping("/selectFullMoneymsg")
	public String selectFullMoneymsg(HttpServletRequest request,HttpServletResponse respons,String userToken,Integer currentPage) {
		// TODO Auto-generated method stub
		try {
			if(userToken!=null) {
				List<Map> map = powerFullService.selectFullMoneymsg(userToken,currentPage);
				HashMap<Object, Object> currentPageMap = new HashMap<>();
				currentPageMap.put("currentPage", "1");
				map.add(currentPageMap);
				request.getSession().setAttribute("data",map);
				System.out.println(map.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "main/fullMoney";
	}
}
