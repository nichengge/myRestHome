
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
<script src="http://libs.baidu.com/jquery/1.8.0/jquery.min.js"></script>
<script src="<%= basePath %>js/userjsp/oldman/list.js"></script>
<title>JSP Page</title>
</head>
<body style="background: #e1e9eb;">
	<form action="<%= basePath %>oldmanList" id="mainForm" method="POST">
		 <input type="hidden" name="id" id="id" value="" />
		 <input type="hidden" name="currentPage" id="currentPage" value="" />
		  <input type="hidden" name="userId" id="userId" value="${oldman.userId }" />
		<div class="right">
			<div class="current">
				当前位置：<a href="javascript:neirong('<%=basePath %>');" style="color: #6E6E6E;">内容管理</a>
				&gt; 内容列表
			</div>
			<div class="rightCont">
				<p class="g_title fix">
					内容列表
					 <a class="btn03" href="javascript:addOldman('<%=basePath%>','${oldman.name}');">新增</a>&nbsp;&nbsp;&nbsp;&nbsp;
					 <a class="btn03" href="javascript:deleteBath('<%=basePath%>','${oldman.name}','${oldmanPage.currentPage}');">删除</a>
				</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">老人名称：</td>
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
								<th>老人编号</th>
								<th>老人照片</th>
								<th>老人姓名</th>
								<th>老人性别</th>
								<th>老人生日</th>
								<th>老人年龄</th>
								<th>护理人员</th>
								<th>操作</th>
							</tr>
							<%-- <c:forEach items="${oldmanPage.list}" var="oldmanList"> --%>
								<c:forEach items="${oldmanPage.list}" var="oldmanList" varStatus="index">
									<tr
									<c:if test="${index.count%2 == 0}">style='background-color:#ECF6EE;'</c:if>>
									<td><input type="checkbox" name="checkId"
										value="${oldmanList.id }" /></td>
										<td>${oldmanList.id }</td>
										<td>
											<c:if test="${oldmanList.pic !=null}">
												<img alt="老人照片" src="/pic/${oldmanList.pic }" width="50px" height="50px">
											</c:if>
										</td>
										<td>${oldmanList.name }</td>
										<td>${oldmanList.gender }</td>
										<td><fmt:formatDate value="${oldmanList.birthday}" pattern="yyyy-MM-dd"/></td>
									
										<td>${oldmanList.age }</td>
										<td>${oldmanList.username}</td>
									
									<%-- <td>${oldmanPage.list.username }</td> --%>
									<td><a
										href="javascript:update('<%=basePath%>','${oldmanList.id}','${oldman.name}','${oldmanPage.currentPage}');">修改</a>&nbsp;&nbsp;&nbsp;
										<a
										href="javascript:deleteOne('<%=basePath%>','${oldmanList.id}','${oldman.name}','${oldmanPage.currentPage}');">删除</a>
									</td>
									</tr>
								</c:forEach>
							<%-- </c:forEach> --%>
						</tbody>
					</table>
					<div class='page fix'>
						共 <b>${ oldmanPage.allLine}</b> 条 <a
							href="javascript:findPage('<%=basePath%>','${oldman.name}','<%=first%>');"
							class='first'>首页</a>
						<c:if test="${oldmanPage.currentPage>1 }">
							<a
								href="javascript:findPage('<%=basePath%>','${oldman.name}','${oldmanPage.currentPage-1 }');"
								class='pre'>上一页</a>
						</c:if>
						当前第<span>${oldmanPage.currentPage }/${oldmanPage.allPage }</span>页

						<c:if test="${oldmanPage.currentPage < oldmanPage.allPage }">
							<a
								href="javascript:findPage('<%=basePath%>','${oldman.name}','${oldmanPage.currentPage+1 }');"
								class='next'>下一页</a>
						</c:if>
						<a
							href="javascript:findPage('<%=basePath%>','${oldman.name}','${oldmanPage.allPage }');"
							class='last'>末页</a> 跳至&nbsp;<input type='text' id="pageGo"
							value="" class='allInput w28' />&nbsp;页&nbsp; <a
							href="javascript:goPage('<%=basePath%>','${oldman.name}');" class='go'>GO</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
