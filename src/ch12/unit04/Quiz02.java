package ch12.unit04;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Quiz02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count;
		
		try {
			System.out.print("구매 개수 ? ");
			count = sc.nextInt();
			
			for(int i = 1; i<=count; i++) {
				Set<Integer> set = lotto();
				System.out.printf("%2d 게임", i);
				print(set);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
		
	}
	
	public static Set<Integer> lotto(){
		Set<Integer> set = new TreeSet<Integer>();
		Random rnd = new Random();
		int n;
		
		while(set.size() < 6) {
			n = rnd.nextInt(45) + 1;
			set.add(n);
		}
		
		return set;
	}
	
	public static void print(final Set<Integer> set) {
		for(Integer n : set) {
			System.out.printf("%4d", n);
		}
		System.out.println();
	}
}
