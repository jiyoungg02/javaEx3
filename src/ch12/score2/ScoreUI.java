package ch12.score2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ScoreUI {
	private BufferedReader br = 
			new BufferedReader(new InputStreamReader(System.in));
	
	private Score ss = new ScoreImpl();
	
	public void menu() {
		System.out.println("\t>> 성적처리 <<");
		
		int ch;
		
		while(true) {
			try {
				do {
					System.out.print("1.등록 2.수정 3.삭제 4.학번검색 5.이름검색 6.전체리스트 7.종료 => ");
					ch = Integer.parseInt(br.readLine());
				} while(ch < 1 || ch > 7);
				
				if(ch == 7) {
					System.out.println("\n프로그램을 종료합니다...");
					return;
				}
				
				switch(ch) {
				case 1: append(); break;
				case 2: update(); break;
				case 3: delete(); break;
				case 4: searchHak(); break;
				case 5: searchName(); break;
				case 6: listAll(); break;
				}
				
			} catch (Exception e) {
				
			}
		}
		
	}
	
	protected void append() {
		System.out.println("\n[데이터 등록]");
		
		try {
			ScoreVO vo = new ScoreVO();
			
			System.out.print("학번 ? ");
			vo.setHak(br.readLine());
			
			System.out.print("이름 ? ");
			vo.setName(inputName());
			
			System.out.print("국어 ? ");
			vo.setKor(inputScore());
			
			System.out.print("영어 ? ");
			vo.setEng(inputScore());
			
			System.out.print("수학 ? ");
			vo.setMat(inputScore());
			
			ss.insertScore(vo);

			System.out.println("데이터가 등록 되었습니다.");
			
		} catch (KoreanException e) {
			System.out.println("이름은 한글 두글자 이상입니다.");
		} catch (NumberFormatException e) {
			System.out.println("점수는 숫자만 입력 가능합니다.");
		} catch (ScoreException e) {
			System.out.println("점수는 0~100 사이만 가능합니다.");
		} catch (MyDuplicationException e) {
			System.out.println("등록된 학번입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}
	
	protected void update() {
		System.out.println("\n[데이터 수정]");
		
		try {
			String hak;
			System.out.print("수정할 학번 ? ");
			hak = br.readLine();
			
			ScoreVO vo = ss.findByHak(hak);
			if(vo == null) {
				System.out.println("등록된 학번이 아닙니다.\n");
				return;
			}
			
			String name;
			int k, e, m;
			
			System.out.print("새로운 이름 ? ");
			name = inputName();
			
			System.out.print("국어 ? ");
			k = inputScore();
			
			System.out.print("영어 ? ");
			e = inputScore();
			
			System.out.print("수학 ? ");
			m = inputScore();
			
			vo.setName(name);
			vo.setKor(k);
			vo.setEng(e);
			vo.setMat(m);
			
			System.out.println("데이터가 수정 되었습니다.");
			
		} catch (KoreanException e) {
			System.out.println("이름은 한글 두글자 이상입니다.");
		} catch (NumberFormatException e) {
			System.out.println("점수는 숫자만 입력 가능합니다.");
		} catch (ScoreException e) {
			System.out.println("점수는 0~100 사이만 가능합니다.");
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
			} else {
				System.out.println("등록된 학번이 아닙니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}
	
	protected void listAll() {
		System.out.println("\n[전체 리스트]");
		
		List<ScoreVO> list = ss.findByAll();
		
		System.out.println("등록인원수 : " + list.size());
		printTitle();
		for(ScoreVO vo : list) {
			System.out.println(vo);
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
			
			printTitle();
			System.out.println(vo);
			
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
				System.out.println("등록된 데이터가 없습니다.");
				return;
			}
			
			printTitle();
			for(ScoreVO vo : list) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	
	// 이름 입력
	private String inputName() throws KoreanException, IOException {
		String s = null;
		String p = "^[가-힣]{2,}$"; // 한글 2자 이상
		
		s = br.readLine();
		if(! s.matches(p)) {
			throw new KoreanException("이름은 한글만 가능 합니다.");
		}
		
		return s;
	}
	
	// 점수 입력
	private int inputScore() throws ScoreException, IOException {
		int s = 0;
		
		s = Integer.parseInt(br.readLine());
		if(s < 0 || s > 100) {
			throw new ScoreException("점수는 0~100 사이만 가능합니다.");
		}
		
		return s;
	}
	
	private void printTitle() {
		System.out.println("---------------------------------------------------");
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("---------------------------------------------------");
	}	
}
