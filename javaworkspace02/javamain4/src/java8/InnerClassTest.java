package java8;

import java8.Person.Dog;

/*
 * 内部类的分类：成员内部类 （静态、非静态）vs 局部内部类（方法内，代码块内，构造器内）
 */
public class InnerClassTest {
	public static void main(String[] args) {
		Person.Bird bird=new Person.Bird();
		bird.show();
		Person p=new Person();
		Person.Dog dog= p.new Dog();
		dog.sing();
		System.out.println();
		dog.display("二哈");
	}
}
class Person{
	String name="小明";
	int age;
	public void eat() {
		System.out.println("人吃饭");
	}
	//成员内部类
	class Dog{
		String name="柴犬";
		public  Dog(){
			
		}
		public void sing() {
			System.out.println("我是一只狗");
			Person.this.eat();
		}
		public void display(String name) {
			System.out.println(name);//形参
			System.out.println(this.name);//内部类的属性
			System.out.println(Person.this.name);//外部类的属性
		}
	}
	
	
	static class Bird{
		String name;
		int age;
		public void show() {
			System.out.println("我是一只小小鸟");
		}
	}
	
	//局部内部类
	public void method(){
		class AA{
			
		}
	}
	{
		class BB{
			
		}
	}
	public Person(){
		class CC{
			
		}
	}
}