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

<title>My JSP 'goods_detailmanage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<img alt="" src="./image/redarrows.jpg">&nbsp;
	<b>商品详细信息管理</b>
	<hr align="left" width="650px" style="color: orange">
	<table>
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>所属分类</th>
			<th>价格</th>
			<th>剩余数量</th>
			<th>图片</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${gds }" var="goods_detail">
			<tr>
				<td>${goods_detail.good_id }</td>
				<td>${goods_detail.goods_name }</td>
				<td>${goods_detail.fenlei}</td>
				<td>${goods_detail.price }</td>
				<td>${goods_detail.remaining }</td>
				<td><img src="${goods_detail.pic }"></td>
				<td><a href="./servlet/Goods_detailDeleteServlet?id=${goods_detail.good_id }" target="main" onclick="return confirm('确认此操作？');">删除</a><a href="./servlet/Goods_detailModifyServlet?id=${goods_detail.good_id }" target="main">修改</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
