package com.varxyz.jv200.mod006;

/**
 * 이 회사의 사원은 이름과 생일이 같다면 같은 사원으로 인식되도록
 * equals()메소드를 재정의 하세요.
 * 
 * @author Administrator
 *
 */

public class EqualsTest {

	public static void main(String[] args) {
		Empolyee e = new Empolyee();
		e.setName("유비");
		e.setSalary(1000.0);
		e.setBirthDate(new MyDate(10, 4, 2000));
		
		Empolyee e2 = new Empolyee();
		e2.setName("유비");
		e2.setSalary(1000.0);
		e2.setBirthDate(new MyDate(10, 4, 2000));

		System.out.println(e==e2);
		System.out.println(e.equals(e2));
	}

}
