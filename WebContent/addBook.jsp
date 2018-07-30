<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addBookServlet" method="post">
		<table align="center">
			<tr>
				<td>书名：</td>
				<td><input type="text" name="bookName" /></td>
			</tr>
			<tr>
				<td>类型：</td>
				<td>
					<input type="radio" name="typeName" value="文学"/>文学
					<input type="radio" name="typeName" value="历史"/>历史
					<input type="radio" name="typeName" value="计算机"/>计算机
				</td>
			</tr>
			<tr>
				<td>价格:</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>作者:</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>出版社:</td>
				<td><input type="text" name="publisher"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="提交" />
			</tr>
			<tr>
			<td colspan="2">
				<font color="red" align="center">
				${errorMsg}</font>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>