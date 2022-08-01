package com.varxyz.jvx330.jdbc.example5;

import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.*;
import java.util.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.varxyz.jvx330.jdbc.Account;

@Repository("accountDao")
// 위랑 같은의미 @Component("accountDao")
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
//	public void addAccount(Account account) {
//		String sql = "INSERT INTO Account (customerId, accountNum, accType, balance, interestRate, overAmount) VALUES (?,?,?,?,?,?)";
//		jdbcTemplate.update(sql, account.getCustomerId(), account.getAccountNum(), account.getAccType(), account.getBalance(), account.getInterestRate(), account.getOverAmount());
//	}
//	
//	public List<Account> findAccountBySsn(String ssn) {
//		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance, a.interestRate, a.overAmount, a.regDate FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = ?";
//		return jdbcTemplate.query(sql, new RowMapper<Account>() {
//
//			@Override
//			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Account account = new Account(rs.getLong("aid"), rs.getLong("customerId"), rs.getString("accountNum"),  rs.getString("accType").charAt(0), rs.getDouble("balance"), rs.getDouble("interestRate"), rs.getDouble("overAmount"), rs.getTimestamp("regDate"));
//				return account;
//			}
//			
//		}, ssn);
//	}
//	public List<Account> findAllAccountNum() {
//		String sql = "SELECT aid, customerId, accountNum, accType, balance, interestRate, overAmount, regDate FROM Account";
//		
//		return jdbcTemplate.query(sql, new RowMapper<Account>() {
//			
//			@Override
//			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Account account = new Account(rs.getLong("aid"), rs.getLong("customerId"), rs.getString("accountNum"),  rs.getString("accType").charAt(0), rs.getDouble("balance"), rs.getDouble("interestRate"), rs.getDouble("overAmount"), rs.getTimestamp("regDate"));
//				return account;
//			}
//			
//		});
//	}
//	
//	public  List<Account> findAccountByCustomerId(Long customerId) {
//		String sql = "SELECT aid, customerId, accountNum, accType, balance, interestRate, overAmount, regDate FROM Account WHERE customerId=?";
//		
//		return jdbcTemplate.query(sql, new RowMapper<Account>() {
//			
//			@Override
//			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Account account = new Account(rs.getLong("aid"), rs.getLong("customerId"), rs.getString("accountNum"),  rs.getString("accType").charAt(0), rs.getDouble("balance"), rs.getDouble("interestRate"), rs.getDouble("overAmount"), rs.getTimestamp("regDate"));
//				return account;
//			}
//			
//		}, customerId);
//	}
	
	/**
	 * 선생님이 하시는 방법
	 * @param account
	 */
	public void addAccount2(Account account) {
		String sql = "INSERT INTO Account (customerId, accountNum, accType, balance, interestRate, overAmount) VALUES (?,?,?,?,?,?)";
		SavingAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		int[] types = new int[] {BIGINT, CHAR, CHAR, DOUBLE, DOUBLE, DOUBLE};
		if(account instanceof SavingAccount) {
			sa = (SavingAccount) account;
			args = new Object[] {
					sa.getCustomer().getCid(), sa.getAccountNum(), String.valueOf(sa.getAccType()), sa.getBalance(), sa.getInterestRate(), 0.0
			};
		} else {
			ca = (CheckingAccount) account;
			args = new Object[] {
					ca.getCustomer().getCid(), ca.getAccountNum(), String.valueOf(ca.getAccType()), ca.getBalance(), 0.0, ca.getOverdraftAmount()
			};
		}
		// args -> object 나타냄 / types -> object에 대한 타입을 알려주는 것
		jdbcTemplate.update(sql, args, types);
	}
	public List<Account> findAccountBySsn2(String ssn) {
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance, a.interestRate, a.overAmount, a.regDate FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = ?";
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), ssn);
	}
	public List<Account> findAccountByCustomerId2(long customerId) {
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance, a.interestRate, a.overAmount, a.regDate FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.customerId = ?";
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), customerId);
	}
	
	
}
