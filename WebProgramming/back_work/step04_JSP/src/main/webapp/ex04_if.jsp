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
	<h3>&lt;c:if> and &lt;c:choose></h3>
	<!-- http://localhost:8080/step04_JSP/ex04_if.jsp?age=10 -->

	<c:if test="${not empty param.age}">
		<h3 style=''>당신의 나이는 ${param.age}살 입니다</h3>
	</c:if>
	<!-- http://localhost:8080/step04_JSP/ex04_if.jsp?age=10 
		age값에 따라서 분기를 만든다면?
	-->
	<c:choose>
		<c:when test="${param.age > 18}">
			<h3>ㅎㅇ</h3>
		</c:when>
		<c:otherwise>
			<h3>ㅂㅂ</h3>
		</c:otherwise>
	</c:choose>

</body>
</html>