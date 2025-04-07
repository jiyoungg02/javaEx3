package ch09.unit03;

public class Ex08 {
	public static void main(String[] args) {
		// divide(10,5);
		// divide(10,0);
		divide(10, -2);
	}
	
	public static void divide(int a, int b) {
		try {
			if(b < 0) {
				System.out.println("음수를 입력 했습니다.");
				return;
				// System.exit(0); // 프로그램 강제 종료
			}
			int c = a / b;
			System.out.printf("%d / %d = %d\n",a, b, c);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}finally {
			// finally 블럭은 System.exit(0);로 프로그램을 강제
			// 종료하는 경우에만 실행하지 않는다.
			
			System.out.println("finally 블럭은 return을 만나도 실행");
			
		}
		System.out.println("end...");
	}
}
