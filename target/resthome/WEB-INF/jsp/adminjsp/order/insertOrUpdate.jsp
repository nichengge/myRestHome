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
	<form action="<%=basePath%>insertOrUpdate" id="updateForm" method="post"
		enctype="multipart/form-data">
			<input type="hidden" name="id" value="${orders.id}"/>
			<input type="hidden" name="uid" value="${orders.uid}"/>

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
								<td>${orders.username}</td>
							</tr>
							<tr>
							<td width="90" align="right">老人姓名：</td>
								<td>
									<select name="oldid">
										<c:choose>
											<c:when test="${!empty orders.oldid}">
												<option value="${orders.oldid}">${orders.oldmanname}</option>
												<option value="">--请选择--</option>
												<c:forEach items="${oldmanList}" var="oldman">
													<c:if test="${orders.oldid != oldman.id}">
														<option value="${oldman.id}">${oldman.name}</option>
													</c:if>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<option value="">--请选择--</option>
												<c:forEach items="${oldmanList}" var="oldman">
													<option value="${oldman.id}">${oldman.name}</option>
												</c:forEach>
											</c:otherwise>
										</c:choose>

									</select>
								</td>
						</tr>
						<tr>
							<td width="90" align="right">房间名称：</td>
							<td>
								<select name="roomid">
									<c:choose>
										<c:when test="${!empty orders.roomid}">
											<option value="${orders.roomid}">${orders.roomname}</option>
											<option value="">--请选择--</option>
											<c:forEach items="${roomList}" var="room">
												<c:if test="${orders.roomid != room.id}">
													<option value="${room.id}">${room.name}</option>
												</c:if>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<option value="">--请选择--</option>
											<c:forEach items="${roomList}" var="room">
													<option value="${room.id}">${room.name}</option>
											</c:forEach>
										</c:otherwise>
									</c:choose>

								</select>
							</td>
							
						</tr>
						<tr>
							<td width="90" align="right">居住时间：</td>
							<td>
								<input type="text" name="duration"
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
