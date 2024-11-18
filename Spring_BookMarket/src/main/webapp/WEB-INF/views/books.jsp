<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring_BookMarket</title>
<link href="/Spring_BookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/home"/>">Home</a>
				<a class="navbar-brand" href="<c:url value="/books"/>">Books</a>
				<a class="navbar-brand" href="<c:url value="/add"/>">Adding Book</a>
			</div>
		</div>
	</nav>

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서 목록</h1>
		</div>
	</div>
	
	<div class="conatainer">
		<div class="row" align="center">
			<c:forEach items="${bookList}" var="book">
				<div class="col-md-4">
					<h3>${book.name}</h3>
					<p>${book.author}</p>
						<br>${book.publisher} | ${book.releaseDate}
					<p align="left">${fn:substring(book.description, 0, 100)}...
					<p>${book.unitPrice}원
					<p><a href="<c:url value='/book?id=${book.bookId}' />" class="btn btn-secondary" role="button">상세정보 &raquo;</a></p>

				</div>
			</c:forEach>
		</div>
		<hr>
		<footer>
			<p>&copy; BookMarket </p>
		</footer>
	</div>
</body>
</html>