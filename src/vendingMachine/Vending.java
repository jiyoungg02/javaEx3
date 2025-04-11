package vendingMachine;

import java.util.List;

public interface Vending {
	public void insertVending(VendingVO vo);
	public VendingVO findById(String number, String name);
	public List<VendingVO> findByAll();
	public List<VendingVO> findByName(String name);
	boolean deleteVending(String number);

	// 입금 등록
	VendingVO findByNumber(String number);
	
	// 오버로딩 인터페이스
	public VendingVO findById(String number);
}

