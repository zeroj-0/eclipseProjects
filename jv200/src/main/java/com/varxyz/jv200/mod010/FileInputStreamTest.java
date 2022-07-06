package com.varxyz.jv200.mod010;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int totalBytes = 0;
		try {
			try {
				/**
				 * 절대주소: '/'가 앞에오면 절대주소 
				 * 상대주소: '/'가 없으면 상대주소
				 */
				fis = new FileInputStream("test.txt");
				// 카피 코드
				fos = new FileOutputStream("test_copy.txt");
				
				// readByte에다가 읽은것을 넣어줌. readByte가 -1이 return되기 전까지 계속 반복
				for ( int readByte; (readByte = fis.read()) != -1;) {
					// 읽은거 찍어줌
					System.out.write(readByte);
					fos.write(readByte);
					// totalBytes는 바이트 수
					totalBytes++;
				}
			} finally {
				fos.close();
				fis.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n전체 바이트 수: "+ totalBytes + "bytes.");

	}

}
