package vendingMachine;

import java.util.List;

public interface Vending {
	public void insertVending(VendingVO vo);
	public VendingVO findById(String number, String name);
	public List<VendingVO> findByAll();
	public List<VendingVO> findByName(String name);
	boolean deleteVending(String number);

	// 자판기 보관액 리스트
	public List<VendingVO> MoneyAll();
	// 입금 등록
	public void vinsertVending(VendingVO vo2);
	VendingVO findByNumber(String number);
	
	// 오버로딩 인터페이스
	public VendingVO findById(String number);
}

