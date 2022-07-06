package com.varxyz.jv250.jdbc.banking;

import java.util.Date;

/**
 * 콩나물0
 * @author Administrator
 *
 */

// SavingsAccount랑 CheckingAccount 동일 메소드 구현을 위해 부모클래스를 추상클래스로 만들어줌
public abstract class Account {
	protected String accountNum;
	protected double balance;
	protected char accountType;
	protected int customerId;
	protected Customer customer;
	protected int accountId;
	protected Date regDate;
	
	public Account() {};
	
	public Account(double balance) {
		this.balance = balance;
	}
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void deposite(double amount) {
		balance += amount;
		System.out.println("입금 후 잔액은: " + balance + "원");
	}
	
	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	// 위의 설명과 같이 동일 메소드 구현을 위해 추상메소드로 선언
	public abstract void withdraw(double amount) throws LoanLimitException;
	
	public String toString() {
		String accountInfo = "AccountNum : " + accountNum + "\t" + "Balance : " + balance + "\t"  + "AccountType : " + accountType + "\t" + "accountId : " + accountId +"\t"+ "regDate : " + regDate;
		return accountInfo;
	}
}

