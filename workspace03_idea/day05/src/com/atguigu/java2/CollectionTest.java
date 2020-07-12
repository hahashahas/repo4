package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author FLD
 * @create 2020-05-07 14:30
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());
        Collection coll1=new ArrayList();
        coll1.add(456);
        coll1.add("cc");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);
        coll.clear();
        System.out.println(coll.isEmpty());

    }
}