package com.syousui.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author acmaker
 * @version 1.0.0
 * @ClassName Home.java
 * @PackageLoaction com.syousui.pojo
 * @createTime 2020-06-16 21:41:00 星期二
 * @Description TODO
 */
public class Home {
    private int id;
    private String title;
    private int price;
    private String publishTime;
    private int typeId;
    public Home ( ) {
    }
    public Home ( int id, String title, int price, String publishTime, int typeId ) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.publishTime = publishTime;
        this.typeId = typeId;
    }
    public int getId ( ) {
        return id;
    }
    public void setId ( int id ) {
        this.id = id;
    }
    public String getTitle ( ) {
        return title;
    }
    public void setTitle ( String title ) {
        this.title = title;
    }
    public int getPrice ( ) {
        return price;
    }
    public void setPrice ( int price ) {
        this.price = price;
    }
    public String getPublishTime ( ) {
        return publishTime;
    }
    public void setPublishTime ( String publishTime ) {
        this.publishTime = publishTime;
    }
    public int getTypeId ( ) {
        return typeId;
    }
    public void setTypeId ( int typeId ) {
        this.typeId = typeId;
    }
    public static String getSystemDateString ( ) {
        return new SimpleDateFormat( "yyyy-MM-dd" ).format( new Date( ) );
    }
}
