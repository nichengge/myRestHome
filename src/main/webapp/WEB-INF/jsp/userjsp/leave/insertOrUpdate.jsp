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
	<form action="<%=basePath%>paramedic/leave/insert" id="updateForm" method="post">

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
							<td width="90" align="right">请假原因：</td>
							<td><input type="text" name="reason"
								class="allInput" value=""/></td>
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
