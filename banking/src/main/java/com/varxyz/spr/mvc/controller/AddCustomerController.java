package com.varxyz.spr.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

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
	public void addCustomer(CustomerCommand customerCommand, HttpServletResponse response) {
		List<String> err = new ArrayList<String>();
	    if(customerCommand.getUserId() == null || customerCommand.getUserId().length() == 0) {
	    	err.add("아이디는 필수입력 정보입니다.");
	    }
	    if (customerCommand.getPasswd() == null || customerCommand.getPasswd().length() == 0) {
	    	err.add("비밀번호 필수입력정보입니다.");
	    }
	    if (customerCommand.getName() == null || customerCommand.getName().length() == 0) {
	    	err.add("이름 필수입력정보입니다.");
	    }
	    if (customerCommand.getPhoneNum() == null || customerCommand.getPhoneNum().length() == 0) {
	    	err.add("휴대폰번호 필수입력정보입니다.");
	    }
	    if (customerCommand.getSsn() == null || customerCommand.getSsn().length() == 0) {
	    	err.add("주민번호 필수입력정보입니다.");
	    }
	    if(err.size() > 0) {
	    	response.setContentType("text/html; charset=UTF-8");
	        PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.println("<script>alert('회원가입에 실패하셨습니다. "+err.get(err.size()-1)+"'); location.href='/banking/domain/add_customer';</script>"); // 경고창 띄우기
				writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		bankingService.addCustomer(customerCommand.getUserId(), customerCommand.getPasswd(), customerCommand.getName(), customerCommand.getSsn(), customerCommand.getPhoneNum());
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println("<script>alert('회원가입에 성공하셨습니다. 로그인화면으로 이동합니다'); location.href='/banking/domain/login';</script>"); // 경고창 띄우기
			writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
