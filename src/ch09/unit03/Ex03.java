package ch09.unit03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03 {
	public static void main(String[] args) {
		// 버퍼를 이용하여 문자(열)을 입력 받는다. 입력 속도 향상
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int a, b, c;
		
		try {
			System.out.print("첫번째 수 ? ");
			s = br.readLine();
				// readLine() 은 checked exception (IOException)
				// 이 발생하므로 반드시 예외처리 해야한다.
			a = Integer.parseInt(s);
			
			System.out.print("두번째 수 ? ");
			b = Integer.parseInt(br.readLine());
				// 문자열을 숫자로 변환하지 못하면
				// NumberFormatException 이라는
				// unchecked exception 이 발생
			
			c = a / b;
				// 0 으로 숫자를 나누면 
				// ArithmeticException이 발생
				// unchecked exception 이 발생
			
			System.out.println(a + "/" + b + "=" + c);
			
		} catch (IOException e) {
			// IOException : 입출력에 문자가 발생할 때 발생하는 예외(checked exception)
			// checked exception 
			// : 메소드를 정의할때 throws 한 예외
			// : 예외처리를 명시적으로 하지 않으면 컴파일 에러 발생
			e.printStackTrace();
		}
		
		//숫자를 0으로 나누거나 문자열을 입력할 경우 프로그램은 비정상적인
		// 종료로 인하여 아래 코드는 실행되지 않는다.
		System.out.println("end...");
	}
}
