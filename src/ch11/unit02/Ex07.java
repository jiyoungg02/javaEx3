package ch11.unit02;

public class Ex07 {
	public static void main(String[] args) {
		Test7 t = new Test7();
		
		t.print("자바");
		t.print(20);
		
		t.disp(15);
		// t.disp("스프링"); // 컴오류
		
	}
}

// generic method
class Test7 {
	public <U> void print(U u) {
		System.out.println(u.getClass().getName() + " : " + u);
	}
	
	public <U extends Number> void disp(U u) {
		System.out.println(u.getClass().getName() + " : " + u);
	}
}
