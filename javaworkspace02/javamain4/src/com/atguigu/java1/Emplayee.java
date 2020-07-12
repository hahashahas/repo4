package com.atguigu.java1;

public abstract class Emplayee {
	private String name;
	private int id;
	private double salary;
	
	public Emplayee() {
		super();
	}

	public Emplayee(String name, int id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public abstract void work();
	
	
}
