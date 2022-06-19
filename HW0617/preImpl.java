package pre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class preImpl implements pre{//3. 인터페이스구현 및 오버라이드해서 내용 만들기
	
	private List<preVO> lists = new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	preVO vo=new preVO();

	
	


	@Override
	public void input() {
		
		String[] name= {"박가가","김나나","이다다","최라라" };
		String[] number= {"A1056","A3021","A0128","V6290"};
		String[] birth= {"930427","881101","000812","960129"};
		String[] lastDate= {"2021-06-08","2022-01-12","2021-12-19","2022-05-05"};
		int[] point= {20130,109000,47000,1089000};
	
		
		for(int i=0;i<4;i++) {
			preVO vo=new preVO();
			
			vo.setName(name[i]);
			vo.setMemberCode(number[i]);
			vo.setBirth(birth[i]);
			vo.setLastDate(lastDate[i]);
			vo.setPoint(point[i]);
			
			lists.add(vo);
		}
	}

	@Override
	public void print() {

		Iterator<preVO> it = lists.iterator();	//interator 컬렉션에서 사용하는 반복자/복사본 생성
		while(it.hasNext()) {							//hasNext()는 다음으로 하나씩 나가고 그 다음이 비어있으면 거기까지만 돌아라~

			preVO vo=it.next();		//scorevo 데이터타입으로 만들어진 it를 한 세트씩 넣고 싶은데 그걸 vo에다가 집어넣는거 그 vo는 당연히 scorevo타입인거고.. 하 ㅋ 이게 맞ㄴ느지도 모르겠다 하....... 한달뒤엔느 더 이해잘되겠지 수진아 제발~!~! 
			System.out.println(vo.toString());

		}
	}

	@Override
	public void searchingMember() {
		
		System.out.println("검색할 회원 이름을 입력해주세요");
		String std=sc.next();
		
		Iterator<preVO> it=lists.iterator();		//이터레이터
		while(it.hasNext()) {
			
			preVO vo=it.next();
			if(std.equals(vo.getName())) {
				System.out.println(vo.toString());		
				break;
			}
		}
	
	}

	@Override
	public void modifyLastDate() {//나중에 날짜 캘린더로 불러오게 한뒤에 여기는 오늘날짜로 수정할수있겠다
		
		System.out.println("회원이름을 입력해주세요");
		String std=sc.next();
		
		Iterator<preVO> it=lists.iterator();
		
		while(it.hasNext()) {
			preVO vo=it.next();
			if(std.equals(vo.getName())) {
				System.out.println("최근방문날짜를 입력해주세요[yyyy-mm-dd]");
				vo.setLastDate(sc.next());
				
			}
			
		}
		print();
		
	}

	@Override
	public void calcPoint() {
		
		int result=0;
		
		System.out.println("회원이름을 입력해주세요");
		String std=sc.next();
		
		Iterator<preVO> it=lists.iterator();
		
		while(it.hasNext()) {
			preVO vo=it.next();
			if(std.equals(vo.getName())) {
				System.out.println("1. 적립금 사용 2. 적립금 추가");
				int ch=sc.nextInt();
				
				switch(ch) {
				case 1: {
					System.out.println("사용금액을 입력해주세요");
					int cost=sc.nextInt();
					result=vo.getPoint()-cost;
					vo.setPoint(result);
					break;

				}
				case 2:{
					System.out.println("적립할 금액을 입력해주세요");
					int point=sc.nextInt();
					result=vo.getPoint()+point;
					vo.setPoint(result);
					break;
				}
				}
				
			}
			
			
		}
		print();
		
	}

	@Override
	public void delete() {

		System.out.println("삭제할 회원의 번호를 입력하세요");
		String std=sc.next();

		Iterator<preVO> it=lists.iterator();
		
		while(it.hasNext()) {
			preVO vo=it.next();	//얘가 정확하게 뭔지 알아보기
			if(std.equals(vo.getMemberCode())) {

				lists.remove(vo);
				break;
			}

		}
		
		print();
		//System.out.println(vo.toString()); 얘왜 null로 출력되는걸까
		
	}

}
