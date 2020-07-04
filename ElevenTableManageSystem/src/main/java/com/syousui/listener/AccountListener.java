package com.syousui.listener; /**
 * @ClassName ${NAME}.java
 * @PackageLoaction ${PACKAGE_NAME}
 * @author acmaker
 * @version 1.0.0
 * @createTime 2020-06-17 10:25:00 星期三
 * @Description TODO
 */

import com.syousui.pojo.Userdetail;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.List;

@WebListener
public class AccountListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public AccountListener ( ) {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized ( ServletContextEvent sce ) {
        ServletContext servletContext = sce.getServletContext( );
    }

    public void contextDestroyed ( ServletContextEvent sce ) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated ( HttpSessionEvent se ) {
        /* Session is created. */
    }

    public void sessionDestroyed ( HttpSessionEvent se ) {
        // 获取 session 和 context
        HttpSession httpSession = se.getSession( );
        ServletContext servletContext = httpSession.getServletContext( );
        // 获取在线用户信息
        Userdetail userdetail = (Userdetail) httpSession.getAttribute( "userdetail" );
        // 获取在线用户名列表 并 移除此人用户名
        List<String> usernameList = (List<String>) servletContext.getAttribute( "usernameList" );
        if ( usernameList != null && usernameList.contains( userdetail.getUsername( ) ) ) {
            usernameList.remove( userdetail.getUsername( ) );
            System.out.println( userdetail.getUsername( ) + " - 已被移除在线用户名列表!" );
        }
        // 更新
        httpSession.removeAttribute( "userdetail" );
        servletContext.setAttribute( "usernameList", usernameList );
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
