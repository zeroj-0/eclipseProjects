package com.varxyz.jvx330.jdbc.example4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class CutomerDaoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
		findAllCustomers(dao);
		findCustomerByEmail(dao, "21811053@yu.ac.kr");
		countCustomers(dao);
		findCustomerByRegDate(dao);
		
		context.close();
	}
	
	public static void findAllCustomers(CustomerDao dao) {
		System.out.println("findAllCustomers() : ");
		dao.findAllCustomers().forEach(customer -> System.out.println(customer));
	}
	
	public static void findCustomerByEmail(CustomerDao dao, String email) {
		System.out.println("findCustomerByEmail() : \n" + dao.findCustomerByEmail(email));
	}
	
	public static void findCustomerByRegDate(CustomerDao dao) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = null;
		try {
			currentDate = format.parse(format.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Customer> list = dao.findCustomerByRegDate(currentDate);
		
		for(Customer customer : list) {
			System.out.println(customer);
		}
	}
	
	public static void countCustomers(CustomerDao dao) {
		System.out.println("CustomerNumber : " + dao.countCustomers() + "명");
	}
}
