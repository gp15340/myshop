<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎注册网络书城账号：</h1>
	<form action="UserRegistServlet" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="userName"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" name="rePassword"/></td>
			</tr>
			<tr>
				<td>邮箱：</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="注册"></td>
			</tr>
			<tr>
			<td colspan="2">
				<font color="red">
				${errorMsg}</font>
			</td>
		</tr>
		</table>
	</form>
</body>
</html>