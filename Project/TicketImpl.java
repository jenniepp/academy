package Project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicketImpl {

	String[] movieArr = {"탑건:매버릭","범죄도시2","마녀 part 2","브로커","버즈 라이트 이어","쥬라기월드:도미니언","헤어질 결심","미친능력","고스트랜드","보통의 용기","컴온컴온"};

	Random rd = new Random();
	Scanner sc = new Scanner(System.in);

	DataVO data = new DataVO();
	MyPageVO vo = new MyPageVO();
	
	String str1;
	String[] str2;
	boolean flag;

	List<TicketVO> listsT1 = new ArrayList<>();


	public void input() {

		int n = rd.nextInt(movieArr.length);
		data.setMovie(movieArr[n]);

	}


	public void todayMovie() {
		
		input();

		System.out.println("랜덤 영화 [" + data.getMovie() + "]");
		System.out.println("예매하시겠습니까? [1.예 | 2.아니요]");

		int ch = sc.nextInt();

		switch(ch) {

		case 1:
			yes(); break;
		case 2:
			System.out.println("영화예매 서비스를 종료합니다"); break;

		}
	}

	public void yes() {

		
		TicketVO voT1 = new TicketVO();

		do {
			System.out.println("인원을 입력하세요");
			voT1.setInwon(sc.nextInt());
		}while(voT1.getInwon()<0);

		System.out.printf("[총인원 %d명]\n",voT1.getInwon());
		
		
		str2  = new String[voT1.getInwon()];
		
		
		System.out.println("[1]번째 좌석을 입력하세요(열-번호:1-10)");
		str2[0] = sc.next();
		
		int i = 1;
		while(i<voT1.getInwon()) {
			
			System.out.println("[" + (i+1) + "]번째 좌석을 입력하세요(열-번호:1-10)");
			str1 = sc.next();
			
			if (!str1.equals(str2[i-1])) {
				str2[i] = str1;
				i++;
			}else if(str1.equals(str2[i-1])){
				System.out.println("이미 선택된 좌석입니다");
			}
			
		}

		voT1.setSeat(str2);
		

		System.out.printf("결제방법을 선택하세요[1.카드/2.현금] (총금액: %d)\n", voT1.getTot());
		voT1.setPay(sc.nextInt());

		System.out.println("예매 완료!");
		System.out.println("-------------------------------------");
		listsT1.add(voT1);
		
		

	}


	public void checkBooking() {
		
			Iterator<TicketVO> it = listsT1.iterator();
			while(it.hasNext()) {
				TicketVO vo = it.next();
				print();
			}
			if(flag) {
				System.out.println("예매내역이 없습니다");
				System.out.println("-------------------------------------");
			}
		
	}
	
	
	
	public void cancleBooking() {
	
		System.out.println("취소하시겠습니까? [yes/no]");
		String a=sc.next();
		
		Iterator<TicketVO> it = listsT1.iterator();
		while(it.hasNext()) {
			TicketVO vo = it.next();
			if(a.equals("yes")) {
				listsT1.remove(vo);
				System.out.println("취소되었습니다.");
				System.out.println("-------------------------------------");
				flag = true;
				break;
			}else {
				System.out.println("종료합니다.");
				System.out.println("-------------------------------------");
				break;
			}

		}
		
		
	}
	
	
	
	
	public void print() {
		
		TicketVO voT1 = new TicketVO();
		
		System.out.print("예매좌석[열-번호]: ");
		
		for(int i=0;i<str2.length;i++) {
			System.out.print(str2[i] + " | ");
		}
		
		System.out.println();
		System.out.println("-------------------------------------");
		
		
	}
	
	

}
