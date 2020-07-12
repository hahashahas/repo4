package com.atguigu.java1;

public class BlockTest {
	public static void main(String[] args) {
		String desc = Person.desc;
		Person p1= new Person();
		Person p2=new Person();
		System.out.println(p1.age);
		Person.info();
		System.out.println(desc);
	}
}
class Person{
	String name;
	int age;
	static String  desc;
	public  Person() {
		
	}
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
		
	}
	//代码块
	static{
		System.out.println("hello");
		desc="我是一个人";
	}
	{
		age=1;
		System.out.println("hello world");
	}
	public void eat() {
		System.out.println("吃饭");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public static void info() {
		System.out.println("我是一个快乐的人");
	}
	
}