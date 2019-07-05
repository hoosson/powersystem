<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
<title>PowerSystem-告警设置</title>
<link type="text/css" rel="stylesheet" href="css/fullMoney.css"/>
<script type="application/javascript" src="js/jquery.js"></script>
<script language="javascript" type="text/javascript" src="js/dataJs/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
	.curPage{
		background-color: #74D2D9;
	}
</style>


<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
var userToken = "${userToken}";



function fullMassage(currentPage) {
	window.location.href="UserLoginPageController/toFullMoneyLogPageJsp.do?currentPage="+currentPage;
}
//跳转
function Jump(){
	var jump_page = $("#jump_btn").val();
	var totalPage = ${data.totalPage};
	if (jump_page > totalPage) {
              alert("您输入的页数大于总页数！");
              return false;
          } else if (jump_page <= 0) {
              alert("您输入的页数有误！");
              return false;
          } else {
		fullMassage(jump_page);
          }
}
</script>
</head>
<body >
<div class="full_hard">----------------&emsp;查询充值记录&emsp;---------------</div>
		<br />
		<div class="condition_div">
			&emsp;&emsp;
			<button class="button_class">新增</button>
			&emsp;&emsp;
			<button class="button_class">编辑</button>
			&emsp;&emsp;
			<button class="button_class">删除</button>
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
				
				
					<tr>
						<td>1</td>
						<td>admin</td>
						<td>20191901</td>
						<td>100</td>
						<td>2019-06-04 16:02:24.0</td>
						<td>0</td>
						<td>2019-07-05 17:20:28.0</td>
					</tr>
				
					<tr>
						<td>2</td>
						<td>admin</td>
						<td>20191901</td>
						<td>111</td>
						<td>2019-06-04 20:12:51.0</td>
						<td>100</td>
						<td>2019-07-05 17:20:28.0</td>
					</tr>
				
					<tr>
						<td>3</td>
						<td>admin</td>
						<td>20191901</td>
						<td>222</td>
						<td>2019-06-04 20:13:11.0</td>
						<td>211</td>
						<td>2019-07-05 17:20:28.0</td>
					</tr>
				
					<tr>
						<td>4</td>
						<td>admin</td>
						<td>20191901</td>
						<td>110</td>
						<td>2019-06-04 20:13:22.0</td>
						<td>433</td>
						<td>2019-07-05 17:20:28.0</td>
					</tr>
				
					<tr>
						<td>5</td>
						<td>admin</td>
						<td>20191901</td>
						<td>111</td>
						<td>2019-06-04 20:39:39.0</td>
						<td>543</td>
						<td>2019-07-05 17:20:28.0</td>
					</tr>
				
				<tr>
					<td colspan="8" style="text-align: center;letter-spacing: 2px;">
						当前第1页&emsp;总共12页&emsp;总共57条记录&emsp;
						<button class="button_paging" onclick="fullMassage(1);">首页</button>&emsp;
						<button class="button_paging" onclick="fullMassage(1);">上一页 </button>&emsp;
			            <button class="curPage" >1</button>
			            <button class="" onclick="fullMassage(2);">2</button>
			            <button class="" onclick="fullMassage(3);">3</button>
			            <button class="" onclick="fullMassage(4);">4</button><button class="" onclick="fullMassage(5);">5</button>
            			<button class="" onclick="fullMassage(6);">6</button>
						<button class="button_paging" onclick="fullMassage(3);"> 下一页</button>&emsp;
						<button class="button_paging" onclick="fullMassage(12);">尾页</button>
						第 <input style="width:40px;" id="jump_btn" type="text" oninput="value=value.replace(/[^\d]/g,'')" value="1"/> 页 
						<button class="button_paging" onclick="Jump();">跳转</button>
					</td>
				</tr>
			</table>
		</div>

</body>	
</html>
