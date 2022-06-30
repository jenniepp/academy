package Project;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class StartPageImpl implements StartPage {
	
	
	
	private List<MyPageVO> lists = null;	//list선언-main절에서 보내주는 list데이터 받을 곳 생성
	Scanner sc = new Scanner(System.in);
	

	TicketImpl tki = new TicketImpl();
	MovieInfoMain mim = new MovieInfoMain();
	
	public StartPageImpl ( ) {
		
	}



	public StartPageImpl(List<MyPageVO> lists) {	//기본생성자 만들어주기. 데이터 어떻게 처리할건지 startpageimpl list를 변수로 받는다
		this.lists = lists;	//받은 list를 이 클래스의 list에 넣어라
	}

	@Override
	public void input() throws Exception {

		MyPageVO vo = new MyPageVO();	//vo 선언&객체생성	list타입을 받았으니까 vo만들고 사용하기 가능

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV Sign Up    　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   회원가입을 시작하겠습니다.                  ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜ 　ID를 입력하세요.                            ｜");
		System.out.println("\t\t｜　　                                           ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================");
		
		String id = sc.next();

		while (true) {
			if (id.equals(vo.getId())) {

				System.out.println("\t\t =================================================");
				System.out.println("\t\t｜　CGV Sign Up    　　　　　　 　[－] [ㅁ] [×] ｜");
				System.out.println("\t\t =================================================");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t｜   [회원가입]                                  ｜");
				System.out.println("\t\t｜　　                                           ｜");
				System.out.println("\t\t｜   이미 존재하는 아이디입니다.                 ｜");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t｜ 　ID를 다시 입력해주세요.                     ｜");
				System.out.println("\t\t｜　　                                           ｜");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t =================================================");
			
				id = sc.next();
			} else {
				vo.setId(id);
				break;
			}
		}

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV Sign Up    　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   [회원가입]                                  ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   비밀번호를 입력하세요.                      ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜ 　(비밀번호는 2자리 이상 입력)                ｜");
		System.out.println("\t\t｜　　                                           ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================");
		
		String pw = sc.next();

		while (true) {
			if (pw.length() < 2) {
				System.out.println("\t\t =================================================");
				System.out.println("\t\t｜　CGV Sign Up    　　　　　　 　[－] [ㅁ] [×] ｜");
				System.out.println("\t\t =================================================");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t｜   [회원가입]                                  ｜");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t｜   비밀번호는 2자 이상이여야합니다             ｜");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t｜ 　다시 입력해주세요.                          ｜");
				System.out.println("\t\t｜　　                                           ｜");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t =================================================");
				
				pw = sc.next();
			} else {
				vo.setPassword(pw);
				break;
			}
		}

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV Sign Up    　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   [회원가입]                                  ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   비밀번호 재확인                             ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜ 　비밀번호를 다시 입력해주세요                ｜");
		System.out.println("\t\t｜　　                                           ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================");
		
		pw = sc.next();

		while (true) {
			if (!pw.equals(vo.getPassword())) {
				
				System.out.println("\t\t =================================================");
				System.out.println("\t\t｜　CGV Sign Up    　　　　　　 　[－] [ㅁ] [×] ｜");
				System.out.println("\t\t =================================================");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t｜   [회원가입]                                  ｜");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t｜   비밀번호가 일치하지 않습니다!!!             ｜");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t｜ 　비밀번호를 다시 입력해주세요                ｜");
				System.out.println("\t\t｜　　                                           ｜");
				System.out.println("\t\t｜                                               ｜");
				System.out.println("\t\t =================================================");
				
				pw = sc.next();
			} else
				break;

		}

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV Sign Up    　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   [회원가입]                                  ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   회원님의 성함을 입력해주세요.               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================");
		vo.setName(sc.next());

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV Sign Up    　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   [회원가입]                                  ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   회원님의 생년월일을 입력해주세요.[yymmdd]	 ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================");
		
		vo.setBirth(sc.next());

		vo.setPoint(500);
		vo.setMoviecount(0);

		lists.add(vo);	//list생성

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV Sign Up    　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   [회원가입]                                  ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   회원가입이 완료되었습니다.              	 ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   가입축하적립금 500P를 드렸습니다.           ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================\n");
		

		System.out.println();
		

		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV Sign Up    　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   [회원가입 완료]                             ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   로그인 페이지로 화면을 이동합니다.       	 ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================\n\n");

		login();

	}

	@Override
	public void login() throws Exception {

		

		
		Iterator<MyPageVO> it = lists.iterator();	//이터레이터 만들기

		boolean result = false;
		
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV Login    　　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   서비스를 이용하시려면 로그인이 필요합니다.  ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜ 　ID를 입력하세요.                            ｜");
		System.out.println("\t\t｜　　                                           ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================");
		
		String checkID = sc.next();
		MyPageVO vo=null;

		while (it.hasNext()) {
			vo = it.next();
			if (checkID.equals(vo.getId())) {
				result = true;
				
				break;
			}
		}

		if (!result) {
		
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜　CGV Login      　　　　　　 　[－] [ㅁ] [×] ｜");
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜   [error!!]                                   ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜   아이디가 존재하지 않습니다.              	 ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t =================================================");
			
			return;
			
		}
		
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜　CGV Login    　　　　　　　 　[－] [ㅁ] [×] ｜");
		System.out.println("\t\t =================================================");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜   [PassWord]                                  ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t｜ 　비밀번호를 입력하세요.                      ｜");
		System.out.println("\t\t｜　　                                           ｜");
		System.out.println("\t\t｜                                               ｜");
		System.out.println("\t\t =================================================");
		
		String checkPW = sc.next();

		if (!checkPW.equals(vo.getPassword())) {
			
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜　CGV Login      　　　　　　 　[－] [ㅁ] [×] ｜");
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜   [로그인 실패]                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜   아이디/비밀번호가 일치하지 않습니다.        ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t =================================================");
			

		} else {
			
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜　CGV Login      　　　　　　 　[－] [ㅁ] [×] ｜");
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜   [로그인 완료]                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    " + checkID  + "님 반갑습니다.                           ");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t =================================================\n\n");

			tki.input();
			start();
			
		}
	}
	
	public void start() throws Exception {
		while (true) {
			
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜　CGV Menu       　　　　　　 　[－] [ㅁ] [×] ｜");
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜   1. 영화정보                                 ｜");
			System.out.println("\t\t｜   2. 영화예매                                 ｜");
			System.out.println("\t\t｜   3. 예매확인                                 ｜");
			System.out.println("\t\t｜   4. 예매취소                                 ｜");
			System.out.println("\t\t｜   5. 로그아웃                                 ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t =================================================");
			
			int ch = sc.nextInt();
			
			switch (ch) {
			case 1: mim.movieInfo(); break;
			case 2: tki.todayMovie(); break;
			case 3: tki.checkBooking(); break;
			case 4: tki.cancleBooking(); break;
			case 5: 
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜　CGV Menu       　　　　　　 　[－] [ㅁ] [×] ｜");
			System.out.println("\t\t =================================================");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    [Logout]                                   ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜    CGV 정보 시스템을 종료합니다!!!!           ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t｜                                               ｜");
			System.out.println("\t\t =================================================");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			String Main[] = {

					
					"\t\t＼＼                             ",
				    "\t\t ＼＼＼∧_∧_                    ", 
					"\t\t ＼|￣( ･ω∩)∩ 　　　　         ",     
					"\t\t＼ |＼|￣( ^ω∧)∧              ",        
					"\t\t ＼◎＼|＼|￣(*･∀･）            ",     
					"\t\t 　 ＼◎＼|＼/っｙっ＼           ",       
					"\t\t 　　　＼◎＼|ニニニニ|          ",    
					"\t\t 　　　　 ＼◎ 　　＼◎          ",
					"\t\t _____                    _  ______              " , 
					"\t\t|  __ \\                  | | | ___ \\             " , 
					"\t\t| |  \\/  ___    ___    __| | | |_/ / _   _   ___ " , 
					"\t\t| | __  / _ \\  / _ \\  / _` | | ___ \\| | | | / _ \\" , 
					"\t\t| |_\\ \\| (_) || (_) || (_| | | |_/ /| |_| ||  __/" , 
					"\t\t \\____/ \\___/  \\___/  \\__,_| \\____/  \\__, | \\___|" , 
					"\t\t                                      __/ |      " , 
					"\t\t                                     |___/       " , 
					""
					
					};

			for(int i=0; i<Main.length; i++) {

				System.out.println(Main[i]);

				Thread.sleep(200);
			}
			System.exit(0);
			break;

			default:
				System.out.println("잘못된 선택입니다.");
				System.exit(0);
			}
		}
	}

}
