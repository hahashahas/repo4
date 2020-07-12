package com.atguigu.java;

import org.junit.Test;

import java.util.List;

/**
 * @author FLD
 * @create 2020-05-11 1:44
 */
public class GenericTest1 {
    @Test
    public void test1(){
        Order<String> order1 = new Order<String>("orderAA",1001,"Order:AA");
        order1.setOrderT("AA:Hello");

    }
    @Test
    public void test2(){
        SubOrder sub1=new SubOrder();
        sub1.setOrderT(1123);

    }
    @Test
    public void test4(){
        Order<String> order=new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);

    }
}
