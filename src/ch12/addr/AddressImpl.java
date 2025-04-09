package ch12.addr;

import java.util.ArrayList;
import java.util.List;


public class AddressImpl implements Address {
	private List<AddressVO> list = new ArrayList<AddressVO>();

	@Override
	public void insertAddress(AddressVO vo){
		if(findById(vo.getName(), vo.getTel()) != null) {
			//throw new MyDuplicationException("등록된 사람입니다.");
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
			if(vo.getName().indexOf(name) >= 0) {
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
