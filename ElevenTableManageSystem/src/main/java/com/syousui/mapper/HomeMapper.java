package com.syousui.mapper;

import com.syousui.pojo.Home;

import java.util.List;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName HomeMapper.java
 * @PackageLoaction com.syousui.mapper
 * @createTime 2020-06-16 21:42:00 星期二
 * @Description TODO
 */
public interface HomeMapper {
    public List<Home> findAll();

    public Home findBy_id ( int id );

    public List<Home> findBy_title( String title );

    public List<Home> findBy_publishTime ( String publishTime_begin, String publishTime_end );

    public List<Home> findBy_price ( int price_begin, int price_end );

    public List<Home> findBy_typeId ( int typeId );

    public int removeBy_id ( int id );

    public int add ( Home home );

    public int modify ( Home home );
}
