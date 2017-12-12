<%@ page language="java" import="java.util.*,com.guimei.entity.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'goods_classmodify.jsp' starting page</title>

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
	<img alt="" src="../image/redarrows.jpg">
	<b>修改大分类</b>
	<hr align="left" width="650px" style="color: orange">
	<%
		Object o = request.getAttribute("gs");
	%>
	<%
		Goods_class gs = (Goods_class) o;
	%>
	<form action="servlet/Goods_classUpdateServlet" method="post">
		<input type="text" style="display: none;" name="id" value=<%=gs.getClass_id()%>>
		<table>
			<tr>
				<td>分类名称（*）：</td>
				<td><input type="text" name="class_name" value=<%=gs.getClass_name()%>>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="修改">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
