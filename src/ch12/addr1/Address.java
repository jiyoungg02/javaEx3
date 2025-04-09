package ch12.addr1;

import java.util.List;

public interface Address {
	public void insertAddress(AddressVO vo);
	public AddressVO findById(String name, String tel);
	public List<AddressVO> findByAll();
	public List<AddressVO> findByName(String name);
	public boolean deleteAddress(String name, String tel);
}
