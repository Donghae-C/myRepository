package ex0924.servlet;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SampleServlet extends HttpServlet {
	String id;
	String pwd;
	String message;
	String uploadLocation;
	public SampleServlet() {
		System.out.println("SampleServlet constructor");
	}

	@Override
	public void init() throws ServletException {
		id = super.getInitParameter("id");
		pwd = super.getInitParameter("pwd");
		System.out.println("SampleServlet init.."+id+", "+pwd);
		//contextParam 정보 가져오기
		
		ServletContext application = super.getServletContext();
		message = application.getInitParameter("message");
		uploadLocation = application.getInitParameter("uploadLocation");
		System.out.println("SampleServlet init.."+message+", "+uploadLocation);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SampleServlet service..");
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pwd);
		
	}

}
