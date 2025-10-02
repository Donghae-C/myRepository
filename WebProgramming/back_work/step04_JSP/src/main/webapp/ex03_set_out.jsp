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
	<h3>&lt;c:set> and &lt;c:out></h3>
	
	<c:set var="id" value="test"></c:set>
	<c:set var="age" value="20" scope="session"></c:set>
	<c:set var="addr" value="<strong>seoul</strong>" scope="application"></c:set>
	
	<h3>저장된 정보 출력하기</h3>
	아이디 : ${id} / <c:out value="${id}"></c:out><br>
	나이 : ${age} / <c:out value="${age }"></c:out><br>
	주소 : ${addr} / <c:out value="${addr}"></c:out><hr>
	
	<%
		String name = "test";
		//request.setAttribute("name", name);
	%>
	<c:set var="name" value="<%=name%>"></c:set>
	이름 : <%=name %> / ${name} / <c:out value="${name}"></c:out> <!-- 뒤에 둘다 안됨 -->
	<hr>
	<a href = "set-result.jsp">이동</a>
</body>
</html>