<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style> 
body{ text-align:center} 
.div{ margin:0 auto; width:600px; height:400px} 
 
</style> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body >

<div class="div">
	<h2>这是一个网站</h2>
	<br/><br/>
	<c:if test="${user!=null }">
		欢迎您:${user.username }<a href="LogoutServlet" >注销</a>
	</c:if>

	<c:if test="${user==null }">
		<a href="RegisterUIServlet">注册</a><br/>
		<a href="LoginUIServlet">登陆</a><br/>
	</c:if>
	
	
	<br/><br/><br/>
	<hr>
	
	<a href="book/ListBookServlet" >浏览书籍</a>
	</div>
</body>
</html>