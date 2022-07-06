package com.varxyz.jv200.mod001;

public class Test {

	public static void main(String[] args) {
		String DEFAULT_SEASONS = "Spring, Summer, Fall, Winter";
		String[] seasons;
		String season_list = DEFAULT_SEASONS;
		seasons = season_list.split(", ");
		System.out.println(seasons);
	}

}
