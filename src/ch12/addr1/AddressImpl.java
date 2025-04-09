package ch12.addr1;

import java.util.ArrayList;
import java.util.List;

public class AddressImpl implements Address {
	private List<AddressVO> list = new ArrayList<AddressVO>();
	
	@Override
	public void insertAddress(AddressVO vo) {
		list.add(vo);
	}

	@Override
	public AddressVO findById(String name, String tel) {
		for(AddressVO vo : list) {
			if(vo.getName().equals(name) && vo.getTel().equals(tel) ) {
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
		List<AddressVO> findList = new ArrayList<>();
		
		for(AddressVO vo : list) {
			if(vo.getName().indexOf(name) != -1) {
				findList.add(vo);
			}
		}
		
		return findList;
	}

	@Override
	public boolean deleteAddress(String name, String tel) {
		AddressVO vo = findById(name, tel);

		return list.remove(vo);
	}

	

}
