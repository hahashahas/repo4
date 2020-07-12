package com.atguigu.contact;
import java.util.Scanner;
public class HelloWorld {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		//静态初始化
		/*int[] ids;
		ids=new int[]{1001,1002,1003,1004};
		//动态初始化
		int num=scan.nextInt();
		String[]names=new String[num];
		System.out.println(names.length);
		for(int i=0;i<names.length;i++) {
			names[i]=scan.next();
		}
		System.out.println("**********************");
		for(int i=0;i<names.length;i++) {
			System.out.println(names[i]);
		}*/
		/*int nums[][]=new int[10][];
		for(int i=0;i<nums.length;i++) {
			nums[i]=new int[i+1];
			nums[i][0]=1;
			nums[i][i]=1;
		}
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums[i].length;j++) {
				if(j!=0&&j!=nums[i].length-1&&i>1)
				 nums[i][j]=nums[i-1][j]+nums[i-1][j-1];
				System.out.print(nums[i][j]+"\t");
			}
			System.out.println();
		}*/
		int n=7;
		int [][]arr=new int[n][n];
		int count=0;
		int maxx=n-1,maxy=n-1,minx=0,miny=0;
		while(minx<=maxx) {
			for(int x=minx;x<=maxx;x++) {
				arr[miny][x]=++count;
			}
			miny++;
			for(int y=miny;y<=maxy;y++) {
				arr[y][maxx]=++count;
			}
			maxx--;
			for(int x=maxx;x>=minx;x--) {
				arr[maxy][x]=++count;
			}
			maxy--;
			for(int y=maxy;y>=miny;y--) {
				arr[y][minx]=++count;
			}
			minx++;
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
