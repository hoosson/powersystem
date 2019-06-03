<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
<title>Power-System-用户注册</title>
	<link rel="stylesheet" type="text/css" href="css/register.css"/>
	<script type="text/javascript">
	/* jquery的ajax的完整示例 */
	function jqueryExample(){
		//格式:$.ajax({参数1:"值1",参数2:"值2",参数3:"值3",......,成功的回调函数,错误的回调函数 });
		$.ajax({
			type:"post",
			url:"/xx/yyy.do",
			data:{"key":"value","key1":"value2"},
			async:true,
			success:function(data){
				//data里面是我们从后端请求到的数据，也就是后端发送给前端的数据。
				//成功的回调函数是建立起完整的请求和响应中间没有其他异常出现。此时就会调用成功回调函数。
				
			},
			error:function(data){
				//data里面是我们从后端请求到的数据，也就是后端发送给前端的数据。
				//错误的回调函数是建立起请求和响应当时中间发生其他异常情况。此时就会调用错误的回调函数。
			}
		});
	}
	</script>
</head>
<body>
	<div class="logo_style"><img class="logo_hrad_style" src="images/logo.jpg"></img></div>
		<div class="font_div"><font class="hrad_style">广西电力有限公司</font></div>
		<div class="bg_style">
			<div class="table_div">
				<table class="table_main">
					<tr>
						<td class="tishi_class">用户名</td>
						<td>
							<input type="text" id="username" onblur="userNameOnly();" class="input_class" placeholder="请输入用户名"/>
						</td>
						<td>
							<font id="usernameFont">*不能以数字开头6-8个字符</font>
						</td>
					</tr>
					<tr>
						<td class="tishi_class">手机号码</td>
						<td>
							<input type="text" id="mobile" onblur="mobileSub();" class="input_class"/>
						</td>
						<td>
							<font id="mobileFont">*请输入手机号码</font>
						</td>
					</tr>
					<tr>
						<td class="tishi_class">电子邮箱</td>
						<td>
							<input type="text" id="email" class="input_class"/>
						</td>
						<td>
							<font id="maileFont">*请输入电子邮箱</font>
						</td>
					</tr>
					<tr>
						<td class="tishi_class">身份证号</td>
						<td>
							<input type="text" id="idcodent" onblur="idVeief();" class="input_class"/>
						</td>
						<td>
							<font id="idcodentFont">*请输入身份号码</font>
						</td>
					</tr>
					<tr>
						<td class="tishi_class">输入密码</td>
						<td>
							<input type="password" id="password" onblur="passwordVri();" class="input_class" placeholder="请输入密码"/>
						</td>
						<td>
							<font id="passwordFont">*密码必须以字母数字混合且8-10位</font>
						</td>
					</tr>
					<tr>
						<td class="tishi_class">确认密码</td>
						<td>
							<input type="password" id="surePassword" class="input_class"/>
						</td>
						<td>
							<font id="surePasswordFont">*请再次输入密码</font>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<button style="display:block;margin:0 auto" onclick="submitUserMassage();">注&emsp;册</button>
						</td>
					</tr>
				</table>
			</div>
		</div>
