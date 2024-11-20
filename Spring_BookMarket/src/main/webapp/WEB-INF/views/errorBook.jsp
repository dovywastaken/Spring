<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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
			<a class="navbar-brand" href="../home">Home</a>
		</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<h2 class="alert alert-danger">
					해당 도서가 존재하지 않습니다. <br>
					도서 ID : ${invalidBookId}
			</h2>
		</div>
	</div>
	
	<div class="container">
		<p>${url}</p>
		<p>${exception}</p>
	</div>
	
	<div class="container">
		<p>
			<a href="${pageContext.request.contextPath}/books">도서목록 &raquo;</a>
		</p>
	</div>
</body>
</html>