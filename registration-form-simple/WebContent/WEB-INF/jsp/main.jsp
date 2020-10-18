<%@ page language="java" import="by.htp.jd2.entity.RegistrationInfo" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>
		
	<jsp:useBean id="regInfo" class="by.htp.jd2.entity.RegistrationInfo" scope="request" />
	
	<table style="border-collapse: collapse;" border="1">
		<tr>
			<th align="center">Name</th>
			<th align="center">Surname</th>
			<th align="center">Email</th>
			<th align="center">Age</th>
		</tr>
		<tr>
			<td align="center"> <jsp:getProperty property="name" name="regInfo" /> </td>
			<td align="center"> <jsp:getProperty property="surname" name="regInfo" /> </td>
			<td align="center"> <jsp:getProperty property="email" name="regInfo" /> </td>
			<td align="center"> <jsp:getProperty property="age" name="regInfo" /> </td>
  		</tr>
	</table> <br />
 	
 	<form action="index.jsp" method="get">
 		<input type="submit" value="add new">
 	</form>
 	
</body>
</html>