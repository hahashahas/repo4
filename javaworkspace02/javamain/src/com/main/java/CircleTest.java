package com.main.java;

public class CircleTest {
	public static void main(String[] args) {
		Circle test1=new Circle();
		test1.radius=2.1;
		System.out.println(test1.findarea());
	}
}
//圆
class Circle{
	double radius;
	public double findarea() {
		double area=Math.PI*radius*radius;
		return area;
	}
}