package com.varxyz.jv200.mod009;

import java.util.*;

public class MapExample {
	
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(Integer.valueOf(1), "유비");
		// 원래는 타입이 맞지않아 컴파일 에러 뜨는데 자바 9버전 이상부터는 가능해짐
		map.put(2, "관우");
		// The constructor Integer(int) is deprecated 는 자바 9버전 이상부터는 쓰지말라는 권고사항!
		map.put(new Integer(3), "장비");
		
		System.out.println(map.get(new Integer(1)));
		System.out.println(map.get(1));
		
		Set<Integer> set = map.keySet();
		for (Integer integer : set) {
			System.out.print(integer);
			System.out.println(" = " + map.get(integer));
		}
	}
}
