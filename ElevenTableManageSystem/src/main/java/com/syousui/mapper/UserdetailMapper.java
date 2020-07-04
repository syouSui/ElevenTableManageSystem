package com.syousui.mapper;

import com.syousui.pojo.Userdetail;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName UserdetailMapper.java
 * @PackageLoaction com.syousui.mapper
 * @createTime 2020-06-16 21:41:00 星期二
 * @Description TODO
 */
public interface UserdetailMapper {
    public List<Userdetail> findAll_role1 ( );

    public List<Userdetail> findAll_role2 ( );

    public Userdetail findBy_username_role1 ( String username );

    public Userdetail findBy_username_role2 ( String username );

    public Userdetail findBy_username_userpass ( String username, String userpass );

    public int removeBy_username ( String username );

    public int add ( Userdetail userdetail );

    public int add_lognum ( String username );

    public int modify ( Userdetail userdetail );
}
