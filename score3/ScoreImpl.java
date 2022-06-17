package com.score3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//인터페이스 구현했으니까 거기있던 추상메소드 전부다 필수로 오버라이딩 해줘야함 

public class ScoreImpl implements Score{

	//아래 두개다 가능 왜그렇게!??!!? 생각해보십시여 인터페이스 이름 =new 클래스 요렇게해도된다~~ 저번시간에 배운거!
	//private ArrayList<ScoreVO1> lists = new ArrayList<>();
	private List<ScoreVO> lists = new ArrayList<>();

	Scanner sc= new Scanner(System.in);


	@Override
	public int input() {	//값 입력받기

		int result = 0;		//여기 void로 바꿔도 실행가능. 실제로 input 메소드는 그냥 입력된 값을 받기 위한 메소드지 뭘 리턴하기 위한게 아니니까

		ScoreVO vo=new ScoreVO();	//ScoreVO를 이용해야하니까 객체생성하기! 어따쓰냐면 ScoreVO에 있는 변수에다가  값을 넣을거야

		System.out.println("학번?");
		String hak=sc.next();	//이거만 쓰면 값이 안들어감 왜냐면 hak은 private 변수라 이런식으로 외부클래스에서 값을 넣을 수가 없음 정신차리십시여
		vo.setHak(hak);			//이렇게 지금 여기서 만든 hak에 받은 값을 vo에 있는 setHak에다가 넣는 과정을 꼭 거쳐야지 절루감! 이걸 저기다 넣어주려고 객체생성도 한거임

		System.out.println("이름?");
		vo.setName(sc.next());

		System.out.println("국어?");
		vo.setKor(sc.nextInt());

		System.out.println("영어?");
		vo.setEng(sc.nextInt());

		System.out.println("수학?");
		vo.setMat(sc.nextInt());

		lists.add(vo);		//우리 배열의 배열 만들었던 것 처럼 지금 여기 클래스에서 lists를 객체생성해서 거기에 vo클래스를 한페이지씩 한칸에 넣어둔거임 지금은 이해가 되는데 나중에도 이해가 됐으면 ㅎ

		return result;
	}

	@Override
	public void print() {	//프린트 어떤 과정을 거쳐서 출력할지 정해주는 메소드지

		Iterator<ScoreVO> it = lists.iterator();		//interator 컬렉션에서 사용하는 반복자/복사본 생성
		while(it.hasNext()) {							//hasNext()는 다음으로 하나씩 나가고 그 다음이 비어있으면 거기까지만 돌아라~

			ScoreVO vo=it.next();		//scorevo 데이터타입으로 만들어진 it를 한 세트씩 넣고 싶은데 그걸 vo에다가 집어넣는거 그 vo는 당연히 scorevo타입인거고.. 하 ㅋ 이게 맞ㄴ느지도 모르겠다 하....... 한달뒤엔느 더 이해잘되겠지 수진아 제발~!~! 

			System.out.println(vo.toString());


		}
	}

	@Override
	public void deleteHak() {

		System.out.println("삭제할 학번을 입력하세요");
		String std=sc.next();		//삭제할 기준이 되는 값을 입력받아서 넣기

		Iterator<ScoreVO> it=lists.iterator();

		while(it.hasNext()) {

			ScoreVO vo=it.next();

			if(std.equals(vo.getHak())) {
				
				lists.remove(vo);
				//it.remove();	//둘다 가능하다 차이가 뭘까?!!!!!!?????????
				break;

			}
		}

		print();

	}


	@Override
	public void searchHak() {

		System.out.println("검색할 학번을 입력하세요");
		String std=sc.next();		//검색할 학번 입력받기

		Iterator<ScoreVO> it=lists.iterator();		//컬렉션에서 처음부터 끝까지 검사할때는 꼭 interator써주기!! 일단 복사시키고 그 복사본으로 확인
		while(it.hasNext()) {

			ScoreVO vo=it.next();	//vo에다가 it를 차례차례 입력하기
			if(std.equals(vo.getHak())) {
				System.out.println(vo);
				break;

			}

		}


	}
	

	@Override
	public void searchName() {
		
		System.out.println("검색할 이름을 입력하세요");
		String std=sc.next();
		
		Iterator<ScoreVO> it=lists.iterator();
		while(it.hasNext()) {

			ScoreVO vo=it.next();	//vo에다가 it를 차례차례 입력하기
			if(std.equals(vo.getName())) {
				System.out.println(vo);
			
			}

		}
		
	}
	

	@Override
	public void descSortTot() {
		Comparator<ScoreVO> comp= new Comparator<ScoreVO>() {		//정렬하는 방법 만들기. 일단 정렬하는 클래스 객체생성

			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {

				return vo1.getTot()<vo2.getTot()?1:-1;
			}
		};

		Collections.sort(lists, comp);		//만든 방법을 이용해서 정렬끝

		print();	//정렬시킨거로 출력해라

	}


	@Override
	public void ascSortHak() {
		Comparator<ScoreVO> comp= new Comparator<ScoreVO>() {		//정렬하는 방법 만들기. 일단 정렬하는 클래스 객체생성

			@Override
			public int compare(ScoreVO vo1, ScoreVO vo2) {

				return Integer.parseInt(vo1.getHak())>Integer.parseInt(vo2.getHak())?1:-1;
			}
		};

		Collections.sort(lists, comp);		//만든 방법을 이용해서 정렬끝

		print();	//정렬시킨거로 출력해라

		
	}

}
