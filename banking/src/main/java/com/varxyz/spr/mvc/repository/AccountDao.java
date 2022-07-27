package com.varxyz.spr.mvc.repository;

import static java.sql.Types.BIGINT;
import static java.sql.Types.CHAR;
import static java.sql.Types.DOUBLE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.varxyz.spr.mvc.domain.Account;
import com.varxyz.spr.mvc.domain.CheckingAccount;
import com.varxyz.spr.mvc.domain.SavingAccount;


@Repository("accountDao")
public class AccountDao {
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addAccount(Account account) {
		String sql = "INSERT INTO Account (customerId, accountNum, accType, balance, interestRate, overAmount) VALUES (?,?,?,?,?,?)";
		SavingAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		int[] types = new int[] { BIGINT, CHAR, CHAR, DOUBLE, DOUBLE, DOUBLE };
		if (account instanceof SavingAccount) {
			sa = (SavingAccount) account;
			args = new Object[] { sa.getCustomer().getCid(), sa.getAccountNum(), String.valueOf(sa.getAccType()),
					sa.getBalance(), sa.getInterestRate(), 0.0 };
		} else {
			ca = (CheckingAccount) account;
			args = new Object[] { ca.getCustomer().getCid(), ca.getAccountNum(), String.valueOf(ca.getAccType()),
					ca.getBalance(), 0.0, ca.getOverdraftAmount() };
		}
		jdbcTemplate.update(sql, args, types);
	}
	
	
	
	public List<Account> getAccounts(long cid) {
		String sql = "SELECT customerId, accountNum, balance, accType FROM Account WHERE customerId = ?";

		return jdbcTemplate.query(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account(rs.getLong("customerId"), rs.getString("accountNum"),
						rs.getDouble("balance"), rs.getString("accType").charAt(0));
				return account;
			}

		}, cid);
	}

	public List<Account> findAccountByUserId(String userId) {
		String sql = "SELECT a.customerId, a.accountNum, a.balance, c.cid FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.userId = ?";

		return jdbcTemplate.query(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account(rs.getLong("customerId"), rs.getString("accountNum"),
						rs.getDouble("balance"));
				return account;
			}

		}, userId);
	}

	public Account getBalance(String accountNum) {
		String sql = "SELECT balance FROM Account WHERE accountNum = ?";

		return jdbcTemplate.queryForObject(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account(rs.getDouble("balance"));
				return account;
			}

		}, accountNum);
	}
	

	public void replaceOverdraftAmount(String accountNum, double amount) {
		String sql = "UPDATE Account SET overAmount=? WHERE accountNum = ?";
		jdbcTemplate.update(sql, amount, accountNum);
	}
	
	public Account getAccType(String accountNum) {
		String sql = "SELECT accType, interestRate, overAmount FROM Account WHERE accountNum = ?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Account>() {
			
			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = null;
				if(rs.getString("accType").charAt(0) == 'C') {
					account = new CheckingAccount();
					CheckingAccount ca = (CheckingAccount) account;
					ca.setOverdraftAmount(rs.getDouble("overAmount"));
					return ca;
				} else {
					account = new SavingAccount();
					SavingAccount sa = (SavingAccount) account;
					sa.setInterestRate(rs.getDouble("interestRate"));
					return sa;
				}
			}
			
		}, accountNum);
	}
	
}
