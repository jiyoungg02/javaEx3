package ch10.unit02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex04 {
	public static void main(String[] args) {
		String className = "ch10.unit02.Book";
		
		try {
			Class<?> cls = Class.forName(className);
			
			System.out.println("[Constructor 를 이용한 객체 생성]...");
			
			// 인자 없는 생성자 이용
			Constructor<?> con = cls.getDeclaredConstructor();
			Book b = (Book)con.newInstance();
			b.disp();
			
			// 파라미터가 있는 생성자 이용
			Constructor<?> con2 = cls.getDeclaredConstructor(String.class);
			Book b2 = (Book)con2.newInstance("스프링");
			b2.disp();
			System.out.println();
			
			System.out.println("[static 필드 접근]..");
			Field f = cls.getDeclaredField("publisher");
			String s = (String)f.get(null); // static 필드는 null
			System.out.println("static 필드값 : " + s);
			
			f.set(null, "대한"); // 설정. static 필드는 첫번째 인자는 null
			s = (String)f.get(null);
			System.out.println("static 필드 변경 후 : " + s);
			System.out.println();
			
			System.out.println("[private 메소드 호출]...");
			Method m = cls.getDeclaredMethod("getSubject");
			m.setAccessible(true); // private 메소드를 접근 가능하도록 설정
			s = (String) m.invoke(b); // b 객체의 getSubject() 메소드 호출
			System.out.println(s);
			
			System.out.println("[메소드 호출]...");
			Method m2 = cls.getDeclaredMethod("amt", int.class, int.class);
			int n = (int)m2.invoke(b, 10, 5000);
			System.out.println("결과 : " + n);
			
			Method m3 = cls.getDeclaredMethod("disp");
			m3.invoke(b);
			// m3.invoke(b2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Book{
	public static String publisher = "이저자";
	private String subject = "쉬운 자바";
	
	public Book() {
		
	}
	
	public Book(String subject) {
		this.subject = subject;
	}
	
	public int amt(int su, int price) {
		return su * price;
	}
	
	private String getSubject() {
		return subject;
	}
	
	public void disp() {
		System.out.println("책이름 - " + getSubject());
	}
}
