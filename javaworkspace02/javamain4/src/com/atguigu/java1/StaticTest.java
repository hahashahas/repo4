package com.atguigu.java1;

public class StaticTest {
	public static void main(String[] args) {
		Chinese c1=new Chinese();
		c1.name="姚明";
		c1.age=40;
		
		Chinese c2=new Chinese();
		c2.name="马龙";
		c2.age=30;
		
		c1.nation="CHM";
		//c2.nation="chinese";
		System.out.println(c2.nation);
		Chinese.info();
		System.out.println();
		c1.eat();
	}
}
class Chinese{
	static String name;
	static int age;
	static String nation;
	public static void info() {
		System.out.println("name:"+name+",age:"+age);
	}
	public void eat() {
		System.out.println("吃饭");
		info();
	}
}