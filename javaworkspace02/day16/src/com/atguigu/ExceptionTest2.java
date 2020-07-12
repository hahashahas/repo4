package com.atguigu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ExceptionTest2 {
	@Test
	public static void main(String [] args){
		try {
			method2();
		}catch(IOException e) {
			e.printStackTrace();
		}
		method3();
	}
	public static void method3() {
		try {
			method2();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void method2() throws FileNotFoundException,IOException{
		method1();
	}
	public static void method1() throws FileNotFoundException,IOException{
		File file=new File("hello1.txt");
		FileInputStream fis =new FileInputStream(file);
		int data=fis.read();
		while(data!=-1) {
			System.out.print((char)data);
			data=fis.read();
		}
		fis.close();
	}
}
