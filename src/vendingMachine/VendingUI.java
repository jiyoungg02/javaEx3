package vendingMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VendingUI {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Vending vend = new VendingImpl();
	
	private int balance = 0;
	private int income = 0;

	public void menu() {

		int ch1;

		while (true) {
			try {
				printTitle();
				List<VendingVO> list = vend.findByAll();
				for(VendingVO vo : list) {
					printTitle_2(vo);
				}
				System.out.println();
				
				
				System.out.print("1.입금 2.출금 3.상품선택 4.종료 => ");
				// 0번 관리자메뉴
				ch1 = Integer.parseInt(br.readLine());

				if (ch1 == 4) {
					System.out.println("\n프로그램을 종료 합니다.");
					return;
				}

				switch (ch1) {
				case 0:
					Mmenu();
					break;
				case 1:
					Deposit();
					break;
				case 2:
					Withdraw();
					break;
				case 3:
					ChooseProduct();
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("원하시는 번호를 눌러주세요.");
			} catch (Exception e) {
			}
		}
	}

	VendingVO vo2 = new VendingVO();

	protected void Deposit() {
	int money;

	try {
		System.out.print("입금할 금액 [1500] ? ");
		money = Integer.parseInt(br.readLine());

		if (money < 0) {
			System.out.println("잘못 입금하셨습니다.");
			return;
		} else if(money %10 != 0) {
			System.out.println("10원단위 금액을 입금해주세요.");
			return;
		}
		balance += money;
		System.out.println("입금 완료");

		} catch (NumberFormatException e) {
			System.out.println("입금할 금액은 숫자만 입력 가능합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
	}

	protected void Withdraw() {
		int dr_ch;
		System.out.println("\n[잔돈반환]");
		if (balance == 0) {
			System.out.println("잔돈이 없습니다.");
			return;
		}

		try {
			System.out.println("잔돈 " + balance + "원을 반환 하시겠습니까?");
			System.out.print("1. 반환하기 2. 취소하기 ?");

			dr_ch = Integer.parseInt(br.readLine());

			switch (dr_ch) {
			case 1:
				System.out.println("잔돈 " + balance + "원 반환 합니다.");
				balance = 0;
				
			case 2:
				System.out.println("반환이 취소되었습니다.");
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	protected void ChooseProduct() {
	
		try {	
			String number;
			System.out.print("\n상품번호를 입력하세요 => ");
			number = br.readLine();

			Integer.parseInt(number); // 문자를 숫자로 형변환, 숫자가 아닌 문자가 입력되면 NumberFormatException 발생

			VendingVO item = vend.findById(number);

			if (item == null) {
				System.out.println("잘못된 번호입니다.");
			} else {
				if (item.getEA() == 0) {
					System.out.println("재고가 부족합니다.");
				} else if (item.getPrice() > balance) {
					System.out.println("금액이 부족합니다.");
				} else {
					System.out.println("상품을 받아주세요.");
					item.setEA(item.getEA() - 1);
					balance -= item.getPrice();
					
					income += item.getPrice();
					
				}
			}

		} catch (NumberFormatException e) {
			System.out.println("원하시는 번호를 눌러주세요.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void ProductList() {
		System.out.println("\n제품 리스트");

		List<VendingVO> list = vend.findByAll();

		Comparator<VendingVO> comp = new Comparator<VendingVO>() {

			@Override
			public int compare(VendingVO o1, VendingVO o2) {
				return -o1.getNumber().compareTo(o2.getNumber());
			}
		};
		Collections.sort(list, comp);

		for (VendingVO vo : list) {
			System.out.println(vo);
		}
		System.out.println();

	}

	public void Mmenu() { // 관리자 메뉴

		int ch2;
		System.out.println();
		while(true) {
			try {
				System.out.print("\n1.품목 재고 확인 2.품목 등록 3.품목 수정 4.품목 수량 변경" 
						+ "\n5.품목 삭제 6.금액 확인 7.출금 8.구매자 메뉴 돌아가기 9.종료 => ");
				ch2 = Integer.parseInt(br.readLine());
						
				if(ch2 == 9) {
					System.out.println("\n프로그램을 종료 합니다.");
					System.exit(0);
				}
				
				switch(ch2) {
				case 1: mProductlist(); break; 
				case 2: minsert(); break; 
				case 3: mupdate(); break; 
				case 4: updateEa(); break;
				case 5: mdelete(); break;				
				case 6: mshowmoney(); break;
				case 7: mWithdraw(); break;
				case 8: menu(); break;
				}
				
			} catch (NumberFormatException e) {
				System.out.println("원하시는 번호를 눌러주세요.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void mProductlist() {
		System.out.println("품목재고 리스트");
		int ch;

		while (true) {
			try {
				do {
					System.out.print("1.전체 재고 확인 2.상품 검색 3.메뉴로 돌아가기 => ");
					ch = Integer.parseInt(br.readLine());
				} while (ch < 1 || ch > 3);

				switch (ch) {
				case 1:mProductfulllist();break;
				case 2:mProductname();break;
				case 3:Mmenu();break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println();
		}
	}

	protected void mProductfulllist() {
		System.out.println("\n품목재고 전체 리스트");
		
		List<VendingVO> list = vend.findByAll();
		
		Comparator<VendingVO> comp = new Comparator<VendingVO>() {
			
			@Override
			public int compare(VendingVO o1, VendingVO o2) {
				return o1.getNumber().compareTo(o2.getNumber());
			}
		};
		Collections.sort(list, comp);
		
		System.out.println("------------------------------");
		System.out.println("제품번호\t제품이름\t상품가격\t제품재고");
		System.out.println("------------------------------");
		for(VendingVO vo : list) {
			printTitle_3(vo);
		}
		
		System.out.println();
		
	}

	protected void mProductname() {
		System.out.println("\n품목이름 재고검색");
		
		String name;
		try {
			System.out.print("품목 이름 ? ");
			name = br.readLine();
			
			List<VendingVO> list = vend.findByName(name);
			if(list.size() == 0) {
				System.out.println("등록된 품목이 없습니다.");
				return;
			}
			
			System.out.println("------------------------------");
			System.out.println("제품번호\t제품이름\t상품가격\t제품재고");
			System.out.println("------------------------------");
			for(VendingVO vo : list) {
				printTitle_3(vo);
				
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		return;
	}

	protected void minsert() {
		System.out.println("\n자판기 품목등록");
		
		try {
			VendingVO vo = new VendingVO();
		
			System.out.print("품목 번호 ? ");				
			vo.setNumber(br.readLine());
			
			if(vend.findByNumber(vo.getNumber()) != null) {
				System.out.println("등록된 자료입니다.\n");
				return;
			}
		
			System.out.print("품목 이름 ? ");
			vo.setName(br.readLine());
			
			System.out.print("품목 가격 ? ");
			vo.setPrice(Integer.parseInt(br.readLine()));
		
			System.out.print("재고 갯수 ? ");
			vo.setEA(Integer.parseInt(br.readLine()));
			
			vend.insertVending(vo);
		
			System.out.println("품목이 등록 되었습니다.\n");
			
		
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력 가능합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void mupdate() {
		System.out.println("\n자판기 품목 수정");
		
		try {
			String number, name;
			
			System.out.print("수정할 품목 번호 : ");
			number = br.readLine();
			
			VendingVO vo = vend.findByNumber(number);
			if(vo == null) {
				System.out.println("등록된 품목 번호가 아닙니다.");
				return;
			}
			
			System.out.println("새로운 품목 번호 ? ");
			number = br.readLine();
			
			System.out.print("새로운 품목명 ? ");
			name = br.readLine();
			VendingVO vo1 = vend.findById(number, name);
			
			if(vo1 != null && vo != vo1) {
				System.out.println("등록된 정보 입니다.\n");
				return;
			}
			
			vo.setNumber(number);
			vo.setName(name);
			
			System.out.print("새로운 가격 ? ");
			vo.setPrice(Integer.parseInt(br.readLine()));
			
			System.out.print("새로운 수량 ? ");
			vo.setEA(Integer.parseInt(br.readLine()));
			
			System.out.println("수정이 완료 되었습니다.");
			
			
		} catch (NumberFormatException e) {
			System.out.println("숫자만 가능합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	protected void mdelete() {
		System.out.println("\n자판기 품목 삭제");
		String number;
		
		List<VendingVO> list = vend.findByAll();
		printTitle();
		for (VendingVO vo : list) {
			System.out.println(vo);
		}
		
		try {
			System.out.print("삭제할 상품번호 ? ");
			number = br.readLine();
			
			
			boolean b = vend.deleteVending(number);
			if(b) {
				System.out.println("품목을 삭제했습니다.");
			} else {
				System.out.println("등록된 품목이 아닙니다.");
			}
									
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();

	}


	protected void mshowmoney() {
		System.out.println("금액확인");
		if ((balance+income) == income) {
			System.out.printf("자판기 저금액 : %,d원\n", balance+income);
		} else {
			System.out.printf("자판기 저금액 : %,d원 \n(수익금 : %,d원)\n", balance+income,income);
		}
		
	}
	
	protected void mWithdraw() {
		System.out.println("출금");
				
		try {
			if((balance+income) == income) {
				System.out.println("현재 금액 = " + (balance + income) + "원");
			} else {
				System.out.println("현재 금액 = " + (balance + income) + "원"+ "\n (수익금 : " + income +"원)" );
			}
			
			
			if(income == 0) {
				System.out.println("금액이 0원입니다. 출금할 수 없습니다.");
				return;
			}
			
			System.out.print("출금 할 금액 ? ");
			int amount = Integer.parseInt(br.readLine());
			
			if(amount < 0) {
				System.out.println("출금할 금액이 적습니다.");
				return;
			}
			if(amount > income) {
				System.out.println("출금할 금액이 많습니다.");
				return;
			}
			
			income -= amount;
			
			System.out.println("출금 완료 : 출금 금액 => " + (balance + income)+ "원");
	
			
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printTitle() {
		System.out.println("---------------------------------");
		System.out.println("제품번호\t제품이름\t상품가격\t 상품여부");
		System.out.println("---------------------------------");
	}
	
	private void printTitle_2(VendingVO vo) {
		System.out.print(vo.getNumber() + "\t");
		System.out.print(vo.getName() + "\t");
		System.out.print(vo.getPrice() + "\t");
		if(vo.getEA() == 0 ) {
			System.out.println("X");
		} else {
			System.out.println("O");
		}	
	}
	
	private void printTitle_3(VendingVO vo) {
		System.out.print(vo.getNumber() + "\t");
		System.out.print(vo.getName() + "\t");
		System.out.print(vo.getPrice() + "\t");
		System.out.println(vo.getEA() + "\t");			
	}
	
	private void updateEa() {
		try {
			String number;
			String edit;
			int ea;
			
			System.out.print("수량변경할 품목 번호 ? ");
			number = br.readLine();
			VendingVO vo = vend.findByNumber(number);
			if(vo == null) {
				System.out.println("등록된 품목 번호가 아닙니다.");
				return;
			}
			System.out.print("새로운 수량 ? ");
			edit = br.readLine();
			
			if(edit.startsWith("-")) {
				edit = edit.replace("-", "");
				ea = Integer.parseInt(edit);
				ea = vo.getEA() - ea;
			}else {
				ea = Integer.parseInt(edit);
				ea = vo.getEA() + ea;
			}
			
			if(ea < 0) {
				System.out.println("현재 수량보다 입력한 값이 더 큽니다.");
				return;
			}
			
			vo.setEA(ea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}