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
	${sessionScope.userId}님 로그인중<br>
	<span id="date"></span>
	
	<a href="${rootPath}/logout">로그아웃</a>
	
	<script>
		let date = new Date("${sessionScope.creationTime}");
		document.getElementById("date").innerText = date.toLocaleString();
	</script>
</body>
</html>