package ch12.unit05;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex02 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("자바", 80);
		map.put("오라클", 90);
		map.put("빅데이터", 100);
		map.put("서블릿", 60);
		map.put("스프링", 80);
		
		System.out.println("map...");
		System.out.println(map);
		
		// 키를 Set 으로 가져오기
		System.out.println("\n키를 Set으로 가져오기..");
		Set<String> set = map.keySet();
		System.out.println(set);
		
		System.out.println("\nmap 전체 - 1");
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			int score = map.get(key);
			System.out.println(key + " -> " + score);
		}
		System.out.println();
		
		System.out.println("\nmap 전체 - 2");
		for(String key : map.keySet()) {
			int score = map.get(key);
			System.out.println(key + " -> " + score);
		}
		
		// 값을 Collection 으로
		Collection<Integer> col = map.values();
		System.out.println("\n값을 컬렉션으로..");
		for(int n : col) {
			System.out.print(n + " ");
		}
		System.out.println();

		System.out.println("최고 값 : " + Collections.max(col));
		System.out.println("최저 값 : " + Collections.min(col));
	
	}
}
