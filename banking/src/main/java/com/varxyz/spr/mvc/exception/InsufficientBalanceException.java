package com.varxyz.spr.mvc.exception;

@SuppressWarnings("serial")
public class InsufficientBalanceException  extends RuntimeException {
	private double balance;
	
	public InsufficientBalanceException(String message) {
		super(message);
	}
	
	public InsufficientBalanceException(String message, double balance) {
		super(message);
		this.balance = balance;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + "현재 잔고는 " + balance + "입니다.";
	}
}
