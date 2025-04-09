package ch12.unit02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
	- ArrayList
	  : List 인터페이스 구현 클래스
	  : 검색시 속도가 빠름
	  : 동기화 되지 않음
	  
	- LinkedList
	  : List 인터페이스 구현 클래스
	  : 검색시 속도가 느림
	  : 동기화 되지 않음
	  : 앞에서 추가하고 뒤에서 삭제가 빈번한 경우 빠름
	  : 앞뒤 아무데나 추가 삭제가 빈번한 경우
	  : 중간에 삽입하는 경우 속도가 현저히 떨어짐
*/
public class Ex04_LinkedList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("자바");
		list.add("오라클");
		list.add("스프링");
		print(list);
		System.out.println();
		
		List<String> list2 = new LinkedList<String>();
		list2.add("자바");
		list2.add("오라클");
		list2.add("스프링");
		print(list2);
		
	}
	
	public static void print(List<String> list) {
		for(String s : list) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
}
