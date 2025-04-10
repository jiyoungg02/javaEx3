package ch12.unit07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex06__Comparable {
	public static void main(String[] args) {
		List<UserVO> list = new ArrayList<UserVO>();
		
		list.add(new UserVO("다자바", "010-3111-1311", 23));
		list.add(new UserVO("너자바", "010-1121-4111", 21));
		list.add(new UserVO("김자바", "010-1311-1151", 22));
		list.add(new UserVO("하자바", "010-1111-1611", 25));
		list.add(new UserVO("가가가", "010-1114-1311", 23));
	
		System.out.println("정렬전...");
		print(list);
		System.out.println();
		
		// Comparable 인터페이스가 구현된 클래스만 가능
		Collections.sort(list);
		
		System.out.println("정렬후...");
		print(list);
	
	}
	
	public static void print(List<UserVO> list) {
		for(UserVO vo : list) {
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getTel() + "\t");
			System.out.println(vo.getAge());
		}
	}
}

class UserVO implements Comparable<UserVO>{
	private String name;
	private String tel;
	private int age;
	
	public UserVO() {
		
	}
	
	public UserVO(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// compareTo() : Comparable 메소드로 정렬 기준을 설정한다.
	@Override
	public int compareTo(UserVO o) {
		// return age - o.getAge(); // 나이 오름차순
		// return -(age - o.getAge()); // 나이 내림차순
		
		// Strint의 compareTo() : 문자열 사전식 비교
		// return name.compareTo(o.getName()); // 이름 오름차순
		return -name.compareTo(o.getName()); // 이름 내림차순
	}
	
}