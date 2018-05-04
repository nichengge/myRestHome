<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <title>内容列表页面</title>
    <link href="<%= basePath %>css/all.css" rel="stylesheet" type="text/css"/>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="<%= basePath %>js/all.js"></script>
    <title>JSP Page</title>
</head>
<body style="background: #e1e9eb;">
<form action="${page.url}" id="mainForm" method="get">
    <input type="hidden" id="pageNum" name="pageNum" value=""/>
    <div class="right">
        <div class="current">
            当前位置：内容管理
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
                    </tr>
                    <c:forEach items="${ordersList}" var="orders"
                               varStatus="index">
                        <tr
                                <c:if test="${index.count%2 == 0}">style='background-color:#ECF6EE;'</c:if>>
                            <td>${orders.id }</td>
                            <td>${orders.username }</td>
                            <td>${orders.oldmanname }</td>
                            <td>${orders.roomname }</td>
                            <td><fmt:formatDate value="${orders.createtime}" pattern="yyyy-MM-dd"/></td>
                            <td>${orders.duration}个月</td>
                            <td>${orders.price }元</td>
                            <c:choose>
                                <c:when test="${orders.status == 0}">
                                    <td>待审核</td>
                                </c:when>
                                <c:when test="${orders.status == 1}">
                                    <td>审核通过</td>
                                </c:when>
                                <c:when test="${orders.status == 2}">
                                    <td>审核未通过</td>
                                    <td></td>
                                </c:when>
                                <c:otherwise>
                                    <td>订单状态错误</td>
                                </c:otherwise>
                            </c:choose>
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
                    跳至&nbsp; <input type='text' id="pageGo" value="" class='allInput w28'/>&nbsp;页&nbsp;
                    <a href="javascript:goPage('${page.pages}');" class='go'>GO</a>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
