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
<style type="text/css">
	.curPage{
		background-color: #74D2D9;
	}
</style>

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

/* function fulloneMassage(currentPage){
	window.location.href="PowerFullController/selectFullMoneymsg.do?currentPage="+currentPage;
} */


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
						
						<c:choose>
							<c:when test="${data.currentPage - 1 > 0}"> 
								<button class="button_paging" onclick="fullMassage(${data.currentPage-1});">上一页</button>&emsp;
							</c:when> 
							<c:otherwise> 
								<button class="button_paging" onclick="fullMassage(1);">上一页 </button>&emsp;
							</c:otherwise>
						</c:choose>
						
						
						
<%--中间页 1,2,3,4,5,6处理--%>
<%--显示6页中间页[begin=起始页,end=最大页]--%>
<%--总页数没有6页--%>
<c:choose>
    <c:when test="${data.totalPage <= 6}">
        <c:set var="begin" value="1"/>
        <c:set var="end" value="${data.totalPage}"/>
    </c:when>
    <%--页数超过了6页--%>
    <c:otherwise>
        <c:set var="begin" value="${data.currentPage - 1}"/>
        <c:set var="end" value="${data.currentPage + 3}"/>
        <%--如果begin减1后为0,设置起始页为1,最大页为6--%>
        <c:if test="${begin -1 <= 0}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="6"/>
        </c:if>
        <%--如果end超过最大页,设置起始页=最大页-5--%>
        <c:if test="${end > data.totalPage}">
            <c:set var="begin" value="${data.totalPage - 5}"/>
            <c:set var="end" value="${data.totalPage}"/>
        </c:if>
    </c:otherwise>
</c:choose>
<%--遍历--%>
<c:forEach var="i" begin="${begin}" end="${end}">
    <%--当前页,选中--%>
    <c:choose>
        <c:when test="${i == data.currentPage}">
            <button class="curPage" >${i}</button>
        </c:when>
        <%--不是当前页--%>
        <c:otherwise>
            <button class="" onclick="fullMassage(${i});">${i}</button>
        </c:otherwise>
    </c:choose>
</c:forEach>												
	                    
						<button class="button_paging" onclick="fullMassage(3);"> 下一页</button>&emsp;
						<button class="button_paging" onclick="fullMassage(${data.totalPage});">尾页</button>
						
						第 <input style="width:40px;" id="jump_btn" type="text" oninput="value=value.replace(/[^\d]/g,'')" value="${data.currentPage}"/> 页 
						<button class="button_paging" onclick="Jump();">跳转</button>
					</td>
				</tr>
			</table>
		</div>
	</body>	
</html>
