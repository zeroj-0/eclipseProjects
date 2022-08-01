package com.varxyz.jvx330.jdbc.example5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Account;
import com.varxyz.jvx330.jdbc.Customer;

public class AccountDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Example5Config.class);
		
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		
		addAccount(dao);
//		findAccountBySsn(dao, "980721-271234");
		
		context.close();
	}
	
	public static void addAccount(AccountDao dao) {
		System.out.println("addAccount() : ");
		SavingAccount account = new SavingAccount();
		account.setCustomer(new Customer(1004));
		account.setAccountNum("684-12-4578");
		account.setAccType('S');
		account.setBalance(50000);
		account.setInterestRate(1.8);
		
		dao.addAccount2(account);
		System.out.println("-------------INSERTED-------------");
	}
	
	public static void findAccountBySsn(AccountDao dao, String ssn) {
		System.out.println("findAccountBySsn() : ");
		dao.findAccountBySsn2(ssn).forEach(account -> System.out.println(account));
	}
	
//	public static void findAllAccountNum(AccountDao dao) {
//		System.out.println("findAllAccountNum() : ");
//		dao.findAllAccountNum().forEach(account -> System.out.println(account));
//	}
}
