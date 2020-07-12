package com.main.java1;

public class OrderTest {
	public static void main(String[] args) {
		Order order=new Order();
		order.orderdefault=1;
		order.orderpublic=2;
		//order.orderprivate=3;出了order类之后，私有结构不允许调用
	}
}
