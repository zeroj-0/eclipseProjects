package com.varxyz.spr.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.spr.mvc.domain.Account;
import com.varxyz.spr.mvc.domain.Customer;
import com.varxyz.spr.mvc.repository.CustomerDao;

@Service("service.bankingService")
public class BankingServiceImpl implements BankingService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public boolean addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
		return false;
	}

	@Override
	public Account addAccount(char accType, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAccounts(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean transfer(double amount, String withdrawAccountNum, String depositAccountNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveInterest(double interestRate, String AccountNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getBalance(String AccountNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
