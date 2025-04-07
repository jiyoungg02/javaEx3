package ch09.unit03;

import java.util.Scanner;

/*
	- 예외가 발생하지 않은 경우
	 1) 블럭 모두 실행
	 2) 블럭 실행 - 정상 종료

	- 예외가 발생한 경우
	 1) 블럭 실행중 예외 발생 -1) 블럭 실행을 중지하고
	 2) 블럭 실행(예외가 발생한 경우만 실행)
	 3) 블럭 실행 - 정상 종료
*/
public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		
		try {
			// 1) 예외가 발생할 가능성이 있는 코드를 기술
			System.out.print("두수 ? ");
			a = sc.nextInt();
			b = sc.nextInt();
			c = a / b;
			
			System.out.printf("%d / %d = %d\n".formatted(a, b, c));
		
		} catch (Exception e) {
			// Exception
			// : 모든 예외를 catch 할 수 있다.
			// : 예외 상황별로 예외를 분리할 수 있다.
			// 2) 예외가 발생할 때 실행할 코드를 작성
			System.out.println("예외가 발생했습니다.");
		}
		
		// 3) 
		System.out.println("end...");
		sc.close();
	}
}
