package com.varxyz.jv200.mod002;


public class SubStringExample {
	public static void main(String[] args) {
		String text = "The cat in the hat";
//		System.out.println(isSubString("back",text));
//		System.out.println(isSubStringNum("The",text));
		System.out.println(isSubStringContains("c",text));
		
	}
	public static boolean isSubString(String item, String line) {
		boolean isTrue = false;
		String[] strArr = line.split(" ");
		
		for(int i=0;i<strArr.length;i++) {
			if(item.equals(strArr[i])) {
				isTrue = true;
			}
		}
		return isTrue;
	}
	
	public static boolean isSubStringNum(String item, String line) {
		boolean isTrue = false;
		String str = "";
		String str2 = "";
		String str3 = "";
		String str4 = "";
		String str5 = "";
		
		for(int i=0;i<line.length();i++) {
			if (i>=0 && i<3) {
				str += line.charAt(i);
			}
			if (i>=4 && i<7) {
				str2 += line.charAt(i);
			}
			if (i>=8 && i<10) {
				str3 += line.charAt(i);
			}
			if (i>=11 && i<14) {
				str4 += line.charAt(i);
			}
			if (i>=15 && i<18) {
				str5 += line.charAt(i);
			}
		}
		
		if(item.equals(str)) {
			isTrue = true;
		} else if (item.equals(str2)) {
			isTrue = true;
		} else if (item.equals(str3)) {
			isTrue = true;
		} else if (item.equals(str4)) {
			isTrue = true;
		} else if (item.equals(str5)) {
			isTrue = true;
		}
//		System.out.println(str+" "+str2+" "+str3+" "+str4+" "+str5);
		
		
		return isTrue;
	}
	
	public static boolean isSubStringContains(String item, String line) {
		boolean isTrue = line.contains(item);
		return isTrue;
	}

}
