package com.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.db.DBConn;
import com.score7.ScoreDTO;

public class Guest {

	Scanner sc=new Scanner(System.in);
	GuestDAO dao=new GuestDAO();
	String std_id=null;

	public void insert() {

		GuestDTO dto= new GuestDTO();

		System.out.println("아이디는?");
		dto.setId(sc.next());

		System.out.println("비밀번호는?(숫자만 입력가능)");
		dto.setPwd(sc.nextInt());

		System.out.println("이름은?");
		dto.setName(sc.next());

		int result = dao.insertData(dto);

		if(result!=0) {
			System.out.println("추가성공!");
		}else {
			System.out.println("추가실패!");
		}


	}

	public void write() {

		login();

		GuestDTO dto= new GuestDTO();

		dto.setId(std_id);

		if(dto.getContent()!=null) {

			System.out.println("내용? (10자이내 ㅎㅎ)");
			dto.setContent(sc.next());

			int result = dao.writeData(dto);

			if(result!=0) {
				System.out.println("추가 성공!");
			}else {
				System.out.println("추가 실패!");
			}
		}else System.out.println("이미 입력했습니다.");

	}

	public void modify() {
		
		login();

		GuestDTO dto= new GuestDTO();

		dto.setId(std_id);

		System.out.println("수정할내용? (10자이내 ㅎㅎ)");
		dto.setContent(sc.next());
		
		int result = dao.modifyData(dto);

		if(result!=0) {
			System.out.println("수정 성공!");
		}else {
			System.out.println("수정 실패!");
		}
		
	}

	public void delete() {
		
		login();
		
		GuestDTO dto= new GuestDTO();

		dto.setId(std_id);
		
		int result = dao.deleteData(dto);

		if(result!=0) {
			System.out.println("삭제 성공!");
		}else {
			System.out.println("삭제 실패!");
		}


	}

	public void check() {

		login();

		//GuestDTO dto= new GuestDTO();
		List<GuestDTO> lists=dao.getList();
		Iterator<GuestDTO> it=lists.iterator();
		
		while(it.hasNext()) {
			GuestDTO dto=it.next();
			System.out.println(dto.toString());
		}


	}

	//로그인
	public void login() {

		//		String std_id;
		int std_pwd;

		System.out.println("아이디를 입력해주세요");
		std_id=sc.next();
		System.out.println("비밀번호를 입력해주세요");
		std_pwd=sc.nextInt();

		GuestDTO dto= dao.getLists(std_id,std_pwd);


		if(dto==null) {
			System.out.println("로그인실패");
			System.exit(0);
		}


	}
}


