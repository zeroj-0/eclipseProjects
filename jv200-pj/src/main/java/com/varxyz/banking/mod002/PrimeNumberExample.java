package com.varxyz.banking.mod002;

public class PrimeNumberExample {
//	int number;
//	
//	public PrimeNumberExample(int number) {
//		this.number = number;
//	}

	public void primeNumber(int number) throws PrimeNumberException {
		
		int count = 0;
		int[] arr = new int[50];
		int arrCount = 0;
		
		if(number < 2) {
			throw new RuntimeException("1보다 큰 숫자를 입력해주세요");
		}
		
		for (int i = 1; i <= number; i++ ) {
			if (number%i == 0) {
				count ++;
				arr[arrCount++] = i;
			}
		}
		try {
			if (count > 2) {
				throw new PrimeNumberException("소수가 아닙니다. 이 숫자는"+arr[1]+"*"+arr[count-2]+"로 이루어져 있습니다.");
			} else if (count == 2) {
				System.out.println("소수입니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
