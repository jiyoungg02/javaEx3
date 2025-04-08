package ch09.unit03;

import java.util.Scanner;

public class Ex18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User18 obj = new User18();
		
		try {
			System.out.print("이름 ? ");
			obj.setName(sc.next());
			
			System.out.print("나이 ? ");
			obj.setAge(sc.nextInt());
			
			System.out.println(obj.getName() + ":" + obj.getAge());
			
		} catch (Exception e) {
			System.out.println("입력 오류 입니다.");
		}finally{
			sc.close();
		}
		
		System.out.println("end...");
	}
}

// Exception 으로 모든 예외처리
class User18{
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) throws Exception{
		if(name.length() < 2) {
			throw new Exception("이름은 두자 이상입니다.");
		}
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception{
		if(age < 0) {
			throw new Exception("나이는 0이상 입니다.");
		}
		this.age = age;
	}
	
}
