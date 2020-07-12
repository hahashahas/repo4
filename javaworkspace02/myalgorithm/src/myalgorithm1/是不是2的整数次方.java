package myalgorithm1;

import java.util.Scanner;

public class 是不是2的整数次方 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if ((n & (n - 1)) == 0) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
}
