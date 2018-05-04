<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
    <base target="body"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script src="<%= basePath %>js/user/list.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			font-size:10pt;
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
	<a href="<%= basePath%>user/list" >用户管理</a>
	
</div>
<div>
	<a href="<%= basePath%>oldman/list" >老人管理</a>
	
</div>
<div>
	<a href="<%= basePath%>room/list">房间管理</a>
	
</div>

<div>
	<a href="<%= basePath%>orders/list">订单管理</a>
	
</div>

<div>
	<a href="<%= basePath%>salary/list">工资管理</a>
</div>

<div>
	<a href="<%= basePath%>leave/list">请假管理</a>
</div>
<div>
	<a href="<%= basePath%>lelve/list">护理等级</a>
</div>
<div>
	<a href="<%= basePath%>counts/list">工资统计</a>
</div>


<%-- <c:forEach items="${categoryList }" var="category">
<div>
	<a href="<c:url value='/BookServlet?method=findByCategory&cid=${category.cid }'/>">${category.cname }</a>
</div>
</c:forEach> --%>
  </body>
</html>
