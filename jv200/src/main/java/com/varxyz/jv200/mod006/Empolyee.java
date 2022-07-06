package com.varxyz.jv200.mod006;

// 외부 라이브러리 불러옴

public class Empolyee {
//	private String name; 오류남
//	public String name;
//	String name; 같은 패키지 안이라서 사용 가능
//	같은 패키지 안이라서 사용 가능 다른 패키지에 있는 클래스는 이 변수를 사용하기 위해서 이 클래스를 상속받지 않으면 쓰지 못함
	protected String name; 
	protected double salary;
	public MyDate birthDate;
	
	public String getDetails() {
		return "Name: "+ name +"\nSalary: " +salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public boolean equals(Object obj) {
		
		if (obj instanceof Empolyee) {
			
			Empolyee emp = (Empolyee)obj;
			
			if(emp.getName().equals(name) && emp.getBirthDate().equals(birthDate)) {
				return true;
			}
			
		}
		return false;
	}
}
