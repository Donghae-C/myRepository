package ex0925.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogExam {
	Log log = LogFactory.getLog(super.getClass());
	
	public static void main(String[] args) {
		System.out.println("**LogTest 시작**");
		
		new LogExam().test();
		
		System.out.println("**LogTest 끝**");
	}
	
	public void test() {
		//호출되면 log를 남기고 싶다!
		log.trace("trace관련 로그");
		log.debug("debug관련 로그");
		log.info("info관련 로그");
		log.warn("warn관련 로그");
		log.error("error관련 로그");
		log.fatal("fatal관련 로그");
	}

}
