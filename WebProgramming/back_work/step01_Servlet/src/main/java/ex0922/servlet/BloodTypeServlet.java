package ex0922.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/bloodCheck" , loadOnStartup = 1)
public class BloodTypeServlet extends HttpServlet {

	public BloodTypeServlet() {
		
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name"); 
		String blood = request.getParameter("blood");
		request.getRequestDispatcher(blood+".jsp").forward(request, response);
		
	}
	

}
