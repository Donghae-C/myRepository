package kosta.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Board관리 Controller
 */
public class BoardController implements Controller {
	
	/**
	 * 게시글 출력
	 */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("message", "게시판 list임");
		return new ModelAndView("board/list.jsp");
	}
	
	
	
	/**
	 * 게시글 상세보기
	 */
	public ModelAndView read(HttpServletRequest request, HttpServletResponse response) {
		
		return new ModelAndView("board/read.jsp", true);
	}
}
