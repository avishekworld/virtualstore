
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>

<%@include file="includes/mainNav.jsp" %>

<body>

<h1>Login Page ${user.username}</h1>
Sign in
<form method="post" action="login" >
User: <input name="username" />
Pass: <input type="password" name="password">
<br />
<input type="submit" />
</form>
OR Sign Up <li style="display: inline;  margin-left: 15px;"><a href="/virtualstore/registrationAtCheckout">Sign up</a></li>
</body>
</html>