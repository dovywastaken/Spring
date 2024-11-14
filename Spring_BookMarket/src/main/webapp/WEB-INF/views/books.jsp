<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${bookList}" var="book">
		<h3>${book.name}</h3>
		<h3>${book.author}</h3>
			<br>${book.publisher} | ${book.releaseDate}
		${fn:substring(book.description, 0, 100)}...
		${book.unitPrice}원
	</c:forEach>
</body>
</html>