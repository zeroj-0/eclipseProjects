package com.varxyz.jv251.service;

import com.varxyz.jv251.dao.CustomerDao;
import com.varxyz.jv251.domain.Customer;
import java.util.*;

/**
 * Service를 따로 만드는 이유 : 
 * @author Administrator
 *
 */
public class CustomerService {
	private CustomerDao customerDao;
	
	public CustomerService(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public Customer createCustomer (String name, String ssn, String phone, String userid, String passwd) {
		return new Customer (name, ssn, phone, userid, passwd);
	}
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public Customer getCustomerBySsn(String ssn) {
		return customerDao.findCustomerBySSn(ssn);
	}
	
	public List<Customer> getAllcustomers() {
		return customerDao.findAllCustomers();
	}
}
