package com.score3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class ScoreImpl1 implements Score{

	private ArrayList<ScoreVO1> lists = new ArrayList<>();
	//자주쓰는 코딩이니까 기억하삼
	
	Scanner sc= new Scanner(System.in);	//공통으로 빼주기
	
	@Override
	public int input() {
		
		int result = 0;
		
		
		
		ScoreVO1 vo=new ScoreVO1();
		
		System.out.println("학번?");
		String hak=sc.next();	//hak을 scorevo에 저장함 여기서 설정한 변수가 아님. 그럼 결국에 scorevo를 연결해야하니까 객체생성하기
		
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		System.out.println("국어?");
		vo.setKor(sc.nextInt());
		
		System.out.println("영어?");
		vo.setEng(sc.nextInt());
		
		System.out.println("수학?");
		vo.setMat(sc.nextInt());
		
		lists.add(vo);
		
		return result;
	}
	
	@Override
	public void print() {
		
		Iterator<ScoreVO1> it = lists.iterator();
		while(it.hasNext()) {
			
			ScoreVO1 vo=it.next();
			
			System.out.println(vo.toString());
			
			/*System.out.printf("%5s %6s %4d %4d %4d %4d %4.1f ",
					vo.getHak(),vo.getName(),vo.getKor(),
					vo.getEng(),vo.getMat(),(vo.getKor()+vo.getEng()+vo.getMat()),
					(vo.getKor()+vo.getEng()+vo.getMat())/3.0);
			*/
		}
	}
	
	
	@Override
	public void deleteHak() {
	}
	

	@Override
	public void searchHak() {
		
		
		System.out.println("검색할 학번이 뭔가요?");
		String hak=sc.next();	// 입력한 학번 hak변수에 넣어주기
		
		Iterator<ScoreVO1> it=lists.iterator();
		while(it.hasNext()) {
			
			ScoreVO1 vo=it.next();
			
			if(hak.equals(vo.getHak())) {
				System.out.println(vo.toString());
				break;
			}
		}
		
		
		
		
	}

	@Override
	public void searchName() {
		
		
		System.out.println("검색할 이름이 뭔가요?");
		String name=sc.next();	// 입력한 학번 hak변수에 넣어주기
		
		// 위에서 부터 줄줄이 실행되는게 아니니까 여기다가도 이터레이터 넣어줘야함
		Iterator<ScoreVO1> it=lists.iterator();
		while(it.hasNext()) {
			
			ScoreVO1 vo=it.next();
			
			if(name.equals(vo.getName())) {
				System.out.println(vo.toString());
				break;
			}
		}
		
		
		
		
		
		
		
	}

	@Override
	public void descSortTot() {
		
		//정렬하는 방법 만들기
		Comparator<ScoreVO1> comp= new Comparator<ScoreVO1>() {
			
			@Override
			public int compare(ScoreVO1 vo1, ScoreVO1 vo2) {
				
				return vo1.getTot()<vo2.getTot()?1:-1;
			}
		};
		
		Collections.sort(lists, comp);		//만든 방법을 이용해서 정렬끝
		
		print();	//정렬시킨거로 출력해라
		
	}

	@Override
	public void ascSortHak() {
	}

	
	
	

}
