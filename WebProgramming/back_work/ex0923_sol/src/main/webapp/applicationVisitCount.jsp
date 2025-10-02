<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
   //1. 기존 count 값을 읽어온다. (application영역에 저장된...)
   Object obj = application.getAttribute("count");
   
   //2. 만약 1의 값이 null이라면 기본 0으로 세팅(저장)!!!
   if(obj == null){
	   application.setAttribute("count", 0);
	   obj = application.getAttribute("count");
   }
   
   //3. 읽어온 데이터에 +1을 해서 다시 저장하고 화면에 출력한다. 
    int count = (Integer)obj;
   
    if(session.isNew()){
     count++;//증가
     application.setAttribute("count", count);
    }
--%>



<%
	//1. 기존 count 값을 읽어온다. (application영역에 저장된...)
	Object obj = application.getAttribute("count");
	
	//2. 만약 1의 값이 null이라면 기본 0으로 세팅(저장)!!!
	if(obj == null){
		   application.setAttribute("count", new AtomicInteger());
		   obj = application.getAttribute("count");
	}
	
	//3. 읽어온 데이터에 +1을 해서 다시 저장하고 화면에 출력한다. 
	 AtomicInteger at = (AtomicInteger)obj; //동기화 문제를 해결하면서도 성능을 높이기 위해  - 멀티스레드 환경에서 공유되는 정수형 변수를 동기화 없이도 안전하게 사용할 때
	
	 int count = at.intValue();
	 if(session.isNew()){
		 count = at.incrementAndGet();//증가	
	 }
%>

<h3>방문자 수 : <%=count%> 명</h3>


</body>
</html>