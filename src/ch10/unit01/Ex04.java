package ch10.unit01;

import java.util.Enumeration;
import java.util.Properties;

public class Ex04 {
	public static void main(String[] args) {
		// 시스템 환경 설정 정보
		Properties p = System.getProperties();
		Enumeration<?> e = p.propertyNames();
		
		while(e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = p.getProperty(key);
			
			System.out.println(key + " => " + value);
		}
	
	}
}
