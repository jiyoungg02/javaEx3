package ch12.unit02;

import java.util.Stack;

/*
	- Stack
	  : LIFO 구조
	  : Vector 하위 클래스
	  : 주요 메소드
	    push() : 스택에 데이터 추가
	    pop() : top 요소 반환 후 삭제
	    peek() : top 요소 반환 후 삭제하지 않음
*/

public class Ex08_Stack {
	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();
		
		st.push("자바"); // 추가
		st.push("스프링");
		st.push("오라클");
		st.push("서블릿");
		st.push("HTML");
		
		while(! st.empty()) {
			String s = st.pop();
			System.out.print(s + " ");
		}
		System.out.println();
		
	}
}
