package com.cyworld;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.imageTest.ImageTestDTO;

public class CyworldDAO {

	private Connection conn=null;

	public CyworldDAO(Connection conn) {
		this.conn=conn;
	}
	
	public int getMaxNum() {//얘는 어디서든 쓸수있으니까 pk로써.. 일단생성하기 출력안한다고 해도!

		int maxNum=0;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select nvl(max(num),0) from guest";

			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			if(rs.next()) {
				maxNum=rs.getInt(1);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return maxNum;

	}
	
	public void insertComment(GuestDTO dto) {
		
		PreparedStatement pstmt;
		String sql;
		
		try {
			
			sql = "insert into guest (num,message,day,nickname,name) values (?,?,sysdate,?,?)";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getMessage());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getName());
			
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
	}
	
	public List<GuestDTO> getlists(){

		List<GuestDTO> lists=new ArrayList<GuestDTO>();

		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql;

		try {

			sql="select num,message,day,name,nickname ";
			sql+="from guest order by num desc";

			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				GuestDTO dto = new GuestDTO();

				dto.setNum(rs.getInt("num"));
				dto.setMessage(rs.getString("message"));
				dto.setDay(rs.getString("day"));
				dto.setName(rs.getString("name"));
				dto.setNickname(rs.getString("nickname"));

				lists.add(dto);

			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		//여기서 리턴한 lists를 이제 html에서도 쓰고 그런다.. 어떻게? 하..
		return lists;



	}



}
