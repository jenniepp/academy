package com.score4;

import java.io.IOException;
import java.util.Scanner;

public class ScoreMain {

	public static void main(String[] args) throws IOException {	//계속 반복해서 물어볼 메뉴를 만들어 볼게요~~
		Scanner sc=new Scanner(System.in);
		
		Score ob=new ScoreImpl();		//얘도 그 뭐냐 인터페이스 그거라 오키
		int ch;
		
		//무한루프 만들거라 이렇게
		while(true) {
			do{
				System.out.println("1.입력 2.출력 3.삭제 4.업데이트 "+
				"5.학번검색 6.이름검색 7.종료 ");
				System.out.println("---------------");
				System.out.print(":  ");
				ch=sc.nextInt();
			}while(ch<1);
			
			switch(ch) {
				case 1: ob.input(); break;
				case 2: ob.print(); break;
				case 3: ob.delete(); break;
				case 4: ob.update(); break;
				case 5: ob.findHak(); break;
				case 6: ob.findName(); break;
				default :
					System.out.println("학사정보 시스템을 종료합니다");
					System.exit(0);	//이 콘솔을 나가라 걍 바로 종료
					
				
			}
		}
		

	}

}
