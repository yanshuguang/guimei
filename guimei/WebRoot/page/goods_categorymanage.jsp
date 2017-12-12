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

<title>My JSP 'goods_categorymanage.jsp' starting page</title>

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
	<b>小分类管理</b>
	<hr align="left" width="650px" style="color: orange">
	<%Object o = session.getAttribute("gcs"); %>
    <%List<Goods_category> sps = (List<Goods_category>)o; %>
    <% Object o1 = session.getAttribute("page"); %>
    <% PageUtil pu = (PageUtil)o1; %>
	
	
	
	<%
		List<Goods_category> good = (List<Goods_category>) o;
	%>
	<%
		Iterator<Goods_category> i = good.iterator();
	%>


	<table>
		<tr id="tr_bg">
			<th>编号</th>
			<th>商品小类别</th>
			<th>所属大类别</th>
			<th>操作</th>
		</tr>
		<%
			while (i.hasNext()) {
		%>
		<%
			Goods_category u = i.next();
		%>

		<tr>
			<td><%=u.getClass_id()%></td>
			<td><%=u.getCategory_name()%></td>
			<td><%=u.getClass_name()%></td>

			<td><a
				href="./servlet/Goods_categoryDeleteServlet?id=<%=u.getCategory_id()%>"
				onclick="return confirm('确认此操作？');">删除</a><a
				href="./servlet/Goods_categoryModifyServlet?id=<%=u.getCategory_id()%>">修改</a></td>
		</tr>
		<%
			}
		%>
		<tr><td colspan="4"><%=pu.getLink("servlet/Goods_categoryManageServlet") %></td></tr>
	                                      
	</table>
</body>
</html>
