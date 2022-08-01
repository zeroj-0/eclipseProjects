package com.varxyz.jvx330.jdbc.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AddCustomerDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		AddCustomerDao dao = context.getBean("addCustomerDao", AddCustomerDao.class);
		
//		Customer customer = new Customer();
//		customer.setEmail("ci5496@naver.com");
//		customer.setPasswd("2222");
//		customer.setName("관우");
//		customer.setSsn("990228-4571235");
//		customer.setPhone("010-2221-3456");
//		
//		Customer customer2 = new Customer();
//		customer2.setEmail("21811053@gmail.com");
//		customer2.setPasswd("218");
//		customer2.setName("수진");
//		customer2.setSsn("990721-271234");
//		customer2.setPhone("010-0504-7816");
		
//		dao.addCustomer2(customer);
//		dao.addCustomer(customer2);
		
//		addCustomer(dao);
//		addCustomer2(dao);
		addCustomer3(dao);
		
		context.close();
	}
	
	
	public static void addCustomer(AddCustomerDao dao) {
		Customer customer = new Customer();
		customer.setEmail("ci5496@naver.com");
		customer.setPasswd("2222");
		customer.setName("관우");
		customer.setSsn("990228-4571235");
		customer.setPhone("010-2221-3456");
		
		dao.addCustomer(customer);
		System.out.println("----inserted----");
	}
	public static void addCustomer2(AddCustomerDao dao) {
		Customer customer = new Customer();
		customer.setEmail("21811053@gmail.com");
		customer.setPasswd("218");
		customer.setName("수진");
		customer.setSsn("990721-271234");
		customer.setPhone("010-0504-7816");
		
		dao.addCustomer2(customer);
		System.out.println("----inserted----");
	}
	public static void addCustomer3 (AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("21811053@yu.ac.kr");
		c.setPasswd("21811053");
		c.setName("서수진");
		c.setSsn("980721-271234");
		c.setPhone("010-0514-7816");
		
		long key = dao.addCustomer3(c);
		System.out.println("key : " + key);
	}
}
