<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Library List</h2>
	
	<table style="border-collapse: collapse;" border="1" >
		<tr>
			<th>Index</th>
			<th>Book</th>
			<th>Author</th>
			<th>Amount</th>
		</tr>		
		<c:forEach var="book" items="${requestScope.books}">
		<tr>
			<td align="center"><c:out value="${book.index}" /></td>
			<td><c:out value="${book.book}" /></td>
			<td><c:out value="${book.author}" /></td>
			<td align="center"><c:out value="${book.amount}" /></td>
		</tr>
		</c:forEach>		
	</table> <br />
	
	
	<h2>Goods Set</h2>
	
	<table style="border-collapse: collapse;" border="1" >
		<tr>			
			<th>Good</th>
			<th>Price</th>
			<th>Amount</th>
			<th>Date</th>
		</tr>		
		<c:forEach var="item" items="${requestScope.items}">
		<tr>
			<td><c:out value="${item.name}" /></td>
			<td align="center"><c:out value="${item.price}" /></td>
			<td align="center"><c:out value="${item.amount}" /></td>
			<td><c:out value="${item.date}" /></td>
		</tr>
		</c:forEach>
	</table> <br />
	
</body>
</html>