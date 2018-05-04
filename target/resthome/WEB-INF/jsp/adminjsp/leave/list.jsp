<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Integer first = 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>内容列表页面</title>
<link href="<%= basePath %>css/all.css" rel="stylesheet" type="text/css" />
<script src="http://libs.baidu.com/jquery/1.8.0/jquery.min.js"></script>
<script src="<%= basePath %>js/all.js"></script>
<title>JSP Page</title>
</head>
<body style="background: #e1e9eb;">
	<form action="${page.url}" id="mainForm" method="get">
		<input type="hidden" id = "pageNum" name="pageNum" value=""/>
		<div class="right">
			<div class="current">
				当前位置：内容管理
				&gt; 内容列表
			</div>
			<div class="rightCont">
				<p class="g_title fix">
					内容列表 &nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03"
						href="javascript:deleteBath('<%=basePath%>leave/deleteBath');">删
						除</a>
				</p>
				<table class="tab1">

				</table>
				<div class="zixun fix">
					<table class="tab2" width="100%">
						<tbody>
							<tr>
								<th><input type="checkbox" id="all"
									onclick="javascript:checkAll();" /></th>
								<th>请假编号</th>
								<th>请假原因</th>
								<th>请假时间</th>
								<th>请假员工</th>
								<th>请假次数</th>
								<th>扣除工资</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${leaveList}" var="leave"
								varStatus="index">
								<tr
									<c:if test="${index.count%2 == 0}">style='background-color:#ECF6EE;'</c:if>>
									<td><input type="checkbox" name="checkId"
										value="${leave.id}" /></td>
									<td>${leave.id}</td>
									<td><fmt:formatDate value="${leave.createdate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
									<th>${leave.reason}</th>
									<td>${leave.username}</td>
									<td>${leave.number}</td>
									<td>${leave.deduct}</td>
									<td><a
										href="<%=basePath%>leave/queryBeforeUpdateOrInsert?id=${leave.id}">修改</a>&nbsp;&nbsp;&nbsp;
										<a
										href="<%=basePath%>leave/delete?id=${leave.id}">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class='page fix'>
						共 <b>${page.total}</b> 条
						<a href="${page.url}&pageNum=1" class='first'>首页</a>
						<c:if test="${page.pageNum > 1}">
							<a href="${page.url}&pageNum=${page.prePage}" class='pre'>上一页</a>
						</c:if>
						当前第<span>${page.pageNum}/${page.pages}</span>页
						<c:if test="${page.pageNum < page.pages}">
							<a href="${page.url}&pageNum=${page.nextPage}" class='next'>下一页</a>
						</c:if>
						<a href="${page.url}&pageNum=${page.pages}" class='last'>末页</a>
						跳至&nbsp; <input type='text' id="pageGo" value="" class='allInput w28' />&nbsp;页&nbsp;
						<a href="javascript:goPage('${page.pages}');" class='go'>GO</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
