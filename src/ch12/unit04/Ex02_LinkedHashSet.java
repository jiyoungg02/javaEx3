package ch12.unit04;

import java.util.LinkedHashSet;
import java.util.Set;

public class Ex02_LinkedHashSet {
	public static void main(String[] args) {
		// Set : 중복 허용 안함
		// LinkedHashSet : 순서 유지
		Set<String> set = new LinkedHashSet<String>();
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
