package com.syousui.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName Userdetail.java
 * @PackageLoaction com.syousui.pojo
 * @createTime 2020-06-16 21:41:00 星期二
 * @Description TODO
 */
public class Userdetail {
    private String username;
    private String userpass;
    private int role;
    private String regtime;
    private int lognum;
    public Userdetail ( ) {
    }
    public Userdetail ( String username, String userpass, int role, String regtime, int lognum ) {
        this.username = username;
        this.userpass = userpass;
        this.role = role;
        this.regtime = regtime;
        this.lognum = lognum;
    }
    public String getUsername ( ) {
        return username;
    }
    public void setUsername ( String username ) {
        this.username = username;
    }
    public String getUserpass ( ) {
        return userpass;
    }
    public void setUserpass ( String userpass ) {
        this.userpass = userpass;
    }
    public int getRole ( ) {
        return role;
    }
    public void setRole ( int role ) {
        this.role = role;
    }
    public String getRegtime ( ) {
        return regtime;
    }
    public void setRegtime ( String regtime ) {
        this.regtime = regtime;
    }
    public int getLognum ( ) {
        return lognum;
    }
    public void setLognum ( int lognum ) {
        this.lognum = lognum;
    }
    public static String getSystemDateString ( ) {
        return new SimpleDateFormat( "yyyy-MM-dd hh:mm:ss" ).format( new Date( ) );
    }
}
