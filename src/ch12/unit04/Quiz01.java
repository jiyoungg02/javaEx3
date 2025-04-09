package ch12.unit04;

import java.util.Set;
import java.util.TreeSet;

public class Quiz01 {
	public static void main(String[] args) {
		// Lotto : 1~45 까지 6개
		
		Set<Integer> lotto = new TreeSet<Integer>();
		while(lotto.size()<6) {
			lotto.add((int)(Math.random()*45)+1);
		}
		System.out.println(lotto);
	}
}
