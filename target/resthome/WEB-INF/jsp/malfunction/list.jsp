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
					内容列表 <a class="btn03" href="<%= basePath %>malfunction/queryBeforeUpdateOrInsert?oldid=${oldid}">新
						增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03"
						href="javascript:deleteBath('<%=basePath%>malfunction/deleteBath');">删
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
								<th>事故编号</th>
								<th>事故类型</th>
								<th>事故原因</th>
								<th>事故结果</th>
								<th>事故时间</th>
								<th>老人姓名</th>
								<th>备注</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${malfunctionList}" var="malfunction"
								varStatus="index">
								<tr
									<c:if test="${index.count%2 == 0}">style='background-color:#ECF6EE;'</c:if>>
									<td><input type="checkbox" name="checkId"
										value="${malfunction.id}" /></td>
									<td>${malfunction.id}</td>
									<td>${malfunction.type}</td>
									<th>${malfunction.reason}</th>
									<td>${malfunction.result}</td>
									<td><fmt:formatDate value="${malfunction.createtime}" pattern="yyyy-MM-dd"></fmt:formatDate>
											</td>
									<td>${malfunction.oldmanname}</td>
									<td>${malfunction.remarks}</td>
									<td><a
										href="<%=basePath%>malfunction/queryBeforeUpdateOrInsert?id=${malfunction.id}">修改</a>&nbsp;&nbsp;&nbsp;
										<a
										href="<%=basePath%>malfunction/delete?id=${malfunction.id}">删除</a>
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
