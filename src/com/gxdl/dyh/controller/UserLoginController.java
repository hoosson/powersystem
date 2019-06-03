package com.gxdl.dyh.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxdl.dyh.po.UserInfo;
import com.gxdl.dyh.service.UserInfoService;
import com.gxdl.dyh.utils.ResPouseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/UserLoginController")
public class UserLoginController {
	/**
	 * 日志输出
	 */
	private Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	UserInfoService userInfoService;
	/*
	 * 用户名验证
	 */
	@RequestMapping(value="/getUserNameOnly")
	public @ResponseBody String getUserNameOnly(HttpServletRequest request,HttpServletResponse response,String username) {
		try {
			if(username!=null&&username.length()>0) {
				return this.userInfoService.getUserNameOnly(username);
			}else
				return ResPouseUtil.FAIL;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("/UserLoginController/getUserNameOnly"+e.getMessage());
			return ResPouseUtil.FAIL;
		}
	}

		/**
		 * 用户注册添加用户的信息
		 * @param userInfo
		 * @return
		 */
		@RequestMapping("/addUserMassage")
		public @ResponseBody  String addUserMassage(String username,String mobile,
					  String emaile,String idnumber,String password,String yearday){
			try {
				//这里原则上是要对每个参数进行判断的，时间限制老师不写了，交给亲们。
				return this.userInfoService.addUserMassage(username, mobile, emaile, idnumber, password, yearday);
			} catch (Exception e) {
				System.out.println("/UserLoginController/addUserMassage Exception:"+e.getMessage());
				return ResPouseUtil.FAIL;
			}
		}
		/*
		 * 登录功能
		 */
		@RequestMapping("/userLoginSubmit")
		public @ResponseBody  JSONObject userLoginSubmit(HttpServletRequest request,String username,String password) {
			JSONObject jsonObject = new JSONObject();
			try {
				//返回查询到的userToken和工具类ResPouseUtil判断标志
				Map<String,Object> result = this.userInfoService.userLoginSubmit(username, password);
				//从map集合中获取userInfo对象并封装到userinfo中  userinfo只有userToken值，LastLoginTime，CurrentLoginFlag值
				UserInfo userinfo = (UserInfo) result.get("userinfo");
				//从userinfo中取出token值放入session作用域里
				request.getSession().setAttribute("userToken", userinfo.getUserToken());
				//删除userinfo，map中只存在判断标志
				result.remove("userinfo");
				//给jsonObject对象转化成下面格式的返回给前端
				//key="YES" value="key=success,value=YES;key="YES" Value="1""
				jsonObject.put(ResPouseUtil.SUCCESS,result);
				return jsonObject;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("/UserLoginController/addUserMassage Exception:"+e.getMessage());
				logger.error("/UserLoginController/addUserMassage Exception:"+e.getMessage());
				jsonObject.put(ResPouseUtil.FAIL,ResPouseUtil.FAIL_Flag);
				return jsonObject;
			}
		}
		
		/**
		 * 登录成功以后获取用户姓名
		 * @param userInfo
		 * @return
		 */
		@RequestMapping("/getUserName")
		public @ResponseBody  JSONObject getUserName(HttpServletRequest request,String userToken){
			//申明一个json格式的对象
			JSONObject jsonObject = new JSONObject();
			try {
				return this.userInfoService.getUserName(userToken);
			} catch (Exception e) {
				System.out.println("/UserLoginController/getUserName Exception:"+e.getMessage());
				logger.error("/UserLoginController/getUserName Exception:"+e.getMessage());
				jsonObject.put(ResPouseUtil.SUCCESS_KRY,ResPouseUtil.FAIL);
				return jsonObject;
			}
		}
}