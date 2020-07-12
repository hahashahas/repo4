package com.atguigu.exer;

public class Kids extends ManKind {
	private int yearsOld;
	
	public int getYearsOld() {
		return yearsOld;
	}

	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	public void printAge() {
		System.out.println("I am"+yearsOld);
	}

	public Kids(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	public Kids() {
	}
	public void employeed() {
		System.out.println("111");
	}
}
