<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
		<title>PowerSystem-头部</title>
		<link type="text/css" href="css/mainHrad.css" rel="stylesheet"/>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
		var userToken= "${userToken}";
		function getUserName(){
			$.ajax({
				type:"post",
				url:"UserLoginController/getUserName.do",
				data:{"userToken":userToken},
				success:function(data){
					if(data.SUCCESS == "YES"){
						$("#fontName").text(data.username);
					}else{
						$("#fontName").text("张三");
					}
				},
				error:function(data){}
			});
		}
			
		</script>
	</head>
	<body onload="getUserName();">
		<div class="head_div" style="padding-top:15px">
			<div class="head_div1">
				<font class="main_hand_font_div">欢迎<font id="fontName"></font>登录广西电力有限公司</font>
				<div class="hardpicdiv">
					<img src="images/hardpic.png"/>
				</div>
				<div class="hardflagdiv">
					<font class="userflagdiv">普通用户</font>
				</div>
			</div>
		</div>
	</body>
</html>
