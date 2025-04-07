package ch09.unit03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		
		try {
			System.out.print("두수 ? ");
			a = sc.nextInt();
			b = sc.nextInt();
			
			c = a / b;
			
			System.out.printf("%d / %d = %d\n", a, b, c);
			
		} catch (InputMismatchException e) {
			// InputMismatchException
			// : unchecked exception
			// : nextInt() 등에서 숫자가 아닌 문자열을 입력한 경우 발생
			
			System.out.println("숫자만 입력 가능합니다.");
		}catch (ArithmeticException e) {
			System.out.println("연산이 불가능 합니다.");
		}finally {
			// finally 블럭에서는 일반적으로 사용한 resource 를 close 한다.
			sc.close();
		}
		System.out.println("end...");
	}
}
