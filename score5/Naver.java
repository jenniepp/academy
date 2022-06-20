package com.score5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



class NaverIdAuthen{
	
	
	public void inputFormat(String id) throws Exception{
			
		if(id.length()>15||id.length()<8) {
			throw new Exception("회원가입시 아이디는 반드시 8~15자 이내여야합니다.\n");}
		
		int eng=0, num=0;
		for(int i=0;i<id.length();i++) {
			char ch=id.charAt(i);
			if((ch>='A' && ch<= 'Z') || (ch>='a' && ch<='z')) eng++;
			if(ch>='0' && ch<='9') num++;
		}

		if(eng==0 || num==0) {
			throw new Exception("회원가입시 아이디는 반드시 영문자 숫자를 혼용해야합니다.\n");

		}
		
	}
}


class NaverPwAuthen{
	public static void inputFormat(String pw) throws Exception{

		Scanner sc=new Scanner(System.in);

		System.out.println("비밀번호를 다시한번 입력해주세요.");
		String pw2=sc.next();

		if(!pw.equals(pw2)) {
			throw new Exception("비밀번호가 일치하지 않습니다.\n");
		}




	}
}

public class Naver {

	Scanner sc=new Scanner(System.in);
	private List<NaverVO> lists = new ArrayList<>();

	NaverIdAuthen nid=new NaverIdAuthen();
	NaverPwAuthen npw=new NaverPwAuthen();

	


	public void input() throws Exception {
		
		NaverVO vo=new NaverVO();
		
		boolean panjung;
		do {
			try {
				panjung=true;
				System.out.println("id를 입력하세요.");
				vo.setId(sc.next());
				
				nid.inputFormat(vo.getId());

			}catch (Exception e) {
				panjung=false;
				System.out.println(e.toString());

			}
		}while(panjung!=true);
		
		
		do {
			System.out.println("비밀번호를 입력해주세요.");
			vo.setPassword(sc.next());
			

			try {
				panjung=true;
				npw.inputFormat(vo.getPassword());


			}catch (Exception e) {
				panjung=false;
				System.out.println(e.toString());

			}
		}while(panjung!=true);
		
		System.out.println("이름을 입력해주세요.");
		vo.setName(sc.next());
		
		System.out.println("성별을 적어주세요 [여자/남자]");
		vo.setGender(sc.next());
		
		if(!vo.getGender().equals("여자") && !vo.getGender().equals("남자")) {
			throw new Exception("성별을 잘못입력하였습니다.\n");
		}
		
		System.out.println("생년월일을 입력하세요.[yyyymmdd]");
		vo.setBirth(sc.next());
		
		if(vo.getBirth().length()!=8) {
			throw new Exception("생년월일을 잘못입력하였습니다.\n");
		}
		
		System.out.println("email을 입력하세요.");
		vo.setEmail(sc.next());
		
		int c=0;
		for(int i=0;i<vo.getEmail().length();i++) {
			char ch=vo.getEmail().charAt(i);
			if(ch=='@') c++;
			}
		
		if(c==0) {
			throw new Exception("email을 다시 입력하십시오.\n");
		}
		
		System.out.println("휴대전화번호를 입력하세요.");
		vo.setTel(sc.next());
		
		if(vo.getTel().length()!=11) {
			throw new Exception("휴대전화번호가 틀렸습니다.");
		}
		
		

		lists.add(vo);
	}

	public void print() {


		Iterator<NaverVO> it = lists.iterator();		
		while(it.hasNext()) {							

			NaverVO vo=it.next();		

			System.out.println(vo.toString());


		}
	}
	
	
	
	public void searchingId() {
		
		NaverVO vo=new NaverVO();
		Iterator<NaverVO> it=lists.iterator();
		
		System.out.println("검색할 아이디를 입력해주세요.");
		String std=sc.next();
		
		while(it.hasNext()) {
			vo=it.next();
			if(std.equals(vo.getId())) {
				System.out.println(vo.toString());
				return;
			}else System.out.println("아이디를 찾을 수 없습니다.");
		}
		
		
		
		
	}
}






