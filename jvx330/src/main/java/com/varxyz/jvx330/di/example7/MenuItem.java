package com.varxyz.jvx330.di.example7;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
// toString() 메소드 Override
@ToString
// 중복검사 메소드
@EqualsAndHashCode
public class MenuItem {
	private String name;
	private double price;
}
