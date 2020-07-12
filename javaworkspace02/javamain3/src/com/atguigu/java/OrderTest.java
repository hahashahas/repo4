package com.atguigu.java;

public class OrderTest {
	public static void main(String[] args) {
		Order order1=new Order(1001,"AA");
		Order order2=new Order(1001,"AA");
		System.out.println(order1.equals(order2));
		
	}
}
class Order{
	private int OrderId;
	private String orderName;
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Order(int orderId, String orderName) {
		super();
		OrderId = orderId;
		this.orderName = orderName;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj instanceof Order) {
			Order order=(Order)obj;
			return this.OrderId==order.OrderId&&this.orderName.equals(order.orderName);
		}
		return false;
	}
}
