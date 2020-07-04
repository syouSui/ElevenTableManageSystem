package com.syousui.service;

import com.syousui.mapper.UserdetailMapper;
import com.syousui.mapper.impl.UserdetailMapperImpl;
import com.syousui.pojo.Userdetail;
import com.syousui.vo.ResultVo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName AmountService.java
 * @PackageLoaction com.syousui.service
 * @createTime 2020-06-17 00:50:00 星期三
 * @Description TODO
 */
public class AccountService {
    UserdetailMapper userdetailMapper = new UserdetailMapperImpl( );

    public void login ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        Userdetail userdetail = null;
        userdetail = userdetailMapper.findBy_username_userpass(
                request.getParameter( "username" ),
                request.getParameter( "userpass" )
        );
        if ( userdetail == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "请确认用户名密码是否正确！", null ).toJSON( ) );
        else {
            // 更新或创建在线用户名列表
            ServletContext servletContext = request.getServletContext( );
            List<String> usernameList = (List<String>) servletContext.getAttribute( "usernameList" );
            if ( usernameList == null )
                usernameList = new LinkedList<String>( );
            else if ( usernameList.contains( userdetail.getUsername( ) ) ) {
                response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "此用户已登录！请确认重试！", null ).toJSON( ) );
                return;
            }
            usernameList.add( userdetail.getUsername( ) );
            servletContext.setAttribute( "usernameList", usernameList );
            System.out.println( userdetail.getUsername( ) + " - 已添加到用户名列表!" );
            // 创建 session
            HttpSession httpSession = request.getSession( true );
            System.out.println( "已创建一个会话, 用户名: \t" + userdetail.getUsername( ) );
            httpSession.setMaxInactiveInterval( 60 * 30 );
            httpSession.setAttribute( "userdetail", userdetail );
            userdetailMapper.add_lognum( userdetail.getUsername( ) );
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", null ).toJSON( ) );
        }
        System.out.println( "login" );
    }

    public void register ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        int counter = userdetailMapper.add(
                new Userdetail(
                        request.getParameter( "username" ),
                        request.getParameter( "userpass" ),
                        0,
                        Userdetail.getSystemDateString( ),
                        0
                )
        );
        if ( counter == 0 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", counter ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", counter ).toJSON( ) );
        System.out.println( "register" );
    }

    public void checkRole ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        HttpSession httpSession = request.getSession( false );
        if ( httpSession == null ) {
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "notOnline", null ).toJSON( ) );
        } else {
            Userdetail userdetail = (Userdetail) httpSession.getAttribute( "userdetail" );
            if ( userdetail != null )
                response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "isOnline", userdetail.getRole( ) ).toJSON( ) );
            else
                response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "notOnline", null ).toJSON( ) );
        }
        System.out.println( "checkRole" );
    }

    public void exit ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        request.getSession( false ).invalidate( );
        response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "Exit successfully.", null ).toJSON( ) );
        System.out.println( "exit" );
    }

    public void showUserdetailName ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        HttpSession httpSession = request.getSession( false );
        if ( httpSession != null ) {
            String username = ((Userdetail) httpSession.getAttribute( "userdetail" )).getUsername( );
            if ( username == null )
                response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", null ).toJSON( ) );
            else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", username ).toJSON( ) );
        } else {

        }
        System.out.println( "showUsername" );
    }

    public void showUserInlineCounter ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        request.getServletContext( ).getAttribute( "userInlineCounter" )
                ).toJSON( )
        );
        System.out.println( "showUserInlineCounter" );
    }

    public void showMaxUserInlineCounter ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        response.getWriter( ).println(
                new ResultVo(
                        ResultVo.CODE_SUCCESS,
                        "success",
                        request.getServletContext( ).getAttribute( "maxUserInlineCounter" )
                ).toJSON( )
        );
        System.out.println( "showMaxUserInlineCounter" );
    }

    public void showUsernameInlineList ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        HttpSession httpSession = request.getSession( false );
        if ( httpSession == null ) {
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_AUTH_FAIL, "without permission.", null ).toJSON( ) );
        } else {
            Userdetail userdetail = (Userdetail) httpSession.getAttribute( "userdetail" );
            if ( userdetail == null ) {
                response.getWriter( ).println( new ResultVo( ResultVo.CODE_AUTH_FAIL, "without permission.", null ).toJSON( ) );
            } else {
                int role = -1;
                role = userdetail.getRole( );
                if ( role == 1 || role == 2 )
                    response.getWriter( ).println(
                            new ResultVo(
                                    ResultVo.CODE_SUCCESS,
                                    "success",
                                    request.getServletContext( ).getAttribute( "usernameList" )
                            ).toJSON( )
                    );
                else
                    response.getWriter( ).println( new ResultVo( ResultVo.CODE_AUTH_FAIL, "without permission.", null ).toJSON( ) );
            }
        }
        System.out.println( "showUsernameInlineList" );
    }

}
