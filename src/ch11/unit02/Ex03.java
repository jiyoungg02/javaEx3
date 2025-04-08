package ch11.unit02;

public class Ex03 {
	public static void main(String[] args) {
		// Test3<String> t = new Test3<>();
		Test3<String> t = new Test3<String>();
		t.set("서울");
		// t.set(50); // 컴오류
		String s = t.get(); // 캐스팅 하지 않음
		System.out.println(s);
	
		Test3<Integer> t2 = new Test3<>();
		t2.set(20);
		int n = t2.get();
		System.out.println(n);
		
	}
}

// generic : 하나의 파라미터 타입
// 파라미터 타입을 실행 시 결정
class Test3<T> {
	private T obj;
	public void set(T obj) {
		this.obj = obj;
	}
	
	public T get() {
		System.out.println(obj.getClass());
		
		return obj;
	}
}
