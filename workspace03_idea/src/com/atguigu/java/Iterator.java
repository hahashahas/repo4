package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author FLD
 * @create 2020-05-07 22:17
 */
public class Iterator {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));
        java.util.Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            if("Tom".equals(next)){
                iterator.remove();
            }
        }
        iterator=coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
