package com.varxyz.jv251.dao;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.domain.Account;

public class DaoTest {

	public static void main(String[] args) {
		AccountDao dao2 = new AccountDao();
		for ( Account account : dao2.findAllAccounts()) {
			System.out.println(account);
		}
	}

}
