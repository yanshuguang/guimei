<%@ page language="java" import="java.util.*,com.guimei.entity.*,com.guimei.util.*"
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
	<b>用户管理</b>
	<hr align="left" width="650px" style="color: orange">
	<%Object o = session.getAttribute("users"); %>
    <%List<User> sps = (List<User>)o; %>
    <% Object o1 = session.getAttribute("page"); %>
    <% PageUtil pu = (PageUtil)o1; %>
	
	<%
		List<User> users = (List<User>) o;
	%>
	<%
		Iterator<User> i = users.iterator();
	%>


	<table border="1">
		<tr id="tr_bg">
			<th>用户名</th>
			<th>真实姓名</th>
			<th>性别</th>
			<th>Email</th>
			<th>手机</th>
			<th>操作</th>
		</tr>
		<%
			while (i.hasNext()) {
		%>
		<%
			User u = i.next();
		%>

		<tr>
			<td><%=u.getUser_name()%></td>
			<td><%=u.getUser_realname()%></td>
			<td><%=u.getUser_gender()%></td>
			<td><%=u.getUser_email()%></td>
			<td><%=u.getUser_phone()%></td>
			<td><a style="text-decoration: none"
				href="./servlet/UserDeleteServlet?id=<%=u.getId()%>"
				onclick="return confirm('确认此操作？');">删除</a><a
				style="text-decoration: none"
				href="./servlet/UserModifyServlet?id=<%=u.getId()%>">修改</a></td>
		</tr>
		<%
			}
		%>
		<tr><td colspan="6"><%=pu.getLink("servlet/UserManagerServlet") %></td></tr>
	</table>
</body>
</html>
