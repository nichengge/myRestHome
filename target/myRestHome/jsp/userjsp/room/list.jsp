
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
<script src="<%= basePath %>js/userjsp/room/list.js"></script>
<title>JSP Page</title>
</head>
<body style="background: #e1e9eb;">
	<form action="<%= basePath %>restOfRoom" id="mainForm" method="POST">
		<input type="hidden" name="id" id="id" value="" /> <input
			type="hidden" name="currentPage" id="currentPage" value="" />
		<div class="right">
			<div class="current">
				当前位置：<a href="<%=basePath%>restOfRoom" style="color: #6E6E6E;">内容管理</a>
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
							<td><input type="text" id="name" name="name"
								class="allInput" value="" /></td>

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
								<th>操作</th>
							</tr>
							<%-- <c:forEach items="${oldmanPage.list}" var="oldmanList"> --%>
								<c:forEach items="${roomPage.list}" var="roomList" varStatus="index">
									<tr
									<c:if test="${index.count%2 == 0}">style='background-color:#ECF6EE;'</c:if>>
									<td><input type="checkbox" name="checkId"
										value="${roomList.id }" /></td>
										<td>${roomList.id }</td>
										<td>
											<c:if test="${roomList.pic !=null}">
												<img alt="房间照片" src="/pic/${roomList.pic }" width="50px" height="50px">
											</c:if>
										</td>
										<td>${roomList.name }</td>
										<td>${roomList.price }元/月</td>
										<td>${roomList.type }</td>
										<td>${roomList.area }平方米</td>
										<td>${roomList.configure}</td>
									
									<%-- <td>${oldmanPage.list.username }</td> --%>
									<td>
										<a href="javascript:openedQuery('<%=basePath%>','${roomList.id }');">登记入住</a>
									</td>
									</tr>
								</c:forEach>
							<%-- </c:forEach> --%>
						</tbody>
					</table>
					<div class='page fix'>
						共 <b>${ roomPage.allLine}</b> 条 <a
							href="javascript:findPage('<%=basePath%>','${room.name}','<%=first%>');"
							class='first'>首页</a>
						<c:if test="${roomPage.currentPage>1 }">
							<a
								href="javascript:findPage('<%=basePath%>','${room.name}','${roomPage.currentPage-1 }');"
								class='pre'>上一页</a>
						</c:if>
						当前第<span>${roomPage.currentPage }/${roomPage.allPage }</span>页

						<c:if test="${roomPage.currentPage < roomPage.allPage }">
							<a
								href="javascript:findPage('<%=basePath%>','${room.name}','${roomPage.currentPage+1 }');"
								class='next'>下一页</a>
						</c:if>
						<a
							href="javascript:findPage('<%=basePath%>','${room.name}','${roomPage.allPage }');"
							class='last'>末页</a> 跳至&nbsp;<input type='text' id="pageGo"
							value="" class='allInput w28' />&nbsp;页&nbsp; <a
							href="javascript:goPage('<%=basePath%>','${room.name}');" class='go'>GO</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
