package pre;

import java.util.Scanner;


public class preMain {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		pre ob=new preImpl();		//얘도 그 뭐냐 인터페이스 그거라 오키
		int ch;

		while(true) {
			do{
				System.out.println("1.입력 2.출력 3.회원삭제 4.회원검색"+
						" 5.방문일수정 6.적립금수정 7.종료 ");
				System.out.println("---------------");
				System.out.print(":  ");
				ch=sc.nextInt();
			}while(ch<1);

			switch(ch) {
			case 1: ob.input(); break;
			case 2: ob.print(); break;
			case 3: ob.delete(); break;
			case 4: ob.searchingMember(); break;
			case 5: ob.modifyLastDate(); break;
			case 6: ob.calcPoint(); break;

			default :
				System.out.println("회원관리 시스템을 종료합니다");
				System.exit(0);	//이 콘솔을 나가라 걍 바로 종료
			}

		}

	}
}

