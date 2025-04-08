package ch09.unit03;

public class Ex12 {
	public static void main(String[] args) {
		User12 obj = new User12();
		
		// obj.setValue(-5); // 컴오류. checked exception을 catch하지 않음
		try {
			obj.setValue(-5);
			int n = obj.getValue();
			System.out.println(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end...");
	}
}

class User12{
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) throws Exception{ // 메소드를 호출한 곳에서 예외를 catch 하도록 설정
		if(value < 0) {
			// 강제로 checked exception 을 발생 시킴
			throw new Exception("0 이상만 가능합니다.");
				// catch로 예외를 잡아야 하는데, 호출하는 곳에서 작업해야 함
		}
		
		this.value = value;
	}
	
}
