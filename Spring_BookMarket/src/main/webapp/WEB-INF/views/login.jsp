<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Security</title>
<link href="/Spring_BookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!--
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="./home">Home</a>
			</div>
		</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">로그인</h1>
		</div>
	</div>
	  -->
	<div class="container col-md-4">
		<div class="text-center">
			<h3 class="form-signin-heading">Please login</h3>
		</div>
	</div>
	
	<% String error = (String)request.getAttribute("error"); %>
	
	<%
		if(error != null)
		{
	%>
		<div class="alert alert-danger">
			UserName과 Password가 올바르지 않습니다.<br/>
		</div>
	<%} %>
	<form class="form-signin" action="login" method="post">
		<div class="form-group row">
			<input type="text" name="username" class="form-control" placeholder="User Name" required autofocus>
		</div>
		
		<div class="form-group row">
			<input type="password" name="password" class="form-control" placeholder="Pasword" required>
		</div>
		
		<div class="form-group row">
			<button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</div>
	</form>
</body>
</html>