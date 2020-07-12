package com.main.java;
/*
 * 1.java类及类的成员：属性，方法，构造器，代码块，内部类
 * 2.面向对象的三大特征：封装，继承，多态，（抽象性）
 * 3.其他关键字：this super static final abstract interface package import
 * 创建类的对象=类的实例化=实例化一个类
 * 
 * */
//测试类
public class mianxiangduixiang1 {
	public static void main(String[] args) {
		//创建person类的对象
		Person p1=new Person();
		//Scanner scanner=new Scanner(System.in);
		//调用对象的结构：属性，方法
		p1.name="Tom";
		p1.isMale=true;
		System.out.println(p1.name);
		//调用方法
		p1.eat();
		p1.sleep();
		p1.talk("Chinese");
	}
}
class Person{
	//属性
	String name;
	int age=1;
	boolean isMale;
	//方法
	public void eat() {
		System.out.println("人可以吃饭");
	}
	public void sleep() {	
		System.out.println("人可以睡觉");
	}
	public void talk(String language) {
		System.out.println("人可以说话，使用的是：" + language);
	}
	
	
	
}
