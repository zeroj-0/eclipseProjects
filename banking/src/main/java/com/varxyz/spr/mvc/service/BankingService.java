package com.varxyz.spr.mvc.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.varxyz.spr.mvc.domain.Account;
import com.varxyz.spr.mvc.domain.Customer;

public interface BankingService {
	
	// 회원가입
	boolean addCustomer(Customer customer);
	
	// 신규계좌가입
	Account addAccount(char accType, String userId);
	
	// 계좌목록확인
	List<Account> getAccounts(String userId);
	
	// 계좌이체
	boolean transfer(double amount, String withdrawAccountNum, String depositAccountNum);
	
	// 매달 말 이자 지급
	boolean saveInterest(double interestRate, String AccountNum);
	
	// 계좌잔고확인
	String getBalance(String AccountNum);
}
