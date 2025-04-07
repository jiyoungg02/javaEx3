package ch09.unit03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex05 {
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
			
		} catch (Exception e) {
			// Exception 
			// : 모든 예외를 catch 할 수 있다.
			// : 예외별로 예외를 분리할 수 없다.
			e.printStackTrace();
		}
		System.out.println("end...");
	}
}
