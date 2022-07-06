package com.varxyz.jv200.mod003;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public MyDate(MyDate object) {
		this.day = object.day;
		this.month = object.month;
		this.year = object.year;
	}
	
	public MyDate addDays(int moreDays) {
		MyDate newDate = new MyDate(this);
		newDate.day = newDate.day + moreDays;
		return newDate;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public String toString() {
		return "day=" + day + ", month=" + month + ", year=" + year;
	}
}
