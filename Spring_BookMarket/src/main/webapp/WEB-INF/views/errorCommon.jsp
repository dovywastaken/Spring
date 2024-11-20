<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<a class="navbar-brand" href="${pageContext.request.contextPath}/home"> Home</a>
			</div>
		</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<h2 class="alert alert-danger">요청한 도서가 존재하지 않습니다</h2>
		</div>
	</div>
	
	<div class="container">
		<p>${exception}</p>
	</div>
	
	<div class="container">
		<p> <a href="<c:url value="/books"/>" class="btn btn-secondary">도서목록 &raquo;</a>
	</div>
	
</body>
</html>