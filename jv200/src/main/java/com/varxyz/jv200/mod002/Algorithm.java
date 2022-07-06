package com.varxyz.jv200.mod002;

public class Algorithm {
	public static void main(String[] args) {
		// 소수 구하기
		// 2부터 1000까지 숫자중에 소수만 카운팅
		int num = 1000;	
		int totalCount = 0;
		
		for(int i=2;i<=num;i++) {
			int count=0;
			for (int j=2;j<=i;j++) {
				if(i%j == 0) {
					count++;
				}
			}
			if(count==1) {
				totalCount++;
			}
		}
		System.out.println(totalCount);
	}	
}
