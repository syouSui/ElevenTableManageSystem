package com.syousui.controller;

import com.syousui.service.UserdetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @PackageLoaction ${PACKAGE_NAME}
 * @createTime 2020-06-16 21:51:00 星期二
 * @Description TODO
 */
@WebServlet ( name = "UserdetailController", urlPatterns = { "/UserdetailController" } )
public class UserdetailController extends HttpServlet {
    protected void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String str_method = request.getParameter( "method" );
        try {
            Method method = UserdetailService.class.getMethod( str_method, HttpServletRequest.class, HttpServletResponse.class );
            method.invoke( new UserdetailService( ), request, response );
        } catch ( NoSuchMethodException | IllegalAccessException | InvocationTargetException e ) {
            e.printStackTrace( );
        }
    }

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        doPost( request, response );
    }
}
