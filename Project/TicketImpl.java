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
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV 영화예매       　　　   　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   랜덤 영화 [" + data.getMovie() +                "]    ");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   영화를 예매하시겠습니까?                    ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   [1.예 | 2.아니요]                           ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================");



		int ch = sc.nextInt();

		switch(ch) {

		case 1:
			yes(); break;
		case 2:
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    영화예매 서비스를 종료합니다 .             ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    화면이 이전페이지로 전환됩니다.            ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t =================================================");
			break;

		}
	}

	public void yes() {


		TicketVO voT1 = new TicketVO();

		do {
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    [예매하기]                                 ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    인원을 입력하세요.                         ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t =================================================");
			voT1.setInwon(sc.nextInt());
		}while(voT1.getInwon()<0);

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜    [예매하기]                                 ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.printf("\t\t｜    [총인원 %d명]                               ｜",voT1.getInwon());
		System.out.println("\n\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");

		System.out.println("\t\t =================================================\n\n");

		str2  = new String[voT1.getInwon()];

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜    [예매하기]                                 ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜    [1]번째 좌석을 입력하세요(열-번호:1-10)    ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================");

		str2[0] = sc.next();

		int i = 1;
		while(i<voT1.getInwon()) {

			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    [예매하기]                                 ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    ["+(i+1) + "]번째 좌석을 입력하세요(열-번호:1-10)    ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t =================================================");

			str1 = sc.next();

			if (!str1.equals(str2[i-1])) {
				str2[i] = str1;
				i++;
			}else if(str1.equals(str2[i-1])){
				System.out.println("\t\t =================================================");
				System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
				System.out.println("\t\t =================================================");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t｜    [예매하기]                                 ｜");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t｜    좌석 선택 불가!!!                          ｜");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t｜    이미 선택된 좌석입니다.                    ｜");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t =================================================");

			}
		}

		voT1.setSeat(str2);

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜    [예매하기]                                 ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜    결제방법을 선택하세요[1.카드/2.현금]       ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.printf("\t\t｜   총금액: %d원                             ｜ ", voT1.getTot());
		System.out.println("\n\t\t｜                                               ｜");
		System.out.println("\t\t =================================================");


		voT1.setPay(sc.nextInt());

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜    [예매완료]                                 ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜    영화가 예매 되었습니다.                    ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜    즐거운 관람되시길 바랍니다.                ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================\n\n");

		listsT1.add(voT1);

	}


public void checkBooking() {

	Iterator<TicketVO> it = listsT1.iterator();
	while(it.hasNext()) {
		TicketVO vo = it.next();
		print();
	}
	if(flag) {

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜    [error!!]                                  ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜    예매하신 영화내역이 존재하지 않습니다.     ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================\n\n");


	}

}


public void cancleBooking() {

	System.out.println("\t\t =================================================");
	System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
	System.out.println("\t\t =================================================");
	System.out.println("\t\t｜                                               ｜");
	System.out.println("\t\t｜                                               ｜");
	System.out.println("\t\t｜    [예매취소]                                 ｜");
	System.out.println("\t\t｜                                               ｜");
	System.out.println("\t\t｜    예매하신 영화를 취소하시겠습니까?[yes/no]  ｜");
	System.out.println("\t\t｜                                               ｜");
	System.out.println("\t\t｜                                               ｜");
	System.out.println("\t\t =================================================");
	
	String a=sc.next();

	Iterator<TicketVO> it = listsT1.iterator();
	while(it.hasNext()) {
		TicketVO vo = it.next();
		if(a.equals("yes")) {
			listsT1.remove(vo);
			
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    [예매취소완료]                             ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    예매하신 내역을 취소하였습니다.            ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t =================================================\n\n");
			
			flag = true;
			break;
		}else {
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜　CGV 영화예매   　　　　　　 　[－] [ㅁ] [×] ｜");
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    예매 내역을 취소 하지 않습니다.            ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    페이지를 종료합니다.                       ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t =================================================");
			
			break;
		}

	}


}


public void print() {

	TicketVO voT1 = new TicketVO();

	System.out.println("\t\t =================================================");
	System.out.println("\t\t｜　CGV 예매확인   　　　　　　 　[－] [ㅁ] [×] ｜");
	System.out.println("\t\t =================================================");
	System.out.println("\t\t｜                                               ｜");
	System.out.println("\t\t｜                                               ｜");
	System.out.println("\t\t｜   [예매내역]                                  ｜");
	System.out.println("\t\t｜                                               ｜");
	System.out.print("\t\t｜   예매좌석[열-번호]: ");

	for(int i=0;i<str2.length;i++) {
		System.out.print( " | "+str2[i] + " | ");
	}
	
	System.out.println("\n\t\t｜                                               ｜");
	System.out.println("\t\t｜                                               ｜");
	System.out.println("\t\t =================================================");

	System.out.println();



}



}
