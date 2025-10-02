package ex0924.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name = "testServlet", urlPatterns = { "/test" }, initParams = { @WebInitParam(name = "addr", value = "서울"),
		@WebInitParam(name = "fileName", value = "info.txt") }, loadOnStartup = 1)
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String addr;
	String fileName;
	String message;
	String uploadLocation;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		System.out.println("TestServelt constructor");
	}

	public void init(ServletConfig config) throws ServletException {
		addr = config.getInitParameter("addr");
		fileName = config.getInitParameter("fileName");
		System.out.println("TestServelt init " + addr + ", " + fileName);
		
		ServletContext application = config.getServletContext();
		message = application.getInitParameter("message");
		uploadLocation = application.getInitParameter("uploadLocation");
		System.out.println("testServlet init.."+message+", "+uploadLocation);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("testServelt service");
	}

}
