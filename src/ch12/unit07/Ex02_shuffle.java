package ch12.unit07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex02_shuffle {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();

		list.add("java");
		list.add("spring");
		list.add("html");
		list.add("css");
		list.add("javascript");
		
		System.out.println(list);
		
		// List shuffle(무작위로 섞기)
		Collections.shuffle(list);
		
		System.out.println(list);
		
	}
}
