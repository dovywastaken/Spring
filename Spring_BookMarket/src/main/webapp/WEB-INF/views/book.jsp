<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring_BookMarket</title>
<link href="/Spring_BookMarket/resources/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/controllers.js"></script>
</head>
<body>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<c:choose>
					    <c:when test="${book.fileName != null}">
					        <img src="${pageContext.request.contextPath}/resources/images/${book.fileName}" style="width: 100%" />
					    </c:when>
					    <c:otherwise>
					        <img src="${pageContext.request.contextPath}/resources/images/default.png" style="width: 100%" />
					    </c:otherwise>
					</c:choose>

				</div>
				
				<div class="col-md-8">
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
					<form:form name="addForm" method="put">
						<p><a href="javascript:addToCart('../cart/add/${book.bookId }')" class="btn btn-primary">도서 주문 &raquo;</a>
						<a href="<c:url value="/cart"/>" class="btn btn-warning">장바구니 &raquo;</a>
						<a href="<c:url value="/books"/>" class="btn btn-secondary">도서 목록 &raquo;</a>
						<sec:authorize access ="isAuthenticated()">
							<a href="${pageContext.request.contextPath}/books/update?id=${book.bookId}" class="btn btn-success">수정 &raquo;</a>
						</sec:authorize>
					</form:form>
				</div>
			</div>
		</div>
</body>
</html>