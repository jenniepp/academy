package com.score3;

import java.io.IOException;

public interface Score {
	
	public int input() throws IOException;		//입력/ 예외처리 해달라고 할때저렇게 씀
	public void print();	//출력
	public void deleteHak();
	public void searchHak();
	public void searchName();
	public void descSortTot();
	public void ascSortHak();
	
	//인터페이스니까 얘를 받은 클래스에 꼭들어가야할 추상메소드들 넣어주기
	
	

}
