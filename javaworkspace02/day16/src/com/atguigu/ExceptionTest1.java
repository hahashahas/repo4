package com.atguigu;

import org.junit.Test;

/*
 * 异常处理:抓抛模型
 * try-catch-finally
 * try{
 * 可能出现异常的代码
 * }catch(异常类型1 变量名1){
 * 		处理方式
 * }catch(异常类型2 变量名2){
 * 		处理方式
 * }
 * finally{
 * 		一定执行的代码
 * }
 * 
 */
public class ExceptionTest1 {
	@Test
	public void test1() {
		String str="abc";
		try {
			int num=Integer.parseInt(str);
			System.out.println("hello-1");
		}catch(NumberFormatException e){
			System.out.println("出现数值转换异常了，不要着急");
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}catch(NullPointerException e){
			System.out.println("出现空指针异常，不要着急");
		}catch(Exception e){
			System.out.println("出现异常了，不要着急");
		}
		System.out.println("hello-2");
	}
}
