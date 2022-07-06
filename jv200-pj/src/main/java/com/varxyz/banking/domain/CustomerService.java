package com.varxyz.banking.domain;

import java.util.*;

// ex) 홈플러스
// 서비스가 가지는 메소드를 여러객체에게 주는 것 하나의 객체를 위한것이 아님
public interface CustomerService {
	void addCustomer(Customer customer);
	Customer getCustomerBySsn(String ssn);
	Collection<Customer> getAllCustomers();
	int getNumOfCustomers();
}
