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
	 * ��־���
	 */
	private Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	UserInfoService userInfoService;
	/*
	 * �û�����֤
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
		 * �û�ע������û�����Ϣ
		 * @param userInfo
		 * @return
		 */
		@RequestMapping("/addUserMassage")
		public @ResponseBody  String addUserMassage(String username,String mobile,
					  String emaile,String idnumber,String password,String yearday){
			try {
				//����ԭ������Ҫ��ÿ�����������жϵģ�ʱ��������ʦ��д�ˣ��������ǡ�
				return this.userInfoService.addUserMassage(username, mobile, emaile, idnumber, password, yearday);
			} catch (Exception e) {
				System.out.println("/UserLoginController/addUserMassage Exception:"+e.getMessage());
				return ResPouseUtil.FAIL;
			}
		}
		/*
		 * ��¼����
		 */
		@RequestMapping("/userLoginSubmit")
		public @ResponseBody  JSONObject userLoginSubmit(HttpServletRequest request,String username,String password) {
			JSONObject jsonObject = new JSONObject();
			try {
				//���ز�ѯ����userToken�͹�����ResPouseUtil�жϱ�־
				Map<String,Object> result = this.userInfoService.userLoginSubmit(username, password);
				//��map�����л�ȡuserInfo���󲢷�װ��userinfo��  userinfoֻ��userTokenֵ��LastLoginTime��CurrentLoginFlagֵ
				UserInfo userinfo = (UserInfo) result.get("userinfo");
				//��userinfo��ȡ��tokenֵ����session��������
				request.getSession().setAttribute("userToken", userinfo.getUserToken());
				//ɾ��userinfo��map��ֻ�����жϱ�־
				result.remove("userinfo");
				//��jsonObject����ת���������ʽ�ķ��ظ�ǰ��
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
		 * ��¼�ɹ��Ժ��ȡ�û�����
		 * @param userInfo
		 * @return
		 */
		@RequestMapping("/getUserName")
		public @ResponseBody  JSONObject getUserName(HttpServletRequest request,String userToken){
			//����һ��json��ʽ�Ķ���
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