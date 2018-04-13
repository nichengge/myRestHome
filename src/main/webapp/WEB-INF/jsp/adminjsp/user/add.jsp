<%-- 
    Document   : add
    Created on : 2018-2-27, 16:29
    Author     : Administrator
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>添加用户页面</title>
<link href="<%=basePath%>css/all.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>js/jquery-1.8.0.min.js"></script>
<title>JSP Page</title>
</head>
<body style="background: #e1e9eb;">
	<form action="<%=basePath%>addUser" id="addForm" method="post">
		<div class="right">
			<div class="current">
				当前位置：<a href="<%=basePath%>userList" style="color: #6E6E6E;">用户管理</a>
				&gt; 信息维护
			</div>
			<div class="rightCont">
				<p class="g_title fix">信息维护</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">用户名称：</td>
							<td><input type="text" id="username" name="username"
								class="allInput" value="" /></td>
						</tr>
						<tr>
							<td width="90" align="right">密&nbsp;&nbsp;码：</td>
							<td><input type="text" id="password" name="password"
								class="allInput" value="" /></td>
						</tr>
						<tr>
							<td width="90" align="right">性&nbsp;&nbsp;别：</td>
							<td><select name="gender">
									<option value="">==请选择性别==</option>
									<option value="男">男</option>
									<option value="女">女</option>
							</select></td>
						</tr>
						<tr>
							<td width="90" align="right">电&nbsp;&nbsp;话：</td>
							<td><input type="text" id="phone" name="phone"
								class="allInput" value="" /></td>
						</tr>
						<tr>
							<td width="85" align="right"><input type="submit"
								class="tabSub" value="添 加" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>
