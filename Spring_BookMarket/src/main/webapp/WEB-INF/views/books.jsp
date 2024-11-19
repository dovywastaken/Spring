<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.springmvc.domain.Book" %>
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
            <h1 class="display-3">도서 목록</h1>
        </div>
    </div>
    
    <div class="container">
        <div class="row">
            <c:forEach items="${bookList}" var="book">
                <div class="col-md-4 mb-4">
                	<c:choose>
                		<c:when test="${book.getBookImage() == null}">
                			<img src="<c:url value='/resources/images/${book.bookId}.png'/>" style="width: 60%"/>
                		</c:when>
                		<c:otherwise>
                			<img src="<c:url value='/resources/images/${book.bookImage.originalFilename}'/>" style="width: 60%"/>
                		</c:otherwise>
                	</c:choose>
                    <h3 class="text-center">${book.name}</h3>
                    <p class="text-left">${book.author}</p>
                    <br><b>${book.publisher} | ${book.releaseDate}</b>
                    <p align="left">${fn:substring(book.description, 0, 100)}...</p>
                    <p>${book.unitPrice}원</p>
                    <p><a href="${pageContext.request.contextPath}/books/book?id=${book.bookId}" class="btn btn-secondary" role="button">상세정보 &raquo;</a></p>
                </div>
            </c:forEach>
        </div>
        <hr>
        <footer>
            <p>&copy; BookMarket</p>
        </footer>
    </div>
</body>
</html>