</body>
<!-- 使用jquery时必须导入jquery的包也就是js文件，这里使用jquery-1.8.3.min.js -->
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
var usernameflag = true;
var mobilefalg = true;
var idnumbers = true;
var emailfalg = true;
var passwordFlag = true;
var yearday = "";//用于保存临时出生年月日
	/* 校验用户名的唯一性和其他要求  */
	function userNameOnly(){
		//获取用户填写的用户名
		var username = document.getElementById("username").value;
		var indexHard = username.substring(0,1);
		for (var i = 0; i < 10; i++) {
			if(indexHard == i){
				usernameflag = false;
				$("#usernameFont").text("*用户名首字符不能为数字!")
				$("#usernameFont").css("color","red");
				return;
			}else{
				usernameflag = true;
			}
		}
		if(username.length<6||username.length>8){
			usernameflag = false;
			$("#usernameFont").text("*用户名的长度在6~8字符之间")
			$("#usernameFont").css("color","red");
			return;
		}
		$.ajax({
			type:"post",
			url:"UserLoginController/getUserNameOnly.do",
			data:{"username":username},
			async:true,
			success:function(data){
				if(data == "NO"){//如果等于NO说明当前用户名已经被使用，然后给用户提示
					$("#usernameFont").text("*用户名已经被使用")
					$("#usernameFont").css("color","red");
					usernameflag = false;
				}else{
					$("#usernameFont").text("*可以使用")
					$("#usernameFont").css("color","#00ff33");
				}
			},
			error:function(data){
				alert(data);
			}
		});
	}
	/* 校验手机号码是否合法  */
	function mobileSub() {
		var mobile = document.getElementById("mobile").value;
		if(mobile.length != 11){
			$("#mobileFont").text("*手机号码不合法！")
			$("#mobileFont").css("color","red");
			mobilefalg = false;
		}else{
			$("#mobileFont").text("*手机号码可以使用");
			$("#mobileFont").css("color","#00ff33");
			mobilefalg = true;
		}
	}
	
	/* 校验身份证号号码是否合法 然后对身份证号中的年月日进行提取  */
	function idVeief() {
		var idnumber = document.getElementById("idcodent").value;
		var emaile = document.getElementById("email").value;
		if(emaile != null || emaile.length > 0){
			$("#maileFont").text("*邮箱可以使用");
			$("#maileFont").css("color","#00ff33");
			emailfalg = true;
		}else{
			$("#maileFont").text("*邮箱未填写!");
			$("#maileFont").css("color","red");
			emailfalg = false;
		}
		if(idnumber.length != 18){
			$("#idcodentFont").text("*身份证码不合法！")
			$("#idcodentFont").css("color","red");
			idnumbers = false;
		}else{
			var year = idnumber.substring(6,10);
			var mouth = idnumber.substring(10,12);
			var day = idnumber.substring(12,14);
			yearday = year+"年"+mouth+"月"+day+"日";
			$("#idcodentFont").text("*身份证码可以使用");
			$("#idcodentFont").css("color","#00ff33");
			idnumbers = true;
		}
	}
	
	//做密码校验
	function passwordVri(){
		var passwordValue = document.getElementById("password").value;
		if(passwordValue.length < 8){
			$("#passwordFont").text("*您输入的密码长度有误!");
			$("#passwordFont").css("color","red");
			passwordFlag = false;
			return;
		}
		if(passwordValue.length>10){
			$("#passwordFont").text("*您输入的密码长度有误!");
			$("#passwordFont").css("color","red");
			passwordFlag = false;
			return;
		}
		passwordFlag = true;
		//开始判断用户输入的密码中是否是数字字母混合的
		var strLength = 0;
		for (var i = 0; i < passwordValue.length; i++) {
			//passwordValue=1 2 34567 a
			var chars = passwordValue.charAt(i);//
			for(var j = 0;j < 10;j++){
				if(chars == j){
					strLength ++;
				}
			}
		}
		if(strLength != passwordValue.length){
			$("#passwordFont").text("*可以使用当前密码");
			$("#passwordFont").css("color","#00ff33");
			passwordFlag = true;
		}else{
			$("#passwordFont").text("*密码必须要数字字母混合!");
			$("#passwordFont").css("color","red");
			passwordFlag = false;
		}
	}
	
	/*提交用户信息*/
	function submitUserMassage(){
		var surePassword = document.getElementById("surePassword").value;
		var passwordValue = document.getElementById("password").value;
		if(surePassword != passwordValue){
			$("#surePasswordFont").text("*密码必须要数字字母混合!");
			$("#surePasswordFont").css("color","red");
			return;
		}
		$("#passwordFont").text("*两次密码输入一致");
		$("#passwordFont").css("color","#00ff33");
		if(usernameflag && mobilefalg && idnumbers && emailfalg && passwordFlag){
			var username = document.getElementById("username").value;
			var mobile = document.getElementById("mobile").value;
			var emaile = document.getElementById("email").value;
			var idnumber = document.getElementById("idcodent").value;
			var surePassword = document.getElementById("surePassword").value;
			//提交用户信息,发送ajax请求
			$.ajax({
				type:"post",
				url:"UserLoginController/addUserMassage.do",
				data:{
						"username":username,
						"mobile":mobile,
						"emaile":emaile,
						"idnumber":idnumber,
						"password":surePassword,
						"yearday":yearday
					},
				success:function(data){
					if(data == "YES"){
						alert("注册成功");
						window.location.href="UserLoginPageController/toUserLoginControllerJsp.do";
					}else{
						alert("当前网络异常，请稍后再次提交!");
					}
				},
				error:function(data){
					
				}
			});
		}else{
			alert("您注册的信息中，有非法项，请检查!");
		}
	}
	
</script>
</html>