<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
	<title>PowerSystem-充值记录</title>
	<link type="text/css" rel="stylesheet" href="css/fullMoney.css"/>
	<script type="application/javascript" src="js/jquery.js"></script>
	<script language="javascript" type="text/javascript" src="js/dataJs/My97DatePicker/WdatePicker.js"></script>
	<script type="application/javascript">
	function data_choose() {
		var d;atatest = $("#datatest").get(0);
		WdatePicker({el:datatest,dateFmt:'yyyy-MM-dd'/* dateFmt:'yyyy-MM-dd HH:mm:ss' */})
	}
	function data_choose1() {
		var datatest = $("#datatest1").get(0);
		WdatePicker({el:datatest,dateFmt:'yyyy-MM-dd'/* dateFmt:'yyyy-MM-dd HH:mm:ss' */})
	}
	</script>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
	var userToken = "${userToken}";
	
	function fulloneMassage(currentPage){
		window.location.href="PowerFullController/selectFullMoneymsg.do?currentPage="+currentPage;
	}
	function fullMassage(currentPage) {
		//不小于最小整数 总数除10总页数
		/* var total = ${data.totalPage};
		var pageTotal = Math.ceil(total/10);
		if(param == 1){
			currentPage = 1;
		}else if(param == 2){
			if(currentPage > 1){
				currentPage = currentPage-1;
			}
		}else if(param == 3){
			if(currentPage < pageTotal){
				currentPage = currentPage+1;
			}
		}else{
			currentPage = pageTotal;
		} */
		window.location.href="UserLoginPageController/toFullMoneyLogPageJsp.do?currentPage="+currentPage;
	}
	</script>
	</head>
	<body ><!-- onload="fulloneMassage(1);" -->
		<div class="full_hard">----------------&emsp;查询充值记录&emsp;---------------</div>
		<br />
		<div class="condition_div">
			开始日期
			<input class="Wdate" type="text" id="datatest" onclick="data_choose();">
			&emsp;至&emsp;
			结束日期
			<input class="Wdate" type="text" id="datatest1" onclick="data_choose1();">
			&emsp;&emsp;
			<button class="button_class">立即查询</button>
			&emsp;&emsp;
			<button class="button_class">导出Excel表格</button>
		</div>
		<div class="table_wai">
			<table class="table_class">
				<tr>
					<th style="text-align: center;width: 20px;background-color: mediumaquamarine;">序号</th>
					<th style="text-align: center;width: 35px;background-color: mediumaquamarine;">用户姓名</th>
					<th style="text-align: center;width: 50px;background-color: mediumaquamarine;">充值账户</th>
					<th style="text-align: center;width: 20px;background-color: mediumaquamarine;">充值金额</th>
					<th style="text-align: center;width: 30px;background-color: mediumaquamarine;">充值时间</th>
					<th style="text-align: center;width: 20px;background-color: mediumaquamarine;">剩余金额</th>
					<th style="text-align: center;width: 30px;background-color: mediumaquamarine;">上次查询时间</th>
				</tr>
				
				<c:forEach items="${data.list}" var="key" varStatus="p">
					<tr>
						<td>${p.index+1}</td>
						<td>${key.username}</td>
						<td>${key.accounts}</td>
						<td>${key.fullmoney}</td>
						<td>${key.fulltime}</td>
						<td>${key.surplusmoney}</td>
						<td>${key.last_login_time}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="8" style="text-align: center;letter-spacing: 2px;">
						当前第${data.currentPage}页&emsp;总共${data.totalPage}页&emsp;总共${data.totalCount}条记录&emsp;
						<button class="button_paging" onclick="fullMassage(1);">首页</button>&emsp;
						<button class="button_paging" onclick="fullMassage(2);">上一页</button>&emsp;
						跳转到第
						<select>
							<option>---1---</option>
							<option>---2---</option>
							<option>---3---</option>
							<option>---4---</option>
						</select>页
						<button class="button_paging" onclick="fullMassage(3);">下一页</button>&emsp;
						<button class="button_paging" onclick="fullMassage(${data.totalPage});">尾页</button>
					</td>
				</tr>
			</table>
		</div>
	</body>	
</html>
