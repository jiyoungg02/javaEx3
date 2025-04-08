package ch11.unit03;

public class Ex02 {
	public static void main(String[] args) {
		Test2<Integer> t = new Test2<>();
		t.set(30);
		disp(t);
		
		Test2<String> t2 = new Test2<>();
		t2.set("자바");
		disp(t2);
	}
	
	/*
		- ?(제너릭 와일드 카드)
		  : 모든 클래스나 인터페이스가 가능
		  : 제너릭 타입에 의존적이지 않는 메소드 등을 호출할 때 사용
	*/
	public static void disp(Test2<?> t) {
		t.print();
		// t.set(10); // 컴파일 오류. 자료형이 결정되지 않은 상태이므로
	}
	
}

class Test2<T> {
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
		
	public T get() {
		return t;
	}
	
	public void print() {
		System.out.println(t);
	}
}