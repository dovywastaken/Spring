<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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
    <div class="container">
        <div class="row">
        <!-- 
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
                	<br>
                    <h3 class="text-left">${book.name}</h3>
                    <p class="text-left">${book.author}</p>
                    <b>${book.publisher} | ${book.releaseDate}</b>
                    <p align="left">${fn:substring(book.description, 0, 100)}...</p>
                    <p>${book.unitPrice}원</p>
                    <p><a href="${pageContext.request.contextPath}/books/book?id=${book.bookId}" class="btn btn-secondary" role="button">상세정보 &raquo;</a></p>
                </div>
            </c:forEach>
             -->
             <c:forEach items="${bookList}" var="book">
             	<div class="col-md-4">
             		<c:choose>
             			<c:when test="${book.getBookImage() == null}">
             				<img src="${pageContext.request.contextPath}/resources/images/${book.fileName}" style="width: 60%"/>
             			</c:when>
             			<c:otherwise>
             				<img src="${pageContext.request.contextPath}/resources/images/${book.fileName}" style="width: 60%"/>
             			</c:otherwise>
             		</c:choose>
             		<h3>${book.name}</h3>
             		<p>${book.author}</p>
             		<br>${book.publisher} | ${book.releaseDate}
             		<p align="left"> ${fn:substring(book.description, 0, 100)}...
             		<p>${book.unitPrice}원
             		<p><a href="<c:url value="/books/book?id=${book.bookId}"/>" class="btn btn-Secondary" role="button">상세정보 &raquo;</a>
             	</div>
             </c:forEach>
        </div>
    </div>
</body>
</html>
