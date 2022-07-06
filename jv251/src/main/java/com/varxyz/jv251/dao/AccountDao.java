package com.varxyz.jv251.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingsAccount;

public class AccountDao{
	
	public AccountDao() {
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
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
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
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setAccountType(rs.getString("accountType").charAt(0));
					account.setRegDate(rs.getDate("regDate"));
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
				con = DataSourceManager.getConnection();
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
					account.setAid(rs.getInt("aid"));
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
		String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft,accountType, customerId) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				
				if ( account instanceof SavingsAccount) {
					SavingsAccount sAccount = (SavingsAccount) account;
					pstmt.setDouble(3, sAccount.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf('S'));
					pstmt.setLong(6, sAccount.getCustomer().getCid());
				} else {
					CheckingAccount cAccount = (CheckingAccount) account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, cAccount.getOverdraftAmount());
					pstmt.setString(5, String.valueOf('C'));
					pstmt.setLong(6, cAccount.getCustomer().getCid());
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
	
	public Account findAccountByAccountNum(String accountNum) {
		String sql = "SELECT * FROM Account WHERE accountNum = ?";
		Account account = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, accountNum);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					if (rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount();
						((SavingsAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} else {
						account = new CheckingAccount();
						((CheckingAccount) account).setOverdraftAmount(rs.getDouble("overdraft"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getInt("cid")));
				}
			} finally {
				DataSourceManager.getConnectionClose(rs, pstmt, con);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public void setBalanceByAccountNum(String accountNum, double balance) {
		String sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setDouble(1, balance);
				pstmt.setString(2, accountNum);
				
				pstmt.executeUpdate();
			} finally {
				DataSourceManager.getConnectionClose(null, pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
