package com.varxyz.spr.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.spr.mvc.domain.Account;
import com.varxyz.spr.mvc.domain.CheckingAccount;
import com.varxyz.spr.mvc.domain.Customer;
import com.varxyz.spr.mvc.domain.SavingAccount;
import com.varxyz.spr.mvc.exception.LackOfBalance;
import com.varxyz.spr.mvc.exception.OverdraftException;
import com.varxyz.spr.mvc.repository.AccountDao;
import com.varxyz.spr.mvc.repository.CustomerDao;

@Service("service.bankingService")
public class BankingServiceImpl implements BankingService {
	
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private AccountDao accountDao;

	@Override
	public boolean addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
		return false;
	}

	@Override
	public Account addAccount(char accType, String userId, double balance) {
		Customer customer = new Customer();
		 customer = customerDao.findCustomerByUserId(userId);
		 
		 StringBuffer stringbuffer = new StringBuffer();
			for(int i = 0; i<3; i++) {
				int num = (int) (Math.random()*10);
				stringbuffer.append(num);			
			}
			stringbuffer.append("-");
			for(int i = 0; i<2; i++) {
				int num = (int) (Math.random()*10);
				stringbuffer.append(num);			
			}
			stringbuffer.append("-");
			for(int i = 0; i<4; i++) {
				int num = (int) (Math.random()*10);
				stringbuffer.append(num);			
			}
			
		if(accType == 'S') {
			SavingAccount sa = new SavingAccount(customer.getCid(), stringbuffer.toString(), accType, balance, customer, 1.2);
			accountDao.addAccount(sa);
		} else {
			CheckingAccount sa = new CheckingAccount(customer.getCid(), stringbuffer.toString(), accType, balance, customer, 0.0);
			accountDao.addAccount(sa);
		}
		return accountDao.findAccountByUserId(userId).get(accountDao.findAccountByUserId(userId).size()-1);
	}

	@Override
	public List<Account> getAccounts(long cid) {
		return accountDao.getAccounts(cid);
	}

	@Override
	public boolean transfer(double amount, String withdrawAccountNum, String depositAccountNum) {
		// 첫번째 계좌가 출금하는 계좌
		// 두번째 계좌가 입금되는 계좌
		
		// 첫번째 계좌에서 출금 계좌 타입확인
		if(accountDao.getAccType(withdrawAccountNum).getAccType() == 'C') {
			CheckingAccount ca = (CheckingAccount) accountDao.getAccType(withdrawAccountNum);
			double overdraft;
			try {
				overdraft = ca.withdraw(amount, ca.getOverdraftAmount());
			} catch (OverdraftException e) {
				e.printStackTrace();
				return false;
			}
			accountDao.reviseBalance(ca.getBalance(), overdraft, 0.0, withdrawAccountNum);
			if(accountDao.getAccType(depositAccountNum).getAccType() == 'C') {
				CheckingAccount deposite = (CheckingAccount) accountDao.getAccType(depositAccountNum);
				deposite.depostie(amount);
				accountDao.reviseBalance(deposite.getBalance(), deposite.getOverdraftAmount(), 0.0, depositAccountNum);
			} else if(accountDao.getAccType(depositAccountNum).getAccType() == 'S'){
				SavingAccount deposite = (SavingAccount) accountDao.getAccType(depositAccountNum);
				deposite.deposite(amount);
				accountDao.reviseBalance(deposite.getBalance(), 0.0, deposite.getInterestRate(), depositAccountNum);
			}
		} else if(accountDao.getAccType(withdrawAccountNum).getAccType() == 'S') {
			SavingAccount sa = (SavingAccount) accountDao.getAccType(withdrawAccountNum);
			try {
				sa.withdraw(amount);
			} catch (LackOfBalance e) {
				e.printStackTrace();
				return false;
			}
			accountDao.reviseBalance(sa.getBalance(), 0.0, sa.getInterestRate(), withdrawAccountNum);
			if(accountDao.getAccType(depositAccountNum).getAccType() == 'C') {
				CheckingAccount deposite = (CheckingAccount) accountDao.getAccType(depositAccountNum);
				deposite.depostie(amount);
				accountDao.reviseBalance(deposite.getBalance(), deposite.getOverdraftAmount(), 0.0, depositAccountNum);
			} else if(accountDao.getAccType(depositAccountNum).getAccType() == 'S'){
				SavingAccount deposite = (SavingAccount) accountDao.getAccType(depositAccountNum);
				deposite.deposite(amount);
				accountDao.reviseBalance(deposite.getBalance(), 0.0, deposite.getInterestRate(), depositAccountNum);
			}
		}
		return true;
	}

	@Override
	public boolean saveInterest(double interestRate, String AccountNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getBalance(String AccountNum) {
		return accountDao.getBalance(AccountNum).getBalance();
	}

	@Override
	public double replaceOverdraftAmount(String accountNum, double amount) {
		accountDao.replaceOverdraftAmount(accountNum, amount);
		
		return ((CheckingAccount) accountDao.getAccType(accountNum)).getOverdraftAmount();
	}

}
