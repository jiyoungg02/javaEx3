package ch12.unit03;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class Ex01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("자바");
		list.add("오라클");
		list.add("스프링");
		list.add("리액트");
		list.add("서블릿");
		
		System.out.println("전체-1");
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		System.out.println("전체-2");
		for(String s : list) {
			System.out.print(s + " ");
		}
		System.out.println();

		System.out.println("전체-3");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.print(s + " ");
		}
		System.out.println();

		ListIterator<String> it2 = list.listIterator();
			// 순방향/역방향 가능
		System.out.println("전체-4");
		while(it2.hasNext()) {
			String s = it2.next();
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println();
		
		Vector<String> v = new Vector<String>();
		v.add("서울");
		v.add("부산");
		v.add("대구");
		
		System.out.println("벡터 전체-1");
		for(String s : v) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println("벡터 전체-2");
		for(int i = 0 ; i<v.size(); i++) {
			System.out.print(v.get(i) + " ");
		}
		System.out.println();
		
		System.out.println("벡터 전체-3");
		Iterator<String> it3 = v.iterator();
		while(it3.hasNext()) {
			String s = it3.next();
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println("벡터 전체-4");
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.print(s + " ");
		}
		System.out.println();
	
	}
}
