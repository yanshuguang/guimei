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
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript">
$(function(){
alert(1);
	$.ajax({
		url:"QueryBigClassServlet",
		type:'post',
		success:function(data){
			var data =eval('('+data+')');
			var optionstring = "";
                     for (var j = 0; j < data.length; j++) {
                     
                         optionstring += "<option value=\"" + data[j].class_id + "\" >" + data[j].class_name + "</option>";
                     }
                     $("#bigclass").html(optionstring);
		},
		error:function(){
		
		}
	
	});
});



</script>
  </head>
  
  <body>
    <select id="bigclass">
						
				
				</select>
  </body>
</html>
