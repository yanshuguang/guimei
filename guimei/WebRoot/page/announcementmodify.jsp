<%@ page language="java" import="java.util.*,com.guimei.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
#tr_bg{

background: url(./image/left_pink.jpg) no-repeat;
}
</style>
  </head>
  
  <body>
   <img alt="" src="./image/redarrows.jpg">&nbsp;<b>修改公告</b>
  <hr align="left" width="650px" style="color: orange">
  <%Object o=request.getAttribute("ann"); %>
  <%Announcement ann=(Announcement)o; %>
  <form action="servlet/AnnouncementUpdateServlet" method="post">
  	<input type="text" value=<%=ann.getId() %> style="display: none" name="id">
  	<table>
  		<tr><td>公告标题（*）：</td><td><input type="text" name="title" value=<%=ann.getTitle() %>></td></tr>
  		<tr><td>公告内容：</td><td><textarea name="content"><%=ann.getContent() %></textarea></td></tr>
  		<tr><td align="center" colspan="2"><input type="submit" value="修改"></td></tr>
  	</table>
  </form>
  
  
  
  </body>
</html>
