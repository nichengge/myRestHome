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
	<script src="<%=basePath%>js/all.js"></script>
	<title>JSP Page</title>
</head>
<body style="background: #e1e9eb;">
<form action="<%=basePath%>user/insertOrUpdate" id="updateForm" method="post">
	<input type="hidden" name="id" value="${user.id}"/>
	<div class="right">
		<div class="current">
			当前位置：用户管理
			&gt; 信息维护
		</div>
		<div class="rightCont">
			<p class="g_title fix">信息维护</p>
			<table class="tab1">
				<tbody>
				<tr>
					<td width="90" align="right">用户名称：</td>
					<td><input type="text" name="username"
							   class="allInput" value="${user.username}"/></td>
				</tr>
				<tr>
					<td width="90" align="right">密&nbsp;&nbsp;码：</td>
					<td><input type="text" name="password"
							   class="allInput" value="${user.password }" /></td>
				</tr>
				<tr>
					<td width="90" align="right">性&nbsp;&nbsp;别：</td>
					<td>
						<c:choose>
							<c:when test="${user.gender eq '男'}">
								<input type="radio" name="gender" value="男" checked/>男
								<input type="radio" name="gender" value="女"/>女
							</c:when>
							<c:when test="${user.gender eq '女'}">
								<input type="radio" name="gender" value="男"/>男
								<input type="radio" name="gender" value="女" checked/>女
							</c:when>
							<c:otherwise>
								<input type="radio" name="gender" value="男"/>男
								<input type="radio" name="gender" value="女"/>女
							</c:otherwise>
						</c:choose>

					</td>
				</tr>
				<tr>
					<td width="90" align="right">电&nbsp;&nbsp;话：</td>
					<td><input type="text" name="phone"
							   class="allInput" value="${user.phone }" /></td>
				</tr>
				<tr>
					<td width="90" align="right">姓&nbsp;&nbsp;名：</td>
					<td><input type="text" name="name"
							   class="allInput" value="${user.name }" /></td>
				</tr>
				<tr>
					<td width="90" align="right">身份证号：</td>
					<td><input type="text" name="identity"
							   class="allInput" value="${user.identity }" /></td>
				</tr>
				<tr>
					<td width="85" align="right"><input type="submit"
														class="tabSub" value="修改" /></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</form>
</body>

</html>
