package com.varxyz.jv250.jdbc.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AccountDao extends Dao {
	private static final String JDBC_DRIVER= "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	
	private static final String JDBC_USER = "jv250";
	private static final String JDBC_PASSWORD = "jv250";
	
	public AccountDao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("LOADED DRIVER ---->" + JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 등록된 모든 계좌 목록 조회
	 * @return
	 */
	public List<Account> findAllAccounts() {
		String sql = "SELECT * FROM Account";
		List<Account> accountList = new ArrayList<Account>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					Account account = new CheckingAccount();
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setAccountType(rs.getString("accountType").charAt(0));
					accountList.add(account);
				}
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return accountList;
	}
	/**
	 * 전달된 주민번호를 가진 특정 고객의 계좌 목록 조회
	 * @param accountNum									주민번호
	 * @return
	 */
	public List<Account> findAccountBySsn(String ssn) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, a.regDate, c.name, c.ssn, c.phone FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn=?";
		List<Account> accountList = new ArrayList<Account>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				
				Account account = null;
				
				while (rs.next()) {
					if (rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount();
						((SavingsAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} else {
						account = new CheckingAccount();
						((CheckingAccount) account).setOverdraftAmount(rs.getDouble("overdraft"));
					}
					account.setAccountId(rs.getInt("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setAccountType(rs.getString("accountType").charAt(0));
					account.setCustomer(new Customer(rs.getString("name"), rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getDate("regDate"));
					accountList.add(account);
				}
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft,accountType, customerId) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				
				if ( account instanceof SavingsAccount) {
					SavingsAccount sAccount = (SavingsAccount) account;
					pstmt.setDouble(3, sAccount.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf('S'));
					pstmt.setInt(6, sAccount.getCustomerId());
				} else {
					CheckingAccount cAccount = (CheckingAccount) account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, cAccount.getOverdraftAmount());
					pstmt.setString(5, String.valueOf('C'));
					pstmt.setInt(6, cAccount.getCustomerId());
				}
				pstmt.executeUpdate();
			} finally {
				pstmt.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
