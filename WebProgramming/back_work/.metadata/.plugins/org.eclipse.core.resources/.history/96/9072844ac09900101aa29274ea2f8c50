<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
response.setHeader("Cache-Control", "no-store");//
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>


	<h3>
		<c:out value="${sessionScope.sessionName}"></c:out>
		님 로그인 중<br> [접속시간 :
		<c:out value="${sessionScope.creationTime}"></c:out>
		]
		<p>
	</h3>
	<img src="${pageContext.request.contextPath}/images/bin.jpg">
	<p>
		<a href="#">로그아웃</a>

		<script type="text/javascript">
			document
					.querySelector("a")
					.addEventListener(
							"click",
							function() {
								//로그아웃기능을하는 페이지로 이동해서 모든세션의 삭제
								if (confirm("로그아웃할래?")) {
									location.href = "${pageContext.request.contextPath}/logout"; //logout이 url-pattern

									//세션의 정보를 삭제하고 폼이동
		<%--
			   session.invalidate();
			   response.sendRedirect("loginForm.jsp");
			--%>
			}
							})
		</script>
</body>
</html>