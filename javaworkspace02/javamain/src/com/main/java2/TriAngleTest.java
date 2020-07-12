package com.main.java2;

public class TriAngleTest {
	public static void main(String[] args) {
		TriAngle t1=new TriAngle();
		t1.setbase(2.0);
		t1.setheight(2.4);
		System.out.println("base : "+t1.getbase()+",height : "+t1.getheight());
		TriAngle t2=new TriAngle(5.1,5.2);
		System.out.println("base : "+t2.getbase()+",height : "+t2.getheight());
	}
}
