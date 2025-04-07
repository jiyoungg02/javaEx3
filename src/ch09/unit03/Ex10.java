package ch09.unit03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex10 {
	public static void main(String[] args) {
		int n;
		String s;
		
		// try~with~resource : 자동으로 resource 가 close 됨
		try (Scanner sc = new Scanner(System.in)){
			System.out.print("나이 ? ");
			n = sc.nextInt();
			
			s = n >= 19 ? "성인" : "미성년자";
			System.out.println(n + "=>" + s);
			
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력 가능합니다.");
		}
		
		System.out.println("end...");
	}
}
