package com.varxyz.jvx330.mvc.example6;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller("example6.addAccountController")
@RequestMapping("/example6/add_account")
public class AddAccountController {
	
	@GetMapping
	public String addAccountForm(Model model) {
		model.addAttribute("account", new AccountCommand());
		
		return "example6/add_account";
	}
	
	@ModelAttribute("accountTypeList")
	public List<AccountType> getAccountType() {
		List<AccountType> list = new ArrayList<AccountType>();
		
		list.add(new AccountType("SavingAccount", 'S'));
		list.add(new AccountType("CheckingAccount", 'C'));
		
		return list;
	}
	
	@PostMapping
	public String addAccount(@ModelAttribute("account")AccountCommand account, Model model) {
		model.addAttribute("account", account);
		return "example6/success_add_account";
	}
}
