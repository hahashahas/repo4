package com.atguigu.java1;

public class EmployeeTest {
	public static void main(String[] args) {
		Emplayee manager=new Manager("顾客",1001,5000,50000);
		
		manager.work();
		CommonEmployee commonEmployee = new CommonEmployee();
		commonEmployee.work();
	}
}
