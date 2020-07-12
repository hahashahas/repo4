package com.atguigu2.com;

public class person {
	String name;
	int age;
	int id=1001;
	public person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public person() {
		
	}
	public person(String name) {
		this.name = name;
	}
	public void eat() {
		System.out.println("吃饭");
	}
	public void sleep() {
		System.out.println("睡觉");
	}
}
