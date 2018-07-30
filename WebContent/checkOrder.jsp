<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单统计</title>
</head>
<body>
	<table border="1">
		<tr><th>订单号</th><th>用户ID</th><th>书号</th><th>数量</th><th>订单时间</th></tr>
		<c:forEach items="${orderList}" var="order">
			<tr>
				<td align="center">${order.orderId}</td>
				<td align="center">${order.userId}</td>
				<td align="center">${order.bookId}</td>
				<td align="center">${order.count}</td>
				<td align="center">${order.orderTime}</td>
			</tr>
		</c:forEach>	
		<tr><td colspan="5">
			<a href="SelectOrderServlet?page=1">首页</a>&nbsp;&nbsp;&nbsp;
			<c:if test="${page.dpage!=1}">
			<a href="SelectOrderServlet?page=${page.dpage-1 }">上一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${page.dpage!=page.totalpage}">
			<a href="SelectOrderServlet?page=${page.dpage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<a href="SelectOrderServlet?page=${page.totalpage}">尾页</a>
		</td>
		</tr>
	</table>
</body>
</html>