<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/home"> Home</a> <a
					class="navbar-brand"
					href="${pageContext.request.contextPath}/books">Books</a> <a
					class="navbar-brand"
					href="${pageContext.request.contextPath}/books/add">Add Book</a>
			</div>
		</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">주문취소</h1>
		</div>
	</div>
	
	<div class="container">
		<h2 class="alert alert-danger">주문을 취소하였습니다.</h2>
	</div>
	<div class="container">
		<p><a href="<c:url value="/books"/>" class="btn btn-primary">&laquo; 도서목록</a></p>
	</div>
</body>
</html>