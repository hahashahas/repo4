package com.atguigu3.com;

public class CheckAccount extends Account{
	private double overdraft;
	public CheckAccount(int id, double balance, double annualInterestRate,double overdraft) {
		super(id, balance, annualInterestRate);
		this.overdraft=overdraft;
	}
	public void withdraw(double amount) {
		if(getBalance()>=amount) {
			//setBalance(getBalance()-amount);
			super.withdraw(amount);
		}else if(overdraft>=amount-getBalance()){
			overdraft-=(amount-getBalance());
			super.withdraw(getBalance());
		}else {
			System.out.println("超过可透支限额");
		}
	}
	public double getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	
}
