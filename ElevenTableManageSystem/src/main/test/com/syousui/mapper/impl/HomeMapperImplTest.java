package com.syousui.mapper.impl;

import com.syousui.mapper.HomeMapper;
import com.syousui.pojo.Home;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * HomeMapperImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>6�� 16, 2020</pre>
 */
public class HomeMapperImplTest {

    @Before
    public void before ( ) throws Exception {
    }

    @After
    public void after ( ) throws Exception {
    }

    HomeMapper homeMapper = new HomeMapperImpl( );
    List<Home> list = null;
    Home home = null;
    /**
     * Method: findAll()
     */
    @Test
    public void testFindAll ( ) throws Exception {
        list = homeMapper.findAll( );
    }

    /**
     * Method: findBy_id(int id)
     */
    @Test
    public void testFindBy_id ( ) throws Exception {
        home = homeMapper.findBy_id( 1 );
    }

    /**
     * Method: findBy_title(String title)
     */
    @Test
    public void testFindBy_title ( ) throws Exception {
        list = homeMapper.findBy_title( "潍坊" );
    }

    /**
     * Method: findBy_publishTime(String publishTime_begin, String publishTime_end)
     */
    @Test
    public void testFindBy_publishTime ( ) throws Exception {
        list = homeMapper.findBy_publishTime( "2013-01-01", "2020-01-01" );
    }

    /**
     * Method: findBy_price(String price_begin, String price_end)
     */
    @Test
    public void testFindBy_price ( ) throws Exception {
        list = homeMapper.findBy_price( 1000, 2000 );
    }

    /**
     * Method: findBy_typeId(int typeId)
     */
    @Test
    public void testFindBy_typeId ( ) throws Exception {
        list = homeMapper.findBy_typeId( 3 );
    }

    /**
     * Method: removeBy_id(int id)
     */
    @Test
    public void testRemoveBy_id ( ) throws Exception {
        homeMapper.removeBy_id( 111 );
    }

    /**
     * Method: add(Home home)
     */
    @Test
    public void testAdd ( ) throws Exception {
        int count = homeMapper.add(
                new Home (
                        111,
                        "test",
                        9999,
                        "2020-06-16",
                        1
                )
        );
    }

    /**
     * Method: modify(Home home)
     */
    @Test
    public void testModify ( ) throws Exception {
        int count = homeMapper.modify(
                new Home (
                        111,
                        "TEST",
                        9999,
                        "2020-06-16",
                        1
                )
        );
    }

} 
