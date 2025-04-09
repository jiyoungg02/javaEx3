package ch12.unit02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex06 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "X", "B", "C", "X", "B", "A", "M", "B");
		System.out.println(list);
		
		// 중복 배제하여 새로운 리스트에 담기
		List<String> list2 = new ArrayList<String>();
		
		/*
		for(String l : list) {
			if(list2.contains(l)) {
				continue;
			}
			list2.add(l);
		}
		System.out.println(list2);
		*/
		
		for(int i=0; i<list.size(); i++) {
			if(list.indexOf(list.get(i)) == i) {
				list2.add(list.get(i));
			}
		}
		System.out.println(list2);
		
	}
}
