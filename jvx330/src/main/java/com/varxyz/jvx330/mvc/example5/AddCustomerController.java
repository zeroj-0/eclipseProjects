package com.varxyz.jvx330.mvc.example5;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("example5.addCustomerController")
@RequestMapping("/example5/add_customer")
public class AddCustomerController {
	
	@GetMapping
	public String addCustomerForm(Model model) {
		model.addAttribute("customer", new CustomerCommand());
		return "example5/add_customer";
	}
	
	@ModelAttribute("emailProviderList")
	public List<EmailProvider> getEmailProviderList() {
		List<EmailProvider> list = new ArrayList<EmailProvider>();
		list.add(new EmailProvider("Google", "gmail.com"));
		list.add(new EmailProvider("Naver", "naver.com"));
		list.add(new EmailProvider("Daum", "daum.net"));
		list.add(new EmailProvider("Nate", "nate.com"));
		
		return list;
	}
	
	@ModelAttribute("phoneProviderList")
	public List<String> getPhoneProviderList() {
		
		List<String> phoneList = new ArrayList<String>();
		phoneList.add("010");
		phoneList.add("011");
		phoneList.add("012");
		
		return phoneList;
	}
	
	@PostMapping
	public String addCustomer(@ModelAttribute("customer") CustomerCommand customer, Model model) {
		
		String email = customer.getEmail1()+"@"+customer.getEmail2();
		String phone = customer.getPhone1()+"-"+customer.getPhone2();
		
		customer.setEmail(email);
		customer.setPhone(phone);
		
		/**
		 * db처리
		 * customer = customerService.addCustomer(customer);
		 */
		
		model.addAttribute("customer", customer);
		return "example5/success_add_account";
	}
}
