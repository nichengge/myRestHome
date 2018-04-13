
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Integer first = 1;
Integer pass = 100;
Integer nopass = 200;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>内容列表页面</title>
<link href="<%= basePath %>css/all.css" rel="stylesheet" type="text/css" />
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="<%= basePath %>js/order/list.js"></script>
<title>JSP Page</title>
</head>
<body style="background: #e1e9eb;">
	<form action="<%= basePath %>wageStatistics" id="mainForm" method="POST">
		<div class="right">
			<div class="current">
				当前位置：<a href="<%=basePath%>wageStatistics" style="color: #6E6E6E;">内容管理</a>
				&gt; 内容列表
			</div>
			<div class="rightCont">
				<p class="g_title fix">内容列表</p>

				<div class="zixun fix">
					<table class="tab2" width="100%">
						<tbody>
							<tr>
								<th>时间</th>
								<th>工资</th>
							</tr>
							<c:forEach items="${map}" var="wape">
								<td><c:out value="${wape.key}"></c:out></td>
								<td><c:out value="${wape.value}"></c:out></td>
							</c:forEach>
						</tbody>
					</table>
					
				</div>
			</div>
		</div>
	</form>
</body>
</html>
