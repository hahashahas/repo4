package com.main.java1;

public class Order {
	private int orderprivate;
	int orderdefault;
	public int orderpublic;
	
	private void methodprivate() {
		orderprivate=1;
		orderdefault=2;
		orderpublic=3;
	}
	void methoddefault() {
		orderprivate=1;
		orderdefault=2;
		orderpublic=3;
	}
	public void methodpublic() {
		orderprivate=1;
		orderdefault=2;
		orderpublic=3;
	}
}
