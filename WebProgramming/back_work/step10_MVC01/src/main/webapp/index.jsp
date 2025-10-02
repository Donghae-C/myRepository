<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB MVC Refactoring TEST</h1>
	<h3>
		<a href="${pageContext.request.contextPath}/front?key=select">검색하기</a><br><br>
		<a href="${pageContext.request.contextPath}/front?key=update">수정하기</a><br><br>
		<a href="${pageContext.request.contextPath}/front?key=delete">삭제하기</a><br><br>
		<a href="${pageContext.request.contextPath}/front?key=insert">등록하기</a><br><br>
		
	</h3>
</body>
</html>