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
<script type="text/javascript">
function test() {
	var roomid = $("#roomid").prop("value")
	var duration = $("#duration").prop("value")
	
	$.ajax({
        type: 'post',
        url: 'amount',
        data: {roomid: roomid,duration: duration},
        success: function(res){
        	$("#count").html(res);
        }
    });
}
</script>
<body style="background: #e1e9eb;">
	<form action="<%=basePath%>opened" id="addForm" method="post"
		enctype="multipart/form-data">
		<input type="hidden" id="uid" name= "uid" value="${sessionScope.user.id}"/>
		<input type="hidden" id="roomid" name= "roomid" value="${room.id}"/>
		<div class="right">
			<div class="current">
				当前位置：<a  style="color: #6E6E6E;">订单管理</a>
				&gt; 信息维护
			</div>
			<div class="rightCont">
				<p class="g_title fix">信息维护</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">入住房间：</td>
							<td>${room.name}</td>
						</tr>
						<tr>
							<td width="90" align="right">入住老人：</td>
							<td>
								<select name = oldmanName>
									<c:forEach items="${oldmanList}" var="oldman">
										<option value="${oldman.name}">${oldman.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td width="90" align="right">住宿时间：</td>
							<td><input type="text" id="duration" name="duration"
								class="allInput" value="" onblur='test()'/>个月</td>
						</tr>
						<tr>
							<td width="90" align="right">总金额：</td>
							<td><span id = "count"></span></td>
						</tr>
						<tr>
							<td width="85" align="right"><input type="submit"
								class="tabSub" value="申请入住" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>
