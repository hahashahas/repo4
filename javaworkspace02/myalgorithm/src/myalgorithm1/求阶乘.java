package myalgorithm1;

public class 求阶乘 {
	public static void main(String[] args) {
		f2(1,6);
	}
	static int f1(int n) {
		if(n==1) return 1;
		return n*f1(n-1);
	}
	static void f2(int i,int j) {
		System.out.print(i+" ");
		if(i<j) f2(i+1,j);
	}
}
