<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>线路详细信息页面</title>
</head>
<body style="text-align: center">

<h1>线路详细信息</h1>
<a href="#" onClick="javascript:history.back(-1);">返回上一页</a>
	<style>

	tr:hover{background-color: yellow;}
	
	</style>
<table>
	<tr>
		<td></td>
	</tr>

</table>

	<table width="100%"  border = "1" >
		<tr>
			<td>时间</td>
			<td>站点编号</td>
			<td>站点名称</td>
			<td>具体站点</td>
		</tr>
		
		<c:forEach var="entry" items="${buslininfo.busstopinfo}">
			<tr>
				<td>${entry.value.stoptime }</td>
				<td>${entry.value.stopnum }</td>
				<td>${entry.value.stopname }</td>
				<td>${entry.value.stopdetail }</td>
<%-- 				<td width="40%"><c:forEach var="entry2" items="${entry.value.busstopinfo }">${entry2.value.stopname }<br/>   </c:forEach></td>
 				<td>${entry.value.busstopinfo.get("2")}</td>
				<td width="10%">
					<a href="BuyServlet?id=${entry.value.linenum}" target="_blank">查看</a>
				</td> --%>
			</tr>
		</c:forEach>
		
	</table>



</body>
</html>