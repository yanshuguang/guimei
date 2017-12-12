<%@ page language="java" import="java.util.*,com.guimei.entity.*"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ordermanage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#tr_bg {
	background: url(../image/left_pink.jpg) no-repeat;
}
</style>
</head>

<body>
	<img alt="" src="/image/redarrows.jpg">&nbsp;
	<b>订单管理</b>
	<hr align="left" width="650px" style="color: orange">

	<form action="servlet/OrderQuerySubServlet" method="post">
		<table>
			<tr>
				<td>订单号：<input type="text" name="search_order_id"></td>
				<td>订货人：<input type="text" name="search_user_name"></td>
				<td><input type="submit" value="查询"></td>
			</tr>


		</table>
	</form>
	<table>
		<tr id="tr_bg">
			<th>编号</th>
			<th>姓名</th>
			<th>发货地址</th>
			<th>状态</th>
			<th>操作</th>
		</tr>

		<c:forEach items="${orders }" var="order">

			<tr>
				<td>${order.order_id }</td>
				<td>${order.user_name}</td>
				<td>${order.order_address}</td>
				<td><c:if test="${order.order_status==1}">
						<c:out value="待审核">待审核</c:out>
					</c:if> <c:if test="${order.order_status==2}">
						<c:out value="已确认">已确认</c:out>
					</c:if></td>
				<td><a style="text-decoration: none"
					href="./servlet/OrderDeleteServlet?id=${order.order_id}"
					onclick="return confirm('确认此操作？');">删除</a><a
					style="text-decoration: none"
					href="./servlet/OrderModifyServlet?id=${order.order_id}">修改</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>
