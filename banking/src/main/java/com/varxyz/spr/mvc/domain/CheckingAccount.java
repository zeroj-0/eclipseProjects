package com.varxyz.spr.mvc.domain;

import com.varxyz.spr.mvc.domain.Account;
import com.varxyz.spr.mvc.exception.OverdraftException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(long aid, long customerId, String accountNum, char accType, double balance,
			Customer customer, double overdraftAmount) {
		super(aid, customerId, accountNum, accType, balance, customer);
		this.overdraftAmount = overdraftAmount;
	}
	public CheckingAccount(long customerId, String accountNum, char accType, double balance,
			Customer customer, double overdraftAmount) {
		super(customerId, accountNum, accType, balance, customer);
		this.overdraftAmount = overdraftAmount;
	}
	public CheckingAccount() {
		super();
	}
	
	public double depostie(double amount, double balance) {
		return amount+balance;
	}
	
	public double withdraw(double amount, double balance, double overdraftAmount) throws OverdraftException {
		if (balance < amount) {
			// 잔고부족시 overdraftAmount 금액 한도 내에서 추가 출금을 승인
			double overdraftNeeded = amount - balance;
			if ( overdraftAmount < overdraftNeeded ) {
				throw new OverdraftException("에러 : 대월금 초과", balance, overdraftNeeded);
			} else {
				balance = 0.0;
				overdraftAmount = overdraftAmount - overdraftNeeded;
			}
			
		} else {
			balance -= amount;
		}
		
		return overdraftAmount;
	}
	
}
