<%@page import="ex0924.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>EL(Expression Language) = 표현언어</h1>
	<h3>
		\${5} = ${5}<br>
		\${5+3} = ${5+3}<br>
		\${5*3} = ${5*3}<br>
		\${5>3} = ${5>3}<br>
		\${5 gt 3} = ${5 gt 3}<br>
		\${5 lt 3} = ${5 lt 3}<br>
		\${5 gt 3 and 10 eq 10} = ${5 gt 3 and 10 eq 10}<hr>
		
		\${"배고프다"} = ${"배고프다"}<br>
		\${'배고프다'} = ${'배고프다'}<hr>
		
		<!-- 
		http://localhost:8080/step04_JSP/ex02_el_test.jsp?age=10
		 -->
		\${param.age} = ${param.age > 18 ? "성인" : "미성년자"}<br>
		<!-- 
		http://localhost:8080/step04_JSP/ex02_el_test.jsp?age=10&id=test
		id는 들어올수도 안들어올수도.
		 -->
		${not empty param.id ? param.id+="로그인중" : "guest".concat("님")}
		
		<!-- scope에 저장된 정보를 표현언어로 출력 
			pageContext < requestScope < sessionScope < applicationScope
			${pageScope.이름}
			${requestScope.이름}
			${sessionScope.이름}
			${applicationScope.이름}
		-->
		<%
		request.setAttribute("id", "test");
		session.setAttribute("name", "testName");
		session.setAttribute("addr", "미금");
		application.setAttribute("addr", "오리");
		application.setAttribute("message", "EL학습중");
		%>
		<hr>
		아이디 : <%=request.getAttribute("id") %> / ${requestScope.id} / ${id}<br>
		이름 : <%=session.getAttribute("name") %> / ${sessionScope.name } / ${name }<br>
		주소 : <%=session.getAttribute("addr") %> / ${sessionScope.addr } / ${addr }<br>
		
		a주소 : <%=application.getAttribute("addr") %> / ${applicationScope.addr } / ${addr }<br>
		메시지 : <%=application.getAttribute("message") %> / ${applicationScope.message } / ${message }<br>
		<hr>
		
		<jsp:useBean id="p" class="ex0924.dto.Product"/>
		
		상품정보<br>
		code : <%=p.getCode() %> / ${p.code} / ${p.getCode()}<br> <!-- getCode()로도 가능하나 굳이..? -->
		name : <%=p.getName() %> / ${p.name} <br>
		qty : <%=p.getQty() %> / ${p.qty}<br>
		price : <%=p.getPrice() %> / ${p.price}<br>
		총금액(수량*가격) : <%=p.getPrice() * p.getQty()%> / ${p.price * p.qty}<br>
		
	</h3>
</body>
</html>