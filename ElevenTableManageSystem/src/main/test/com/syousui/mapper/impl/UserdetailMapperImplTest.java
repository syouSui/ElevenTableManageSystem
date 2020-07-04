package com.syousui.mapper.impl;

import com.syousui.mapper.UserdetailMapper;
import com.syousui.pojo.Userdetail;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * UserdetailMapperImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>6�� 16, 2020</pre>
 */
public class UserdetailMapperImplTest {

    @Before
    public void before ( ) throws Exception {
    }

    @After
    public void after ( ) throws Exception {
    }

    UserdetailMapper userdetailMapper = new UserdetailMapperImpl( );
    List<Userdetail> list = null;
    Userdetail userdetail = null;

    /**
     * Method: findAll()
     */
    @Test
    public void testFindAll ( ) throws Exception {
        list = userdetailMapper.findAll_role2( );
    }

    /**
     * Method: findBy_username
     */
    @Test
    public void testFindBy_username ( ) throws Exception {
        userdetail = userdetailMapper.findBy_username_role2( "admin" );
    }

    /**
     * Method: findBy_username
     */
    @Test
    public void testFindBy_username_userpass ( ) throws Exception {
        userdetail = userdetailMapper.findBy_username_userpass( "dzs","dzs" );
    }

    /**
     * Method: removeBy_username(String username)
     */
    @Test
    public void testRemoveBy_username ( ) throws Exception {
        int cout = userdetailMapper.removeBy_username( "test" );
    }

    /**
     * Method: add(Userdetail userdetail)
     */
    @Test
    public void testAdd ( ) throws Exception {
        int count = userdetailMapper.add( new Userdetail(
                        "test",
                        "test",
                        0,
                        "2020-06-16 23:00:00",
                        0
                )
        );
    }

    /**
     * Method: modify(Userdetail userdetail)
     */
    @Test
    public void testModify ( ) throws Exception {
        int count = userdetailMapper.modify( new Userdetail(
                        "test",
                        "TEST",
                        0,
                        "2020-06-17 20:00:00",
                        0
                )
        );
    }

}
