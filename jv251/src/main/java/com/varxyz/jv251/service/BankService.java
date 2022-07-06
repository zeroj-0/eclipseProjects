package com.varxyz.jv251.service;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.dao.CustomerDao;
import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingsAccount;
import com.varxyz.jv251.exception.CustomerNotFoundException;
import com.varxyz.jv251.exception.DuplicateEntityException;
import com.varxyz.jv251.exception.EntityNotFoundException;

import java.util.*;

public class BankService {
	private static final BankService service = new BankService();
	public static final char SA = 'S';
	public static final char CA = 'C';
	
	public static final double DEFAULT_INTEREST_RATE  = 0.03;
	public static final double DEFAULT_OVERDRAFT_AMOUNT = 1000.0;
	
	private CustomerService customerService;
	private AccountService accountService;
	
	/**
	 * 누구든 상관없이 서비스는 하나로만 쓰자 -> 싱글톤(singleton)
	 */
	public BankService() {
		init();
	}
	
	public void init() {
		customerService = new CustomerService(new CustomerDao());
		accountService = new AccountService(new AccountDao());
	}
	
	public static BankService getInstance() {
		return service;
	}
	
	public void addCustomer(String name, String ssn, String phone, String userId, String passwd) {
		if(!isCustomer(ssn)) {
			customerService.addCustomer(customerService.createCustomer(name, ssn, phone, userId, passwd));
		} else {			
			throw new DuplicateEntityException(ssn + " is duplicated.");
		}
	}
	
	public Customer getCustomerBySsn(String ssn) {
		return customerService.getCustomerBySsn(ssn);
	}
	
	public List<Customer> getAllCustomer() {
		return customerService.getAllcustomers();
	}
	
	public void addSavingsAccount(double balance, double interestRate, String ssn) throws CustomerNotFoundException {
		SavingsAccount account = new SavingsAccount();
		account.setBalance(balance);
		account.setAccountNum(accountService.generateAccountNum());
		account.setAccountType(BankService.SA);
		account.setInterestRate(interestRate);
		Customer customer = customerService.getCustomerBySsn(ssn);
		if(customer != null) {
			account.setCustomer(customer);
			accountService.addAccount(account);
		} else {
			throw new CustomerNotFoundException(ssn + " not fount");
		}
	}
	
	public void addCheckingAccount(double balance, double overdraftAmount, String ssn) throws CustomerNotFoundException  {
		CheckingAccount account = new CheckingAccount();
		account.setBalance(balance);
		account.setAccountNum(accountService.generateAccountNum());
		account.setAccountType(BankService.CA);
		account.setOverdraftAmount(overdraftAmount);
		
		Customer customer = customerService.getCustomerBySsn(ssn);
		if(customer != null) {
			account.setCustomer(customer);
			accountService.addAccount(account);
		} else {
			throw new CustomerNotFoundException(ssn + " no found");
		}
	}
	
	public boolean isCustomer(String ssn) {
		return customerService.getCustomerBySsn(ssn) == null ? false : true;
	}
	
	public List<Account> getAccountBySsn(String ssn) {
		return accountService.getAccountBySsn(ssn);
	}
	
	public void deposite(String accountNum, double balance) {
		Account account = accountService.getAccountByAccountNum(accountNum);
		account.deposite(balance);
		accountService.setBalanceByAccountNum(accountNum, balance);
	}
	
}
