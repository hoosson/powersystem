<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
		<title>PowerSystem-主页</title>
		<link rel="stylesheet" type="text/css" href="css/mainPage.css"/>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
		var userToken = "${userToken}";
		function pageLoadInit() {
			//页面初始化是开始加载所有的子页面
			/* window.location.href="UserLoginPageController/toMainHeadPage.do?userToken="+userToken;//顶部的页面
			window.location.href="UserLoginPageController/toMainLeftPage.do?userToken="+userToken;//左部的页面  */
			/* $("#mainHeadId").src="UserLoginPageController/toMainHeadPage.do";
			$("#mainLeftID").src="UserLoginPageController/toMainLeftPage.do";  */
			$("#mainHeadId").attr("src","UserLoginPageController/toMainHeadPage.do?userToken="+userToken);
			$("#mainLeftID").attr("src","UserLoginPageController/toMainLeftPage.do?userToken="+userToken);
		}
		</script>
	</head>
 	<frameset rows="7%,*" bordercolor="6699ff" border="2px" frameborder="1" onload="pageLoadInit();">
 		<frame id="mainHeadId" noresize="noresize" scrolling="no"/>
 		<frameset cols="15%,*" bordercolor="6699ff" border="2px" frameborder="1">
 			<frame id="mainLeftID">
 			<frame src="watches.html" name="right"/>
 		</frameset>
 	</frameset>
	
</html>
