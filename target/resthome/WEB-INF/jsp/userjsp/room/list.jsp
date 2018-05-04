
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Integer first = 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>内容列表页面</title>
<link href="<%= basePath %>css/all.css" rel="stylesheet" type="text/css" />
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="<%= basePath %>js/all.js"></script>
<title>JSP Page</title>
</head>
<body style="background: #e1e9eb;">
	<form action="${page.url}" id="mainForm" method="POST">

		<div class="right">
			<div class="current">
				当前位置：<a href="<%=basePath%>paramedic/restRoom" style="color: #6E6E6E;">内容管理</a>
				&gt; 内容列表
			</div>
			<div class="rightCont">
				<p class="g_title fix">
					内容列表 
				</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">房间名称：</td>
							<td><input type="text" name="name"
								class="allInput" value="" />
								<input type="hidden" id = "pageNum" name="pageNum" value=""/>
							</td>

							<td width="85" align="right"><input type="submit"
								class="tabSub" value="查 询" /></td>
						</tr>
					</tbody>
				</table>
				<div class="zixun fix">
					<table class="tab2" width="100%">
						<tbody>
						<tr>
							<th><input type="checkbox" id="all"
									   onclick="javascript:checkAll();" /></th>
							<th>房间编号</th>
							<th>房间照片</th>
							<th>房间名称</th>
							<th>房间价格</th>
							<th>房间类型</th>
							<th>房间面积</th>
							<th>房间配置</th>
							<th>入住老人</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${roomList}" var="room" varStatus="index">
							<tr
									<c:if test="${index.count%2 == 0}">style='background-color:#ECF6EE;'</c:if>>
								<td><input type="checkbox" name="checkId"
										   value="${room.id}" /></td>
								<td>${room.id}</td>
								<td>
									<c:if test="${room.pic !=null}">
										<img alt="房间照片" src="/pic/${room.pic }" width="50px" height="50px">
									</c:if>
								</td>
								<td>${room.name }</td>
								<td>${room.price }元/月</td>
								<td>${room.type }</td>
								<td>${room.area }平方米</td>
								<td>${room.configure}</td>
								<td>${room.oldmanname }</td>
								<td><a href="<%=basePath%>paramedic/register?roomid=${room.id}">-->登记入住</a></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<div class='page fix'>
						共 <b>${page.total}</b> 条
						<a href="${page.url}&pageNum=1" class='first'>首页</a>
						<c:if test="${page.pageNum > 1}">
							<a href="${page.url}&pageNum=${page.prePage}" class='pre'>上一页</a>
						</c:if>
						当前第<span>${page.pageNum}/${page.pages}</span>页
						<c:if test="${page.pageNum < page.pages}">
							<a href="${page.url}&pageNum=${page.nextPage}" class='next'>下一页</a>
						</c:if>
						<a href="${page.url}&pageNum=${page.pages}" class='last'>末页</a>
						跳至&nbsp; <input type='text' id="pageGo" value="" class='allInput w28' />&nbsp;页&nbsp;
						<a href="javascript:goPage('${page.pages}');" class='go'>GO</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
