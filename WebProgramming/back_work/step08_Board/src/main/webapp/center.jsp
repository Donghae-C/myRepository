<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/5/w3.css">
</head>
<body>


<table  class="w3-table  w3-striped  w3-bordered">
  <caption><h3 style="text-shadow: 5px 5px 5px blue;"> Board LIST </h3></caption>
 <tr>
    <th>순서</th>
    <th>글번호</th>
    <th>제목</th>
    <th>내용</th>
 </tr>
<c:forEach items="${applicationScope.boardList}" var="board" varStatus="state">
  <tr>
     <td>${state.count}</td>
     <td>${board.no}</td> <!-- board.getNo()호출 -->
     <td>${board.subject}</td><!-- board.getSubject()호출 -->
     <td>${board.content}</td><!-- board.getContent()호출 -->
  </tr>
</c:forEach>
</table>

<hr>

<c:if test="${not empty sessionScope.sessionId}">
   <form action="${rootPath}/board" method="post" >
      글번호 : <input type="text" name="no" class="w3-input"/><br>
      제목 : <input type="text" name="subject"  class="w3-input"/><br>
      내용: <textarea rows="5" cols="20" name="content"  class="w3-input"></textarea> <br>
      <input type="submit" value="등록">
      <input type="reset" value="취소">
   </form>
</c:if>




</body>
</html>