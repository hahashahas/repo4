package com.main.java;

public class Instance {
	public static void main(String[] args) {
		Phone p=new Phone();
		System.out.println(p);
		p.sendEmail();
		p.playGame();
		//匿名对象
		new Phone().sendEmail();
		new Phone().playGame();
		phonemall mall=new phonemall();
		mall.show(new Phone());
	}
}
class Phone{
	double price;
	public void sendEmail() {
		System.out.println("发送邮件");
	}
	public void playGame() {
		System.out.println("玩游戏");
	}
	
}
class phonemall{
	public void show(Phone phone) {
		phone.sendEmail();
		phone.playGame();
	}
}
