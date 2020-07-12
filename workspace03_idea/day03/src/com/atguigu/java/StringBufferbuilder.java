package com.atguigu.java;

/**
 * @author FLD
 * @create 2020-04-01 8:33
 */
public class StringBufferbuilder {
    public static void main(String[] args) {
        /*StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
        StringBuffer sb2=new StringBuffer();
        System.out.println(sb2.length());*/
        StringBuffer s1=new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);
        //s1.delete(2,4);
        //System.out.println(s1);
        s1.replace(2,4,"hello");
        System.out.println(s1);
        s1.insert(2,false);
        System.out.println(s1);
        System.out.println(s1.length());
        s1.reverse();
        System.out.println(s1);
    }
}
