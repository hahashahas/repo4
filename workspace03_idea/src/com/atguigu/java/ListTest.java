package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FLD
 * @create 2020-05-08 17:15
 */
public class ListTest {
    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);
        System.out.println(list);
        list.add(1,"BB");
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.get(1));
    }
}
