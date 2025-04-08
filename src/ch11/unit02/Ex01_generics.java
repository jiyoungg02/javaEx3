package ch11.unit02;

public class Ex01_generics {
	public static void main(String[] args) {
		Object[] obj = new Object[5];
		
		//Object 는 모든 클래스를 참조할 수 있다. (up-casting)
		obj[0] = new String("자바");
		obj[1] = new String("스프링");
		obj[2] = 90;
		obj[3] = 100;
		obj[4] = new String("오라클");
		
		// Arrays.sort(obj); // ClassCastException 예외 발생
		
		for(Object o : obj) {
			/*
			String s = (String)o; // ClassCastException 예외 발생
			System.out.println(s.length());
			System.out.println(o);
			*/
			
			if(o instanceof String) {
				String s = (String)o;
				System.out.println(s + " : " + s.length());
			}else if(o instanceof Integer) {
				Integer s = (Integer)o;
				System.out.println("정수 : " + s);
			}
			
		}
		
	}
}
