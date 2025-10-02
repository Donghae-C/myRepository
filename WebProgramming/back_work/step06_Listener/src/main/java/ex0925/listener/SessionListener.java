package ex0925.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
	public SessionListener() {
		System.out.println("SessionListener constructor...");
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionListener sessionCreated call...");
		
	}
	/**
	 * session.invalidate();호출
	 * session timeout(기본 30분)
	 * 
	 * 브라우저를 끈다고 session이 destroyed가 되지 않음
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionListener sessionDestroyed call...");
	}
	
	
}
