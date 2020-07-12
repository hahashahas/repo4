package com.atguigu.java;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author FLD
 * @create 2020-05-09 11:03
 */
public class TreeSetTest {
    @Test
    public void test(){
        TreeSet set = new TreeSet();
        /*set.add(123);
        set.add(456);
        set.add("AA");
        set.add(new User("Tom",12));*/
        /*set.add(34);
        set.add(-34);
        set.add(11);
        set.add(8);*/
        set.add(new User("Tom",12));
        set.add(new User("AA",12));
        System.out.println(set);
    }
}
