package ch12.score3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoreUI {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Score ss = new ScoreImpl();
	
	public void menu() {
		int ch;
		
		while(true) {
			try {
				System.out.println("1.등록 2.수정 3.삭제 4.학번검색 5.이름검색 6.총점내림차순 7.이름오름차순 8.학번순 9.종료");
				System.out.print("선택 => ");
				ch = Integer.parseInt(br.readLine());
				
				if(ch == 9) {
					System.out.println("\n프로그램 종료...");
					return;
				}
				
				switch(ch) {
				case 1: insert(); break;
				case 2: update(); break;
				case 3: delete(); break;
				case 4: searchHak(); break;
				case 5: searchName(); break;
				case 6: sortTot(); break;
				case 7: sortName(); break;
				case 8: sortHak(); break;
				}
				
			} catch (Exception e) {
				
			}
		}
	}
	
	protected void insert() {
		System.out.println("\n[데이터 등록]");
		
		try {
			ScoreVO vo = new ScoreVO();
			
			System.out.print("학번 ? ");
			vo.setHak(br.readLine());
			
			if(ss.findByHak(vo.getHak()) != null) {
				System.out.println("등록된 학번입니다.\n");
				return;
			}
			
			System.out.print("이름 ? ");
			vo.setName(br.readLine());
			
			System.out.print("국어 ? ");
			vo.setKor(Integer.parseInt(br.readLine()));
			
			System.out.print("영어 ? ");
			vo.setEng(Integer.parseInt(br.readLine()));
			
			System.out.print("수학 ? ");
			vo.setMat(Integer.parseInt(br.readLine()));
			
			ss.insertScore(vo);
			
			System.out.println("데이터가 등록되었습니다.");
			
		} catch (NumberFormatException e) {
			System.out.println("점수는 숫자만 가능합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}
	
	protected void update() {
		System.out.println("\n[데이터 수정]");
		
			String hak;
			String name;
			int kor, eng, mat;
			
		try {
			
			System.out.print("수정할 학번 ? ");
			hak = br.readLine();
			
			ScoreVO vo = ss.findByHak(hak);
			if(vo == null) {
				System.out.println("등록된 학번이 아닙니다.\n");
				return;
			}
			
			System.out.print("새로운 이름 ? ");
			name = br.readLine();
			
			System.out.print("국어 ? ");
			kor = Integer.parseInt(br.readLine());
			
			System.out.print("영어 ? ");
			eng = Integer.parseInt(br.readLine());
			
			System.out.print("수학 ? ");
			mat = Integer.parseInt(br.readLine());
					
			vo.setName(name);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMat(mat);

			System.out.println("데이터가 수정이 되었습니다.");
			
			
		} catch (NumberFormatException e) {
			System.out.println("점수는 숫자만 가능합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	protected void delete() {
		System.out.println("\n[데이터 삭제]");
		
		String hak;
		
		try {
			System.out.print("삭제할 학번 ? ");
			hak = br.readLine();
			
			boolean b = ss.deleteScore(hak);
			
			if(b) {
				System.out.println("데이터가 삭제되었습니다.");
			}else {
				System.out.println("등록된 학번이 아닙니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		
	}
	
	protected void searchHak() {
		System.out.println("\n[학번 검색]");
		
		String hak;
		
		try {
			System.out.print("검색할 학번 ? ");
			hak = br.readLine();
			
			ScoreVO vo = ss.findByHak(hak);
			if(vo == null) {
				System.out.println("등록된 학번이 아닙니다.\n");
				return;
			}
			
			print(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	protected void searchName() {
		System.out.println("\n[이름 검색]");
		
		String name;
		
		try {
			System.out.print("검색할 이름 ? ");
			name = br.readLine();
			
			List<ScoreVO> list = ss.findByName(name);
			
			if(list.size() == 0) {
				System.out.println("등록된 데이터가 없습니다.\n");
				return;
			}
			
			for(ScoreVO vo : list) {
				print(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	protected void sortTot() {
		System.out.println("\n[총점 내림차순]");
		
		List<ScoreVO> list = ss.findByAll();
		
		// 이름 오름차순
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				return -(o1.getTot()-o2.getTot());
			}
		};
		Collections.sort(list, comp);
		
		for(ScoreVO vo : list) {
			print(vo);
		}
		System.out.println();
	}
	
	protected void sortName() {
		System.out.println("\n[이름 오름차순]");
		
		List<ScoreVO> list = ss.findByAll();
		
		// 이름 오름차순
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(list, comp);
		
		for(ScoreVO vo : list) {
			print(vo);
		}
		System.out.println();
	}

	protected void sortHak() {
		System.out.println("\n[학번 오름차순]");
		
		List<ScoreVO> list = ss.findByAll();
		
		// 학번오름차순
		Comparator<ScoreVO> comp = new Comparator<ScoreVO>() {
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				return o1.getHak().compareTo(o2.getHak());
			}
		};
		Collections.sort(list, comp);
		
		for(ScoreVO vo : list) {
			print(vo);
		}
		System.out.println();
	}
	
	private void print(ScoreVO vo) {
		System.out.print(vo.getHak() + "\t");
		System.out.print(vo.getName() + "\t");
		System.out.print(vo.getKor() + "\t");
		System.out.print(vo.getEng() + "\t");
		System.out.print(vo.getMat() + "\t");
		System.out.print(vo.getTot() + "\t");
		System.out.println(vo.getAve());
	}
}
