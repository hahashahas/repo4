package com.main.java1;

public class personTest {
	private int age;
	public static void main(String[] args) {
		personTest b=new personTest();
		b.setage(1);
		System.out.println(b.getage());
	}
	public void setage(int a) {
		if(a<0||a>130) {
			throw new RuntimeException("传入的数值非法");
		}else {
			age=a;
		}
	}public int getage() {
		return age;
	}
}
