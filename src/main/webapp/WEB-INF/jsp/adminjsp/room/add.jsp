<%-- 
    Document   : add
    Created on : 2018-2-27, 16:29
    Author     : Administrator
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<form action="<%=basePath%>addRoom" id="addForm" method="post"
		enctype="multipart/form-data">
		<div class="right">
			<div class="current">
				当前位置：<a href="<%=basePath%>roomList" style="color: #6E6E6E;">用户管理</a>
				&gt; 信息维护
			</div>
			<div class="rightCont">
				<p class="g_title fix">信息维护</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">房间照片：</td>
							<td><input type="file" id="oldpic" name="oldpic" /></td>
						</tr>
						<tr>
							<td width="90" align="right">房间名称：</td>
							<td><input type="text" id="name" name="name"
								class="allInput" value="" /></td>
						</tr>
						<tr>
							<td width="90" align="right">房间类型：</td>
							<td><select id="type" name="type">
									<option value="经典型">经典型</option>
									<option value="豪华型">豪华型</option>
							</select></td>
						</tr>
						<tr>
							<td width="90" align="right">房间价格：</td>
							<td><input type="text" id="price" name="price"
								class="allInput" value="" /></td>
						</tr>
						<tr>
							<td width="90" align="right">房间面积：</td>
							<td><input type="text" id="area" name="area"
								class="allInput" value="" /></td>
						</tr>
						<tr>
							<td width="90" align="right">入住老人：</td>
							<td><select id="oldmanName" name="oldmanName">
									<option value="----">----</option>
									<c:forEach items="${oldmanList }" var="oldman">
										<option value="${oldman.name}">${oldman.name}</option>
									</c:forEach>
							</select></td>
						</tr>

						<tr>
							<td width="90" align="right">房间配置：</td>
							<td><textarea rows="3" cols="30" id="configure"
									name="configure" style="border: 1px solid #c3ced0;"></textarea></td>
						</tr>
						<tr>
							<td width="85" align="right"><input type="submit"
								class="tabSub" value="添加" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>
