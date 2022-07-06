package com.varxyz.banking.domain;

//던지려고하는 예외는 꼭 확인되어야하니까 CheckedException인 Exception 사용

public class LoanLimitException extends Exception {
	
	public LoanLimitException(String messeage) {
		super(messeage);
	}
}
