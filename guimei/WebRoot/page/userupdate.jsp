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

<title>My JSP 'userupdate.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
input {
	
}
</style>
</head>

<body>
	<img alt="" src="./image/redarrows.jpg">&nbsp;
	<b>修改用户</b>
	<hr align="left" width="650px" style="color: orange">
	<%
		User user = (User) request.getAttribute("user");
	%>
	<form action="servlet/UserUpdateServlet" method="post" name="update">
		<input type="text" style="display: none;" name="id"
			value=<%=user.getId()%> />
		<table>
			<tr>
				<td>用户名（*）：</td>
				<td><input type="text" name="user_name"
					value=<%=user.getUser_name()%>></td>
			</tr>
			<tr>
				<td>真实姓名（*）：</td>
				<td><input type="text" name="user_realname"
					value=<%=user.getUser_realname()%>></td>
			</tr>
			<tr>
				<td>登录密码（*）：</td>
				<td><input type="password" name="user_pwd"
					value=<%=user.getUser_pwd()%>></td>
			</tr>
			<tr>
				<td>确认密码（*）：</td>
				<td><input type="password" name="user_checkpwd" value=<%=user.getUser_pwd()%>></td>
			</tr>
			<tr>
				<td>性别（*）：</td>
				<td><input type="radio" name="user_sex" value="男"
					<%=(user.getUser_gender().trim().equals("男") ? "checked"
					: "")%>>男<input
					type="radio" name="user_sex" value="女"
					<%=(user.getUser_gender().trim().equals("女") ? "checked"
					: "")%>>女</td>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td><input type="text" name="user_birthdate"
					value=<%=user.getUser_birthdate()%>></td>
			</tr>
			<tr>
				<td>身份证：</td>
				<td><input type="text" name="user_id"
					value=<%=user.getUser_id()%>></td>
			</tr>
			<tr>
				<td>电子邮件：</td>
				<td><input type="text" name="user_email"
					value=<%=user.getUser_email()%>></td>
			</tr>
			<tr>
				<td>手机：</td>
				<td><input type="text" name="user_phone"
					value=<%=user.getUser_phone()%>></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" name="user_address"
					value=<%=user.getUser_address()%>></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="更新"></td>
			</tr>

		</table>
	</form>

</body>
</html>
