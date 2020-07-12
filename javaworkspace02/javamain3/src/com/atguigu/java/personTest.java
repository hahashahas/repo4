package com.atguigu.java;

public class personTest {
	public static void main(String[] args) {
		person p1=new person();
		p1.eat();
		Man man=new Man();
		man.eat();
		man.age=25;
		man.earnMoney();
		//对象的多态性
		System.out.println("*****************");
		person p2=new Man();
		p2.eat();
		System.out.println("*****************");
		p2.name="Tom";
	//	p2.isSmoking=true;
		//强制类型转换符，向下转型
		Man m1=(Man)p2;
		m1.earnMoney();
		m1.isSmoking=true;
		m1.name="hahaha";
		System.out.println(p2.name);
		//a instanceof A:判断对象a是否是类A的实例
		if(p2 instanceof Man) {
			Man m2=(Man)p2;
			m2.earnMoney();
		}else {
			Woman m2=(Woman)p2;
			m2.goshopping();
		}
	}
}
