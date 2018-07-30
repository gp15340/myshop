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
	<form action="AlterBookServlet" method="post">
		<table align="center">
			<tr>
				<td>书号：</td>
				<td><input type="hidden" name="bookId" value="<%=request.getParameter("bookId")%>"/></td>
			</tr>
			<tr>
				<td>书名：</td>
				<td><input type="text" name="bookName" value="<%=request.getParameter("bookName")%>"/></td>
			</tr>
			<tr>
				<td>类型：</td>
				<td>
				<c:choose>
					<c:when test='<%=request.getParameter("typeName").equals("文学")%>'>
						<input type="radio" name="typeName" value="文学" checked/>文学
						<input type="radio" name="typeName" value="历史"/>历史
						<input type="radio" name="typeName" value="计算机"/>计算机
					</c:when>
					<c:when test='<%=request.getParameter("typeName").equals("历史")%>'>
						<input type="radio" name="typeName" value="文学"/>文学
						<input type="radio" name="typeName" value="历史" checked/>历史
						<input type="radio" name="typeName" value="计算机"/>计算机
					</c:when>
					<c:when test='<%=request.getParameter("typeName").equals("计算机")%>'>
						<input type="radio" name="typeName" value="文学"/>文学
						<input type="radio" name="typeName" value="历史"/>历史
						<input type="radio" name="typeName" value="计算机" checked/>计算机
					</c:when>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td>价格:</td>
				<td><input type="text" name="price" value="<%=request.getParameter("price")%>"/></td>
			</tr>
			<tr>
				<td>作者:</td>
				<td><input type="text" name="author" value="<%=request.getParameter("author")%>"/></td>
			</tr>
			<tr>
				<td>出版社:</td>
				<td><input type="text" name="publisher" value="<%=request.getParameter("publisher")%>"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="提交" />
			</tr>
		</table>
	</form>
</body>
</html>