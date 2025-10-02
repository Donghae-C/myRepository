<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
      <link rel="stylesheet" type="text/css" href="css/navbar.css">
    <style>
        body{
            height: 100vh;
            display: grid;
            grid-template-columns:1fr 3fr ;
            grid-template-rows:100px auto 30px ;

            grid-template-areas: 
            'header header' 'aside main' 'footer footer' ;
        }
        header{ grid-area: header;}
        main{grid-area: main;}
        aside{ grid-area: aside;  }
        footer{ grid-area: footer;}

        iframe {width: 100%;height: 100%; border: none; }
        
       footer > h3{
			
			color: white;
			font-size: xx-large;;
			text-align: center;
			text-shadow: 5px 5px 5px blue;
			padding: 30px;
    }
    </style>
</head>
<body>
    <!-- 상단의 메뉴 -->
    <header>
        <jsp:include page="top.jsp"/>
    </header>

    <!-- 본문 영역 -->
     <!-- 본문과 관계없는 광고  -->
    <aside><iframe src="left.jsp" name="left"></iframe></aside>
    
    <main> <iframe src="center.jsp" name="center"></iframe></main>
 
    <!-- 하단 영역 -->
    <footer><jsp:include page="footer.jsp"/></footer>
</body>
</html>