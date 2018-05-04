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
<script src="<%=basePath%>js/oldman/list.js"></script>
<title>JSP Page</title>
</head>
<body style="background: #e1e9eb;">
	<form action="<%=basePath%>oldman/insertOrUpdate" id="addForm" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="id" value="${oldman.id}"/>
		<div class="right">
			<div class="current">
				当前位置：<a href="<%=basePath%>oldman/list" style="color: #6E6E6E;">用户管理</a>
				&gt; 信息维护
			</div>
			<div class="rightCont">
				<p class="g_title fix">信息维护</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">老人照片：</td>
							<c:if test="${!empty oldman.pic}">
								<img alt="老人照片" src="/pic/${oldman.pic }" width="50px" height="50px">
							</c:if>
							<td><input type="file" name="oldPic" /></td>

						</tr>
						<tr>
							<td width="90" align="right">老人姓名：</td>
							<td><input type="text" name="name"
								class="allInput" value="${oldman.name}" /></td>
						</tr>
						<tr>
							<td width="90" align="right">性&nbsp;&nbsp;别：</td>
							<td>
								<c:choose>
									<c:when test="${oldman.gender eq '男'}">
										<input type="radio" name="gender" value="男" checked/>男
										<input type="radio" name="gender" value="女"/>女
									</c:when>
									<c:when test="${oldman.gender eq '女'}">
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
							<td width="90" align="right">老人年龄：</td>
							<td><input type="text" name="age" class="allInput"
								value="${oldman.age}" /></td>
						</tr>
						<tr>
							<td width="90" align="right">身份证号：</td>
							<td><input type="text" name="identity" class="allInput"
									   value="${oldman.identity}" /></td>
						</tr>
						<tr>
							<td width="90" align="right">婚姻状态：</td>
							<td><input type="text" name="marital" class="allInput"
									   value="${oldman.marital}" /></td>
						</tr>
						<tr>
							<td width="90" align="right">政治面貌：</td>
							<td><input type="text" name="political" class="allInput"
									   value="${oldman.political}" /></td>
						</tr>
						<tr>
							<td width="90" align="right">护理人员：</td>
							<td>
								<select name="uid">
									<c:choose>
										<c:when test="${!empty oldman.username}">
											<option value="${oldman.uid}">${oldman.username}</option>
											<option value="">--请选择--</option>
											<c:forEach items="${userList}" var="user">
												<c:if test="${oldman.username != user.name}">
													<option value="${user.id}">${user.name}</option>
												</c:if>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<option value="">--请选择--</option>
											<c:forEach items="${userList}" var="user">
													<option value="${user.id}">${user.name}</option>
											</c:forEach>
										</c:otherwise>
									</c:choose>

								</select>
							</td>
						</tr>

						<tr>
							<td width="90" align="right">老人描述：</td>
							<td><textarea rows="3" cols="30" name="introduce" style="border: 1px solid #c3ced0;">${oldman.introduce}</textarea></td>
						</tr>
						<tr>
							<td width="85" align="right"><input type="submit"
								class="tabSub" value="保存" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>
