package com.syousui.mapper.impl;

import com.syousui.mapper.HomeMapper;
import com.syousui.pojo.Home;
import com.syousui.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName HomeMapperImpl.java
 * @PackageLoaction com.syousui.mapper.impl
 * @createTime 2020-06-16 21:42:00 星期二
 * @Description TODO
 */
public class HomeMapperImpl extends C3P0Util implements HomeMapper {
    private String selectSQL = "select * from home where 1=1 ";
    private String select_id = "and id=? ";
    private String select_title = "and title like ? ";
    private String select_publishTime = "and publishTime>=? and publishTime<=? ";
    private String select_price = "and price>=? and price<=? ";
    private String select_typeId = "and typeId=? ";
    private String deleteSQL = "delete from home where id=? ";
    private String insertSQL = "insert into home values(?, ?, ?, ?, ? ) ";
    private String updateSQL = "update home set title=?, price=?, publishTime=?, typeId=? where id=? ";

    @Override
    public List<Home> findAll ( ) {
        List<Home> list = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL,
                    new BeanListHandler<>( Home.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }
    @Override
    public Home findBy_id ( int id ) {
        Home home = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                id
        };
        try {
            home = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + select_id,
                    new BeanHandler<>( Home.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return home;
    }
    @Override
    public List<Home> findBy_title ( String title ) {
        List<Home> list = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                "%" + title + "%"
        };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + select_title,
                    new BeanListHandler<>( Home.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }
    @Override
    public List<Home> findBy_publishTime ( String publishTime_begin, String publishTime_end ) {
        List<Home> list = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                publishTime_begin,
                publishTime_end
        };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + select_publishTime,
                    new BeanListHandler<>( Home.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }
    @Override
    public List<Home> findBy_price ( int price_begin, int price_end ) {
        List<Home> list = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                price_begin,
                price_end
        };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + select_price,
                    new BeanListHandler<>( Home.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }
    @Override
    public List<Home> findBy_typeId ( int typeId ) {
        List<Home> list = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                typeId
        };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + select_typeId,
                    new BeanListHandler<>( Home.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }
    @Override
    public int removeBy_id ( int id ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                id
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    deleteSQL,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }
    @Override
    public int add ( Home home ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                home.getId( ),
                home.getTitle( ),
                home.getPrice( ),
                home.getPublishTime( ),
                home.getTypeId( )
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    insertSQL,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }
    @Override
    public int modify ( Home home ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                home.getTitle( ),
                home.getPrice( ),
                home.getPublishTime( ),
                home.getTypeId( ),
                home.getId( )
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    updateSQL,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }
}
