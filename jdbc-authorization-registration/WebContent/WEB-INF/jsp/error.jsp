<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>

	<c:out value="${requestScope.error}" /> <br />
	
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="authorization" />
		<input type="submit" value="log in" />
	</form> <br />
		
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="registration" />
		<input type="submit" value="register" />
	</form>
	
</body>
</html>