package com.score3;

public class ScoreVO {	//ValueObject
	
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;	
	
	//private 변수설정
	
	public int getTot() {	//int형태의 return값을 반환해라 그건 kor+eng+mat이다
		return kor+eng+mat;
	}


	public String getHak() {	//이건 hak을 내보내라
		return hak;
	}


	public void setHak(String hak) {	//String형태의 hak을 입력받아서 그걸 이 클래스에 있는hak에다가 넣어라
		this.hak = hak;
	}




	public String getName() {	//name으로 내보내라
		return name;
	}

	
	public void setName(String name) {	//name을 받아서 이 클래스의 name에다가 넣어라
		this.name = name;
	}


	public int getKor() {	//kor내보내라
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


	public void setMat(int mat) {		//아 위아래가 세트인거다. set을 통해서 받은  외부의 mat값을 이 클래스mat값에다가 넣고 왜냐면 private변수라 외부에서 값ㅇ르 수정을 못하니까 이 클래스안의 메소드를통해서 고쳐주는거지
		this.mat = mat;					//그걸 한뒤에 getMat를 통해서 이 클래스의 mat 값을 내보내주는거 오~~~~
	}
	
	
	
	@Override
	public String toString() {
		
		if(hak==null||hak.equals("")) {	//string은 비교할때 오류가 종종나서 이렇게 둘다 해주기도 함
			return null;				//여기선 아직 컬랙션 사용안됐으니까 그냥 우리 평소에 하던대로 하는거임 헷갈리지 말자!!!
		}
		
		String str=String.format("%5s %6s %4d %4d %4d %4d %4.1f",
				hak,name,kor,eng,mat,getTot(),getTot()/3.0);
	
	
	return str;
	}
	
	
	//이 페이지에서 private으로 설정한 변수들을 어떻게 수정하고 내보낼지 메소드들로 정의하고 toString을 통해서 어떤 형태로 출력할지 결정해주기

}
