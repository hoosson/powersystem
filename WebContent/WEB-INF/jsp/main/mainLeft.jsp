<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
		<title>PowerSystem-left</title>
		<link type="text/css" href="css/mainLeft.css" rel="stylesheet"/>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			var userToken = "${userToken}";
			//到立即冲值页面
			function toInstantFullPageJsp(){
				$("#fullMoneyId").attr("href","UserLoginPageController/toFullMoneyPageJsp.do?userToken="+userToken);
			}
			//到冲值记录页面
			function toInstantFullLogPageJsp(){
				$("#fullMoneyLogId").attr("href","UserLoginPageController/toFullMoneyLogPageJsp.do?userToken="+userToken);
				
			}
		</script>
	</head>
	<body>
		<div class="list_div">
			<a id="fullMoneyId" onclick="toInstantFullPageJsp();" target="right">
				<li>立即充值</li>
			</a>
			<a id="fullMoneyLogId" onclick="toInstantFullLogPageJsp();" target="right">
				<li >充值记录</li>
			</a>
			<a href="watches.html" target="right">
				<li >剩余电量</li>
			</a>
			<a href="watches.html" target="right">
				<li >剩余金额</li>
			</a>
			<a href="watches.html" target="right">
				<li >年度账单</li>
			</a>
			<a href="watches.html" target="right">
				<li >用电分析</li>
			</a>
			<a href="watches.html" target="right">
				<li >告警设置</li>
			</a>
			<a href="watches.html" target="right">
				<li >修改密码</li>
			</a>
			<a href="watches.html" target="right">
				<li >退出登录</li>
			</a>
		</div>
	</body>
</html>
