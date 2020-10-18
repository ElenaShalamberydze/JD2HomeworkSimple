<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>

	<form action="controller" method="post">
		Enter registration info: <br />
		<input type="text" name="name" placeholder="name" value="" /> <br />
		<input type="text" name="surname" placeholder="surname" value="" /> <br />
		<input type="text" name="email" placeholder="email" value="" /> <br />
		<input type="number" name="age" placeholder="age" value="" /> <br />
		<input type="submit" value="submit" />
	</form>

</body>
</html>