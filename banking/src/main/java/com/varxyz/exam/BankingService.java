package com.varxyz.exam;

import java.util.*;

import org.springframework.stereotype.Service;

import com.varxyz.spr.mvc.domain.Account;
import com.varxyz.spr.mvc.domain.Customer;

public interface BankingService {
	
	// 온라인 뱅킹을 위한 가입 수행
	boolean addCustomer(String userId, String passwd, String name, String ssn, String phone);
	
	// 신규계좌신청
	Account addAccount(char accType, String userId, double balance);
	
	// 본인 계좌목록확인
	List<Account> getAccounts(long cid, String userId);
	
	// 계좌이체
	boolean transfer(double amount, String withdrawAccountNum, String depositAccountNum);
	
	// 매달 말 이자 지급
	boolean saveInterest(double interestRate, String AccountNum);
	
	// 계좌잔고확인
	double getBalance(String AccountNum);

}
