package com.varxyz.banking.mod001;

public class TestAccount {
	public static void main(String[] args) {
		Account account = new Account(2000.0);
		System.out.println(account.getBalance());
	}
}
