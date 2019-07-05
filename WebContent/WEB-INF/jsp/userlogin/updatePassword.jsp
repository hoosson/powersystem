<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
		<title>PowerSystem-修改密码</title>
		<link type="text/css" href="css/instantFull.css" rel="stylesheet"/>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
		var userToken = "${userToken}";
		/* function getUserMsgAndMoney(){
			$.ajax({
				type:"post",
				url:"PowerFullController/getUserMsgAndMoney.do",
				data:{"userToken":userToken},
				success:function(data){
					if(data.SUCCESS == "YES"){
						$("#usernameId").val(data.username);
						$("#accountsId").val(data.accounts);
						$("#surplusMoneyId").val(data.surplusMoney+".00");
						$("#hiddenUserid").val(data.userid);
					}else{
						$("#usernameId").val("张三");
						$("#accountsId").val("GX123456");
						$("#surplusMoneyId").val("98.9");
					}
				},
				error:function(data){}
			});
		} */
		
		
		//用户对账户进行充值
		function insertFullMoney() {
			var username = $("#usernameId").val();//用户的姓名
			var accounts = $("#accountsId").val();//用户的账户
			var fullMoney = $("#fullMoneyId").val();//用户的充值金额
			var userId = $("#hiddenUserid").val();//用户的充值金额
			var password = $("#password").val();//用户的登录密码
			$.ajax({
				type:"post",
				url:"PowerFullController/insertFullMoney.do",
				data:{
						"userToken":userToken,
						"username":username,
						"accounts":accounts,
						"fullMoney":fullMoney,
						"userId":userId,
						"password":password
					  },
				success:function(data){
					if(data.SUCCESS ==	"YES"){
						alert("充值成功");
						window.location.href="watches.html";
						return;
					}else{
						alert("网络异常请稍后重试！");
						return;
					}
				},
				error:function(data){}
			});
		}
		</script>
	</head>
	<body onload="getUserMsgAndMoney2();">
		<input type="hidden" id="hiddenUserid">
		<div class="maindiv">
			<table class="table_class_div">
				<tr>
					<td>
						<ul>用户姓名&emsp;<input type="text" id="usernameId" readonly="readonly"/></ul>
						<ul>请输入原密码&emsp;<input type="text" id="fullMoneyId"/></ul>
						<ul>请输入新密码&emsp;<input type="password" id="password"/></ul>
						<ul>重新输入密码&emsp;<input type="password" id="password"/></ul>
						<ul>
							<button onclick="insertFullMoney();">确定修改</button>&emsp;&emsp;
						</ul>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>
