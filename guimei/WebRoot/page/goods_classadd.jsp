<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goods_classadd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="./js/jquery-1.11.3.js"></script>
	<script type="text/javascript">
	function checkBigClassName(){
		var classname=$('#class_name').val();
		$.ajax({
			url:"servlet/checkbigclassname",
			type:'post',
			data:{"classname":classname},//要传输的前台classname
			success:function(data){
			data=eval('('+data+')');
			$('#message').innerTHML= data.message;
				if(data.message){
				//如果用户名存在或者不合法，提交按钮不能提交
				}
				
			},
			error:function(){
				alert("error");
			}
		});
	};
	
	$('#class_name').blur(function(){
		checkBigClassName();
	});
	</script>
  </head>
  
  <body>
  <img alt="" src="./image/redarrows.jpg">&nbsp;<b>添加大分类</b>
  <hr align="left" width="650px" style="color: orange">
    <form action="servlet/Goods_classAddServlet" method="post">
    	<table>
    		<tr><td>分类名称：</td><td><input type="text" name="class_name" id="class_name"><span id="message"></span></td></tr>
    		<tr><td></td><td><input type="submit" value="添加"></td></tr>
    	
    	
    	</table>
    	
    	
    </form>
  </body>
</html>
