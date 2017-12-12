<%@ page language="java" import="java.util.*,com.guimei.entity.*"
	pageEncoding="UTF-8"%>
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

<title>My JSP 'goods_classmanage.jsp' starting page</title>

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
	<b>大分类管理</b>
	<hr align="left" width="650px" style="color: orange">
	<%
		Object o = request.getAttribute("gcs");
	%>
	<%
		List<Goods_class> good = (List<Goods_class>) o;
	%>
	<%
		Iterator<Goods_class> i = good.iterator();
	%>


	<table>
		<tr id="tr_bg">
			<th>编号</th>
			<th>分类名称</th>
			<th>操作</th>
		</tr>
		<%
			while (i.hasNext()) {
		%>
		<%
			Goods_class u = i.next();
		%>

		<tr>
			<td><%=u.getClass_id()%></td>
			<td><%=u.getClass_name()%></td>

			<td><a
				href="./servlet/Goods_classDeleteServlet?id=<%=u.getClass_id()%>"
				onclick="return confirm('确认此操作？');">删除</a><a
				href="./servlet/Goods_classModifyServlet?id=<%=u.getClass_id()%>">修改</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
