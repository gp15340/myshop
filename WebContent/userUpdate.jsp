<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改个人信息</title>
<!-- Custom Theme files -->
<link href="Css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<link href='http://fonts.useso.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<!--Google Fonts-->
</head>
<body>
	<p style="color:blue">欢迎您：${user.userName}，以下是您的信息，您可以对其进行修改：</p>
	<form action="UserUpdateServlet" method="post">
		<table>
			<tr>
				<td><input type="hidden" name="userId" value="${user.userId}"/></td>
			</tr>
			<tr>
				<td style="color:blue" >用户名：</td>
				<td><input type="text" name="userName" value="${user.userName}"/></td>
			</tr>
			<tr>
				<td style="color:blue">密码：</td>
				<td><input type="text" name="password" value="${user.password}"/></td>
			</tr>
			<tr>
				<td style="color:blue">邮箱：</td>
				<td><input type="text" name="email" value="${user.email}"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修改"></td>
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