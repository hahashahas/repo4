package com.main.java2;


public class PersonTest {
	public static void main(String[] args) {
		person p1=new person();
		p1.setage(1);
		p1.eat();
		System.out.println(p1.getage());
		System.out.println();
		person p2=new person("tom",20);
		System.out.println(p2.getage());
	}
}
class person{
	private String name;
	private int age;
	
	public person() {
		this.eat();
	}
	public person(String name) {
		this();
		this.name=name;
	}
	public person(String name,int age) {
		this(name);
		this.age=age;
		//this.name=name;
	}
	public void setname(String name) {
		this.name=name;
	}
	public void setage(int age) {
		this.age=age;
	}
	public int getage() {
		return this.age;
	}
	public String  getname() {
		return this.name;
	}
	public void eat() {
		System.out.println("人吃饭");
		this.study();
	}
	public void study() {
		System.out.println("人学习");
	}
}