package com.atguigu.exer;

public class student extends person{
	String major;
	public student() {
		
	}
	public student(String major) {
		this.major = major;
	}
	public void study() {
		System.out.println("学习，专业是"+major);
	}
	//对父类的eat方法重写
	public void eat() {
		System.out.println("学生多吃有营养的");
	}
}
