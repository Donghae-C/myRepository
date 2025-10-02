package ex0925.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

    
    public AppListener() {
    
    }

	
    public void contextInitialized(ServletContextEvent e)  { 
    	ServletContext application = e.getServletContext();
    	String saveDir = application.getInitParameter("saveDir");
    	application.setAttribute("saveDir", saveDir);
    }

	
	
}
