<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: double 3px red;
	border-collapse: collapse;
}

th, td{
	border: 1px solid red;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h3>&lt;c:forEach> Test</h3>
	<!-- 객체 생성 -->
	<jsp:useBean id="bean" class="ex0924.dto.ForEachBean" />
	${bean.names }
	<br> ${bean.menus }
	<br> ${bean.boardList }
	<br> ${bean.map }
	<br>

	<!-- 이렇게 1부터 10까지 돌릴수도 있음 -->
	<c:forEach begin="1" end="10" var="i">
${i},
</c:forEach>
	<hr>
	<!-- names는 select 모양으로 -->
	<select>
		<c:forEach var="name" items="${bean.names}" varStatus="state">
			<option value="${state.index}">${name}</option>
		</c:forEach>
	</select>
	<!-- menus는 체크박스 -->
	<fieldset>
		<legend>menu</legend>
		<c:forEach var="menu" items="${bean.menus}" varStatus="state">
			<input type="checkbox" name="menu" value="${state.index}"> ${menu}
		</c:forEach>
	</fieldset>

	<!-- map은 radio -->
	<fieldset>
		<legend>map</legend>
		<c:forEach var="map" items="${bean.map}" varStatus="state">
			<input type="radio" value="${map.key}" name="map"> ${map.value}
		</c:forEach>
	</fieldset>

	<!-- boardList는 table로 -->
	<fieldset>
		<legend>boardList</legend>
		<table>
			<tr>
				<th style="width: 50px;">순서</th>
				<th style="width: 50px;">번호</th>
				<th style="width: 200px;">제목</th>
				<th style="width: 200px;">내용</th>
			</tr>
			<c:forEach var="board" items="${bean.boardList}" varStatus="state">
				<tr>
					<td>${state.count}</td>
					<td>${board.no}</td>
					<td>${board.subject}</td>
					<td>${board.content}</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
	
	<hr>
	가격 : 2546700000원 / <fmt:formatNumber value="2546700000"/>원 <br>
	날짜 : <%=new Date() %> / <fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd HH-mm-ss"/><br>
</body>
</html>