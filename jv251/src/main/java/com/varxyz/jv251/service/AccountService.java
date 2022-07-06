package com.varxyz.jv251.service;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.domain.Account;
import java.util.*;

public class AccountService {
	private AccountDao accountDao;
	
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}
	
	public List<Account> getAccountBySsn(String ssn) {
		return accountDao.findAccountBySsn(ssn);
	}
	
	public Account getAccountByAccountNum(String accountNum) {
		return accountDao.findAccountByAccountNum(accountNum);
	}
	
	public void setBalanceByAccountNum(String accountNum, double balance) {
		accountDao.setBalanceByAccountNum(accountNum, balance);
	}
	
	/**
	 * XXX-XX-XXXX 형식으로 계좌번호 생성
	 * @return
	 */
	public String generateAccountNum() {
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
		
		return stringbuffer.toString();
	}
	public List<Account> findAllAccounts() {
		return accountDao.findAllAccounts();
	}
}
