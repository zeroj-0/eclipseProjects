package com.varxyz.spr.mvc.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
	private long cid;
	private String userId;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	
	public Customer(String userId, String passwd, String name, String ssn, String phone) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}

	public Customer(long cid) {
		this.cid = cid;
	}
}
