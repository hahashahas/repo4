package com.atguigu.java1;

public class AbstractTest {
	public static void main(String[] args) {
		/*Person1 p1=new Person1();
		p1.eat();*/
		
	}
}
abstract class Creature{
	public abstract void breath();
}
abstract class Person1 extends Creature{
	String name;
	int age;
	//抽象方法
	public abstract void eat();
	public void walk() {
		System.out.println("人走路");
	}
	public Person1() {
		
	}
	public Person1(String name,int age) {
		this.name=name;
		this.age=age;
		
	}
	
}
class Student extends Person1{
	
	public Student(String name,int age) {
		super(name,age);
	}
	public Student() {
		
	}
	public void eat() {
		System.out.println("学生多吃有营养的食物");
	}
	@Override
	public void breath() {
		// TODO Auto-generated method stub
		
	}
}