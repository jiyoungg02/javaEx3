package vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingImpl implements Vending {
	private List<VendingVO> list = new ArrayList<VendingVO>();
	
	@Override
	public void insertVending(VendingVO vo) {
		list.add(vo);
		
	}

	@Override
	public VendingVO findById(String number, String name) {
		for(VendingVO vo : list) {
			if(vo.getNumber().equals(number) && vo.getName().equals(name)) {
				return vo;
			}
		}
		return null;
	}
	
	// findById 오버로딩
	public VendingVO findById(String number) {
		for(VendingVO vo : list) {
	        if(vo.getNumber().equals(number)) {
	           return vo;
	        }
	     }
		return null;
	}
	

	@Override
	public List<VendingVO> findByAll() {
		return list;
	}

	@Override
	public VendingVO findByNumber(String number) {
		for(VendingVO vo : list) {
			if(vo.getNumber().equals(number)) {
				return vo;
			}
		}
		return null;	
		
	}
	@Override
	public List<VendingVO> findByName(String name) {
		List<VendingVO> searchList = new ArrayList<VendingVO>();
		
		for(VendingVO vo : list) {
			if(vo.getName().contains(name)) {
				searchList.add(vo);
			}
		}
		return searchList;
	}

	@Override
	public boolean deleteVending(String number) {
		VendingVO vo = findById(number);
		return list.remove(vo);
	}
	
}