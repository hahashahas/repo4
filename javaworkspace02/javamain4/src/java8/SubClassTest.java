package java8;

public class SubClassTest {
	public static void main(String[] args) {
		SubClass s=new SubClass();
		//实现类重写了接口中的默认方法，调用时，调用的是重写后的方法
		s.method2();
		//接口中定义的静态方法，只能用接口调
		CompareA.method1();
		s.method3();
	}
}
class SubClass extends SuperClass implements CompareA,CompareB{
	public void method2() {
		System.out.println("SubClass:上海");
	}

	@Override
	public void method3() {
		System.out.println("SubClass:上海");
	}
	public void myMethod() {
		method3();
		super.method3();
		//调用接口中的默认方法
		CompareA.super.method3();
		CompareB.super.method3();
	}
}
