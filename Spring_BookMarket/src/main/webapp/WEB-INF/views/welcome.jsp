<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- 정적리소스는 절대경로표시를 추천함 -->
<link href="/Spring_BookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Spring_BookMarket</title>
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
			<h1 class="display-3">${greeting}</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="text-center">
			<h3>${strapline}</h3>
		</div>
	</div>
	
	<footer class="container">
		<hr>
		<p>&copy; WebMarket</p>
	</footer>
	
</body>
</html>