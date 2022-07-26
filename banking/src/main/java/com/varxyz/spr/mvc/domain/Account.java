package com.varxyz.spr.mvc.domain;

import com.varxyz.spr.mvc.domain.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
	private long aid;
	private long customerId;
	private String accountNum;
	private char accType;
	private double balance;
	private Customer customer;
}
