package ch10.unit01;

public class Ex03 {
	public static void main(String[] args) {
		// 시스템 환경 설정 확인
		String s;
		
		s = System.getProperty("os.name");
		System.out.println("운영체제 : " + s);
		
		s= System.getProperty("file.encoding");
		System.out.println("character set : " + s); // UTF-8
		
		s = System.getProperty("java.version");
		System.out.println("자바버전 : " + s);
		
		s = System.getProperty("user.dir");
		System.out.println("현재작업경로 : " + s);
		
	}
}
