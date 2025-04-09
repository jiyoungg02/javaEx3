package ch12.unit05;

import java.util.Map;

public class Ex03 {
	public static void main(String[] args) {
		// 불변 Collection : JDK 9
		Map<String, Integer> map = Map.of("a", 100);
		System.out.println(map);
		// map.put("b", 200); // 런타임오류
		
		Map<String, Integer> map2 = Map.of("a", 100, "b",200);
		System.out.println(map2);
		
		Map<String, Integer> map3 = Map.ofEntries(Map.entry("a", 100), Map.entry("b", 200));
		System.out.println(map3);
		
	}
}
