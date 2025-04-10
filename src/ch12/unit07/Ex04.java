package ch12.unit07;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] aa = new String[] {
				"남1", "남2", "남3", "남4", "남5", "남6", "남7"
		};
		
		String[] bb = new String[] {
				"여1", "여2", "여3", "여4", "여5", "여6", "여7",
				"여8", "여9", "여10", "여11", "여12", "여13"
 		};
		
		String[] cc = null;
		String [][]group;
		
		int total, groupCount;
		int ratio, groupInwon;
		
		try {
			total = aa.length + bb.length; // 전체 인원수
					
			System.out.print("몇조로 만들까요 ? ");
			groupCount = sc.nextInt();
			
			if(groupCount > total) {
				System.out.println("전체 인원수보다 조의 수가 많을 수 없습니다.");
				return;
			}
			
			System.out.print("남성과 여성의 비율은 어떻게 할까요[1:같은비율, 2:무작위] ? ");
			ratio = sc.nextInt();
			if(ratio<1 || ratio>2) {
				System.out.println("비율은 1 또는 2만 가능합니다.");
				return;
			}
			
			// 한조당 최대 인원수
			groupInwon = total % groupCount == 0 ? total / groupCount : total / groupCount + 1;
			
			cc = new String[total];
			group = new String[groupCount][groupInwon];
			
			if(ratio == 1) {
				// 같은 비율
				Collections.shuffle(Arrays.asList(aa));
				Collections.shuffle(Arrays.asList(bb));
				
				System.arraycopy(aa, 0, cc, 0, aa.length);
				System.arraycopy(bb, 0, cc, aa.length, bb.length);
				
			}else {
				// 무작위 
				System.arraycopy(aa, 0, cc, 0, aa.length);
				System.arraycopy(bb, 0, cc, aa.length, bb.length);
				
				Collections.shuffle(Arrays.asList(cc));
				
			}

			int n = 0;
			gogo:
			for(int col=0; col<groupInwon; col++) {
				for(int row=0; row<groupCount; row++) {
					group[row][col] = cc[n++];
					if(n >= cc.length) {
						break gogo;
					}
				}
			}
			
			System.out.println("\n편성된 조원...");
			for(int i=0; i<group.length; i++) {
				System.out.printf("%2d 조 :", (i+1));
				for(int j=0; j<group[i].length; j++) {
					if(group[i][j] != null) {
						System.out.print(group[i][j] + " ");
					}
				}
				System.out.println();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
}
