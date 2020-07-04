package com.syousui.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter ( "/*" )
public class A_CORSFilter implements Filter {
    public void destroy ( ) {
    }

    public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
//        String origin = request.getHeader("Origin");
//        response.setHeader( "Access-Control-Allow-Origin", "http://localhost:8080" );
//        response.setHeader( "Access-Control-Allow-Origin", "http://127.0.0.1:5500" );
//        response.setHeader( "Access-Control-Allow-Origin", "http://etms.acmaker.vip" );
        response.setHeader( "Access-Control-Allow-Origin", request.getHeader( "Origin" ) );
        response.setHeader( "Access-Control-Allow-Credentials", "true" );
        chain.doFilter( req, resp );
    }

    public void init ( FilterConfig config ) throws ServletException {

    }

}
