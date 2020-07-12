package com.main.java;

public class Arrayutiltest {
	public static void main(String[] args) {
		Arrayutil util=new Arrayutil();
		int [] arr=new int [] {32,34,32,5,3,54,654,-98,0,-53,5};
		int max=util.getmax(arr);
		System.out.println("最大值为: "+max);
	}
}
