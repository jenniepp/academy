package com.score4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreImpl implements Score {
	
	private Map<String, ScoreVO> hMap=new TreeMap<>();
	//보이는 거처럼map의 key는 스트링데이터타입, value는 scoreVO라는 클래스 타입이다 확인
	
	Scanner sc=new Scanner(System.in);
	String hak; 	//key값으로 활용될 학번string  선언해주기

	@Override
	public void input() {
		
		System.out.println("학번?");	//key값 입력
		hak=sc.next();
		
		if(searchHak(hak)) {
			System.out.println("학번이 존재합니다. 추가실패");
			return;	//리턴이랑 브레이크 차이는 뭐임????????????오 브레이크는 바복문이나 스위치문안에서만 쓰는건가바
			
		}
		
		ScoreVO vo=new ScoreVO();
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		System.out.println("국어?");
		vo.setKor(sc.nextInt());
		
		System.out.println("영어?");
		vo.setEng(sc.nextInt());
		
		System.out.println("수학?");
		vo.setMat(sc.nextInt());
		
		hMap.put(hak, vo);
		
		System.out.println("추가성공!");
	}

	@Override
	public boolean searchHak(String hak) {
		
		/*if(hMap.containsKey(hak)) {
			return true;
		}
		
		return false;*/
		
		return hMap.containsKey(hak);	//저 이프문을 그냥 이렇게 써도된다 어차피 true/false가 나올거니까
	}

	@Override
	public void print() {
		
		
		Iterator<String> it=hMap.keySet().iterator();
		
		while(it.hasNext()) {
			
			String hak = it.next();		//우리ㅏㄱ꺼낼 기준이 key니까 자료형도 key의 자료형인 String으로 맞춰준다
			ScoreVO vo= hMap.get(hak);
			
			System.out.println(hak+" "+vo.toString());	//오버라이드 된거안에서는 vo만 찍어도 주소값이 아니라 답이 나오네!! 대박~~!
			
		}
		
		
	}

	@Override
	public void delete() {
		
		Iterator<String> it=hMap.keySet().iterator();		//이게 뭔 작용을 하는 거야??? 걍 컬랙션은 어떤 비교를 하기전에 복사본을 만들어야한다고 정리하자
		System.out.println("삭제할 학번을 입력해주세요");	//이거 약간 그 의민가보다 그 keyset해서 이 map의 키값인 학번애들이 들어가 있는 모임
		String std=sc.next();
		
		if(searchHak(std)) {
			hMap.remove(std);
			//return;	
		} else System.out.println("존재하지 않는 학번입니다.");
		
		print();	
		
	}

	@Override
	public void update() {
		
		Iterator<String> it=hMap.keySet().iterator();		
		System.out.println("업데이트할 학번을 입력해주세요");
		String std=sc.next();
		
		if(searchHak(std)) {
			String hak=it.next();	//변수값 하나 선언해주고 거기다가it.next()써서 불러오기 학번을
			ScoreVO vo= hMap.get(hak);

			System.out.println("국어점수를 입력해주세요");
			vo.setKor(sc.nextInt());
			System.out.println("영어점수를 입력해주세요");
			vo.setEng(sc.nextInt());
			System.out.println("수학점수를 입력해주세요");
			vo.setMat(sc.nextInt());		
			//return;		hMap.put(hak,vo) 이거 왜해주는거임?
			}else {
				System.out.println("존재하지 않는 학번입니다.");
			}
		
		print();

	}

	@Override
	public void findHak() {

		Iterator<String> it=hMap.keySet().iterator();		
		System.out.println("검색할 학번을 입력해주세요");
		String std=sc.next();	//검색할 학번 입력받기
		//이제 vo에 저장되어 있는 값이랑 비교하려면 일단 key값인 학번을 불러와야함. 그럼 어케 불러오냐면...

		if(searchHak(std)) {
			String hak=it.next();	//변수값 하나 선언해주고 거기다가it.next()써서 불러오기 학번을
			ScoreVO vo= hMap.get(hak);
			System.out.println(hak+" "+vo);	//toString이랑 syso 이랑 print()랑 언제 쓰는지 구분이 어려움

		}




	}

	@Override
	public void findName() {
		
		Iterator<String> it=hMap.keySet().iterator();		
		System.out.println("검색할 이름을 입력해주세요");
		String stdname=sc.next();	//검색할 학번 입력받기
		//이제 vo에 저장되어 있는 값이랑 비교하려면 일단 key값인 학번을 불러와야함. 그럼 어케 불러오냐면...
		
		boolean flag=false;
		
		
		while(it.hasNext()) {
			String hak=it.next();	//변수값 하나 선언해주고 거기다가it.next()써서 불러오기 학번을
			ScoreVO vo= hMap.get(hak);		//해체작업해주기 안에 있는 string값인 name을 꺼내오기 위해서
			if(stdname.equals(vo.getName())) {
				System.out.println(hak+" "+vo);	//toString이랑 syso 이랑 print()랑 언제 쓰는지 구분이 어려움....
				flag = true;
			}
		}
		
		if(flag) System.out.println("검색성공!");
		
	}

	
	
	
	
	
	
}
