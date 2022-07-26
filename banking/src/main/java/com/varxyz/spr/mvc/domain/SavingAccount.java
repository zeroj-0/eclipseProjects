package com.varxyz.spr.mvc.domain;

import com.varxyz.spr.mvc.domain.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingAccount extends Account {
	private double interestRate;

	public SavingAccount(long aid, long customerId, String accountNum, char accType, double balance, Customer customer,
			double interestRate) {
		super(aid, customerId, accountNum, accType, balance, customer);
		this.interestRate = interestRate;
	}
}
