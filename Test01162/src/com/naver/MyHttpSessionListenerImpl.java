package com.naver;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Application Lifecycle Listener implementation class MyHttpSessionListenerImpl
 *
 */
public class MyHttpSessionListenerImpl implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyHttpSessionListenerImpl() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("session created");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("session destroyed");
    }
	
}
