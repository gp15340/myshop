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
			<tr><th>书号</th><th>书名</th><th>类别</th><th>价格</th><th>作者</th><th>出版社</th></tr>
		<c:forEach items="${bookList}" var="book">
			<tr>
				<td align="center">${book.bookId}</td>
				<td align="center">${book.bookName}</td>
				<td align="center">${book.bookType.typeName}</td>
				<td align="center">${book.price}</td>
				<td align="center">${book.author}</td>
				<td align="center">${book.publisher}</td>
			</tr>
		</c:forEach>
		<tr><td colspan="6">
			<a href="AdminSelectServlet?page=1">首页</a>&nbsp;&nbsp;&nbsp;
			<c:if test="${page.dpage!=1}">
			<a href="AdminSelectServlet?page=${page.dpage-1 }">上一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${page.dpage!=page.totalpage}">
			<a href="AdminSelectServlet?page=${page.dpage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<a href="AdminSelectServlet?page=${page.totalpage}">尾页</a>
		</td>
		</tr>
	</table>
</body>
</html>