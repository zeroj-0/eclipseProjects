package com.varxyz.jv301.mod010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitializeDataBaseListenser implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce)  {
		ServletContext context = sce.getServletContext();
		InputStream is = null;
		BufferedReader reader = null;
		
		try {
			is = context.getResourceAsStream("/WEB-INF/classes/jdbc.properties.txt");
			reader = new BufferedReader(new InputStreamReader(is));
			String record = null;
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	
}
