package com.varxyz.spr.mvc.domain;

import com.varxyz.spr.mvc.domain.Account;
import com.varxyz.spr.mvc.exception.LackOfBalance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingAccount extends Account {
	private double interestRate;

	public SavingAccount(long customerId, String accountNum, char accType, double balance, Customer customer,
			double interestRate) {
		super(customerId, accountNum, accType, balance, customer);
		this.interestRate = interestRate;
	}
	
	public SavingAccount(long aid, long customerId, String accountNum, char accType, double balance, Customer customer,
			double interestRate) {
		super(aid, customerId, accountNum, accType, balance, customer);
		this.interestRate = interestRate;
	}

	public SavingAccount() {
		super();
	}

	public void deposite(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) throws LackOfBalance {
		if(balance >= amount) {
			balance -= amount;
		} else if (balance < amount) {
			throw new LackOfBalance("에러 : 잔액부족");
		}
	}
}
