<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的订单</title>
</head>
<body>
	<table border="1" >
		<tr><th>书名</th><th>数量</th><th>单价</th><th>总额</th><th>提交订单</th></tr>
		<c:forEach items="${cartList}" var="cart">
			<tr>
				<td align="center">${cart.bookName}</td>
				<td align="center">${cart.count}</td>
				<td align="center">${cart.price}</td>
				<td align="center" id="amount">${cart.amount}</td>
				<td align="center"><a href="SubmitOrderServlet?bookId=${cart.bookId}&count=${cart.count}">提交订单</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">总额:${totalAmount}</td>
		</tr>
	</table>
<a href="index.html">返回首页</a>
</body>
</html>