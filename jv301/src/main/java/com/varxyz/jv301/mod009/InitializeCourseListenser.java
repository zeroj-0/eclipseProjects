package com.varxyz.jv301.mod009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 어노테이션을 가지고 다 처리하는 것 -> xml등록필요x
 * @author Administrator
 * 
 * Servlet과 WebListener 등
 * 파일 전체를 볼때는 xml을 통해 보는게 좋음
 * 
 * 사실은 컨테이너가 존재할때까지의 scope
 */
@WebListener
public class InitializeCourseListenser implements ServletContextListener {

	// 톰캣에 올라갈때 이벤트를 발생
	@Override
	public void contextInitialized(ServletContextEvent sce)  { 
		System.out.println("contextInitialized() method called");
		
		ServletContext context = sce.getServletContext();
		
		// 파일 읽기 읽을때는 기본적으로 Buffer사용
		InputStream is = null;
		
		/**
		 * binary(바이트단위 그대로 읽고쓰는 클래스들)
		 * character inputstream 의 최상위는 Reader Writer
		 */
		BufferedReader reader = null;
		List<String[]> contentList = new ArrayList<String[]>();
//		String[] strArr = new String[] {"servlet"};
		try {
			// 리턴타입이 inputStream인 context의 메소드
			// 실제 경로 C:\JAVA_lgm\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jv301\WEB-INF\classes\여기로 들어오게됨
			is = context.getResourceAsStream("/WEB-INF/classes/course_contents.txt");
			
			// inputStream을 가지고 inputStreamReader로 읽게하기
			// 데코레이터 패턴
			reader = new BufferedReader(new InputStreamReader(is));
			String record = null;
			
			// readLine 한줄씩 읽음. -> 한줄씩 record에 담음
//			contentList.add(strArr);
			while((record = reader.readLine()) != null) {
				record = escapeHtml(record);
				String[] fields = record.split("\t");
				contentList.add(fields);
			}
			context.setAttribute("contentList", contentList);
			System.out.println("The course contents has been loader");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	// 톰캣을 shutdown할때 이벤트 발생
	@Override
    public void contextDestroyed(ServletContextEvent sce)  { 
		System.out.println("contextDestroyed() method called");
    }
	
	private String escapeHtml(String line) {
		if(line.length() == 0) {
				return line;
		}
		return line.replace("<", "&lt;").replace(">", "&gt;");
	}
}