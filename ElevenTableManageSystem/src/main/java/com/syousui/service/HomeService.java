package com.syousui.service;

import com.syousui.mapper.HomeMapper;
import com.syousui.mapper.impl.HomeMapperImpl;
import com.syousui.pojo.Home;
import com.syousui.vo.ResultVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName HomeService.java
 * @PackageLoaction com.syousui.service
 * @createTime 2020-06-16 21:56:00 星期二
 * @Description TODO
 */
public class HomeService {
    HomeMapper homeMapper = new HomeMapperImpl( );

    public void findAll ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        List<Home> list = homeMapper.findAll( );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findAll" );
    }

    public void findBy_id ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        Home home = homeMapper.findBy_id( Integer.parseInt( request.getParameter( "id" ) ) );
        if ( home == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", home ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", home ).toJSON( ) );
        System.out.println( "findBy_id" );
    }

    public void findBy_title ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        List<Home> list = homeMapper.findBy_title( request.getParameter( "title" ) );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findBy_title" );
    }

    public void findBy_publishTime ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        String[] str = request.getParameter( "publishTime" ).split( " " );
        List<Home> list = homeMapper.findBy_publishTime( str[0], str[1] );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findBy_publishTime" );
    }

    public void findBy_price ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        String[] str = request.getParameter( "price" ).split( " " );
        List<Home> list = homeMapper.findBy_price( Integer.parseInt( str[0] ), Integer.parseInt( str[1] ) );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findBy_price" );
    }

    public void findBy_typeId ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        List<Home> list = homeMapper.findBy_typeId( Integer.parseInt( request.getParameter( "typeId" ) ) );
        if ( list == null )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", list ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", list ).toJSON( ) );
        System.out.println( "findBy_typeId" );
    }

    public void removeBy_id ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        int counter = homeMapper.removeBy_id( Integer.parseInt( request.getParameter( "id" ) ) );
        if ( counter == 0 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", counter ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", counter ).toJSON( ) );
        System.out.println( "removeBy_id" );
    }

    public void add ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        int counter = homeMapper.add(
                new Home(
                        Integer.parseInt( request.getParameter( "id" ) ),
                        request.getParameter( "title" ),
                        Integer.parseInt( request.getParameter( "price" ) ),
                        request.getParameter( "publishTime" ),
                        Integer.parseInt( request.getParameter( "typeId" ) )
                )
        );
        if ( counter==0 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", counter ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", counter ).toJSON( ) );
        System.out.println( "add" );
    }

    public void modify ( HttpServletRequest request, HttpServletResponse response ) throws Exception {
        int counter = homeMapper.modify(
                new Home(
                        Integer.parseInt( request.getParameter( "id" ) ),
                        request.getParameter( "title" ),
                        Integer.parseInt( request.getParameter( "price" ) ),
                        request.getParameter( "publishTime" ),
                        Integer.parseInt( request.getParameter( "typeId" ) )
                )
        );
        if ( counter == 0 )
            response.getWriter( ).println( new ResultVo( ResultVo.CODE_FAILED, "failed", counter ).toJSON( ) );
        else response.getWriter( ).println( new ResultVo( ResultVo.CODE_SUCCESS, "success", counter ).toJSON( ) );
        System.out.println( "modify" );
    }
}
