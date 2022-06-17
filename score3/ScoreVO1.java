package com.score3;

public class ScoreVO1 {//Value Object
	
	//외부에서 접근 못하게 하고 싶은 데이터는 private(=외부에서 수정을 못하게 해주는 private)
	//그래서 이제 디폴트는 private로 설정할거다
	
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;		//얘는 개터세터에서 set하는 경우가 없음 get만함.
	
	
	
	
	
	
	public int getTot() {
		return kor+eng+mat;
	}




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




	@Override
		public String toString() {
			

		if(hak==null||hak.equals("")) {
			return null;
		}
		
		String str=String.format("%5ds %6s %4d %4d %4d %4d %4.1f",
				hak,name,kor,eng,mat,getTot(),getTot()/3.0);
	
	
	return str;
		
	
	
	}
}
