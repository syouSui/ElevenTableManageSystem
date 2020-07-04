package com.syousui.filter;

import com.syousui.pojo.Userdetail;
import com.syousui.vo.ResultVo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName ${NAME}.java
 * @PackageLoaction ${PACKAGE_NAME}
 * @createTime 2020-06-17 09:07:00 星期三
 * @Description TODO
 */
@WebFilter ( filterName = "C_UserdetailFilter", urlPatterns = { "/UserdetailController" } )
public class C_UserdetailFilter implements Filter {
    public void destroy ( ) {
    }

    public void doFilter ( ServletRequest req, ServletResponse resp, FilterChain chain ) throws ServletException, IOException {
        int role = ((Userdetail) ((HttpServletRequest) req).getSession( ).getAttribute( "userdetail" )).getRole( );
        if ( role == 1 || role == 2 )
            chain.doFilter( req, resp );
        else resp.getWriter( ).println( new ResultVo( ResultVo.CODE_AUTH_FAIL, "Without permission.", null ) );
    }

    public void init ( FilterConfig config ) throws ServletException {
    }

}
