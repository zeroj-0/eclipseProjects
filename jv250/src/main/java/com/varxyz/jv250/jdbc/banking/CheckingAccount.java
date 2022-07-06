package com.varxyz.jv250.jdbc.banking;

public class CheckingAccount extends Account {
	private double overdraftAmount;
	
	public CheckingAccount() {};
	
	public CheckingAccount(double balance, double overdraftAmount) {
		super(balance);
		this.overdraftAmount = overdraftAmount;
	}
	
	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}
	
	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}

	// throws는 사용하는 쪽에다가 예외가 발생될 수 있다는 것을 알려주는 키워드기 때문에
	// throw로 예외를 던져주는 메소드에다가 정의 꼭 해줘야함.
	public void withdraw(double amount) throws LoanLimitException {
		if (balance < amount) {
			// 잔고부족시 overdraftAmount 금액 한도 내에서 추가 출금을 승인
			
			// 대출하려는 돈이 대출한도액보다 클때 예외발생
			if (overdraftAmount < (amount-balance)) {
				throw new LoanLimitException("대출한도 초과");
			} else {				
				// 대출 한도액에다가 잔고보다 부족한 금액 빼서 씀
				overdraftAmount = overdraftAmount - (amount-balance);
				
				// 대출한 금액 통잔잔고에 찍기
				balance = -(amount-balance);
			}
			
		} else {
			balance -= amount;
		}
		System.out.println("출금 후 잔액은: " + balance + "원");
	}
	public String toString() {
		return super.toString() + "\t" + "overdraftAmount : " + overdraftAmount;
	}
}
