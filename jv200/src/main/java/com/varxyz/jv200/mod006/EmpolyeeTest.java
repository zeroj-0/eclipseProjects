package com.varxyz.jv200.mod006;


public class EmpolyeeTest {

	public static void main(String[] args) {
		Empolyee em = new Empolyee();
		em.name = "유빈";
		em.salary = 1000.0;
//		em.birthDate = new Date();

		String detail = em.getDetails();
		
		System.out.println(detail);
		System.out.println(em.birthDate);
		
		Manager mg = new Manager();
		mg.department = "영업부";
		mg.name = "관우";
		mg.salary = 2000.0;
		
		System.out.println(mg.getDetails());
		
		Director d = new Director();
		d.name = "호야";
		d.salary = 6300.0;
		
		System.out.println(d.getDetails());
		
		Empolyee e = new Manager();
//		e.department = "경영"; Manager클래스의 department 속성 못 불러옴
		// Manager클래스의 getDetails메소드가 불려오는 이유는 오버라이딩되었기 때문!!!!!!!!!!!!!!!!!!!
		System.out.println(e.getDetails());
	}

}
