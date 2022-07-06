package com.varxyz.jv200.mod010;

import java.io.File;

public class FileTest {
	private static final String SAVE_DIR = "C:\\temp";
	public static void main(String[] args) {
		File saveDir = new File(SAVE_DIR);
		System.out.println(saveDir.getPath());
		// OS에따라 파일구분자가 다르기 때문에 File.separator를 이용하여 현재 OS의 파일구분자를 리턴해주는 것
		// window는 \지만 Linux는 /임
		System.out.println("window : " + File.separator);
	}

}
