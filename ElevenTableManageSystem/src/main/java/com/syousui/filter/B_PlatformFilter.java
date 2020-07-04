package com.syousui.filter;

import com.syousui.pojo.Userdetail;
import com.syousui.service.AccountService;
import com.syousui.vo.ResultVo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @PackageLoaction ${PACKAGE_NAME}
 * @createTime 2020-06-17 08:40:00 星期三
 * @Description TODO
 */
@WebFilter ( filterName = "B_PlatformFilter", urlPatterns = { "/AccountController", "/HomeController" } )
public class B_PlatformFilter implements Filter {
    public void destroy ( ) {
    }

    public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException {
        String str_method = req.getParameter( "method" );
        if ( "login".equals( str_method ) || "register".equals( str_method ) || "checkRole".equals( str_method ) ) {
            chain.doFilter( req, resp );
            return;
        }

        int role = -1;
        HttpSession httpSession = ((HttpServletRequest) req).getSession( false );
        if ( httpSession != null ) {
            Userdetail userdetail = (Userdetail) httpSession.getAttribute( "userdetail" );
            if ( userdetail != null ) {
                role = userdetail.getRole( );
                if ( role == 0 || role == 1 || role == 2 )
                    chain.doFilter( req, resp );
                else
                    resp.getWriter( ).println( new ResultVo( ResultVo.CODE_AUTH_FAIL, "Please log in first.", null ).toJSON( ) );
            }
        }
    }

    public void init ( FilterConfig config ) throws ServletException {

    }

}
