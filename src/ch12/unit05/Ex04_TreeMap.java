package ch12.unit05;

import java.util.Map;
import java.util.TreeMap;

public class Ex04_TreeMap {
	public static void main(String[] args) {
		// TreeMap
		// : 소트된 상태로 데이터 추가
		// : 키 순서로 정렬
		// : 키는 Comparable 인터페이스가 구현되어 있어야함

		// 키 순서로 정렬
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		map.put("자바", 100);
		map.put("오라클", 95);
		map.put("스프링", 90);
		map.put("자바스크립트", 80);
		map.put("HTML", 90);
		
		System.out.println(map);
		
		// 스프링에서 자바 이전까지
		// subMap() : TreeMap 메소드
		Map<String, Integer> subMap = map.subMap("스프링", "자바");
		System.out.println(subMap);
		
	}
}
