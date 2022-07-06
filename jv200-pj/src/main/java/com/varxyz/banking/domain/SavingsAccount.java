package com.varxyz.banking.domain;

public class SavingsAccount extends Account {
	private static final double DEFAULT_INTEREST_RATE= 0.03;
	private double interestRate;
	
	public SavingsAccount(double balance) {
		super(balance);
	}
	public SavingsAccount(String accountNum, double balance) {
		this(accountNum, balance, DEFAULT_INTEREST_RATE);
	}
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	
	public void withdraw(double amount) throws LoanLimitException {
		if(balance - amount < 0) {
			// 예외발생
			throw new LoanLimitException("잔고부족");
		}
		super.balance -= amount;
	}

}
