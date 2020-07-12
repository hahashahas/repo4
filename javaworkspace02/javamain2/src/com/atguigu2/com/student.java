package com.atguigu2.com;
public class student extends person{
	String major;
	int id=1002;
	public student() {
		
	}
	public student(String major) {
		this.major=major;
	}
	public student(String name,int age,String major) {
		super(name,age);
		this.major=major;
	}
	@Override
	public void eat() {
		System.out.println("学生可以吃饭");
	}
	public void study() {
		System.out.println("学生学习知识");
		this.eat();
		super.eat();
	}
	public void show() {
		System.out.println("name:"+this.name+",age:"+super.age);
		System.out.println("id:"+this.id);
		System.out.println("id:"+super.id);
	}
	
}
