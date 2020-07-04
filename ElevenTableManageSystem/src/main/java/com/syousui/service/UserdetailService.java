package com.syousui.service;

import com.syousui.mapper.UserdetailMapper;
import com.syousui.mapper.impl.UserdetailMapperImpl;
import com.syousui.pojo.Userdetail;
import com.syousui.vo.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName UserdetailService.java
 * @PackageLoaction com.syousui.service
 * @createTime 2020-06-16 21:56:00 星期二
 * @Description TODO
 */
public class UserdetailService {
    UserdetailMapper userdetailMapper = new UserdetailMapperImpl( );

    public void findAll ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        int cur_role = ((Userdetail) request.getSession( ).getAttribute( "userdetail" )).getRole( );
        List<Userdetail> list = cur_role == 2 ? userdetailMapper.findAll_role2( ) : userdetailMapper.findAll_role1( );
        response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findAll" );
    }

    public void findBy_username ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        int cur_role = ((Userdetail) request.getSession( ).getAttribute( "userdetail" )).getRole( );
        Userdetail userdetail = cur_role == 2 ?
                userdetailMapper.findBy_username_role2( request.getParameter( "username" ) ) :
                userdetailMapper.findBy_username_role1( request.getParameter( "username" ) );
        if ( userdetail == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", null ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", userdetail ).toJSON( ) );
        System.out.println( "findBy_username" );
    }

    public void removeBy_username ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        String goal_username = request.getParameter( "username" );
        int goal_role = userdetailMapper.findBy_username_role1( goal_username ).getRole( );
        int cur_role = ((Userdetail) request.getSession( ).getAttribute( "userdetail" )).getRole( );
        if ( cur_role == 1 && goal_role !=0 || cur_role == 2 && goal_role == 2 ) {
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_AUTH_FAIL, "Without permission.", null ) );
            return;
        }
        int counter = userdetailMapper.removeBy_username( goal_username );
        if ( counter == 0 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", counter ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", counter ).toJSON( ) );
        System.out.println( "removeBy_username" );
    }

    public void add ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        int cur_role = ((Userdetail) request.getSession( ).getAttribute( "userdetail" )).getRole( );
        int goal_role = Integer.parseInt( request.getParameter( "role" ) );
        if ( cur_role == 1 && goal_role !=0 || cur_role == 2 && goal_role == 2 ) {
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_AUTH_FAIL, "Without permission.", null ) );
            return;
        }
        int counter = userdetailMapper.add(
                new Userdetail(
                        request.getParameter( "username" ),
                        request.getParameter( "userpass" ),
                        goal_role,
                        request.getParameter( "regtime" ),
                        Integer.parseInt( request.getParameter( "lognum" ) )
                )
        );
        if ( counter == 0 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", counter ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", counter ).toJSON( ) );
        System.out.println( "add" );
    }

    public void modify ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        String goal_username = request.getParameter( "username" );
        int goal_role = userdetailMapper.findBy_username_role1( goal_username ).getRole( );
        int cur_role = ((Userdetail) request.getSession( ).getAttribute( "userdetail" )).getRole( );
        if ( cur_role == 1 && goal_role !=0 || cur_role == 2 && goal_role == 2 ) {
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_AUTH_FAIL, "Without permission.", null ) );
            return;
        }
        int counter = userdetailMapper.modify(
                new Userdetail(
                        request.getParameter( "username" ),
                        request.getParameter( "userpass" ),
                        goal_role,
                        request.getParameter( "regtime" ),
                        Integer.parseInt( request.getParameter( "lognum" ) )
                )
        );
        if ( counter == 0 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", counter ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", counter ).toJSON( ) );
        System.out.println( "modify" );
    }
}
