<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" buffer="16kb" session="false"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%@include file="header.html" %>
	<form action="checkuser.jsp" method="post">


		<p>
			Username:<input type="text" name="username"
				placeholder="Enter Username">
		</p>
		<p>
			Password:<input type="password" name="passwd"
				placeholder="Enter password">
		</p>
		<p>
			<input type="submit" value="SIGN IN"> <br>
			<a href=>Forgot password</a>
		</p>




	</form>
	<%@include file="footer.html" %>
</body>
</html>