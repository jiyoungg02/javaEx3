package ch12.unit05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
  - Map
    : 키, 값 구조
    : 키는 중복을 허용하지 않는다.
    : 키는 순서가 없다.
    : 키는 변경 불가능하다. 변경할 경우 삭제후 다시 등록한다.
    : 값은 replace(키, 값)으로 변경할 수 있다.
  	: 구현 클래스 - HashMap, Hashtable, LinkedHashMap, TreeMap 등
  - HashMap
    : 동기화 지원하지 않음 
  - Hashtable
    : 동기화 지원
  - LinkedHashMap
    : 키가 등록된 순서를 유지
  - TreeMap
    : 키 순서로 정렬
    : 키는 Comparable 인터페이스가 구현되어 있어야 한다.
*/
public class Ex01_HashMap {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// map 에 저장
		map.put("서울", 1000); // 키, 값
		map.put("부산", 350);
		map.put("대구", 250);
		map.put("인천", 300);
		map.put("광주", 150);
		map.put("대전", 150);
		map.put("울산", 110);
		map.put("세종", 12);
		map.put("서울", 980); // 키가 같으면 값 덮는다.
		
		System.out.println(map);
		
		// map 의 데이터 반환
		// 타입 변수 = map.get(키);
		
		// int n = map.get("경기"); // 런타임오류.
			// 데이터가 없으면 null 을 반환
		Integer n = map.get("경기"); // null
		System.out.println(n);
		
		n = map.get("인천"); // 300
		System.out.println(n);
		System.out.println();
		
		/*
			- Map
			  : Iterator(반복자)가 없다.
			  : 향상된 for 문을 사용할 수 없다.
			  : 키에서 Set 객체를 반환 받아 처음부터 끝까지 순회한다.
		*/
		
		Set<String> set = map.keySet(); // 키에 대한 Set 객체
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key + " => " + value);
		}
		System.out.println();
		
		System.out.println("키에 서울 존재 ? " + map.containsKey("서울"));
		System.out.println("키에 경기 존재 ? " + map.containsKey("경기"));
		System.out.println("값에 300 존재 ? " + map.containsValue(300));
		
		System.out.println("전체 개수 : " + map.size());
		
		map.remove("세종"); // 삭제후 삭제된 객체반환
		System.out.println(map);
		
	}
}
