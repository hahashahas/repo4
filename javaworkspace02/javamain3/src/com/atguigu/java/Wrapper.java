package com.atguigu.java;

import org.junit.Test;

public class Wrapper {
	@Test
	public void test1(){
		int num=10;
		Integer in1=new Integer(num);
		System.out.println(in1);
		System.out.println(in1.toString());
		Integer in2=new Integer("123");
		System.out.println(in2);
		Integer in3=new Integer(12);
		int i1=in3.intValue();
		System.out.println(i1+1);
		int num2=10;
		Integer in4=num2;
		System.out.println(in4);
		float f1=12.3f;
		String s1=String.valueOf(f1);
		System.out.println(f1);
		String str1="123";
		int num3=Integer.parseInt(str1);
		System.out.println(num3+1);
		
	}
}

