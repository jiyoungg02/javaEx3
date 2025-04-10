package ch12.addr;

import java.util.ArrayList;
import java.util.List;

import ch12.addr2.MyDuplicationException;

public class AddressImpl implements Address {
	private List<AddressVO> list = new ArrayList<AddressVO>();

	@Override
	public void insertAddress(AddressVO vo) throws MyDuplicationException {
		if(findById(vo.getName(), vo.getTel()) != null) {
			throw new MyDuplicationException("등록된 자료 입니다.");
		}
		
		list.add(vo);
	}
	
	@Override
	public AddressVO findById(String name, String tel) {
		for(AddressVO vo : list) {
			if(vo.getName().equals(name) && vo.getTel().equals(tel)) {
				return vo;
			}
		}
		return null;
	}

	@Override
	public List<AddressVO> findByAll() {
		return list;
	}

	@Override
	public List<AddressVO> findByName(String name) {
		List<AddressVO> searchList = new ArrayList<AddressVO>();
		
		for(AddressVO vo : list) {
			if(vo.getName().indexOf(name) != -1) {
				searchList.add(vo);
			}
		}
		
		return searchList;
	}

	@Override
	public boolean deleteAddress(String name, String tel) {
		AddressVO vo = findById(name, tel);
		
		return list.remove(vo);
	}
}
