package com.varxyz.jv251.domain;

import java.util.*;

public class Customer {
	private long cid;
	private String name;
	private String ssn;
	private String phone;
	private String userId;
	private String passwd;
	private ArrayList<Account> myAccount;
	
	public Customer(long cid) {
		this.cid = cid;
	}
	public Customer(String name, String ssn, String phone) {
//		this.name = name;
//		this.ssn = ssn;
//		this.phone = phone;
		this(name, ssn, phone, null, null);
	}
	public Customer(String name, String ssn, String phone, String customerId, String passwd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = customerId;
		this.passwd = passwd;
		myAccount = new ArrayList<Account>();
	}

	public Customer() {}
	
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public ArrayList<Account> getMyAccount() {
		return myAccount;
	}
	public void setMyAccount(ArrayList<Account> myAccount) {
		this.myAccount = myAccount;
	}
	public String toString() {
		String customerInfo = "Customer name : " + name +"\t" + "Customer Social Security Number : "+ ssn +"\t " +"Customer id : "+ userId; 
		return customerInfo;
	}
	
}
