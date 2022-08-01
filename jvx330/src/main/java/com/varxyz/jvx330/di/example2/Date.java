package com.varxyz.jvx330.di.example2;

import lombok.AllArgsConstructor;

// 모든 필드 값을 파라미터로 받는 생성자
@AllArgsConstructor
public class Date {
	private int year;
	private int month;
	private int day;
	
	/**
	 * 
		public Date(int year, int month, int day) {
			super();
			this.year = year;
			this.month = month;
			this.day = day;
		}
	 * 생성자 아규먼트 컨테이너에게 알려줘야하기 때문에 beans.xml에서
	 * <bean name="regDate" class="com.varxyz.jvx330.di.example2.Date">
			<constructor-arg index="0" type="int" value="2022"/>
			<constructor-arg index="1" type="int" value="7"/>
			<constructor-arg index="2" type="int" value="21"/>
		</bean>
	 * 
	 * 이런식으로 지정해 줘야한다
	 * @param year
	 * @param month
	 * @param day
	 */
	
	
	public String toString() {
		return year + "-" + month + "-" + day;
	}
	
	public int hashCode() {
		return (day ^ month ^ year);
	}

}
