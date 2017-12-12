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

<title>My JSP 'userupdate.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="./js/jquery-1.11.3.js"></script>
</head>

<body>
	<img alt="" src="./image/redarrows.jpg">
	<b>添加用户</b>
	<hr align="left" width="650px" style="color: orange">
	<form action="servlet/UserAddServlet" method="post" name="addform">
		<table>
			<tr>
				<td>用户名（*）：</td>
				<td><input type="text" name="user_name" id="user_name"></td>
				<td><span id="user_nameSpan"></span></td>
			</tr>
			<tr>
				<td>真实姓名（*）：</td>
				<td><input type="text" name="user_realname" id="user_realname"></td>
				<td><span id="user_realnameSpan"></span></td>
			</tr>
			<tr>
				<td>登录密码（*）：</td>
				<td><input type="password" name="user_pwd" id="user_pwd"></td>
				<td><span id="user_pwdSpan"></span></td>
			</tr>
			<tr>
				<td>确认密码（*）：</td>
				<td><input type="password" name="user_checkpwd" id="user_checkpwd"></td>
				<td><span id="user_checkpwdSpan"></span></td>
			</tr>
			<tr>
				<td>性别（*）：</td>
				<td>男<input type="radio" name="user_sex" value="男"
					checked="checked">女<input type="radio" name="user_sex"
					value="女"></td>
					<td><span id="user_sexSpan"></span></td>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td><input type="text" name="user_birthdate"></td>
				<td><span id="user_birthdateSpan"></span></td>
			</tr>
			<tr>
				<td>身份证：</td>
				<td><input type="text" name="user_id" id="user_id"></td>
				<td><span id="user_idSpan"></span></td>
			</tr>
			<tr>
				<td>电子邮件：</td>
				<td><input type="text" name="user_email" id="user_email"></td>
				<td><span id="user_emailSpan"></span></td>
			</tr>
			<tr>
				<td>手机：</td>
				<td><input type="text" name="user_phone" id="user_phone"></td>
				<td><span id="user_phoneSpan"></span></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" name="user_address"></td>
				<td><span id="user_addressSpan"></span></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="添加" name="submitID"></td>
			</tr>

		</table>
	</form>

</body>
<script>
			var usernamecheck=false;
			var usernpwdcheck=false;;
            var userrepwdcheck=false; ;
            var userIDcheck=false; ;
            var userEmailcheck=false; ;
			function $(id) {
				return document.getElementById(id);
			};
			//名字的非空检测
			$("user_name").onblur = function() {
				var Uservalue = this.value;
				if(Uservalue == '') {

					$("user_nameSpan").innerHTML = "用户名不能为空！";
					return false;
					//名字的内容是否符合格式要求	：(可包含a-z,0-9和_)
				} else {
					for(var t = 0; t < Uservalue.length; t++) {
						var c = Uservalue.charAt(t);
						if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c == '_')) {

						} else {
							$("user_nameSpan").innerHTML = "用户名只包含a-z,0-9和_";
							usernamecheck = false;
							return false;
						}
					}
				}
				usernamecheck = true;
				return true;
			};
			$("user_name").onfocus = function() {
					$("user_nameSpan").innerHTML = "";
				}
				//检测密码长度是否符合要求
			$("user_pwd").onblur = function() {
				if(this.value.length < 6) {
					$("user_pwdSpan").innerHTML = "密码的长度不能小于6位";
					usernpwdcheck = false;
					return false;
				}
				usernpwdcheck = true;
				return true;
			}
			$("user_pwd").onfocus = function() {
					$("user_pwdSpan").innerHTML = "";
				}
				//检测输入密码和再一次输入密码是否一致
			 $("user_checkpwd").onblur = function() {
				if(this.value != $("user_pwd").value) {
					$("user_checkpwdSpan").innerHTML = "两次输入的密码不一致！";
					userrepwdcheck=false;
					return false;
				}
				userrepwdcheck=true;
				return true;
			}
			$("user_checkpwd").onfocus = function() {
					$("user_checkpwdSpan").innerHTML = "";
				}
				//检测身份证是否符合要求
			 $("user_id").onblur = function() {
				var userid = this.value
				if(userid.length != 18) {
					$("user_idSpan").innerHTML = "身份证号码只能是18位！";
					userIDcheck =false;
					return false;
				} else {
					for(var t = 0; t < 17; t++) {
						if(isNaN(userid[t])) { //有一个非数字
							$("user_idSpan").innerHTML = "身份证号码前17位只能由数字构成！";
							userIDcheck =false;
							return false;
						}
					}
					if(isNaN(userid[17])) {
						if(userid[17] != 'X') {
							$("user_idSpan").innerHTML = "身份证号码第18位只能由数字或者X构成！";
							userIDcheck =false;
							return false;
						}
					}
				}
				userIDcheck =true;
				return true;
			}
			$("user_id").onfocus = function() {
				$("user_idSpan").innerHTML = "";
			}

			//emain的简单验证
			$("user_email").onblur = function() {
				var email = this.value;
				if(email.indexOf('@') > -1 && email.indexOf('.') > -1) {

				} else {
					$("user_emailSpan").innerHTML = "电子信箱的格式不正确!";
					this.style.border = "1px solid red";
					this.value = "";
					//this.select();//选中内容
					//this.focus();
					userEmailcheck=false;
					return false;
				}
				userEmailcheck=true;
				return true;
			}
			$("user_email").onfocus = function() {
				$("user_emailSpan").innerHTML = "";
			}

			$("submitID").onclick = function() {
				var t=userIDcheck&&userEmailcheck&&usernamecheck&&usernpwdcheck&&userrepwdcheck;
				if(t==false){
					alert("资料填写有误，不能提交数据！")
				}
				return t;//如果是t=false;则会中断提交数据

			}
		</script>
</html>
