package ch11.unit02;

public class Ex06 {
	public static void main(String[] args) {
		Test6<Integer> t = new Test6<>();
		t.set(10);
		Integer i = t.get();
		System.out.println(i);
		
		// Test6<String> t2 = new Test6<>(); // 컴오류
	}
}

// 제한된 타입 파라미터
// <T extends Number> : Number 를 상속 받은 클래스만 가능(Integer, Double 등)
class Test6<T extends Number>{
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}
