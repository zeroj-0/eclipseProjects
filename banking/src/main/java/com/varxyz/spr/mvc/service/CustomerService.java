package com.varxyz.spr.mvc.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.spr.mvc.repository.CustomerDao;

@Service("service.customerService")
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public boolean isValidUser(String userId, String passwd) {
		boolean isvalid = false;
		List<Map<String,String>> list = new ArrayList<>();
		list = customerDao.isValidCustomer(userId, passwd);
		
		for(Map<String,String> map : list) {
			if(userId.equals(map.get("userId")) && passwd.equals(map.get("passwd"))) {
				isvalid = true;
			} else {			
				isvalid = false;
			}
		}
		return isvalid;
	}

	public long getCidByUserId(String userId) {
		return customerDao.getCidByUserId(userId).getCid();
	}
}
