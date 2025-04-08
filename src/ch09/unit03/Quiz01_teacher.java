package ch09.unit03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz01_teacher {
	public static void main(String[] args) {
		Calculate c = new Calculate();
		
		c.calc();
	}
}

// 사용자 정의 예외 클래스
class OperatorException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public OperatorException() {
		
	}
	
	public OperatorException(String message) {
		super(message);
	}
}

class Calculate{
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void calc() {
		int a, b;
		String op, s;
		
		try {
			System.out.print("첫번째수 ? ");
			a = Integer.parseInt(br.readLine());
			
			System.out.print("두번째수 ? ");
			b = Integer.parseInt(br.readLine());
			
			System.out.print("연산자 ? ");
			op = inputOperator();
			
			s = result(a,b,op);
			
			System.out.println(s);
		
		}catch (NumberFormatException e) { // Integer, IntegerLong 등에서 숫자로 바꾸지 못할 때 일어나는 오류
			System.out.println("두수는 숫자만 입력 가능합니다.");
		}catch (OperatorException e) {
			System.out.println("연산자 입력 오류 입니다.");
		}catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected String inputOperator() throws OperatorException, IOException{
		String op = null;
		
		op = br.readLine(); // checked exception : IOException
		
		if(!op.matches("(\\+|\\-|\\*|\\/|\\%)")) {
			throw new OperatorException("연산자 입력 오류...");
		}
		
		
		return op;
	}
	
	protected String result(int a, int b, String op) {
		String s = null;
		
		try {
			switch(op) {
			case "+": s = String.format("%d + %d = %d", a,b,a+b); break;
			case "-": s = String.format("%d - %d = %d", a,b,a-b); break;
			case "*": s = String.format("%d * %d = %d", a,b,a*b); break;
			case "/": s = String.format("%d / %d = %d", a,b,a/b); break;
			case "%": s = String.format("%d %% %d = %d", a,b,a%b); break;
			}
		} catch (Exception e) {
			throw e;
		}
		
		return s;
	}
	
}