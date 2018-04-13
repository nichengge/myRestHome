
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Integer first = 1;
Integer pass = 100;
Integer nopass = 200;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>内容列表页面</title>
<link href="<%= basePath %>css/all.css" rel="stylesheet" type="text/css" />
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="<%= basePath %>js/order/list.js"></script>
<title>JSP Page</title>
</head>
<body style="background: #e1e9eb;">
	<form action="<%= basePath %>orderList" id="mainForm" method="POST">
		<input type="hidden" name="id" id="id" value="" /> 
		<input type="hidden" name="currentPage" id="currentPage" value="" />
		<input type="hidden" name="pass" id="pass" value="" /> 
		<div class="right">
			<div class="current">
				当前位置：<a href="<%=basePath%>orderList" style="color: #6E6E6E;">内容管理</a>
				&gt; 内容列表
			</div>
			<div class="rightCont">
				<p class="g_title fix">内容列表</p>

				<div class="zixun fix">
					<table class="tab2" width="100%">
						<tbody>
							<tr>
								<th>订单编号</th>
								<th>受理人</th>
								<th>老人姓名</th>
								<th>房间名称</th>
								<th>入住时间</th>
								<th>居住时间</th>
								<th>订单金额</th>
								<th>订单状态</th>
								<th>操作</th>
							</tr>
							<%-- <c:forEach items="${oldmanPage.list}" var="oldmanList"> --%>
							<c:forEach items="${orderPage.list}" var="orderList"
								varStatus="index">
								<tr
									<c:if test="${index.count%2 == 0}">style='background-color:#ECF6EE;'</c:if>>
									<td>${orderList.id }</td>
									<td>${orderList.userName }</td>
									<td>${orderList.oldmanName }</td>
									<td>${orderList.roomName }</td>
									<td><fmt:formatDate value="${orderList.createtime}" pattern="yyyy-MM-dd"/></td>
									<td>${orderList.duration}个月</td>
									<td>${orderList.price }元</td>
									<c:choose>
										<c:when test="${orderList.status == 0}">
											<td>待审核</td>
											<td><a
												href="javascript:ifpass('<%=basePath%>','${orderList.id}','${orderPage.currentPage}','<%=pass%>');">通过</a>&nbsp;&nbsp;
												<a
												href="javascript:ifpass('<%=basePath%>','${orderList.id}','${orderPage.currentPage}','<%=nopass%>');">不通过</a>
												<a
												href="javascript:update('<%=basePath%>','${orderList.id}','${orderPage.currentPage}');">修改</a>
												<a
												href="javascript:delect('<%=basePath%>','${orderList.id}','${orderPage.currentPage}');">删除</a>
											</td>
										</c:when>
										<c:when test="${orderList.status == 1}">
											<td>审核通过</td>
											<td></td>
										</c:when>
										<c:when test="${orderList.status == 2}">
											<td>审核未通过</td>
											<td></td>
										</c:when>
										<c:otherwise>
											<td>订单状态错误</td>
											<td></td>
										</c:otherwise>
									</c:choose>

									<%-- <td>${oldmanPage.list.username }</td> --%>

								</tr>
							</c:forEach>
							<%-- </c:forEach> --%>
						</tbody>
					</table>
					<div class='page fix'>
						共 <b>${ orderPage.allLine}</b> 条 <a
							href="javascript:findPage('<%=basePath%>','<%=first%>');"
							class='first'>首页</a>
						<c:if test="${orderPage.currentPage>1 }">
							<a
								href="javascript:findPage('<%=basePath%>','${orderPage.currentPage-1 }');"
								class='pre'>上一页</a>
						</c:if>
						当前第<span>${orderPage.currentPage }/${orderPage.allPage }</span>页

						<c:if test="${orderPage.currentPage < orderPage.allPage }">
							<a
								href="javascript:findPage('<%=basePath%>','${orderPage.currentPage+1 }');"
								class='next'>下一页</a>
						</c:if>
						<a
							href="javascript:findPage('<%=basePath%>','${orderPage.allPage }');"
							class='last'>末页</a> 跳至&nbsp;<input type='text' id="pageGo"
							value="" class='allInput w28' />&nbsp;页&nbsp; <a
							href="javascript:goPage('<%=basePath%>');"
							class='go'>GO</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
