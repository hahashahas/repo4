package com.atguigu.java;

public class AnimalTest {
	public static void main(String[] args) {
		AnimalTest test=new AnimalTest();
		test.func(new Dog());
	}
	public void func(Animal animal) {
		animal.eat();
		animal.shout();
	}
}
class Animal{
	public void eat() {
		System.out.println("进食");
	}
	public void shout() {
		System.out.println("动物叫");
	}
	
}
class Dog extends Animal {
	public void eat() {
		System.out.println("狗吃狗粮");
	}
	public void shout() {
		System.out.println("汪汪汪");
	}
}
class Cat extends Animal {
	public void eat() {
		System.out.println("猫吃猫粮");
	}
	public void shout() {
		System.out.println("喵喵喵");
	}
}