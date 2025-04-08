package ch11.unit02;

public class Ex05 {
	public static void main(String[] args) {
		TestImpl5<Integer> t = new TestImpl5<>();
		t.print(10);
		
		DemoImpl5 ob = new DemoImpl5();
		ob.print("자바");
		
	}
}

// 제너릭 인터페이스
interface Test5<T>{
	public void print(T t);
}

// 구현 클래스 1
class TestImpl5<T> implements Test5<T>{
	@Override
	public void print(T t) {
		System.out.println(t);
	}
}

// 구현 클래스 2
class DemoImpl5 implements Test5<String>{
	@Override
	public void print(String t) {
		System.out.println(t);
	}
}