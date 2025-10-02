package ex0924.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * 생성 + 매핑
 * 1) web.xml
 * 2) @annotaion
 */
public class SampleFilter implements Filter {
	
	

	public SampleFilter() {
		System.out.println("SampleFilter constructor call...");
	}

	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SampleFilter init call...");
	}


	
	/**
	 * 사용자 요청을 가로채서 사전, 사후처리를 공통으로 적용
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("SampleFilter의 사전 처리중...");
		
		filterChain.doFilter(req, res);//다음 filter나 타겟대상을 호출해준다.
		
		System.out.println("SampleFilter의 사후 처리중...");
	}



	@Override
	public void destroy() {
		System.out.println("SampleFilter destory call...");
	}
	
	

}
