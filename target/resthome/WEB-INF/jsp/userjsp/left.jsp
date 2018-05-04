<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>left</title>
<base target="body" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<script src="http://libs.baidu.com/jquery/1.8.0/jquery.min.js"></script>
<script src="<%= basePath %>js/user/left.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
* {
	font-size: 10pt;
	text-align: center;
}

div {
	background: #87CEFA;
	margin: 3px;
	padding: 3px;
}

a {
	text-decoration: none;
}
</style>
</head>

<body>


	<div>
		<a href="<%= basePath%>paramedic/myMessage">我的信息</a>

	</div>

	<div>
		<a href="<%= basePath%>paramedic/oldman/list">我的老人</a>

	</div>

	<div>
		<a href="<%= basePath%>paramedic/restRoom">剩余房间</a>

	</div>
	<div>
		<a href="<%= basePath%>paramedic/orders/list">我的订单</a>
	</div>

	<div>
		<a href="<%= basePath%>paramedic/leave/queryBeforeInsert">申请请假</a>
	</div>

</body>
</html>
