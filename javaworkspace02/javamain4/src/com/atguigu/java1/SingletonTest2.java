package com.atguigu.java1;
//懒汉式
public class SingletonTest2 {
	public static void main(String[] args) {
		Order order1=Order.getInstance();
		Order order2=Order.getInstance();
		System.out.println(order1==order2);
	}
}
class Order{
	private Order() {
		
	}
	//懒汉式，没有造对象
	private static Order instance=null;
	public static Order getInstance() {
		if(instance==null) {
		instance = new Order();
		return instance;}
		return instance;
	}
}