package kosta.listener;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import kosta.dto.BoardDTO;

@WebListener
public class BoardListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {
		//게시물 3개정도를 미리 list에 저장하고 list를 모든 영역에서 언제든지 누구나 다 사용할수 있도록
		//application영역에 저장 - ServletContext
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		boardList.add(new BoardDTO(10, "즐거운 월요일","오늘도 열심히 화이팅!!"));
		boardList.add(new BoardDTO(20, "Spring프레임웍", "이미설계된 구조"));
		boardList.add(new BoardDTO(30, "jQuery란", "javaScript 경량의 라이브러리"));
		
	
	   ServletContext application = e.getServletContext();
	   application.setAttribute("boardList", boardList);//뷰에서 ${applicationScope.boardList} 사용
	   application.setAttribute("rootPath", application.getContextPath());//뷰에서 ${rootPath}
	   
	   
	   
	   System.out.println("boardList = " + boardList);
	}
   
}
