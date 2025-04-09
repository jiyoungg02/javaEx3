package ch12.score2;

public class ScoreVO {
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	public String getHak() {
		return hak;
	}
	public void setHak(String hak) {
		this.hak = hak;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public int getTot() {
		return kor + eng + mat;
	}
	
	public int getAve() {
		return getTot() / 3;
	}
	
	@Override
	public String toString() {
		if(hak == null || name == null) {
			return null;
		}
		
		String s = null;
		
		s = String.format("%s\t%s\t%d\t%d\t%d\t%d\t%d", 
				hak, name, kor, eng, mat, getTot(), getAve());
		
		return s;
	}
	
}
