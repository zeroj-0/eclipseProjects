package com.varxyz.jv250.jdbc.banking;

//던지려고하는 예외는 꼭 확인되어야하니까 CheckedException인 Exception 사용

public class LoanLimitException extends Exception {
	
	public LoanLimitException(String messeage) {
		super(messeage);
	}
}
