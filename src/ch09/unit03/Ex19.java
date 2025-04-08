package ch09.unit03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex19 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User19 obj = new User19();
		
		try {
			System.out.print("이름 ? ");
			obj.setName(sc.next());
			
			System.out.print("나이 ? ");
			obj.setAge(sc.nextInt());
			
			System.out.println(obj.getName() + ":" + obj.getAge()); 
			
		} catch (InputMismatchException e) {
			System.out.println("나이는 숫자만 가능합니다.");
		}catch (NameValidException e) {
			System.out.println("이름은 두자 이상 입력해야 합니다.");
		}catch (AgeValidException e) {
			System.out.println("나이는 0 이상입니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
		System.out.println("end...");
	}
}

// 사용자 정의 예외 클래스(checked exception)
class NameValidException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NameValidException() {
		
	}
	
	public NameValidException(String message) {
		super(message);
	}
}

class AgeValidException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public AgeValidException() {
		
	}
	
	public AgeValidException(String message) {
		super(message);
	}
}

class User19{
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) throws NameValidException {
		if(name.length() < 2) {
			throw new NameValidException("이름은 두자 이상입니다.");
		}
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws AgeValidException {
		if(age < 0) {
			throw new AgeValidException("나이는 0이상 입니다.");
		}
		this.age = age;
	}
	
}