package ch12.addr2;

import java.util.List;

public interface Address {
	public void insertAddress(AddressVO vo) throws MyDuplicationException;
	public AddressVO findById(String name, String tel);
	public List<AddressVO> findByAll();
	public List<AddressVO> findByName(String name);
	public boolean deleteAddress(String name, String tel);
}
