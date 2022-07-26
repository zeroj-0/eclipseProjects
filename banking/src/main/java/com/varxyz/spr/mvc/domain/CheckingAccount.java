package com.varxyz.spr.mvc.domain;

import com.varxyz.spr.mvc.domain.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(long aid, long customerId, String accountNum, char accType, double balance,
			Customer customer, double overdraftAmount) {
		super(aid, customerId, accountNum, accType, balance, customer);
		this.overdraftAmount = overdraftAmount;
	}
	
}
