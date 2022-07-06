package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.OverdraftException;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount() {};
	
	public SavingsAccount(double balance) {
		super(balance);
	}
	public SavingsAccount(String accountNum, double balance) {
		this(accountNum, balance, 0.0);
	}
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void withdraw(double amount) throws OverdraftException {
	}
	
	public String toString() {
		return super.toString() + "\t"  + "interestRate : " + interestRate;
	}
}
