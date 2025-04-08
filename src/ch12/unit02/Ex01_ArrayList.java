package ch12.unit02;

import java.util.ArrayList;
import java.util.List;

/*
	- List 인터페이스
	  : 순서가 있다.
	  : 배열과 유사한 구조
	  : 가변길이(저장 공간이 부족하면 자동으로 공간이 늘어남)
	  : 중복적인 요소도 추가 가능
	  : 중간에 데이터를 추가하거나 삭제도 가능
	  : 주요 구현 클래스
	    ArrayList, Vector, LinkedList, Stack 등
	  : Vector - 동기화 지원. 멀티 스레드 환경에서 안전
	  : ArrayList - 동기화 지원하지 않음. 멀티 스레드 환경에서 안전하지 않음
*/

public class Ex01_ArrayList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(); // up casting
		String s;
		
		// 마지막에 요소 추가
		list.add("서울");
		list.add("부산");
		list.add("인천");
		list.add("광주");
		list.add("서울"); // 중복적인 요소 추가 가능
		list.add("대전");
		System.out.println(list);

		// 2 인덱스에 데이터 추가
		list.add(2,"대구");
		System.out.println(list);
		
		// 데이터 개수
		System.out.println("데이터 개수 : " + list.size());
		
		// 처음 데이터 반환
		s = list.get(0);
		// s = list.getFirst(); // JDK 21부터 생김
		System.out.println("처음:" + s);

		// 두번째 데이터 반환
		s = list.get(1);
		System.out.println("두번째:" + s);
		
		// 마지막 데이터 반환
		s = list.get(list.size() - 1);
		// s = list.getLast(); // JDK 21부터 생김
		System.out.println("마지막:" + s);
		
		// 처음에 한국 추가
		list.add(0, "한국");
		System.out.println(list);
		
		// 처음의 데이터를 대한민국이라고 수정
		list.set(0, "대한민국");
		System.out.println(list);
		
		int idx;
		
		// 인천의 인덱스는?
		idx = list.indexOf("인천");
		System.out.println("인천 인덱스:" + idx);
		
		idx = list.indexOf("세종");
		System.out.println("세종 인덱스:" + idx); // 없으면 -1
		
		idx = list.indexOf("서울");
		System.out.println("서울(처음부터) 인덱스:" + idx); // 1
		
		idx = list.lastIndexOf("서울");
		System.out.println("서울(뒤에서부터) 인덱스:" + idx); // 6
		
		// 부산 존재 ?
		System.out.println("부산 ? " + list.contains("부산"));
		
		// 대한민국 삭제
		// list.remove("대한민국");
		list.remove(0);
		System.out.println(list);
		
	}
}
