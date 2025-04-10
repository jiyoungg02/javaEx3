package ch12.unit07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex05_SortSearch {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("서울");
		list.add("부산");
		list.add("대구");
		list.add("인천");
		list.add("광주");
		list.add("대전");
		list.add("울산");
		list.add("세종");
		System.out.println(list);
		
		int idx;
		
		// 순차검색
		idx = list.indexOf("부산");
		System.out.println("부산 위치 : " + idx);
		
		// 크기순으로 정렬 : Comparable 인터페이스 구현 클래스만 가능
		Collections.sort(list);
		System.out.println("정렬후 : " + list);
		
		// 이분검색 : 정렬되어 있어야 가능
		// 없으면 -1
		idx = Collections.binarySearch(list, "서울");
		System.out.println("서울 위치 : " + idx);
		
		//역순 정렬
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("역순 정렬 후 : " + list);
		
	}
}
