package com.varxyz.spr.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.spr.mvc.domain.Account;
import com.varxyz.spr.mvc.service.BankingService;

@Controller("controller.accountController")
public class AccountController {
	
	@Autowired
	private BankingService bankingService;
	
	@GetMapping("/domain/create_account")
	public String createAccount() {
		return "domain/create_account";
	}
	
	@PostMapping("/domain/create_result")
	public String createAccountForm(HttpServletResponse response, @RequestParam(value="userId", required = true) String userId, @RequestParam double balance, @RequestParam String accType) {
		Account account = bankingService.addAccount(accType.charAt(0), userId, balance);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println("<script>alert('"+account.getAccountNum()+"으로 가입되셨습니다!'); location.href='/banking/domain/accountList';</script>"); // 경고창 띄우기
			writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return "domain/accountList";
	}
	
	@GetMapping("/domain/accountList")
	public String accountListCheck(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		long cid = (long)session.getAttribute("cid");
		return "domain/accountList";
	}
	
	@PostMapping("/domain/accountList")
	public ModelAndView accountList(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		long cid = (long)session.getAttribute("cid");
		String userId = (String)session.getAttribute("userId");
		
		List<Account> list = new ArrayList<>();
		list = bankingService.getAccounts(cid);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("domain/accountList");
		mav.addObject("list", list);
		
		return mav;
	}
	
	@GetMapping("/domain/transfer_account")
	public ModelAndView transferAccount(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		long cid = (long)session.getAttribute("cid");
		String userId = (String)session.getAttribute("userId");
		
		List<Account> list = new ArrayList<>();
		list = bankingService.getAccounts(cid);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("domain/transfer_account");
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/domain/transfer_account")
	public void transferAccountBath(@RequestParam(value="myAccountNum", required = true) String myAccountNum, @RequestParam double amount, @RequestParam String otherAccountNum) {
		bankingService.transfer(amount, myAccountNum, otherAccountNum);
	}
	
	@GetMapping("/domain/check_balance")
	public ModelAndView check_balance(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		long cid = (long)session.getAttribute("cid");
		String userId = (String)session.getAttribute("userId");
		
		List<Account> list = new ArrayList<>();
		list = bankingService.getAccounts(cid);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("domain/check_balance");
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/domain/check_balance")
	public ModelAndView checking_balance(HttpServletRequest request, @RequestParam(value="accountNum", required = true) String accountNum) {
		HttpSession session = request.getSession(false);
		long cid = (long)session.getAttribute("cid");
		List<Account> list = new ArrayList<>();
		list = bankingService.getAccounts(cid);
		double balance = bankingService.getBalance(accountNum);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("domain/check_balance");
		mav.addObject("balance", balance);
		mav.addObject("list", list);
		mav.addObject("accountNum", accountNum);
		
		return mav;
	}
	
	@GetMapping("/domain/overdraftamount_replace")
	public ModelAndView overdraftamountReplaceSelect(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		long cid = (long)session.getAttribute("cid");
		List<Account> list = new ArrayList<>();
		list = bankingService.getAccounts(cid);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("domain/overdraftamount_replace");
		mav.addObject("list", list);
		
		return mav;
	}
	
	@PostMapping("/domain/overdraftamount_replace")
	public void overdraftAmountReplace(HttpServletResponse response, @RequestParam(value="accountNum", required = true) String accountNum, double overdraftAmount) {
		
		double overdraft = bankingService.replaceOverdraftAmount(accountNum, overdraftAmount);
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println("<script>alert('"+overdraft+" 원으로 변경되었습니다!'); location.href='/banking/domain/menuList';</script>"); // 경고창 띄우기
			writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
