package ch12.unit04;

import java.util.HashSet;
import java.util.Set;

/*
 - Set
   : 순서를 유지하지 않는 데이터의 집합
   : 중복을 허용하지 않는다.
   : null 도 하나의 null 만 저장할 수 있다.
   : 구현클래스 - HashSet, LinkedHashSet, TreeSet
 - HashSet
   : set 인터페이스 구현 클래스
   : 요소의 저장 순서가 유지 되지 않는다.
   : 멀티 스레드 환경에서 안전하지 않다.
 - LinkedHashSet
   : HashSet 하위 클래스
   : 해시테이브로가 링크드리스트를 구현한 Set
   : 추가하는 순서대로 저장(저장 순서 유지)
   : 멀티 스레드 환경에서 안전하지 않다.
 - TreeSet
   : SortedSet 인터페이스 구현 클래스
   : 정렬된 순서에 의해 반복
   : 요소의 중복을 허용하지 않는다.
   : 멀티 스레드 환경에서 안전하지 않다.
   : Comparable 인터페이스를 구현한 클래스만 추가 가능
*/
public class Ex01_HashSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("서울");
		set.add("부산");
		set.add("대구");
		set.add("인천");
		set.add("광주");
		set.add("대전");
		set.add("울산");
		set.add("세종");
		set.add("서울"); // 이전 서울을 덮는다.
		
		System.out.println(set);
		
	}
}
