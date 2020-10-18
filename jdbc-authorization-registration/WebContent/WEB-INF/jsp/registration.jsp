<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>

	<h1> Enter your data to register: </h1>
	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="registration"/> <br />
		<input type="text" name="login" placeholder="login" value="" /> <br />
		<input type="password" name="password" placeholder="password" value="" /> <br />
		<input type="text" name="name" placeholder="name" value="" /> <br />
		<input type="text" name="surname" placeholder="surname" value="" /> <br />
		<input type="number" name="age" placeholder="age" value="" /> <br />
		<input type="submit" value="register" />
	</form> <br />
	
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="authorization" />
		<input type="submit" value="log in" />
	</form>
		
</body>
</html>