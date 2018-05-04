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
	<form action="<%=basePath%>room/insertOrUpdate" id="updateForm" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="id" value="${room.id}" />
		<div class="right">
			<div class="current">
				当前位置：<a href="<%=basePath%>room/list" style="color: #6E6E6E;">用户管理</a>
				&gt; 信息维护
			</div>
			<div class="rightCont">
				<p class="g_title fix">信息维护</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">房间照片：</td>
							<td><c:if test="${room.pic !=null}">
									<img src="/pic/${room.pic}" width=100 height=100 />
									<br />
								</c:if>
								<input type="file" name="roomPic" /></td>
						</tr>
						<tr>
							<td width="90" align="right">房间名称：</td>
							<td><input type="text" name="name"
								class="allInput" value="${room.name}" /></td>
						</tr>
						<tr>
							<td width="90" align="right">房间类型：</td>
							<td>
								<c:choose>
									<c:when test="${room.type eq '经典型'}">
										<input type="radio" name="type" value="经典型" checked/>经典型
										<input type="radio" name="type" value="豪华型"/>豪华型
									</c:when>
									<c:when test="${room.type eq '豪华型'}">
										<input type="radio" name="type" value="经典型"/>经典型
										<input type="radio" name="type" value="豪华型" checked/>豪华型
									</c:when>
									<c:otherwise>
										<input type="radio" name="type" value="经典型"/>经典型
										<input type="radio" name="type" value="豪华型"/>豪华型
									</c:otherwise>
								</c:choose>

							</td>
						</tr>
						<tr>
							<td width="90" align="right">房间价格：</td>
							<td><input type="text" name="price"
								class="allInput" value="${room.price}" /></td>
						</tr>
						<tr>
							<td width="90" align="right">房间面积：</td>
							<td><input type="text" name="area"
								class="allInput" value="${room.area }" /></td>
						</tr>
						<tr>
							<td width="90" align="right">入住老人：</td>
							<td>
								<select name="oldid">
									<c:choose>
										<c:when test="${!empty room.oldid}">
											<option value="${room.oldid}">${room.oldmanname}</option>
											<option value="">--请选择--</option>
											<c:forEach items="${oldmanList}" var="oldman">
												<c:if test="${room.oldid != oldman.id}">
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
							<td width="90" align="right">房间配置：</td>
							<td><textarea rows="3" cols="30" name="configure" style="border: 1px solid #c3ced0;">${room.configure}</textarea></td>
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
