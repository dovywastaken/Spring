<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<a class="navbar-brand" href="<c:url value="/add"/>">Add Book</a>
				</div>
			</div>
		</nav>
		<div class="jumbotron">
			<div class="container">
				<h1 class="display-3">도서 정보</h1>
			</div>
		</div>
		
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h3>${book.name}</h3>
					<p>${book.description}</p>
					<br>
					<p><b>도서코드 : </b> <span class="badge badge-info">${book.bookId}</span>
					<p><b>저자 : </b> ${book.author}
					<p><b>출판사 : </b> ${book.publisher}
					<p><b>출판일 : </b> ${book.releaseDate}
					<p><b>분류 : </b> ${book.category}
					<p><b>재고 : </b> ${book.unitsInstock}
					<h4>${book.unitPrice}원</h4>
					<br>
					<p><a href="#" class="btn btn-primary">도서 주문 &raquo;</a>
					<a href="<c:url value="/books"/>" class="btn btn-secondary">도서 목록 &raquo;</a>
				</div>
			</div>
			<hr>
			<footer><p>&copy; BookMarket</p></footer>
		</div>
</body>
</html>