package ch12.unit04;

import java.util.Set;
import java.util.TreeSet;

public class Ex03_TreeSet {
	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();
			// TreeSet : 정렬한다. Comparable 구현 클래스만 가능
		
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
