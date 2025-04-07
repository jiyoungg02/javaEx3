package ch09.unit03;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		// 잘못 작성한 코드 예
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		
		System.out.println("정수 ? ");
		a = sc.nextInt();
		b = sc.nextInt();
		
		c = a / b;
		System.out.printf("%d / %d = %d\n", a, b, c);
		
		// b가 0인 경우 프로그램이 비정상적으로 종료되어 아래 코드는 실행되지 않는다.
		System.out.println("end...");
		
		sc.close();
	}
}
