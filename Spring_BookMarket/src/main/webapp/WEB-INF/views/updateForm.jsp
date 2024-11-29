<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            <div class="col-md-4">
                <img src="${pageContext.request.contextPath}/resources/images/${book.fileName}" alt="image" style="width:100%"/>
            </div>
            <div class="col-md-7">
                <form:form modelAttribute="updateBook" action="./update?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal" enctype="multipart/form-data">
                    <fieldset>
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">도서 ID</label>
                            <div class="col-sm-6" style="padding-top: 10px">
                                <form:input id="bookId" path="bookId" type="hidden" class="form-control" value="${book.bookId}"/>
                                <span class="badge badge-info">${book.bookId}</span>
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">도서명</label>
                            <div class="col-sm-6">
                                <form:input path="name" class="form-control" value="${book.name}"/>
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">가격</label>
                            <div class="col-sm-6">
                                <form:input path="unitPrice" class="form-control" value="${book.unitPrice}"/>
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">저자</label>
                            <div class="col-sm-6">
                                <form:input path="author" class="form-control" value="${book.author}"/>
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">상세정보</label>
                            <div class="col-sm-6">
                                <form:input path="description" class="form-control" value="${book.description}"/>
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">출판사</label>
                            <div class="col-sm-6">
                                <form:input path="publisher" class="form-control" value="${book.publisher}"/>
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">분류</label>
                            <div class="col-sm-6">
                                <form:input path="category" class="form-control" value="${book.category}"/>
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">재고수</label>
                            <div class="col-sm-6">
                                <form:input path="unitsInstock" class="form-control" value="${book.unitsInstock}"/>
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">출판일</label>
                            <div class="col-sm-6">
                                <form:input path="releaseDate" class="form-control" value="${book.releaseDate}"/>
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">상태</label>
                            <div class="col-sm-6">
                                <form:radiobutton path="condition" value="New"/>New
                                <form:radiobutton path="condition" value="Old"/>Old
                                <form:radiobutton path="condition" value="E-Book"/>E-Book
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">이미지</label>
                            <div class="col-sm-6">
                                <form:input path="bookImage" class="form-control" type="file"/>
                            </div>
                        </div>
                        
                        <div class="form-group row">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="submit" class="btn btn-primary" value="수정"/>
                                <a href="<c:url value='/books'/>" class="btn btn-primary">취소</a>
                            </div>
                        </div>
                    </fieldset>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
