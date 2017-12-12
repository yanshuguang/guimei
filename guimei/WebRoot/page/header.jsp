<%@ page language="java" import="java.util.*,com.guimei.entity.*"
	pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>My JSP 'header.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript">
	$(function() {
		$('td').mouseover(
				function() {
					$(this).css('background-color', 'orange').css('font-color',
							'white');

				});
		$('td').mouseout(function() {
			$(this).css('background-color', 'RGB(216,216,216)');
		});

	});
</script>
<style type="text/css">
div {
	width: 1000px;
}

a {
	text-decoration: none;
}

a:hover {
	color: white;
	background-color: orange;
}

#logo {
	position: relative;
	top: 0px;
	left: 200px;
}

#head {
	position: relative;
	top: 0px;
	left: 200px;
}

#tb_head td {
	width: 100px;
	text-align: center;
	background-color: RGB(216, 216, 216);
}

#welcome {
	position: relative;
	top: 0px;
	left: 200px;
	background: orange;
}
</style>
</head>

<body>
	<div id="logo">
		<img alt="" src="../image/logo.jpg">

	</div>
	<div id="head">
		<center>
			<table id="tb_head">
				<tr>
					<td><a href="#">首页</a></td>
					<td><a href="../servlet/UserManagerServlet" target="main">用户</a></td>
					<td><a href="../servlet/Goods_classManageServlet" target="main">商品分类</a></td>
					<td><a href="../servlet/OrderQueryServlet" target="main">订单</a></td>
					<td><a href="../servlet/Goods_detailManageServlet" target="main">商品详细</a></td>
					<td><a href="../servlet/AnnouncementManageServlet" target="main">公告</a></td>
				</tr>
			</table>
		</center>
	</div>
	<div id="welcome">
		<%
			Object o = request.getSession().getAttribute("login");
		%>
		<%
			Login login = (Login) o;
		%><marquee>
			<%=login.getUsername() %>管理员你好，今天是<%=new Date()%>，欢迎回到管理后台。
		</marquee>
		您现在的位置：贵美商城 &nbsp;>&nbsp;后台管理
	</div>

</body>
</html>
