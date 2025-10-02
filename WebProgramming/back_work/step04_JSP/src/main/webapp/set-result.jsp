<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : ${id} /
	<c:out value="${id}"></c:out>
	<br> 나이 : ${age} /
	<c:out value="${age }"></c:out>
	<br> 주소 : ${addr} /
	<c:out value="${addr}"></c:out>
	<hr>
</body>
</html>