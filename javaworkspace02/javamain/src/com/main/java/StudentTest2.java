package com.main.java;

public class StudentTest2 {
	public static void main(String[] args) {
		student1[] stus=new student1[20];
		for(int i=0;i<stus.length;i++) {
			stus[i]=new student1();
			stus[i].number=i+1;
			stus[i].state=(int)(Math.random()*(6-1+1)+1);
			stus[i].score=(int)(Math.random()*(100-0+1)+1);
		}
		StudentTest2 test=new StudentTest2();
		test.print(stus);
		System.out.println("**********************************");
		test.searchstate(stus,6);
		System.out.println("**********************************");
		test.sort(stus);
		test.print(stus);
	}
		//遍历
		public void print(student1[] stus) {
			for(int i=0;i<stus.length;i++) {
				System.out.println(stus[i].info());
			}
		}
		//查找
		public void searchstate(student1[] stus,int state) {
			for(int i=0;i<stus.length;i++) {
				if(stus[i].state==state)
				System.out.println(stus[i].info());
			}
		}
		//排序
		public void sort(student1[] stus) {
			for(int i=0;i<stus.length-1;i++) {
				for(int j=0;j<stus.length-1-i;j++) {
					if(stus[j].score<stus[j+1].score) {
						student1 temp=stus[j+1];
						stus[j+1]=stus[j];
						stus[j]=temp;
					}
				}
			}
		}
}
class student1{
	int number;//学号
	int state;//年级
	int score;//成绩
	public String info() {
		return "学号:"+number+" 年级:"+state+" 成绩:"+score;
	}
}
