package com.main.java1;
/*
 * 面向对象的特征一：封装与隐藏
 * */
public class AnimalTese {
	public static void main(String[] args) {
		Animal a=new Animal("abc");
		//a.name="大黄";
		a.age=1;
		//a.legs=4;
		a.setlegs(6);
		a.show();
		System.out.println(a.getlegs());
	}
}
class Animal{
	String name;
	int age;
	private int legs;
	
	public Animal() {
		System.out.println("....");
	}
	public Animal(String n) {
		name=n;
	}
	public void setlegs(int l) {
		if(l>=0&&l%2==0) legs=l;
		else {
			legs=0;
			//抛出一个异常
		}
	}
	public int getlegs() {
		return legs;
	}
	public void eat() {
		System.out.println("动物进食");
	}
	public void show() {
		System.out.println("name = "+name+",age = "+age+",legs = "+legs);
	}
}