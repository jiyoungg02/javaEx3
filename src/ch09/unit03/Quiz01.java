package ch09.unit03;
/*
	
	- 첫번째수 ? 10
	  두번째수 ? 5
	  연산자 ? +
	  10 + 5 = 15
	  
	  연산자는 + - * / % 가 가능하고 모두 정수로 처리
	  예외 처리 최대로 활용
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserQ01 obj = new UserQ01();
		
		try {
			System.out.print("첫번째수 ? ");
			obj.setN1(sc.nextInt());
			
			System.out.print("두번째수 ? ");
			obj.setN2(sc.nextInt());
			
			System.out.print("연산자 ? ");
			obj.setS(sc.next());
			
			System.out.println(obj.getN1() + obj.getS() + obj.getN2() + "=" + obj.result()); 
			
		} catch (InputMismatchException e) { // scanner 의 nextInt() 에서 발생하는 오류
			System.out.println("숫자만 가능합니다.");
		}catch (OperatorValidException e) {
			System.out.println("연산자를 잘못 입력했습니다.");
		}catch (DivideValidException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
		System.out.println("end...");
	}
}

class DivideValidException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public DivideValidException(String message) {
		super(message);
	}
}

class OperatorValidException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public OperatorValidException(String message) {
		super(message);
	}
}

class UserQ01{
	private int n1;
	private int n2;
	private String s;

	public int getN1() {
		return n1;
	}
	public void setN1(int n1){
		this.n1 = n1;
	}
	public int getN2() {
		return n2;
	}
	public void setN2(int n2){
		this.n2 = n2;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) throws DivideValidException, OperatorValidException{
		if(s.length() > 1 || !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/") && !s.equals("%")) {
			throw new OperatorValidException("연산자를 잘못 입력했습니다.");
		}
		
		if(s.equals("%") || s.equals("/")) {
			if(n2 == 0) {
				throw new DivideValidException("0으로 나눌 수 없습니다.");
			}
		}
		this.s = s;
	}
	public int result() {
		int result = 0;
		switch(s) {
		case "+": result = n1+n2; break;
		case "-": result = n1-n2; break;
		case "*": result = n1*n2; break;
		case "/": result = n1/n2; break;
		case "%": result = n1%n2; break;
		}
		return result;
	}
	
}
