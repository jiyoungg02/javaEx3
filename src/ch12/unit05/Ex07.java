package ch12.unit05;

import java.io.FileOutputStream;
import java.util.Properties;

public class Ex07 {
	public static void main(String[] args) {
		Properties p = new Properties();
		
		//Properties에 값 저장
		p.setProperty("자바", "80");
			// put() 을 사용할 수 있지만 권장하지 않음
		p.setProperty("스프링", "85");
		p.setProperty("서블릿", "80");
		p.setProperty("오라클", "95");
		p.setProperty("HTML", "100");
	
		p.list(System.out);
		System.out.println();
		
		// Properties 에 저장된 자료를 파일에 저장
		// FileOutputStream : 파일 출력 바이트 스트림
		
		String pathname = "subject.properties";
		try(FileOutputStream fos = new FileOutputStream(pathname)) {
			
			// Properties 내용을 파일에 저장
			p.store(fos, "과목별 성적");
				// 숫자, 영문자 제외하고는 유니코드로 저장
			
			System.out.println("파일 저장 완료...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
