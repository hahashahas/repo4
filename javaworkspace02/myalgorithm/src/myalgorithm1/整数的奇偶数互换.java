package myalgorithm1;

import java.util.Scanner;

public class 整数的奇偶数互换 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		int ji=i&0xaaaaaaaa;
		int ou=i&0x55555555;
		System.out.println((ou<<1)^(ji>>1));
	}
	
	
}
