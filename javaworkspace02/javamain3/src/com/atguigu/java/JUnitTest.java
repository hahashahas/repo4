package com.atguigu.java;

import org.junit.Test;

public class JUnitTest {
	int num=10;
	@Test
	public void testEquals() {
		System.out.println(num);
		//show();
	}
	@Test
	public void show() {
		num=12;
		System.out.println("show().....");
	}
}
