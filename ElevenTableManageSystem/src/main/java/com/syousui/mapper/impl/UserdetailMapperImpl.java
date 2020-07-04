package com.syousui.mapper.impl;

import com.syousui.mapper.UserdetailMapper;
import com.syousui.pojo.Userdetail;
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
 * @ClassName UserdetailMapper.java
 * @PackageLoaction com.syousui.mapper.impl
 * @createTime 2020-06-16 21:42:00 星期二
 * @Description TODO
 */
public class UserdetailMapperImpl extends C3P0Util implements UserdetailMapper {
    private String selectSQL = "select * from userdetail where 1=1 ";
    private String orderSQL = " order by role desc, username asc ";
    private String selectSQL_findBy_username = "select * from userdetail where username=? ";
    private String selectSQL_findBy_username_userpass = "select * from userdetail where username=? and userpass=? ";
    private String deleteSQL = "delete from userdetail where username=? ";
    private String insertSQL = "insert into userdetail values( ?, ?, ?, ?, ? ) ";
    private String updateSQL = "update userdetail set userpass=?, role=?, regtime=?, lognum=? where username=? ";
    private String updateSQL_lognum = "update userdetail set lognum=lognum+1 where username=? ";
    private String role1SQL = " and role=0 ";
    private String role2SQL = " and role<=2 and role>=0 ";

    @Override
    public List<Userdetail> findAll_role1 ( ) {
        List<Userdetail> list = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + role1SQL +orderSQL,
                    new BeanListHandler<>( Userdetail.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }
    @Override
    public List<Userdetail> findAll_role2 ( ) {
        List<Userdetail> list = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] { };
        try {
            list = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL + role2SQL +orderSQL,
                    new BeanListHandler<>( Userdetail.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return list;
    }
    @Override
    public Userdetail findBy_username_role1 ( String username ) {
        Userdetail userdetail = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                username
        };
        try {
            userdetail = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL_findBy_username+role1SQL,
                    new BeanHandler<>( Userdetail.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return userdetail;
    }
    @Override
    public Userdetail findBy_username_role2 ( String username ) {
        Userdetail userdetail = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                username
        };
        try {
            userdetail = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL_findBy_username+role2SQL,
                    new BeanHandler<>( Userdetail.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return userdetail;
    }
    @Override
    public Userdetail findBy_username_userpass ( String username, String userpass ) {
        Userdetail userdetail = null;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                username,
                userpass
        };
        try {
            userdetail = new QueryRunner( super.getDataSource( ) ).query(
                    conn,
                    selectSQL_findBy_username_userpass,
                    new BeanHandler<>( Userdetail.class ),
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return userdetail;
    }
    @Override
    public int removeBy_username ( String username ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                username
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
    public int add ( Userdetail userdetail ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                userdetail.getUsername( ),
                userdetail.getUserpass( ),
                userdetail.getRole( ),
                userdetail.getRegtime( ),
                userdetail.getLognum( ),
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
    public int add_lognum ( String username ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                username,
        };
        try {
            count = new QueryRunner( super.getDataSource( ) ).update(
                    conn,
                    updateSQL_lognum,
                    param
            );
        } catch ( SQLException throwables ) {
            throwables.printStackTrace( );
        }
        super.closeConnection( conn );
        return count;
    }

    @Override
    public int modify ( Userdetail userdetail ) {
        int count = 0;
        Connection conn = super.getConnection( );
        Object[] param = new Object[] {
                userdetail.getUserpass( ),
                userdetail.getRole( ),
                userdetail.getRegtime( ),
                userdetail.getLognum( ),
                userdetail.getUsername( ),
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
