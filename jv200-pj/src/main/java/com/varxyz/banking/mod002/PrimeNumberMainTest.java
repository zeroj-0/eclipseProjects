package com.varxyz.banking.mod002;

public class PrimeNumberMainTest {

	public static void main(String[] args) {
		/**
		 * 숫자를 던져주었을 때 그 숫자가 소수인지 아닌지 판별.
		 * 소수가 아닐때 예외를 던져주면서 그 숫자가 왜 소수가 아닌지 
		 * 약수와 함께 같이 던져줌.
		 */
		
		PrimeNumberExample primeNumber = new PrimeNumberExample();
		try {
			primeNumber.primeNumber(60);
		} catch (PrimeNumberException e1) {
			e1.printStackTrace();
		}
		try {
			primeNumber.primeNumber(25);
		} catch (PrimeNumberException e) {
			e.printStackTrace();
		}
		try {
			primeNumber.primeNumber(4);
		} catch (PrimeNumberException e) {
			e.printStackTrace();
		}
		try {
			primeNumber.primeNumber(30);
		} catch (PrimeNumberException e) {
			e.printStackTrace();
		}
		try {
			primeNumber.primeNumber(11);
		} catch (PrimeNumberException e) {
			e.printStackTrace();
		}
	}

}
