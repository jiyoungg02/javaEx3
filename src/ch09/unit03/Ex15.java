package ch09.unit03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex15 {
	public static void main(String[] args) {
		User15 obj = new User15();
		
		obj.input();
		obj.input();
		
	}
}

class User15{
	private Scanner sc = new Scanner(System.in);
	
	public void input() {
		String name, tel;
		int kor, eng;
		
		try {
			System.out.print("이름 ? ");
			name = sc.next();
			
			System.out.print("국어 ? ");
			kor = inputScore();
			
			System.out.print("영어 ? ");
			eng = inputScore();
			
			System.out.print("전화번호 ? ");
			tel = sc.next();
			
			System.out.println(name + ":" + kor + ":" + eng + ":" + tel);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("---------------------------");
	}
	
	private int inputScore() throws Exception{
		int s = 0;
		
		try {
			s = sc.nextInt();
			
			if(s < 0 || s > 100) {
				// 강제로 checked exception 발생
				throw new Exception("점수는 0~100 사이의 숫자입니다.");
			}
			
		} catch (InputMismatchException e) {
			sc.nextLine();
			throw new Exception("점수는 숫자만 가능합니다.");
		}
		
		return s;
	}
}