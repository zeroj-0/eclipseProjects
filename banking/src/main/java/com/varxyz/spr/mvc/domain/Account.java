package com.varxyz.spr.mvc.domain;

import com.varxyz.spr.mvc.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
	protected long aid;
	protected long customerId;
	protected String accountNum;
	protected char accType;
	protected double balance;
	protected Customer customer;
	
	public Account(long customerId, String accountNum, char accType, double balance, Customer customer) {
		super();
		this.customerId = customerId;
		this.accountNum = accountNum;
		this.accType = accType;
		this.balance = balance;
		this.customer = customer;
	}

	public Account(long customerId, String accountNum, double balance) {
		this.customerId = customerId;
		this.accountNum = accountNum;
		this.balance = balance;
	}
	public Account(long customerId, String accountNum, double balance, char accType) {
		this.customerId = customerId;
		this.accountNum = accountNum;
		this.balance = balance;
		this.accType = accType;
	}

	public Account(double balance) {
		this.balance = balance;
	}

	public Account() {};

}
