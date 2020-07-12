import java.util.Scanner;
class VariableTest 
{
	public static void main(String[] args) 
	{
		/*
		int myAge=12;
		System.out.println(myAge);
		int myNumber;
		myNumber=1001;
		System.out.println(myNumber);
		long l1=123456789101112314l;
		System.out.println(l1);
		byte b=12;
		double b1=b+1.2;
		System.out.println(b1);
		String number="学号：";
		String sum=number+myNumber;
		System.out.println(sum);
		
		String str=123 + "";
		System.out.println(str);
		int num1=Integer.parseInt(str);
		System.out.println(num1);
		char c=97;
		System.out.println(c); */
		/*int num1=10,num2=20;
		System.out.println("num1="+num1+",num2="+num2);
		int temp=num1;
		num1=num2;
		num2=temp;
		num1=num1+num2;
		num2=num1-num2;
		num1=num1-num2;
		num1=num1^num2;
		num2=num1^num2;
		num1=num1^num2;
		System.out.println("num1="+num1+",num2="+num2);*/
		/*String str1=Integer.toHexString(30);
		System.out.println(str1);*/
		/*Scanner scan = new Scanner(System.in);//Scanner 的实例化
		System.out.println("请输入您的姓名：");
		//int num = scan.nextInt();
		String name=scan.next();
		char name_Char = name.charAt(0);
		System.out.println(name);
		System.out.println("请输入您的芳龄：");
		int age=scan.nextInt();
		System.out.println(age);
		System.out.println("请输入您的体重：");
		double weight =scan.nextDouble();
		System.out.println(weight);
		System.out.println("您是否有钱（true/false）");
		boolean money = scan.nextBoolean();
		System.out.println(money);*/
		int value = (int)(Math.random()*28+1);//[0.0,1.0)
		System.out.println(value);
	}
}
