package myalgorithm1;

import java.util.Scanner;


public class 然而沼沃鱼早就看穿了一切 {		//14种
	public static int count=0,n=4;
	public static void main(String[] args) {
		f(0,0);
		System.out.println(count);
	}
	public static void f(int left,int right){
		if(left==n  ){
			count++;
			return;
		}
		
		f(left+1,right);
		if(left>right){
			f(left,right+1);
		}
	}
}

