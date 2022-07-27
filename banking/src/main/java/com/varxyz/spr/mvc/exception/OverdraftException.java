package com.varxyz.spr.mvc.exception;

//던지려고하는 예외는 꼭 확인되어야하니까 CheckedException인 Exception 사용

@SuppressWarnings("serial")
public class OverdraftException extends InsufficientBalanceException {
	private double overdraftAvail;
	
	public OverdraftException(String messeage, double balance, double overdraftAvail) {
		super(messeage, balance);
		this.overdraftAvail = overdraftAvail;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + ", 사용 가능한 대월액은 " + overdraftAvail + "입니다.";
	}
}
