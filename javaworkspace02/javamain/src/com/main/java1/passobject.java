package com.main.java1;

public class passobject {
	public static void main(String[] args) {
		passobject test=new passobject();
		circle c=new circle();
		test.printareas(c, 5);
	}
	public void printareas(circle c,int time) {
		System.out.println("Radius\t\tArea");
		
		for(int i=1;i<=time;i++) {
			c.radius=i;
			System.out.println(c.radius+"\t\t"+c.findarea());
		}
	}
}
