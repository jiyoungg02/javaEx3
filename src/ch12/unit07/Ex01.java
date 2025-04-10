package ch12.unit07;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("java");
		list.add("spring");
		list.add("html");
		list.add("css");
		list.add("javascript");
		
		System.out.println(list);
		
		// shuffle 구현
		int n;
		String s;
		for(int i=0; i<list.size(); i++) {
			n = (int)(Math.random()*list.size());
			
			if(i != n) {
				s = list.get(i);
				list.set(i, list.get(n));
				list.set(n, s);
			}else
				i--;
		}
		
		
		System.out.println(list);
		
	}
}
