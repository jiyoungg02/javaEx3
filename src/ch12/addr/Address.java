package ch12.addr;

import java.util.List;

import ch12.addr2.MyDuplicationException;

public interface Address {
	public void insertAddress(AddressVO vo) throws MyDuplicationException;
	public AddressVO findById(String name, String tel);
	public List<AddressVO> findByAll();
	public List<AddressVO> findByName(String name);
	public boolean deleteAddress(String name, String tel);
	
}
