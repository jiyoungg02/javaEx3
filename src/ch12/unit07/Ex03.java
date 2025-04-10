package ch12.unit07;

import java.util.Arrays;
import java.util.Collections;

public class Ex03 {
	public static void main(String[] args) {
		String[] aa = new String[] {"java","css", "html", "javascript", "jsp", "servlet"};
		
		System.out.println(Arrays.toString(aa));
		
		// Integer[] 은 가능하지만 int[] 는 불가
		Collections.shuffle(Arrays.asList(aa));
		System.out.println(Arrays.toString(aa));
		
	}
}
