
<%@include file="includes/header.jsp" %>
<%@include file="includes/mainNav.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="css/main.css" rel="stylesheet">
</head>



<body>
<div class="signin">
	<form method="post" action="" >
		<table>
		<tr> <td>User: </td><td><input name="username" /></td></tr>
		<tr> <td>Pass: </td><td><input type="password" name="password"></td></tr>
		<tr><td>
			<input type="submit" value="Login"/>
			</td>
		</tr>
	</table>
	</form>
</div>

</body>
</html>
