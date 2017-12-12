<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'login.jsp' starting page</title>

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
	margin: 0px auto;
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
}

#head {
	position: relative;
}

#mid {
	
}

#tb_head td {
	width: 100px;
	text-align: center;
	background-color: RGB(216, 216, 216);
}
#tb_mid td{
text-align: center;
}
#welcome {
	position: relative;
	background: orange;
}

#foot {
	position: relative;
	top: 100px;
	text-align: center;
	background-color: RGB(216, 216, 216);
	width: 1000px;
	margin: 0px auto;
	text-align: center;
}
</style>
</head>

<body>
	<div id="logo">
		<img alt="" src="image/logo.jpg">

	</div>
	<div id="head">
		<center>
			<table id="tb_head">
				<tr>
					<td><a href="#">首页</a></td>
					<td><a href="#">用户</a></td>
					<td><a href="#">商品分类</a></td>
					<td><a href="#">订单</a></td>
					<td><a href="#">商品详细</a></td>
					<td><a href="#">公告</a></td>
				</tr>
			</table>
		</center>
	</div>
	<div id="welcome">
		<marquee>
			管理员你好，今天是<%=new Date()%>，欢迎回到管理后台。
		</marquee>
	</div>

	<div id="mid">
		您现在的位置：贵美商城&nbsp;>&nbsp;后台管理<br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
			alt="" src="image/redarrows.jpg"> <b>管理首页</b>
		<hr id="line"  width="700px" style="color: orange">
		<center>
		<br><br>
		
			<h2>欢迎登录贵美商城系统</h2>
			<form action="LoginServlet" method="post">
				<table id="tb_mid">
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="login_name" /></td>
					</tr>
					<tr>
						<td>登录密码：</td>
						<td><input type="password" name="login_password" /></td>
					</tr>
					<tr>
						<td>验证码：</td>
						<td><img id="imgchange"alt="" src="checkImage" onclick="change()"/><input type="text" name="checkimg" /></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="submit"
							value="立即登录"  style="background:green;color:white" /></td>
					</tr>

				</table>

			</form>
		</center>
	</div>
	<div id="foot">CopyRight&copy;2017博创华宇 All &nbsp;Rights&nbsp;
		Reserved.京ICP证1000001号</div>
</body>
<script type="text/javascript">

	function change(){
		var img=document.getElementById("imgchange");
		img.setAttribute("src", "checkImage?time="+new Date().getTime());
	
	}

</script>
</html>

