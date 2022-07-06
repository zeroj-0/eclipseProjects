package com.varxyz.jv250.jdbc.banking;

import java.util.*;

public class Customer {
	private long cid;
	String name;
	String ssn;
	String phone;
	String customerId;
	String passwd;
	ArrayList<Account> myAccount;
	
	public Customer(long cid) {
		this.cid = cid;
	}
	public Customer(String name, String ssn, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}
	public Customer(String name, String ssn, String phone, String customerId, String passwd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.customerId = customerId;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public void setMyAccount(Account account) {
		myAccount.add(account);
	}
	
	public List<Account> getMyAccountList() {
		return myAccount;
	}
	
	public String toString() {
		String customerInfo = "Customer name : " + name +"\t" + "Customer Social Security Number : "+ ssn +"\t " +"Customer id : "+ customerId; 
		return customerInfo;
	}
	
}
