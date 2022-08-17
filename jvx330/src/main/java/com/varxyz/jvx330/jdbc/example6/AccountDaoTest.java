package com.varxyz.jvx330.jdbc.example6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.varxyz.jvx330.jdbc.Account;
import com.varxyz.jvx330.jdbc.Customer;

public class AccountDaoTest {
	
	private static AccountDao dao;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Example6Config.class);
		
		 dao = context.getBean("accountDao", AccountDao.class);
		findAll();
//		findAccountBySsn(dao, "980721-271234");
		
		context.close();
	}
	
	public static void findAll() {
		System.out.println("findAll() : ");
		/**
		 * 0페이지부터 5개씩 regDate를 내림차순으로 읽겠다는 뜻
		 */
		Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "regDate");
		dao.findAll(pageable).forEach(c -> System.out.println(c));
	}
}
