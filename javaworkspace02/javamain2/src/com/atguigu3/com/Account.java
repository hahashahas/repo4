package com.atguigu3.com;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	public Account(int id, double balance, double annualInterestRate) {
		super();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	
	public Account() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	//返回月利率
	public double getMonthlyInterest() {
		return annualInterestRate/12;
	}
	//取钱
	public  void withdraw(double amount) {
		if(balance>=amount) {
			balance-=amount;
			return;
		}
		System.out.println("余额不足");
	}
	//存钱
	public void deposit(double amount) {
		if(amount>0) {
			balance+=amount;
		}
	}
	
}
