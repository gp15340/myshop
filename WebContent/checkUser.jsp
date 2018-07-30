<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr><th>用户ID</th><th>用户名</th><th>密码</th><th>email</th></tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td align="center">${user.userId}</td>
				<td align="center">${user.userName}</td>
				<td align="center">${user.password}</td>
				<td align="center">${user.email}</td>
			</tr>
		</c:forEach>
		<tr><td colspan="6">
			<a href="SelectUserServlet?page=1">首页</a>&nbsp;&nbsp;&nbsp;
			<c:if test="${page.dpage!=1}">
			<a href="SelectUserServlet?page=${page.dpage-1 }">上一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${page.dpage!=page.totalpage}">
			<a href="SelectUserServlet?page=${page.dpage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<a href="SelectUserServlet?page=${page.totalpage}">尾页</a>
		</td>
		</tr>
	</table>
</body>
</html>