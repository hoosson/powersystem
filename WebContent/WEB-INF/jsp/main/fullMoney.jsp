<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

	$(function(){
		fulloneMassage(1);
	})
	function fulloneMassage(currentPage){
		//window.location.href="PowerFullController/selectFullMoneymsg.do?userToken="+userToken+"&currentPage"+currentPage;
	}
	function fullMassage(param) {
		//不小于最小整数 总数除10总页数
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
		}
		window.location.href="PowerFullController/selectFullMoneymsg.do?userToken="+userToken+"/currentPage"+currentPage;
	}
	</script>
	</head>
	<body <!-- onload="fulloneMassage(1);" -->>
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
					<td style="text-align: center;width: 20px;background-color: mediumaquamarine;">序号</td>
					<td style="text-align: center;width: 35px;background-color: mediumaquamarine;">用户姓名</td>
					<td style="text-align: center;width: 50px;background-color: mediumaquamarine;">充值账户</td>
					<td style="text-align: center;width: 30px;background-color: mediumaquamarine;">开户时间</td>
					<td style="text-align: center;width: 20px;background-color: mediumaquamarine;">充值金额</td>
					<td style="text-align: center;width: 30px;background-color: mediumaquamarine;">充值时间</td>
					<td style="text-align: center;width: 20px;background-color: mediumaquamarine;">剩余金额</td>
					<td style="text-align: center;width: 30px;background-color: mediumaquamarine;">上次查询时间</td>
				</tr>
				<tr>
					<td colspan="8" style="text-align: center;letter-spacing: 2px;">
						<button class="button_paging" onclick="fullMassage(1);">首页</button>&emsp;
						<button class="button_paging" onclick="fullMassage(2);">上一页</button>&emsp;
						当前第x页&emsp;总共xx页&emsp;总共aa条记录&emsp;
						跳转到第
						<select>
							<option>---1---</option>
						</select>页
						<button class="button_paging" onclick="fullMassage(3);">下一页</button>&emsp;
						<button class="button_paging" onclick="fullMassage(4);">尾页</button>
					</td>
				</tr>
					<c:forEach var="key" items="${data}">
						<tr>
							<td>${key.bookName}</td>
							<td>${key.bookAuthor}</td>
							<td>${key.bookPrice}</td>
							<td>${key.bookSimple}</td>
							<td>${key.bookNumber}</td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</body>	
</html>
