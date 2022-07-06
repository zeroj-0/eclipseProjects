package com.varxyz.jv200.mod006;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		return year+" "+month+" "+day;
	}
	
	public boolean equals (Object obj) {
		
		if( obj instanceof MyDate) {
			MyDate mydate = (MyDate) obj;
			if (day == mydate.day && month == mydate.month && year == mydate.year) {
				return true;
			}
		}
		
		return false;
		
	}
	
}
