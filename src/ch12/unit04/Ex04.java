package ch12.unit04;

import java.util.Set;

public class Ex04 {
	public static void main(String[] args) {
		// 불변 Collection : JDK 9
		Set<String> set = Set.of("자바", "오라클", "스프링");
		System.out.println(set);
		
		// set.add("HTML"); // 런타임오류
		
	}
}
