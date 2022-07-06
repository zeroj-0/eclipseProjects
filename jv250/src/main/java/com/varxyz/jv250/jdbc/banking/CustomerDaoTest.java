package com.varxyz.jv250.jdbc.banking;

import java.util.*;

public class CustomerDaoTest {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		
		// addCustomer() Test
//		dao.addCustomer(new Customer("태태", "951231-1721534","010-4775-8612","bts","0412"));
		
		// findAllCustomer() Test
		List<Customer> customerList = dao.findAllCustomers();
		for ( Customer customer : customerList ) {
			System.out.println(customer.toString());
		}
		
		AccountDao dao2 = new AccountDao();
		
		List<Account> accountList = dao2.findAllAccounts();
		for ( Account account : accountList ) {
			System.out.println(account.toString());
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		
		dao2.findAccountBySsn("980623-1717846");
		
//		Account account1 = new SavingsAccount("111-54-9332",21000.0,2);
//		account1.setCustomerId(101);
//		dao2.addAccount(account1);
		
		SavingsAccount sa = new SavingsAccount();
		sa.setAccountNum("567-03-0123");
		sa.setBalance(84000.0);
		sa.setCustomerId(104);
		sa.setInterestRate(0.04);
		sa.setRegDate(new Date());
		sa.setAccountType('S');
		
		dao2.addAccount(sa);
		List<Account> accountSsnList = dao2.findAccountBySsn("980623-1717846");
		for ( Account accountInfo : accountSsnList ) {
			System.out.println(accountInfo.toString());
		}
	}

}
