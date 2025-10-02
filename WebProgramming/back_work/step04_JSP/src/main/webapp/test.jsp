<%@page
	import="jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP - Java Server Page 문법 test</h2>
	<%
	//자바영역
	String name = "test";
	int age = 30;
	out.print("<h3>이름 : " + name + "</h3>");
	%>


	<h3>
		나이 :
		<%=age%>살
	</h3>
	<h3>
		주소 :
		<%=test("ㅇㅇ")%>
	</h3>

	<%!String addr;

	public String test(String addr) {
		System.out.println("test call");
		return "kosta의 주소는 " + addr;
	}%>
</body>
</html>