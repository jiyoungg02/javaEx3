package ch12.unit05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 - entry
   : 키와 값을 set 형태로 저장
   : key와 value를 묶어주기 위해 사용
 - Map.Entry 인터페이스
   : 맵의 앤트리
 
*/
public class Ex05 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("홍길동", 90);
		map.put("이순신", 100);
		map.put("이기자", 70);
		map.put("김자바", 100);
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		Iterator<Map.Entry<String, Integer>> it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Integer> e = it.next();
			String name = e.getKey();
			int score = e.getValue();
			
			System.out.println(name + " -> " + score);
		}
		
		
	}
}
