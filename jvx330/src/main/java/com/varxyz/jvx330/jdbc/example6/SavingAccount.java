package com.varxyz.jvx330.jdbc.example6;

import com.varxyz.jvx330.jdbc.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingAccount extends Account {
	private double interestRate;
	
	public void withdraw(double amount) {
		
	}
}
