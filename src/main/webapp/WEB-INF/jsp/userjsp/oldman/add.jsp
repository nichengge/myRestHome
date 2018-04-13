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
	<form action="<%=basePath%>addOldman" id="addForm" method="post"
		enctype="multipart/form-data">
		<input type="hidden" id="userId" name= "userId" value="${oldman.userId}"/>
		<div class="right">
			<div class="current">
				当前位置：<a href="<%=basePath%>oldmanList" style="color: #6E6E6E;">用户管理</a>
				&gt; 信息维护
			</div>
			<div class="rightCont">
				<p class="g_title fix">信息维护</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">老人照片：</td>
							<td><input type="file" id="oldpic" name="oldpic" /></td>

						</tr>
						<tr>
							<td width="90" align="right">老人姓名：</td>
							<td><input type="text" id="name" name="name"
								class="allInput" value="" /></td>
						</tr>
						<tr>
							<td width="90" align="right">性&nbsp;&nbsp;别：</td>
							<td><select id="gender" name="gender">
									<option value="男">男</option>
									<option value="女">女</option>
							</select></td>
						</tr>
						<tr>
							<td width="90" align="right">老人年龄：</td>
							<td><input type="text" id="age" name="age" class="allInput"
								value="" /></td>
						</tr>
						<tr>
							<td width="90" align="right">老人生日：</td>
							<td><input type="text" id="birthday" name="birthday"
								class="allInput"
								value="" /></td>
						</tr>
						<tr>
							<td width="90" align="right">老人描述：</td>
							<td><textarea rows="3" cols="30" id="introduce"
									name="introduce" style="border: 1px solid #c3ced0;"></textarea></td>
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
