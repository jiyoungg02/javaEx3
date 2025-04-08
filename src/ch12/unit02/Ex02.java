package ch12.unit02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ex02 {
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

		// 전체 출력-1
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		// 전체 출력-2
		for(String s : list) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		// 전체 출력-3 : 반복자
		// Iterator : 순방향만 가능
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.print(s + " ");
		}
		System.out.println();
		
		// 전체 출력-4 : 반복자
		// ListIterator : 순방향과 역방향 가능
		ListIterator<String> it2 = list.listIterator();
		while(it2.hasNext()) {
			String s = it2.next();
			System.out.print(s + " ");
		}
		System.out.println();
		
		// 전체 역방향-1
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		// 전체 역방향-2
		ListIterator<String> it3 = list.listIterator(list.size());
		while(it3.hasPrevious()) {
			String s = it3.previous();
			System.out.print(s + " ");
		}
		System.out.println();
		
		// 전체 삭제
		list.clear();
		System.out.println("모두 삭제후 개수: " + list.size());
	}
}
