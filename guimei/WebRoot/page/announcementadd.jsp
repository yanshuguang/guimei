<%@ page language="java" import="java.util.*,com.guimei.entity.*"
	pageEncoding="utf-8"%>
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

<title>My JSP 'usermanage.jsp' starting page</title>

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
	background: url(./image/left_pink.jpg) no-repeat;
}
</style>
</head>

<body>
	<img alt="" src="./image/redarrows.jpg">&nbsp;
	<b>添加公告</b>
	<hr align="left" width="650px" style="color: orange">


	<form action="servlet/AnnouncementAddServlet" method="post">
		<table>
			<tr>
				<td>公告标题（*）：</td>
				<td><input type="text" name="title">
				</td>
			</tr>
			<tr>
				<td>公告内容：</td>
				<td><textarea name="content"></textarea>
				</td>
			</tr>
			<tr><td colspan="2" align="center"><input type="submit" value="添加"></td></tr>

		</table>
	</form>
</body>
</html>
