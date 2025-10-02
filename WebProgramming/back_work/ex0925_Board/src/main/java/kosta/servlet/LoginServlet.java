package kosta.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login" }, initParams = { @WebInitParam(name = "dbId", value = "test"),
		@WebInitParam(name = "dbPwd", value = "1234") }, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dbId;
	private String dbPwd;

	public LoginServlet() {

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		dbId = config.getInitParameter("dbId");
		dbPwd = config.getInitParameter("dbPwd");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		if(dbId.equals(userId) && dbPwd.equals(userPwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			
			
			LocalDateTime date = LocalDateTime.now();
			session.setAttribute("creationTime", date);
			
			PrintWriter out = response.getWriter();
			//response.sendRedirect("index.jsp");
			out.println("<script>");
			out.println("top.location.href='index.jsp'");
			out.println("</script>");
			out.flush();
			out.close();
		}else {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보를 다시 확인해주세요.')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		
	}

}
