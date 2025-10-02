package kosta.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderController implements Controller{
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("OrderController selectAll.");
		request.setAttribute("message", "selectAll.. 목록 대용");
		return new ModelAndView("order/list.jsp");
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("OrderController insert.");
		request.setAttribute("message", "insert라고 표시중");
		return new ModelAndView("order/list.jsp");
	}
}
