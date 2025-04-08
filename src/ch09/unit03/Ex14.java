package ch09.unit03;

public class Ex14 {

}

//잘못 작성한 코드
class User14 {
	private int value;

	public int getValue() {
		return value;
}

public void setValue(int value) {
	try {
		if(value < 0) {
			throw new Exception("0 이상만 가능합니다.");
		}
		this.value = value;
		} catch (Exception e) {
			// 이곳에서 throw new Exception("") 한 예외를 catch 함
			System.out.println(e.toString());
		}
	}
}
