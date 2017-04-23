<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车列表</title>
<script type="text/javascript">
function deleteitem(id){
var b = window.confirm("确认删除？");
if(b){
	window.location.href="DeleteCartItemServlet?id=" + id;
}

}
function clearcart(){
	var b = window.confirm("确认清空？");
	if(b){
		window.location.href="ClearCartServlet";
	}
}

function changequantity(input, id, oldvalue){
	var quantity = input.value; //得到要修改的数量

	//检查是不是数字
	if(isNaN(quantity)){
		alert("请输入数字");
		input.value = oldvalue;
		return;}
	
	
	//检查是不是正整数
	if(quantity<0 || quantity!=parseInt(quantity)){
		alert("请输入正整数");
		input.value = oldvalue;
		return;
		}
	quantity=parseInt(quantity);
	var b = window.confirm("修改数量为：" + quantity);
	if(b){
		window.location.href="ChangeQuantityServlet?id="+id+"&quantity="+quantity; 
		}
}

</script>
</head>
<body>

<h1>购物车列表</h1>

<c:if test="${empty(cart.map) }">
没有任何商品
</c:if>
<c:if test="${!empty(cart.map) }">
	<table width="70%"  border = "1" >
		<tr>
			<td>书名</td>
			<td>作者</td>
			<td>单价</td>
			<td>数量</td>
			<td>小计</td>
			<td>操作</td>
		</tr>
		
		<c:forEach var="entry" items="${cart.map}">
			<tr>
				<td>${entry.value.book.name }</td>
				<td>${entry.value.book.author }</td>
				<td>${entry.value.book.price }</td>
				<td><input type="text" name="quantity" value = "${entry.value.quantity}" style="width:40px;" onchange="changequantity(this,${entry.key},${entry.value.quantity})"></td>
				<td>${entry.value.price}</td>
				<td>
<%-- 					<a href="DeleteCartItemServlet?id=${entry.key}">删除</a>
 --%>					<%--去掉超链接默认行为--%>
					<a href="javascript:void(0)" onclick="deleteitem(${entry.key})">删除</a>
<%-- 				<a href="${pageContext.request.contextPath}/book/DeleteCartItemServlet?id=${entry.key}">删除</a>
 --%>				</td>
			</tr>
		</c:forEach>
		<tr>
				<td colspan="3">总价</td>
				<td colspan="2">${cart.price} 元</td>
				<td colspan="1">
				<a href="javascript:void(0)" onclick="clearcart()">清空购物车</a></td>
			</tr>
		
	</table>

</c:if>



</body>
</html>