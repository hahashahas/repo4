package com.atguigu.java1;
//接口中不能构造器，接口不可以实例化
//接口通过让类去实现（implements）的方式使用,如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
public class InterfaceTest {
	public static void main(String[] args) {
		System.out.println(Flyable.MAX_SPEED);
		Plane plane =new Plane();
		plane.fly();
	}
}
interface Flyable{
	public static final int MAX_SPEED=7900;
	public static final int MIN_SPEED=1;
	
	public abstract void fly();
	void stop();
}
interface Attackable{
	void attack();
}
class Plane implements Flyable{

	public void fly() {
		System.out.println("飞");
	}

	public void stop() {
		System.out.println("停");
	}
	
}
 abstract class Kite implements Flyable{

	public void fly() {
		
	}
}
 class Bullet extends Object implements Flyable,Attackable,CC{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}
	 
 }
 interface AA{
	 void method1();
 }
 interface BB{
	 void method2();
 }
 interface CC extends BB,AA{
	 
 }
 
 
 
 
 
 
 
 
 
 
 