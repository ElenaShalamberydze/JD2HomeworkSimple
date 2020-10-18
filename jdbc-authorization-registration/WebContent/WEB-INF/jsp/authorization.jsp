<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authorization</title>
</head>
<body>

	<h1> Log in: </h1>
	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="authorization"/>
		<input type="text" name="login" placeholder="login" value="" /> <br />
		<input type="password" name="password" placeholder="password" value="" /> <br />
		<input type="submit" value="log in" />
	</form> <br />
	
	or register <br />
	
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="registration" />
		<input type="submit" value="register" />
	</form>

	
</body>
</html>