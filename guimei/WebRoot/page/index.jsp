<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!--  <iframe src="./admin/header.jsp" width="100%"></iframe>-->
  
   <frameset rows="160px,*,100px" border="0">
  		
  		<frame src="./page/header.jsp" name="header">
  		<frameset cols="460px,*">
  			<frame src="./page/left.jsp" name="left">
  			<frame src="./page/right.jsp" name="main">
  		</frameset>
  		<frame src="./page/foot.jsp"/>
  </frameset>
 
</html>
