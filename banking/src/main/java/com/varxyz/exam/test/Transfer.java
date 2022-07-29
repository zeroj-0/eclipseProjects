package com.varxyz.exam.test;

import java.util.*;

import org.springframework.stereotype.Service;

import com.varxyz.spr.mvc.domain.Account;
import com.varxyz.spr.mvc.domain.Customer;

public interface Transfer {
	
	// 계좌이체
	boolean transfer(double amount, String withdrawAccountNum, String depositAccountNum);

}
