package com.atguigu.com;

public class person {
	String name;
	int age;
	public person() {
		
	}
	public person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public void eat() {
		System.out.println("吃饭");
	}
	public void sleep() {
		System.out.println("睡觉");
	}
}
