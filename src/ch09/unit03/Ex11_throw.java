package ch09.unit03;

public class Ex11_throw {
	public static void main(String[] args) {
		User11 obj = new User11();
		
		obj.setValue(-5);
		int n = obj.getValue();
		System.out.println(n);
		
	}
}

// 잘못 작성된 클래스
class User11{
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if(value < 0) {
			return;
		}
		
		this.value = value;
	}
}
