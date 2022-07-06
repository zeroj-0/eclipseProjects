package com.varxyz.jv200.mod009;

import java.util.*;

public class ListExample2 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("점심시간");
		list.add("12시 50분");
		
		System.out.println(list);
		
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		list2.add(1);
		list2.add(365);
		list2.add(1);
		list2.add(24);
		
		System.out.println(list2);
		
		for (String s : list) {
			System.out.print(s+" ");
		}
		
		System.out.println();
		
		for (Iterator<Integer> i = list2.iterator() ; i.hasNext();) {
			int data = i.next();
			System.out.print(data+" ");
		}
	}
}
