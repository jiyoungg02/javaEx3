package ch09.unit03;

import java.util.Scanner;

public class Ex06_finally {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] ss = new String[3];
		int idx = 0;
		String s;
		
		try {
			System.out.print("문자열 입력[문자열을 입력하지 않고 엔터] ? ");
			while((s = sc.nextLine()).length() != 0) {
				ss[idx++] = s;
				System.out.println("문자열 입력 : ");
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			// ArrayIndexOutOfBoundsException
			// : unchecked exception
			// : 배열의 첨자가 벗어나는 경우 발생하는 예외
			idx--;
			
			System.out.println("입력을 초과 했습니다.");
		}finally {
			// catch 하지 않은 예외가 있어도 실행
		
			System.out.println("예외 발생 유뮤와 상관 없이 실행");
			sc.close();
		}
		System.out.println("입력 문자열...");
		for(int i=0; i<idx; i++) {
			System.out.println(ss[i]);
		}
	}
}
