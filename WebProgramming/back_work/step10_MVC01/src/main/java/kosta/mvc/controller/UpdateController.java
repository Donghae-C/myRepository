package kosta.mvc.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//수정 -> 전송된 데이터 받기
		//서비스 호출 -> 결과 받아서 이동
		System.out.println("UpdateController 호출됨...");
		request.setAttribute("message", "수정완료");
		
		return new ModelAndView("updateResult.jsp");
	}

}
