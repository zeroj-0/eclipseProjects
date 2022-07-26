package com.varxyz.spr.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.spr.mvc.domain.Customer;
import com.varxyz.spr.mvc.service.BankingService;

@Controller("controller.addCustomerController")
public class AddCustomerController {
	
	@Autowired
	private BankingService bankingService;
	
	@GetMapping("/domain/add_customer")
	public String addCustomerForm() {
		return "domain/add_customer";
	}
	
	@PostMapping("/domain/add_customer")
	public String addCustomer(CustomerCommand customerCommand) {
		Customer customer = new Customer(customerCommand.getUserId(), customerCommand.getPasswd(), customerCommand.getName(), customerCommand.getSsn(), customerCommand.getPhoneNum());
		bankingService.addCustomer(customer);
		return "domain/login";
	}
}
