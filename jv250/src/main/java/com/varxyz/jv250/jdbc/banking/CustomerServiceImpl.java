package com.varxyz.jv250.jdbc.banking;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {
	private static CustomerService service = new CustomerServiceImpl();
	
	private Map<String, Customer> map = new HashMap<String, Customer>();
	
	private CustomerServiceImpl() {
		super(); // 생략가능
	}
	public static CustomerService getInstance() {
		return service;
	}

	public void addCustomer(Customer customer) {
		if(!map.containsKey(customer.getSsn())) {
			map.put(customer.getSsn(), customer);
		}
		
	}

	public Customer getCustomerBySsn(String ssn) {
		if(map.containsKey(ssn)) {			
			return map.get(ssn);
		}
		return null;
	}

	public Collection<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return map.values();
	}

	public int getNumOfCustomers() {
		return map.size();
	}

}
