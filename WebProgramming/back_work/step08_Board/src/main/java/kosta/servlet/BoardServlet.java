package kosta.servlet;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kosta.dto.BoardDTO;


@WebServlet(urlPatterns ="/board"  , loadOnStartup = 1 )
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private List<BoardDTO> boardList ;
       
	public BoardServlet() {
      System.out.println("BoardServlet 생성자 call....");
	}
    
	/**
	 * 게시물 3개 초기화 해서 ServletContext영역에 저장
	 * */
	public void init(ServletConfig config) throws ServletException {
	   ServletContext application = config.getServletContext();
	   boardList = (List<BoardDTO>)application.getAttribute("boardList");
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//넘어오는 값 3개를 받아서 BoardDTO로 만들고 list에 추가한다.
		String no = request.getParameter("no");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		BoardDTO board = new BoardDTO(Integer.parseInt(no), subject, content);
		
		//appplication에 저장된 boardList에 추가한다.
		boardList.add(board);
		
		
		//이동
		response.sendRedirect("center.jsp");
		
	}

}






