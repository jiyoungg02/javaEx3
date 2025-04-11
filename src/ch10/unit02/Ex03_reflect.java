package ch10.unit02;

import java.lang.reflect.Constructor;

public class Ex03_reflect {
	public static void main(String[] args) {
		String ClassName = "ch10.unit02.TestImpl";
		
		try {
			Class<?> cls = Class.forName(ClassName);
			
			// 객체 생성
			// Test t = new TestImpl();
			
			// 객체 생성
			// Constructor<?> con = cls.getConstructor(); // 런타임오류
			Constructor<?> con = cls.getDeclaredConstructor();
							// private , 디폴트 생성자의 정보도 가져옴
			Test t = (Test)con.newInstance();
			
			int s = t.sum(10, 5);
			t.print("합", s);
			
		} catch (ClassNotFoundException e) {
			// 클래스가 존재하지 않는 경우
			e.printStackTrace();
		} catch (InstantiationException e) {
			// 객체를 생성할 수 없는 경우
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}

interface Test{
	public int sum(int a, int b);
	public void print(String title, int result);
	
}

class TestImpl implements Test{

	@Override
	public int sum(int a, int b) {
		return a + b;
	}

	@Override
	public void print(String title, int result) {
		System.out.println(title +  " -> " + result);
		
	}
	
}
