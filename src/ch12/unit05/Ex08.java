package ch12.unit05;

import java.io.FileInputStream;
import java.util.Properties;

public class Ex08 {
	public static void main(String[] args) {
		String pathname = "subject.properties";
		Properties p = new Properties();
		
		// 파일이 저장된 Properties 값 불러오기
		// FileInputStream 
		// : 파일의 내용을 읽어내는 바이트 스트림
		// : 파일이 없으면 FileNotFoundException 발생
		
		try(FileInputStream fos = new FileInputStream(pathname)) {
			// 파일의 내용을 읽어 Properties 객체에 저장
			p.load(fos);
			
			p.list(System.out);
			System.out.println();
			
			 String s = p.getProperty("자바");
			 System.out.println(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
