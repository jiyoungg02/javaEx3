package vendingMachine;

public class VendingVO {
	private String number; //제품 번호
	private String name; //이름
	private int money; // 돈
	private int vmoney; // 자판기에 들어있는 돈
	private int v2money; // 추가 ㅁㅁㅁㅁ
	private int ea; //재고 갯수
	private int price; //상품가격
	private int income; // 수익금
	
	public int getV2money() {// 추가 ㅁㅁㅁㅁ
		return v2money;// 추가 ㅁㅁㅁㅁ
	}
	public void setV2money(int v2money) {// 추가 ㅁㅁㅁㅁ
		this.v2money = v2money;// 추가 ㅁㅁㅁㅁ
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public int setMoney(int money) { //추가
		return this.money = money;
	}
	public int getEA() {
		return ea;
	}
	public void setEA(int ea) {
		this.ea = ea;
	}
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getvMoney() {
		return vmoney;
	}
	
	public void setvMoney(int money) {
		this.vmoney = money;
	}


	@Override

	public String toString() {
	
		if(number == null || name == null) {
			return null;
		}
		String s = null;
		s = String.format("%s\t%s\t%d\t%d", number, name, price, ea);
	
		return s;
	}
}
	
	

	
	

