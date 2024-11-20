<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
				<a class="navbar-brand" href="${pageContext.request.contextPath}/books">Books</a>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/books/add">Add Book</a>
			</div>
		</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3"><spring:message code="addBook.form.title.label"/></h1>
		</div>
	</div>
	
	<div class="container">
		<div class="float-right">
			<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" class="btn btn-sm btn-success" value="Logout">
			</form:form>
		</div>
		<br><br>
	
		<form:form modelAttribute="NewBook" class="form-horizontal" action="./add?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
			<fieldset>
			<legend><spring:message code="addBook.form.subtitle.label"/></legend>
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="addBook.form.bookId.label"/></label>
					<div class="col-sm-3">
						<form:input path="bookId" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="addBook.form.name.label"/></label>
					<div class="col-sm-3">
						<form:input path="name" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="addBook.form.unitPrice.label"/></label>
					<div class="col-sm-3">
						<form:input path="unitPrice" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="addBook.form.author.label"/></label>
					<div class="col-sm-3">
						<form:input path="author" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="addBook.form.description.label"/></label>
					<div class="col-sm-3">
						<form:input path="description" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="addBook.form.publisher.label"/></label>
					<div class="col-sm-3">
						<form:input path="publisher" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="addBook.form.category.label"/></label>
					<div class="col-sm-3">
						<form:input path="category" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="addBook.form.unitsInStock.label"/></label>
					<div class="col-sm-3">
						<form:input path="unitsInstock" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="addBook.form.releaseDate.label"/></label>
					<div class="col-sm-3">
						<form:input path="releaseDate" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="addBook.form.Condition.label"/></label>
					<div class="col-sm-3">
						<form:radiobutton path="condition" value ="New"/> New
						<form:radiobutton path="condition" value ="Old"/> Old
						<form:radiobutton path="condition" value ="E-Book"/> E-Book
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label"><spring:message code="addBook.form.bookImage.label"/></label>
					<div class="col-sm-7">
						<form:input path="bookImage" type="file" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-primary" value="<spring:message code="addBook.form.button.label"/>"/>
					</div>
				</div>
			</fieldset>
		</form:form>
		<hr>
		<footer>
			<p>&copy; BookMarket</p>
	</footer>
	</div>
</body>
</html>