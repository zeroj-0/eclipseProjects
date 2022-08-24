package com.varxyz.ncs.util;

public class StringsUtil {
	
	/**
	 * 주어진 문자열에 숫자(양수에 한함)와 관련된 문자열을 추출하여 리턴한다.
	 * 숫자가 없을때 빈문자열을 리턴한다.
	 * 
	 * ex) "abc432def" 입력시 "432" 출력
	 * 
	 * @param target
	 * @return
	 */
	public String extractIntCharacters(String str) {
		
		// 문자로 비교했기때문에 음수적었을 때 -를 다른 문자로 구분함.
		
		char[] strToChar = str.toCharArray();
		char[] number = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<strToChar.length;i++) {
			for(int j=0; j<number.length; j++) {
				if(strToChar[i] == number[j]) {
					sb.append(number[j]);
				}
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 주어진 문자열에 포함된 숫자(양수에 한함)문자열을 정수로 리턴한다.
	 * 숫자가 없을때 IllegalArguemntException 예외를 던진다.
	 * 
	 * ex) "abc432def" 입력시 432 출력
	 * @param target
	 * @return
	 */
	public int extractNum(String target) throws IllegalArgumentException {
		
		// 문자로 비교했기때문에 음수적었을 때 -를 다른 문자로 구분함.
		
		char[] strToChar = target.toCharArray();
		char[] number = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<strToChar.length;i++) {
			for(int j=0; j<number.length; j++) {
				if(strToChar[i] == number[j]) {
					sb.append(number[j]);
				}
			}
		}
		
		if(sb.toString().equals("")) {
			throw new IllegalArgumentException("숫자없습니다.");
		}
		
		return Integer.parseInt(sb.toString());
	}
}
