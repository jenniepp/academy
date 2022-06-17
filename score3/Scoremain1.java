package com.score3;

import java.util.Scanner;

public class Scoremain1 {

	public static void main(String[] args) {
		
	//계속 반복해서 물어볼 메뉴를 만들어 볼게요~~
		
		Scanner sc=new Scanner(System.in);
		
		Score ob=new ScoreImpl1();
		
		int ch;
		
		//무한루프 만들거라 이렇게
		while(true) {
			do{
				System.out.println("1.입력 2.출력 3.학번삭제 4.학번검색"+
				"5.이름검색 6.총점내림차순 7.학번오름차순 8.종료 ");
				System.out.println("---------------");
				System.out.print(":  ");
				ch=sc.nextInt();
			}while(ch<1);
			
			switch(ch) {
				case 1: ob.input(); break;
				case 2: ob.print(); break;
				case 3: ob.deleteHak(); break;
				case 4: ob.searchHak(); break;
				case 5: ob.searchName(); break;
				case 6: ob.descSortTot(); break;
				case 7: ob.ascSortHak(); break;
				default :
					System.out.println("학사정보 시스템을 종료합니다");
					System.exit(0);	//이 콘솔을 나가라 걍 바로 종료
					
				
			}
		}
		

	}

}
