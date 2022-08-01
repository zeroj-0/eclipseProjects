//package com.varxyz.exam.test;
//
//import com.varxyz.spr.mvc.domain.CheckingAccount;
//import com.varxyz.spr.mvc.domain.SavingAccount;
//import com.varxyz.spr.mvc.exception.LackOfBalance;
//import com.varxyz.spr.mvc.exception.OverdraftException;
//
//public class TransferAccount implements Transfer {
//	
//	private AccountDao accountDao;
//
//	@Override
//	public boolean transfer(double amount, String withdrawAccountNum, String depositAccountNum) {
//		// withdrawAccountNum : 출금계좌번호
//		// depositeAccountNum : 입금계좌번호
//		
//		// 출금 계좌 타입확인
//				if(accountDao.getAccType(withdrawAccountNum).getAccType() == 'C') {
//					CheckingAccount ca = (CheckingAccount) accountDao.getAccType(withdrawAccountNum);
//					double overdraft;
//					try {
//						overdraft = ca.withdraw(amount, ca.getOverdraftAmount());
//					} catch (OverdraftException e) {
//						e.printStackTrace();
//						return false;
//					}
//					accountDao.reviseBalance(ca.getBalance(), overdraft, 0.0, withdrawAccountNum);
//					if(accountDao.getAccType(depositAccountNum).getAccType() == 'C') {
//						CheckingAccount deposite = (CheckingAccount) accountDao.getAccType(depositAccountNum);
//						deposite.depostie(amount);
//						accountDao.reviseBalance(deposite.getBalance(), deposite.getOverdraftAmount(), 0.0, depositAccountNum);
//					} else if(accountDao.getAccType(depositAccountNum).getAccType() == 'S'){
//						SavingAccount deposite = (SavingAccount) accountDao.getAccType(depositAccountNum);
//						deposite.deposite(amount);
//						accountDao.reviseBalance(deposite.getBalance(), 0.0, deposite.getInterestRate(), depositAccountNum);
//					}
//				} else if(accountDao.getAccType(withdrawAccountNum).getAccType() == 'S') {
//					SavingAccount sa = (SavingAccount) accountDao.getAccType(withdrawAccountNum);
//					try {
//						sa.withdraw(amount);
//					} catch (LackOfBalance e) {
//						e.printStackTrace();
//						return false;
//					}
//					accountDao.reviseBalance(sa.getBalance(), 0.0, sa.getInterestRate(), withdrawAccountNum);
//					if(accountDao.getAccType(depositAccountNum).getAccType() == 'C') {
//						CheckingAccount deposite = (CheckingAccount) accountDao.getAccType(depositAccountNum);
//						deposite.depostie(amount);
//						accountDao.reviseBalance(deposite.getBalance(), deposite.getOverdraftAmount(), 0.0, depositAccountNum);
//					} else if(accountDao.getAccType(depositAccountNum).getAccType() == 'S'){
//						SavingAccount deposite = (SavingAccount) accountDao.getAccType(depositAccountNum);
//						deposite.deposite(amount);
//						accountDao.reviseBalance(deposite.getBalance(), 0.0, deposite.getInterestRate(), depositAccountNum);
//					}
//				}
//				return true;
//	}
//	
//}
