package com.varxyz.jv200.mod002;

public class ArrayRange {

	public static void main(String[] args) {
		
		// 기준이 되는 범위 값 설정
		int[] standardRangeNum = new int[10];
		for(int i=5;i<standardRangeNum.length+5;i++) {
			standardRangeNum[i-5]=i;
		}
		
		// 판단 해주는 메소드 호출
		System.out.println(inRange(standardRangeNum, 8, 18));
		System.out.println(inRange(standardRangeNum, 2, 8));
		System.out.println(inRange(standardRangeNum, 1, 4));
		System.out.println(inRange(standardRangeNum, 6, 12));
		System.out.println(inRange(standardRangeNum, 16, 18));
	}
	
	public static String inRange(int[] standardArray, int start, int end) {
		// 비교할 새로운 배열 생성
		
		String judge = null; 
		
		int[] newArray = new int[end-start+1];
		
		for(int i=start;i<=end;i++) {
			newArray[i-start]=i;
		}
		
		// 받아온 배열을 새로운 배열 큰값과 작은값으로 비교해 포함관계 확인
		if(standardArray[standardArray.length-1] < newArray[0] || standardArray[0] > newArray[newArray.length-1]) {
			judge = "범위밖";
		} else if( standardArray[0] < newArray[0] && standardArray[standardArray.length-1] > newArray[newArray.length-1] ) {
			judge = "포함";
		} else if( standardArray[0] > newArray[0] && standardArray[0] < newArray[newArray.length-1] ){
			judge = "부분포함";
		} else if(standardArray[standardArray.length-1] > newArray[0] && standardArray[standardArray.length-1] < newArray[newArray.length-1] ){
			judge = "부분포함";
		} else {
			judge = "error";
		}
		
		return judge;
	}

}
