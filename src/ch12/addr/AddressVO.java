package ch12.addr;

import java.util.Calendar;

// 이름, 전화번호, 생년월일, 주소, 등록일
public class AddressVO {
	private String name;
	private String tel;
	private String birth;
	private String age;
	private String address;
	private String startDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		String birth = getBirth();
		
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate() {
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH) + 1;
		int d = cal.get(Calendar.DATE);
		
		this.startDate = String.format("%4d-%2d-%2d", y, m ,d);
	}
	
	@Override
	public String toString() {
		if(name == null || tel == null) {
			return null;
		}
		
		String s = null;
		
		s = String.format("%s\t%s\t%s\t%s\t%s\t%s", 
				name, tel, birth, age, address, startDate);
		
		return s;
	}
	
}
