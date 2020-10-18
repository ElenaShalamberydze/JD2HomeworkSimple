<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>
	
	Hello there, 
	<c:out value="${requestScope.user.name}"/>
	<c:out value="${requestScope.user.surname}" />! <br />	
	
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="authorization" />
		<input type="submit" value="log out" />
	</form>

</body>
</html>