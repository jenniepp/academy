package com.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.db.DBConn;


public class GuestDAO {

	//회원가입
	public int insertData(GuestDTO dto) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql="insert into guestCustom (id,pwd,name) ";
			sql+="values(?,?,?)";

			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setInt(2, dto.getPwd());
			pstmt.setString(3, dto.getName());

			result=pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;

	}
	
	
	//방명록 작성
	public int writeData(GuestDTO dto) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into guestRecord values (?,?,sysdate) ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getContent());
			
			result = pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
		
		
	}
	
	//방명록 수정
	public int modifyData(GuestDTO dto) {
		int result = 0;

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "update guestRecord set content=?,created=sysdate where id=?";

			pstmt = conn.prepareStatement(sql);

			
			pstmt.setString(1, dto.getContent());
			pstmt.setString(2, dto.getId());
			
			result = pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
		
		
	}
	
	
	//방명록 삭제
	public int deleteData(GuestDTO dto) {
		int result = 0;

		Connection conn = DBConn.getConnection();//db연결
		PreparedStatement pstmt = null;
		String sql;
		
		try {

			sql="delete guestRecord where id=?";
			

			pstmt=conn.prepareStatement(sql);	//statement와 사용하는 방법이 조금 다름 비교해보기
			pstmt.setString(1,dto.getId());

			result = pstmt.executeUpdate();	//앞에서 검사를 다 하니까 여기선 굳이 넣어줄 값이 없다.

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}
	
	//전체출력
	public List<GuestDTO> getList(){
		
		List<GuestDTO> lists=new ArrayList<GuestDTO>();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql;
		
		try {
			
			sql="select id,content,created from guestRecord";
			
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { //rs의 다음값이 있냐~
				
				GuestDTO dto= new GuestDTO(); //while도는 동안 반복적으로 dto가 생성되어야 하기 때문에 반복문 안에 담아준다
				
				dto.setId(rs.getString("id")); //rs에 저장된 스트링형태의 값을 가져올 거다. 1번째에 위치해있는~
				dto.setContent(rs.getString("content")); //숫자 대신 칼럼명을 써도 된다.
				dto.setCreated(rs.getString("created"));
				
				lists.add(dto);
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
		
	}
	

	
	//로그인부분
	public GuestDTO getLists(String id,int pwd) { //list에 dto담아놓고 비교하기
		
		GuestDTO dto=null; // 1. 여기 왜 null값 주고 시작하는 거야? 선언만했으니까 그렇지....
		
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs=null;
		
	
		
		try {
			
			sql="select id,pwd from guestCustom where id=? and pwd=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, pwd);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto=new GuestDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getInt("pwd"));
			}
			
			rs.close();
			pstmt.close();
				
					
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return dto;
	}
	

}
