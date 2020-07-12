package com.atguigu.java;

import java.util.Date;

/**
 * @author FLD
 * @create 2020-04-01 15:40
 */
public class DateTimeTest {
    public static void main(String[] args) {
        /*long time=System.currentTimeMillis();
        System.out.println(time);*/
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());
    }

}
