package com.atguigu.com;

public class Extend {
	public static void main(String[] args) {
		person p1 = new person();
		p1.age=1;
		p1.eat();
		
		Student s1 = new Student();
		s1.name="啦啦啦";
		s1.eat();
		s1.sleep();
		System.out.println(s1.name);
	}
}
