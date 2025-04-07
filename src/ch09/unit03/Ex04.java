package ch09.unit03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b, c;
		
		try {
			System.out.print("첫번째 수 ? ");
			a = Integer.parseInt(br.readLine());
			
			System.out.print("두번째 수 ? ");
			b = Integer.parseInt(br.readLine());
			
			c = a / b;
			
			System.out.printf("%d / %d = %d\n", a, b, c);
			
		// 예외 발생별로 예외를 catch
		} catch (IOException e) {
			// readLine() 의 checked exception
			// 반드시 catch 해야 함
			
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// unchecked exception
			// : 문자열을 숫자로 변경하지 못하면 발생하는 예외
			// : 반드시 catch 할 필요는 없지만 예외가 발생하면 비정상적인 종료가 발생
			
			// System.out.println("숫자만 입력 가능합니다.");
			// System.out.println(e.getMessage()); // 메시지를 간단히 출력
			// System.out.println(e.toString()); // 발생한 예외 클래스 및 간단한 메시지 출력
			e.printStackTrace(); // 자세히 출력
		} catch (ArithmeticException e) {
			// unchecked exception
			// : 0으로 나누는 등 연산이 불가능한 경우에 발생
			
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (Exception e) {
			// Exception : 모든 예외 catch 가능
			// 다른 예외 클래스와 같이 catch 할 경우 가장 마지막에 위치
			
			e.printStackTrace();
		}
		
		System.out.println("end...");
	}
}
