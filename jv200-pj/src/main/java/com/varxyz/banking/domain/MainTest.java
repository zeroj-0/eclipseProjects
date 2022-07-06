package com.varxyz.banking.domain;

import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		Account account = new CheckingAccount(5000.0, 20000.0);
		Account account2 = new SavingsAccount(10000.0);
		
		account.deposite(2000);
		
		try {
			account.withdraw(30000);
		} catch (LoanLimitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			account.withdraw(5000);
		} catch (LoanLimitException e) {
			System.out.println(e.getMessage());
		}
		
		
		CustomerService customerservice = CustomerServiceImple.getInstance();
		Customer c1 = new Customer("홍길동","990930-2700000","010-1111-2222","abcd1234","abcd12345");
		Customer c2 = new Customer("김길동","980930-2710000","010-1111-2222","abcd1234","abcd12345");
		Customer c3 = new Customer("서길동","970930-2720000","010-1111-2222","abcd1234","abcd12345");
		
//		customerservice.addCustomer(new Customer("홍길동","990930-2700000","010-1111-2222","abcd1234","abcd12345"));
//		customerservice.addCustomer(new Customer("김길동","980930-2700000","010-1111-2222","abcd1234","abcd12345"));
//		customerservice.addCustomer(new Customer("서길동","970930-2700000","010-1111-2222","abcd1234","abcd12345"));
		customerservice.addCustomer(c1);
		customerservice.addCustomer(c2);
		customerservice.addCustomer(c3);
		
		customerservice.getCustomerBySsn("990930-2700000");
		System.out.println(customerservice.getCustomerBySsn("990930-2700000").getName());
		
		AccountService accountService = AccountServiceImpl.getInstance();
		accountService.createCheckingAccount("1234", 30000, 20);
		accountService.createSavingsAccount("4567", 20000, 10);
		
		c1.setMyAccount(accountService.createCheckingAccount("1234", 30000, 20));
		c1.setMyAccount(accountService.createCheckingAccount("8526", 40000, 5));
		
		c2.setMyAccount(accountService.createSavingsAccount("4567", 20000, 10));
		
		int pageNum = accountService.getAccountBySsn("990930-2700000").size();
//		System.out.println(accountService.getAccountBySsn("990930-2700000").get(1).getAccountNum());
		
		for(int i =0; i<pageNum; i++) {
			System.out.println(accountService.getAccountBySsn("990930-2700000").get(i).getAccountNum());
		}
	}

}
