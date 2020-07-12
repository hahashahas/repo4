package com.atguigu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class FinallyTest {
	@Test
	public void test1() {
		try{
			int a=10;
			int b=0;
			System.out.println(a/b);
		}catch(ArithmeticException e){
			int[] arr=new int[10];
			System.out.println(arr[10]);
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			System.out.println("我好帅啊~~");
		}
	}
	@Test
	public void testMethod() {
		int num=method();
		System.out.println(num);
	}
	public int method() {
		try {
			int[] arr=new int[10];
			System.out.println(arr[10]);
			return 1;
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			return 2;
		}finally {
			System.out.println("我一定会被执行");
			return 3;
		}
	}
	@Test
	public void test2() {
		FileInputStream fis=null;
		try {
			File file=new File("hello.txt");
			fis =new FileInputStream(file);
			int data=fis.read();
			while(data!=-1) {
				System.out.print((char)data);
				data=fis.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
