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
	<form action="<%=basePath%>updateRoom" id="updateForm" method="post"
		enctype="multipart/form-data">
		<input type="hidden" id="id" name="id" value="${roomQuery.id}" /> <input
			type="hidden" id="oldid" name="oldid" value="${roomQuery.oldid}" />
		<input type="hidden" id="likeName" name="likeName"
			value="${room.name}" /> <input type="hidden" id="currentPage"
			name="currentPage" value="${currentPage}" />
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
							<td><c:if test="${roomQuery.pic !=null}">
									<img src="/pic/${roomQuery.pic}" width=100 height=100 />
									<br />
								</c:if> <input type="file" id="oldpic" name="oldpic" /></td>

						</tr>
						<tr>
							<td width="90" align="right">房间名称：</td>
							<td><input type="text" id="name" name="name"
								class="allInput" value="${roomQuery.name }" /></td>
						</tr>
						<tr>
							<td width="90" align="right">房间类型：</td>
							<td><select id="type" name="type">
									<c:choose>
										<c:when test="${roomQuery.type eq '经典型' }">
											<option value="经典型">经典型</option>
											<option value="豪华型">豪华型</option>
										</c:when>
										<c:otherwise>
											<option value="豪华型">豪华型</option>
											<option value="经典型">经典型</option>
										</c:otherwise>
									</c:choose>
							</select></td>
						</tr>
						<tr>
							<td width="90" align="right">房间价格：</td>
							<td><input type="text" id="price" name="price"
								class="allInput" value="${roomQuery.price}" /></td>
						</tr>
						<tr>
							<td width="90" align="right">房间面积：</td>
							<td><input type="text" id="area" name="area"
								class="allInput" value="${roomQuery.area }" /></td>
						</tr>
						<tr>
							<td width="90" align="right">入住老人：</td>
							<td><select id="oldmanName" name="oldmanName">
									
									
									<c:choose>
										<c:when test="${!empty roomQuery.oldmanName}">
											<option value="${roomQuery.oldmanName }">${roomQuery.oldmanName }</option>
											<option value="----">----</option>
										</c:when>
										<c:otherwise>
											<option value="----">----</option>
										</c:otherwise>
									</c:choose>
									<c:forEach items="${oldmanList }" var="oldman">
										<option value="${oldman.name}">${oldman.name}</option>
									</c:forEach>
									
							</select></td>
						</tr>

						<tr>
							<td width="90" align="right">房间配置：</td>
							<td><textarea rows="3" cols="30" id="configure"
									name="configure" style="border: 1px solid #c3ced0;">${roomQuery.configure}</textarea></td>
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
