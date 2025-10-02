package ex0925.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

	public AppListener() {
		System.out.println("AppListener constructor...");
	}

	/**
	 * 
	 * 서버 start시 : 프로젝트가 배포될 때 해야될 일이 있다면 여기에
	 */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("AppListener contextInitialized call");
		ServletContext application = e.getServletContext();
		String path = application.getContextPath();
		application.setAttribute("path", path); // jsp에서 ${applicationScope.path} or ${path}

	}

	/**
	 * 
	 * 서버 stop시. 즉 ServletContext 소멸될 때
	 */

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		System.out.println("AppListener contextDestroyed call");

	}

}
