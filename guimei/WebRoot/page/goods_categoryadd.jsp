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

<title>My JSP 'goods_categoryadd.jsp' starting page</title>

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
$(function(){

	$.ajax({
		url:"servlet/QueryBigClassServlet",
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
			alert("哎呦，出了点小问题");
		}
	
	});
});


</script>
</head>

<body>
	<img alt="" src="./image/redarrows.jpg">&nbsp;
	<b>添加小分类</b>
	<hr align="left" width="650px" style="color: orange">
	<form action="servlet/Goods_categoryAddServlet" method="post">
		<table>
			<tr>
				<td>商品类别名称（*）：</td>
				<td><input type="text" name="class_name"></td>
			</tr>
			<tr>
				<td>所属大分类：</td>
				<td><select id="bigclass" name="bigclass">
						
				
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="添加"></td>
			</tr>


		</table>


	</form>

</body>
</html>

