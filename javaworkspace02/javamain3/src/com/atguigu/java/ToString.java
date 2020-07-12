package com.atguigu.java;
//String\Date\File\包装类等都重写了Object类中的toString()方法
//使得在调用对象的ToString()时，返回实体内容信息
import java.util.Date;

public class ToString {
	public static void main(String[] args) {
		String str=new String("MM");
		System.out.println(str);
		Date date=new Date(123245);
		System.out.println(date);
	}
	@Override
	public String toString() {
		return "";
	}
}
