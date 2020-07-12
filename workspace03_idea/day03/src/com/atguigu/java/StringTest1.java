package com.atguigu.java;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author FLD
 * @create 2020-03-31 17:20
 */
public class StringTest1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*String str1="123";
        int num = Integer.parseInt(str1);
        System.out.println(num);
        String str2 = String.valueOf(num);
        System.out.println(str2);*/
        /*String str1="abc123";
        char[] c1 = str1.toCharArray();
        char []arr=new char[]{'h','e','l','l','o'};
        String s2 = new String(arr);
        System.out.println(s2);*/
        String s1="abc123中国";
        byte[] bytes = s1.getBytes();
        System.out.println(Arrays.toString(bytes));
        byte[] gbks = s1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));
        System.out.println("***************************");
        String s = new String(bytes);
        System.out.println(s);
        String s2 = new String(gbks);
        System.out.println(s2);
        String str4 = new String(gbks, "gbk");
        System.out.println(str4);

    }
}
