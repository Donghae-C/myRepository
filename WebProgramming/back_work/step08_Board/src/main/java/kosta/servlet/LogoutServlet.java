package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout" , loadOnStartup = 1) 
//@WebServlet("/logout")//다른 옵션이 없을때 url-pattern이 기본속성이다.
public class LogoutServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//모든 세션의 정보 삭제
		HttpSession session = req.getSession();
		session.invalidate();//모든세션정보 무효화
		
		PrintWriter out= resp.getWriter();
		out.println("<script>");
		out.println("top.location.href='index.jsp';");
		out.println("</script>");
		
	}
	
}










