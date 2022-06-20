package com.score5;

import java.util.Scanner;

public class NaverMain {

	public static void main(String[] args) throws Exception {

		Scanner sc=new Scanner(System.in);
		Naver nv=new Naver();
		int ch;

		while(true) {
			do{
				System.out.println("1.회원가입 2.전체회원출력 3.아이디검색 4.종료");
				System.out.println("---------------");
				System.out.print(":  ");
				
				ch=sc.nextInt();
				
			}while(ch<1);

			try {

				switch(ch) {
				case 1: nv.input(); break;
				case 2: nv.print(); break;
				case 3: nv.searchingId(); break;

				default :
					System.out.println("시스템을 종료합니다");
					System.exit(0);	//이 콘솔을 나가라 걍 바로 종료
				}
			}catch (Exception e) {	//매개변수를 e로 받아서 그 e의 toString을 출력해라~ 이말

				System.out.println(e.toString());

			}

		}
	}
}


