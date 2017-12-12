<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>My JSP 'goods_detailmodify.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="./js/jquery-1.11.3.js"></script>
<!-- <script type="text/javascript">
	
		$('#imageuploadbtn').click(function (){
			$.ajax({
				url:"servlet/changeImageServlet",
				type:'post',
				success:function(data){
				
					$('#image').get(0).setAttribute("src", data);
				},
				error:function(){}
			})
		});
	
	
</script> -->
</head>
<body>
<img alt="" src="./image/redarrows.jpg">&nbsp;
	<b>修改商品详细信息</b>
	<hr align="left" width="650px" style="color: orange">
<form action="servlet/Goods_detailUpdateServlet?id=${gd.good_id }"
	method="post" enctype="multipart/form-data">
	<input type="text" name="id" style="display: none;" value="${gd.good_id }">
	<table>
		<tr>
			<td>商品编号：</td>
			<td><input  type="text" name="goods_detail_id"
				value="${gd.good_id} "></td>
		</tr>
		<tr>
			<td>商品名称：</td>
			<td><input  type="text" name="goods_detail_name"
				value="${gd.goods_name} "></td>
		</tr>
		<tr>
			<td>所属分类：</td>
			<td><input  type="text" name="goods_detail_fenlei"
				value="${gd.fenlei} "></td>
		</tr>
		<tr>
			<td>价格：</td>
			<td><input  type="text" name="goods_detail_price"
				value="${gd.price} "></td>
		</tr>
		<tr>
			<td>剩余数量：</td>
			<td><input  type="text" name="goods_detail_remaining"
				value="${gd.remaining}"></td>
		</tr>
		<tr>
			<td>图片：</td>
			<td><img id="image" src="${gd.pic}"/><input type="file" name="file"/> <input id="imageuploadbtn" type="button" value="上传" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="更新"></td>
		</tr>
	</table>
</form>
</body>
<script type="text/javascript">
	$('#imageuploadbtn').click(function (){
			var id=document.getElementsByName("id").value;
			$.ajax({
				url:"servlet/UploadServlet",
				type:'post',
				data:{"id":id},
				success:function(data){
				
					$('#image').get(0).setAttribute("src", data);
				},
				error:function(){
					alert("图片除了点问题，哈");
				}
			})
		});
</script>
</html>
