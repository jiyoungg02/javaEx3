package ch12.unit02;

import java.util.List;

public class Ex05_immutable {
	public static void main(String[] args) {
		// 불변 Collection(JDK 9)
		List<String> list = List.of("A", "B", "D");
		System.out.println(list);
		
		// list.add("C"); // 런타임오류
		// list.set(2, "C"); // 런타임오류
		// 수정, 삭제 등 모두 불가. 변경할 수 없음
		
	}
}
