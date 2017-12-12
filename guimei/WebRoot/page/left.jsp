<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'left.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.fontjiacu {
	font-weight: bold;
	background-color: RGB(216, 216, 216);
	text-align: left;
}

#tb_left {
	position: absolute;
	left: 200px;
}

a {
	text-decoration: none;
}
</style>
</head>

<body>
	<table id="tb_left">
		<tr>
			<td colspan="2">您现在的位置：贵美商城>后台管理</td>
		</tr>
		<tr>
			<td colspan="2" class="fontjiacu">用户管理</td>
		</tr>
		<tr>
			<td><img alt="" src="../image/pinkarrows.jpg"><a
				href="../servlet/UserManagerServlet" target="main">用户管理</a></td>
			<td><a href="useradd.jsp" target="main">新增</a></td>
		</tr>
		<tr>
			<td colspan="2" class="fontjiacu">商品分类管理</td>
		</tr>
		<tr>
			<td><img alt="" src="../image/pinkarrows.jpg"><a href="../servlet/Goods_classManageServlet" target="main">大分类管理</a></td>
			<td><a href="./goods_classadd.jsp" target="main">新增</a></td>
		</tr>
		<tr>
			<td><img alt="" src="../image/pinkarrows.jpg"><a href="../servlet/Goods_categoryManageServlet" target="main">小分类管理</a></td>
			<td><a href="./goods_categoryadd.jsp" target="main">新增</a></td>
		</tr>
		<tr>
			<td colspan="2" class="fontjiacu">订单管理</td>
		</tr>
		<tr>
			<td colspan="2"><img alt="" src="../image/pinkarrows.jpg"><a
				href="../servlet/OrderQueryServlet" target="main">订单管理</a></td>
		</tr>
		<tr>
			<td colspan="2" class="fontjiacu">商品详细管理</td>
		</tr>
		<tr>
			<td colspan="2"><img alt="" src="../image/pinkarrows.jpg"><a href="../servlet/Goods_detailManageServlet" target="main">商品详细管理</a></td>
			
		</tr>
		<tr>
			<td colspan="2" class="fontjiacu">公告管理</td>
		</tr>
		<tr>
			<td><img alt="" src="../image/pinkarrows.jpg"><a
				href="../servlet/AnnouncementManageServlet" target="main">公告管理</a></td>
			<td><a href="announcementadd.jsp" target="main">新增</a></td>
		</tr>
	</table>
</body>
</html>
