package com.guest;

import java.util.Scanner;

import com.db.DBConn;


public class GuestMain {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int ch;
		Guest gst =new Guest();
		
		while(true){
			
			do {
				System.out.println("1.기본정보입력 2.방명록 작성 3.방명록 수정 4.방명록 삭제 5.방명록 확인 6.종료");
				ch=sc.nextInt();	
			}while(ch<1||ch>6);
			
			switch(ch) {
			
			case 1: gst.insert();break;
			case 2: gst.write();break;
			case 3: gst.modify();break;
			case 4: gst.delete();break;
			case 5: gst.check();break;
			
			default: 
				DBConn.close();
				System.out.println("종료가 완료되었습니다.");
				System.exit(0);
			}
		}
		
		
		
		
		
		

	}

}
