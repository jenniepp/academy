package com.score4;

public class ScoreVO {//value값이 될거야 key는 학번으로 만들거야
	
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	
	//학번으로 key할거니까 그건 빼고 만든다
	
	
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
		return kor+eng+mat;
	}
	
	@Override
		public String toString() {
		
		String str=String.format("%6s %4d %4d %4d %4d %4.1f",
				name,kor,eng,mat,getTot(),getTot()/3.0);
		
				return str;
		}
	

	
	
	
	

}
