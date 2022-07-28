package com.varxyz.spr.mvc.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.spr.mvc.domain.Customer;
import com.varxyz.spr.mvc.repository.CustomerDao;

@Service("service.customerService")
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public boolean isValidUser(String userId, String passwd) {
		boolean isvalid = false;
		
		Customer customer = customerDao.isValidCustomer(userId, passwd);
		
		if(userId.equals(customer.getUserId()) && passwd.equals(customer.getPasswd())) {
			isvalid = true;
		} else {
			isvalid = false;
		}
		return isvalid;
	}

	public long getCidByUserId(String userId) {
		return customerDao.getCidByUserId(userId).getCid();
	}
	
	public Customer findCustomerByUserId(String userId) {
		return customerDao.findCustomerByUserId(userId);
	}
}
