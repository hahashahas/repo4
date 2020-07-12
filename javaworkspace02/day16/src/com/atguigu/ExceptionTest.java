package com.atguigu;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ExceptionTest {
	//*********************************运行时异常***************************************//
	//NullPointerException 空指针
	@Test
	public void test1() {
		int[] arr=null;
		System.out.println(arr);
		String str="abc";
		str=null;
		System.out.println(str.charAt(0));
	}
	//ArrayIndexOutOfBoundsException 数组越界
	@Test
	public void test2() {
		/*int [] arr=new int[10];
		System.out.println(arr[10]);*/
		String str="abc";
		System.out.println(str.charAt(3));
	}
	//ClassCastException 类型转换异常
	@Test
	public void test3() {
		Object obj=new Date();
		String str=(String)obj;
	}
	//NumberFormatException
	@Test
	public void test4() {
		String str="abc";
		int num=Integer.parseInt(str);
	}
	//InputMismatchException//输入不匹配
	@Test
	public void tesat5() {
		Scanner scanner=new Scanner(System.in);
		int score = scanner.nextInt();
		System.out.println(score);
		scanner.close();
	}
	//ArithmeticException//除数是0了
	@Test
	public void test6() {
		int a=10;
		int b=0;
		System.out.println(a/b);
	}
	
	//***********************************************编译时异常***********************************************//
	/*@Test
	public void test7() {
		File file=new File("hello.txt");
		FileInputStream fis =new FileInputStream(file);
		int data=fis.read();
		while(data!=-1) {
			System.out.print((char)data);
			data=fis.read();
		}
		fis.close();
	}*/
	
	
	
	
	
	
	
}
