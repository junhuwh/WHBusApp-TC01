<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册界面</title>
<script src="js/laydate/laydate.js"></script>
<style> 
body{ text-align:center} 
.div{ margin:0 auto; width:450px; height:300px} 
 
</style> 
</head>
<body>
	<div>注册界面</div>
<div class="div">
	<form action="RegisterServlet" method="post">
		<table class="formtable">
			<tr>
				<td class="td1">用户名：</td>
				<td><input class="userinput" type="text" name="username" value="${form.username}"></td>
				<td>	<span class="message">${form.errors.username }</span></td>
			</tr>
			<tr>
				<td class="td1">密码：</td>
				<td><input class="userinput" type="password" name="password"></td>
				<td>
					<span class="message">${form.errors.password }</span></td>
			</tr>
			<tr>
				<td class="td1">确认密码：</td>
				<td><input class="userinput" type="password" name="password2"></td>
				<td>
					<span class="message">${form.errors.password2 }</span></td>
			</tr>
			<tr>
				<td class="td1">邮箱：</td>
				<td><input class="userinput" type="text" name="email" value="${form.email}"></td>
				<td>
					<span class="message">${form.errors.email }</span></td>
			</tr>
			<tr>
				<td class="td1">生日：</td>
				<td><input class="userinput" type="text" name="birthday" value="${form.birthday}"
					onclick="laydate()"></td>
				<td> <span class="message">${form.errors.birthday }</span>
				</td>
			</tr>
			<tr>
				<td class="td1">昵称：</td>
				<td><input class="userinput" type="text" name="nickname" value="${form.nickname}">
					</td>
				<td><span class="message">${form.errors.nickname }</span></td>
			</tr>
			<tr>
				<td class="td1">验证码：</td>
				<td><input class="userinput" type="text" name="checkcode"></td>
			</tr>
		</table>
		<div class="formsubmit">
			<span><input class="btn" type="reset" name="reset" value="重置"></span>
			&nbsp;&nbsp;&nbsp;&nbsp; <span><input class="btn"
				type="submit" name="submit" value="提交"></span>

		</div>
	</form>

</div>
</body>
</html>