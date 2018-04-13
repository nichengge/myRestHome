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
	<form action="<%=basePath%>updateOrders" id="updateForm" method="post"
		enctype="multipart/form-data">
		<input type="hidden" id="id" name="id" value="${orders.id}" /> 
		<input type="hidden" id="uid" name="uid" value="${orders.uid}" /> 
		<input type="hidden" id="oldid" name="oldid" value="${orders.oldid}" />
		<input type="hidden" id="roomid" name="roomid" value="${orders.roomid}" /> 
		<input type="hidden" id="currentPage" name="currentPage" value="${currentPage}" />
		<div class="right">
			<div class="current">
				当前位置：<a  style="color: #6E6E6E;">用户管理</a>
				&gt; 信息维护
			</div>
			<div class="rightCont">
				<p class="g_title fix">信息维护</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">护理人员：</td>
							<td>
								<select name="userName">
									<option value="${orders.userName}">${orders.userName}</option>
									<c:forEach items="${userList}" var="user">
										<option value="${user.username }">${user.username }</option>
									</c:forEach>
								</select>
							</td>

						</tr>
						<tr>
							<td width="90" align="right">老人姓名：</td>
							<td>
								<select name="oldmanName">
									<option value="${orders.oldmanName}">${orders.oldmanName}</option>
									<c:forEach items="${oldmanList}" var="oldman">
										<option value="${oldman.name }">${oldman.name }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td width="90" align="right">房间名称：</td>
							<td>
								<select name="roomName">
									<c:forEach items="${roomList}" var="room">
										<option value="${room.name }">${room.name }</option>
									</c:forEach>
								</select>
							</td>
							
						</tr>
						<tr>
							<td width="90" align="right">居住时间：</td>
							<td>
								<input type="text" id="duration" name="duration"
									class="allInput" value="${orders.duration}" />个月
							</td>
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
