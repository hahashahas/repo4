package com.atguigu.java1;

public class PersonTest {
	public static void main(String[] args) {
		method(new Student());
		Worker worker = new Worker();
		method1(worker);
		//创建了一个匿名子类的对象
		Person1 p=new Person1() {
			public void eat() {
				System.out.println("吃东西");
			}
			public void breath() {
				System.out.println("呼吸");
			}
		};
		method1(p);
		System.out.println();
		method1(new Person1() {
			public void eat() {
				System.out.println("吃东西");
			}
			public void breath() {
				System.out.println("呼吸");
			}
		});
	}
	
	public static void method1(Person1 p) {
		p.eat();
		p.walk();
		p.breath();
	}
	public static void method(Student s) {
		System.out.println("学生");
	}
}
class Worker extends Person1{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		
	}
	
}