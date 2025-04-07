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
			a = Integer.parseInt(s);
			
			System.out.print("두번째 수 ? ");
			b = Integer.parseInt(br.readLine());
			
			c = a / b;
			
			System.out.println(a + "/" + b + "=" + c);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("end...");
	}
}
