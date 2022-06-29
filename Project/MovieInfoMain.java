package Project;

import java.util.Scanner;


public class MovieInfoMain extends Thread{

	public void movieInfo() throws Exception {

		Scanner sc = new Scanner(System.in);
		
		Movie ob = new MovieImpl();
		StartPageImpl spi = new StartPageImpl();

		int ch;

		while(true) {

			do {

				System.out.println("\t\t\t┏━━━━━━━━━━━━━━━━┓");
				System.out.println("\t\t\t┃ [전체 영화 정보]               ┃");
				System.out.println("\t\t\t┃ 1. 상영예정작                  ┃");
				System.out.println("\t\t\t┃ 2. 현재상영작                  ┃");
				System.out.println("\t\t\t┃ 3. 영화이름검색                ┃");
				System.out.println("\t\t\t┃ 4. 영화순위                    ┃");
				System.out.println("\t\t\t┃ 5. 뒤로가기                    ┃");
				System.out.println("\t\t\t┗━━━━━━━━━━━━━━━━┛");
				System.out.println("\t\t\t\t       ᕱ    ᕱ    ┃ ┃ ");
				System.out.println("\t\t\t         ( ･ω･ )┃ ┃ ");
				System.out.println("\t\t\t         /　  つ┃ Φ");
				
				
				System.out.print(":");
				ch = sc.nextInt();


			}while(ch<1);

			switch(ch) {
			case 1:
				ob.ascSortFutureMovie(); break;
			case 2:
				ob.presentMovie(); break;
			case 3:
				ob.searchMovie(); break;
			case 4:
				ob.descSortRank(); break;
			case 5:
				spi.start(); break;
				
				/*
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
				}
				String Main[] = {

						"\t\t\t┏━━━━━━━━━━┓",
						"\t\t\t┃ 영화정보 시스템을  ┃",
						"\t\t\t┃ 종료합니다!!!!     ┃",
						"\t\t\t┗━━━━┓┏━━━━┛",
						"\t\t\t  ∧,,,∧ ┃┃			 ",
						"\t\t\t (=・ω・)┃┃			 ",
						"\t\t\t （　　 づ┃Φ			 ",
						"\t\t\t＼＼                             ",
					    "\t\t\t ＼＼＼∧_∧_                    ", 
						"\t\t\t ＼|￣( ･ω∩)∩ 　　　　         ",     
						"\t\t\t＼|＼|￣( ^ω∧)∧              ",        
						"\t\t\t ＼◎＼|＼|￣(*･∀･）            ",     
						"\t\t\t 　 ＼◎＼|＼/っｙっ＼           ",       
						"\t\t\t 　　　＼◎＼|ニニニニ|          ",    
						"\t\t\t 　　　　 ＼◎ 　　＼◎          ",
						
						};

				for(int i=0; i<Main.length; i++) {

					System.out.println(Main[i]);

					sleep(200);
				}
				*/
				
				
				

			} System.out.println();
		}
	}
}
