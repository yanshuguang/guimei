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

a {
	text-decoration: none;
}
</style>
</head>

<body>
	<img alt="" src="./image/redarrows.jpg">&nbsp;
	<b>公告管理</b>
	<hr align="left" width="650px" style="color: orange">
	<%
		Object o = request.getAttribute("anns");
	%>
	<%
		List<Announcement> users = (List<Announcement>) o;
	%>
	<%
		Iterator<Announcement> i = users.iterator();
	%>


	<table>
		<tr id="tr_bg">
			<th>编号</th>
			<th>公告标题</th>
			<th>操作</th>
		</tr>
		<%
			while (i.hasNext()) {
		%>
		<%
			Announcement u = i.next();
		%>

		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getTitle()%></td>

			<td><a
				href="./servlet/AnnouncementDeleteServlet?id=<%=u.getId()%>"
				target="main" onclick="return confirm('确认此操作？');">删除</a><a
				href="./servlet/AnnouncementModifyServlet?id=<%=u.getId()%>"
				target="main">修改</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
