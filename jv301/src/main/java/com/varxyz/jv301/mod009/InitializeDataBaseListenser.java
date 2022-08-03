package com.varxyz.jv301.mod009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeDataBaseListenser implements ServletContextListener {
	
	private static final String JDBC_FILE_PATH = "/WEB-INF/classes/jdbc.properties";

	@Override
	public void contextInitialized(ServletContextEvent event)  {
		// 파일 읽어오기 위함
		ServletContext context = event.getServletContext();
		InputStream is = null;
		try {
			is = context.getResourceAsStream(JDBC_FILE_PATH);
			
			// property파일은 Buffer사용안해도 된다. 따라서 Properties의 로드메소드 사용. 전에는 txt여서 Buffer사용함
			Properties prop = new Properties();
			prop.load(is);
			
			String jdbcDriver = prop.getProperty("JDBC_DRIVER");
			String jdbcURL = prop.getProperty("JDBC_URL");
			String userName = prop.getProperty("JDBC_USER");
			String password = prop.getProperty("JDBC_PASSWORD");
			
			// 데이터 소스만듦
			DataSource dataSource = new DataSource(jdbcDriver,jdbcURL,userName,password);
			
//			context에다가 저장하기
//			context.setAttribute("dataSource", dataSource); // web쪽으로는 이것도 맞음
			NamingService namingService = NamingService.getInstance();
			namingService.setAttribute("dataSource", dataSource);
			
			System.out.println("DataSource has been initilized. ");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
    public void contextDestroyed(ServletContextEvent event)  { 
    }

	
}