<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班车线路列表页面</title>
</head>
<body style="text-align: center">
	<style>

	tr:hover{background-color: yellow;}
	
	</style>
<h1>班车线路列表</h1>
<div ><a href="#" onClick="javascript:history.back(-1);">返回上一页</a></div>
	<table width="100%"  border = "1" >
		<tr>
			<td>线路号</td>
			<td>班车类型</td>
			<td>车牌号</td>
			<td>司机师傅</td>
			<td>师傅手机号</td>
			<td>经停站点</td>
			<td>详细信息</td>
		</tr>
		
		<c:forEach var="entry" items="${map}">
			<tr>
				<td>${entry.value.linenum }</td>
				<td>${entry.value.bustype }</td>
				<td>${entry.value.licenseplatenum }</td>
				<td>${entry.value.drivername }</td>
				<td>${entry.value.driverphonenum }</td>
				<td width="40%"><c:forEach var="entry2" items="${entry.value.busstopinfo }">${entry2.value.stopname }<br/>   </c:forEach></td>
<%-- 				<td>${entry.value.busstopinfo.get("2")}</td>
 --%>				<td width="10%">
					<a href="ListBusStopInfoServlet?id=${entry.value.id}" >查看</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>



</body>
</html>