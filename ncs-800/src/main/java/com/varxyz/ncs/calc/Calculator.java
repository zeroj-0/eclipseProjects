package com.varxyz.ncs.calc;

public class Calculator {
	private int result = 0;

	public void add(int data) {
		this.result += data;
	}

	public void subtract(int data) {
		this.result -= data;
	}

	public void multiply(int data) {
		this.result *= data;
	}

	public void division(int data) {
		this.result /= data;
	}

	// 현재 계산 결과
	public int getResult() {
		return this.result;
	}

	public void clear() {
		this.result = 0;
	}
	
	public void setResult(int result) {
		this.result = result;
	}

}
