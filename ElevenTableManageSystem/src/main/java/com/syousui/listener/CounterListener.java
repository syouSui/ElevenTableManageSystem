package com.syousui.listener; /**
 * @ClassName ${NAME}.java
 * @PackageLoaction ${PACKAGE_NAME}
 * @author acmaker
 * @version 1.0.0
 * @createTime 2020-06-16 21:53:00 星期二
 * @Description TODO
 */


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class CounterListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    long userInlineCounter;
    long maxUserInlineCounter;

    // Public constructor is required by servlet spec
    public CounterListener ( ) {
        userInlineCounter = 0;
        maxUserInlineCounter = 0;
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized ( ServletContextEvent sce ) {
        userInlineCounter = 0;
        maxUserInlineCounter = 0;
        System.out.println( "SERVLET INITIALIZED" );
    }

    public void contextDestroyed ( ServletContextEvent sce ) {
        System.out.println( "SERVLET DESTROYED" );
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated ( HttpSessionEvent se ) {
        ++userInlineCounter;
        maxUserInlineCounter = Math.max( maxUserInlineCounter, userInlineCounter );
        ServletContext servletContext = se.getSession(  ).getServletContext( );
        servletContext.setAttribute( "userInlineCounter", userInlineCounter );
        servletContext.setAttribute( "maxUserInlineCounter", maxUserInlineCounter );
        System.out.println( "+1 !" + " \tcounter: "+ userInlineCounter );
    }

    public void sessionDestroyed ( HttpSessionEvent se ) {
        --userInlineCounter;
        se.getSession( ).getServletContext( ).setAttribute( "userInlineCounter", userInlineCounter );
        System.out.println( "-1 !" + " \tcounter: "+ userInlineCounter );
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded ( HttpSessionBindingEvent sbe ) {
      /* This method is called when an attribute
         is added to a session.
      */
    }

    public void attributeRemoved ( HttpSessionBindingEvent sbe ) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced ( HttpSessionBindingEvent sbe ) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }
}
