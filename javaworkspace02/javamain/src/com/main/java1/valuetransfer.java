package com.main.java1;

public class valuetransfer {
	public static void main(String[] args) {
		data data = new data();
		data.m=10;
		data.n=20;
		System.out.println("m:"+data.m+",n:"+data.n);
		//交换m和n的值
		//int temp=data.m;
		//data.m=data.n;
		//data.n=temp;
		
		valuetransfer test=new valuetransfer();
		test.swap(data);
		System.out.println("m:"+data.m+",n:"+data.n);
	}
	public void swap(data data) {
		int temp=data.m;
		data.m=data.n;
		data.n=temp;
	}
}
class data{
	int m;
	int n;
}
