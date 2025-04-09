package ch12.unit02;

import java.util.Vector;

public class Ex07_Vector {
	public static void main(String[] args) {
		// ArrayList : 동기화 지원 안함
		// Vector : 동기화 지원
		
		// List<String> list = new Vector<>();
		Vector<String> list = new Vector<>();
		
		System.out.println("초기용량 : " + list.capacity()); // 10
		
		list.add("a1");
		list.add("a2");
		list.add("a3");
		list.add("a4");
		list.add("a5");
		list.add("a6");
		list.add("a7");
		list.add("a8");
		list.add("a9");
		list.add("a10");
		list.add("a11");
		list.add("a12");
		list.add("a13");
		list.add("a14");
		list.add("a15");
		
		System.out.println("개수:" + list.size()); // 15
		System.out.println("용량:" + list.capacity()); //20
			// 부족하면 10개씩 증가
		
		list.add(0, "korea");
		System.out.println(list);
		
		System.out.println("처음:" + list.get(0));
		System.out.println("처음:" + list.firstElement());
		System.out.println("처음:" + list.getFirst());
		
		System.out.println("마지막:" + list.get(list.size()-1));
		System.out.println("마지막:" + list.lastElement());
		System.out.println("마지막:" + list.getLast());
		
		list.set(0, "대한민국");
		System.out.println(list);
		
		list.remove(3);
		list.remove("a7");
		list.remove("a15");
		System.out.println("개수:" + list.size()); // 13
		System.out.println("용량:" + list.capacity()); // 20
		
		list.trimToSize(); // 용량을 개수로 조정
		System.out.println("용량:" + list.capacity()); // 13
		
		list.clear();
		
	}
}
