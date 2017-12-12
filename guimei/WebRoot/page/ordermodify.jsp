<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ordermodify.jsp' starting page</title>
    
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
 		
 		<form action="servlet/OrderUpdateServlet?id=${order.order_id }" method="post">
 		
    	<table>
    		<tr><td>订单编号：</td><td><input type type="text" name="order_id" value="${order.order_id} "></td></tr>
    		<tr><td>订购人姓名：</td><td><input type type="text" name="order_name" value="${order.user_name} "></td></tr>
    		<tr><td>订购人地址：</td><td><input type type="text" name="order_address" value="${order.order_address} "></td></tr>
    		<tr><td>总金额：</td><td><input type type="text" name="order_total" value="${order.order_sum_price} "></td></tr>
    		<tr><td>下单日期：</td><td><input type type="text" name="order_date" value="${order.order_date}"></td></tr>
    		<tr><td>订单状态：</td><td><select name="order_status">
    		<c:if test="${order.order_status==1}">
    		<option ><c:out value="待审核">待审核</c:out></option>
    		<option><c:out value="已确认">已确认</c:out></option>
    		</c:if>
    		<c:if test="${order.order_status==2}">
    		<option ><c:out value="已确认">已确认</c:out></option>
    		<option><c:out value="待审核">待审核</c:out></option>
    		</c:if>
    		</select> </td></tr>
    		<tr><td></td><td><input type="submit" value="更新"></td></tr>
    	</table>
    	</form>
  </body>
</html>
