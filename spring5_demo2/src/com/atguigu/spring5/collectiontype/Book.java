package com.atguigu.spring5.collectiontype;

import java.util.List;

/**
 * @author FLD
 * @create 2020-06-20 10:23
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }
    public void test(){
        System.out.println(list);
    }
}
