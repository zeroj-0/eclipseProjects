package com.varxyz.spr.mvc.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCommand {
	private String userId;
	private String passwd;
	private String name;
	private String ssn;
	private String phoneNum;
	
}
