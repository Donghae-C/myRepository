<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//*필요한 변수 선언
	boolean state = false; //--쿠키존재여부를 판별(false-없음, true -있음)
	String message=""; //-출력할 변수
	long time = System.currentTimeMillis();  //-현재시간을 저장할 변수(System.currentTimeMills();)
	Cookie lastDate = null;  //-Cookie 저장할 변수
	
	
	Cookie [] cookie = request.getCookies();
	 
	if(cookie != null){ //값이 없어서 널 포인트 Exception
	 for(Cookie co : cookie){
		  if(co.getName().equals("lastDate")){//찾는쿠키가존재한다면, 
			  state=true;//찾는 쿠키가 있다.
			  lastDate =co;//찾은 쿠키를 변수에 저장한다.
			  break; //더이상 반복문 돌지읺고 원하는 것을 찾으면 빠져 나옴
		  }
	 }
	}
	
	
	if(!state){//2. 쿠키 없으면 현재날짜를 저장하는 쿠키생성하여 저장한다.
		lastDate = new Cookie("lastDate", time+""); 
		lastDate.setMaxAge(60*60*24*365);
		lastDate.setPath("/");
		response.addCookie(lastDate);//
		message="당신은 처음 방문하셨습니다.";
			
	}else{//3. 쿠키 있으면 이전쿠키가 저장한 날짜를 가져와서 출력할 변수에 저장한다.
		  Date date = new Date(Long.valueOf(lastDate.getValue())); //데이트 타입이 long이므로(쿠키의 반환 값은 스트링) long형으로 변환 
			 
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		  String timeInFormat = sdf.format(date);
		 
	
		  message="당신의 마지막 접속일은 "+ timeInFormat; //과거날짜
	    
	   /* 4.현재 방문한 시점의 시간을 쿠키의 새로운 값으로 설정
	    -쿠키의 setValue를 이용하여 쿠키의 새로운값으로 변경
	     -쿠키를 클라이언트쪽에 다시저장한다.
	
	     response.addCookie(lastDate);는 쿠키를 새로 저장, 업데이트 하는 역할을 한다.
       하지만 업데이트하려는 값(value)이 바뀌지 않았다면,
        즉 setValue()를 호출하지 않았다면, 이전 값 그대로 클라이언트에 
        다시 저장된다.*/
	   lastDate.setMaxAge(60*60*24*365);
	   lastDate.setPath("/"); 
	   
	   lastDate.setValue(time+"");//수정
	   response.addCookie(lastDate); //변경된 내용을클라이언트쪽에저장   
	}
	  
%>

<h2>
 메시지 :  <%=message %><br>
 time : <%=time%><br>
  <hr>

</h2>
</body>
</html>