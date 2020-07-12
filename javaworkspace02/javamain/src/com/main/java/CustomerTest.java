package com.main.java;
/*
 * 方法：描述类应该具有的功能
 * return 后不可有语句
 * */
public class CustomerTest {
	public static void main(String[] args) {
		Customer cust1=new Customer();
		cust1.eat();
	}
}
//客户类
class Customer{
	//属性
	String name;
	int age;
	boolean ismale;
	
	//方法
	
	public void eat() {
		System.out.println("客户吃饭");
		return;
	}
	public void sleep(int hour) {
		System.out.println("休息了"+hour+"个小时");
	}
	public String getname() {
		return name;
	}
	public String getnation(String nation) {
		String info="我的国籍是"+nation;
		return info;
	}
}
