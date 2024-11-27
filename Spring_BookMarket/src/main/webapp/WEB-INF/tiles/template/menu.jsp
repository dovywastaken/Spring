<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/home">Book Market</a>
		</div>
		
		<div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="navbar-brand" href="${pageContext.request.contextPath}/home"> Home</a></li>
				<li class="nav-item"><a class="navbar-brand" href="${pageContext.request.contextPath}/books">Books</a></li>
				<li class="nav-item"><a class="navbar-brand" href="${pageContext.request.contextPath}/books/add">Add Book</a></li>
				<li class="nav-item"><a class="navbar-brand" href="${pageContext.request.contextPath}/cart">Cart</a></li>
			</ul>
		</div>
	</div>
</nav>