package ch11.unit02;

public class Ex04 {
	public static void main(String[] args) {
		Test4<String, Integer> t = new Test4<>();
		
		t.set("자바", 95);
		t.disp();
		
	}
}

class Test4<T, U>{
	private T t;
	private U u;
	
	public void set(T t, U u) {
		this.t = t;
		this.u = u;
	}
	
	public void disp() {
		System.out.println("T : " + t.getClass().getName() + ", " + t);
		System.out.println("U : " + u.getClass().getName() + ", " + u);
		
	}
	
}