package ch12.addr1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*
  - 데이터 등록
    : 이름, 전화번호, 생년월일, 주소, 등록일
    : 등록일은 컴퓨터 시스템의 날짜에서 yyyy-MM-dd 형식만 등록
    : 이름과 전화번호가 동일하면 등록 불가(선택사항)
    : 생년월일는 yyyy-MM-dd 형식이 아니면 등록불가(선택사항)
    
  - 데이터 출력
    : 이름 전화번호 생년월일 나이 주소 등록일
    : 나이는 생년월일을 기준으로 계산(선택사항)
    
  - 기타 자유   
*/

public class AddressUI {
	private BufferedReader br = 
			new BufferedReader(new InputStreamReader(System.in));
	private Address addr = new AddressImpl();
	
	public void menu() {
		int ch;
		
		while(true) {
			try {
				System.out.print("1.등록 2.수정 3.삭제 4.이름검색 5.전체리스트 6.종료 => ");
				ch = Integer.parseInt(br.readLine());
				
				if(ch == 6) {
					System.out.println("\n프로그램을 종료 합니다.");
					return;
				}
				
				switch(ch) {
				case 1: insert(); break;
				case 2: update(); break;
				case 3: delete(); break;
				case 4: searchName(); break;
				case 5: printAll(); break;
				}
			} catch (Exception e) {
			}
		}
		
	}
	
	protected void insert() {
		System.out.println("\n[데이터 등록]");
		
		AddressVO vo = new AddressVO();
		String s;
		
		try {
			System.out.print("이름 ? ");
			vo.setName(br.readLine());

			System.out.print("전화번호 ? ");
			vo.setTel(br.readLine());
			
			if(addr.findById(vo.getName(), vo.getTel()) != null) {
				System.out.println("등록된 자료입니다.\n");
				return;
			}
			
			System.out.print("생년월일 ? ");
			vo.setBirth(br.readLine());

			System.out.print("주소 ? ");
			vo.setAddr(br.readLine());
			
			/*
			Calendar cal =  Calendar.getInstance();
			s = String.format("%tF(%tA)", cal, cal);
			*/
			LocalDate localDate = LocalDate.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd(E)");
			s = localDate.format(dtf);
			vo.setRegDate(s);
		
			addr.insertAddress(vo);
			
			System.out.println("등록이 완료 되었습니다. !!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}
	
	protected void update() {
		System.out.println("\n[데이터 수정]");
		String name, tel;
		
		try {
			System.out.print("검색할 이름 ? ");
			name = br.readLine();

			System.out.print("검색할 전화번호 ? ");
			tel = br.readLine();
			
			AddressVO vo = addr.findById(name, tel);
			if(vo == null) {
				System.out.println("등록된 자료가 아닙니다.\n");
				return;
			}
			
			System.out.print("새로운 이름 ? ");
			name = br.readLine();

			System.out.print("전화번호 ? ");
			tel = br.readLine();
			AddressVO vo1 = addr.findById(name, tel);
			
			if(vo1 != null && vo != vo1) {
				System.out.println("등록된 정보 입니다.\n");
				return;
			}
			
			vo.setName(name);
			vo.setTel(tel);

			System.out.print("생년월일 ? ");
			vo.setBirth(br.readLine());

			System.out.print("주소 ? ");
			vo.setAddr(br.readLine());
			
			System.out.println("수정이 완료 되었습니다. !!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}
	
	protected void delete() {
		System.out.println("\n[데이터 삭제]");
		
		String name, tel;
		
		try {
			System.out.print("삭제할 이름 ? ");
			name = br.readLine();

			System.out.print("삭제할 전화번호 ? ");
			tel = br.readLine();
			
			boolean b = addr.deleteAddress(name, tel);
			if(! b) {
				System.out.println("등록된 자료가 아닙니다.\n");
				return;
			}
			
			System.out.println("자료가 삭제 되었습니다. !!!");			
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
			
			List<AddressVO> list = addr.findByName(name);
			
			if(list.size() == 0) {
				System.out.println("등록된 자료가 없습니다.\n");
				return;
			}
			
			System.out.println("이름\t생년월일\t\t전화번호\t\t주소\t등록일");
			System.out.println("----------------------------------------------------------------------");
			for(AddressVO vo : list) {
				print(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}
	
	protected void printAll() {
		System.out.println("\n[전체 리스트]");
		
		List<AddressVO> list = addr.findByAll();
		System.out.println("이름\t생년월일\t\t전화번호\t\t주소\t등록일");
		System.out.println("----------------------------------------------------------------------");
		for(AddressVO vo : list) {
			print(vo);
		}
		System.out.println();
	}
	
	private void print(AddressVO vo) {
		System.out.print(vo.getName() + "\t");
		System.out.print(vo.getBirth() + "\t");
		System.out.print(vo.getTel() + "\t");
		System.out.print(vo.getAddr() + "\t");
		System.out.println(vo.getRegDate());
	}
}
