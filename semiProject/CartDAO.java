package com.moody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
	

	private Connection conn;
	
	
	public CartDAO(Connection conn) {
		this.conn=conn;
	}
	
	public int getMaxNum(){
		
		int maxNum = 0;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql;
		
		try {
			
			sql="select nvl(max(num),0) from cart";
			pstmt = conn.prepareStatement(sql);
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
	
	public int insertData(CartDTO dto) {
		
		int result =0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			
			sql= "insert into cart (num,id,pnum,pname,cnt,psize,price) ";
			sql+="values (?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPnum());
			pstmt.setString(4, dto.getPname());
			pstmt.setInt(5, dto.getCnt());
			pstmt.setString(6, dto.getPsize());
			pstmt.setInt(7, dto.getPrice());
			
			
			
			result = pstmt.executeUpdate();
			pstmt.close();
			
				
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
		
	}

	public int getDataCount() {

		int dataCount = 0;

		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql;

		try {


			sql="select nvl(count(*),0) from cart ";

			pstmt=conn.prepareStatement(sql);

			rs=pstmt.executeQuery();

			if(rs.next()) {
				dataCount=rs.getInt(1);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return dataCount;

	}
	
	List<CartDTO> getLists(String id){ //매개변수 없다. 전체 데이터 다 가져올것임

		List<CartDTO> lists = new ArrayList<CartDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null; //전체데이터를 가져올때 쓰는거. 한행씩 불러올 수 있다는 장점이 있다. 
		String sql;

		try {
			
			sql = "select num,id,pnum,pname,cnt,psize,price ";
			sql +="from cart where id like ? order by num desc ";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			//select이기 때문에 rs랑 Query사용

			while(rs.next()) {

				CartDTO dto = new CartDTO();	//list만들어서 거기에 값넣는 반복문

				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setPnum(rs.getString("pnum"));
				dto.setPname(rs.getString("pname"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setPsize(rs.getString("psize"));
				dto.setPrice(rs.getInt("price"));

				lists.add(dto);	//한 행씩 값을 리스트에 저장하는 거. 안그러면 뭉탱이로 안돌아댕김
			}

			pstmt.close();	//connection 사용한건 다 사용뒤에 close해주기!!
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return lists;

	}

	public CartDTO getReadData(int num) {

		CartDTO dto = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {


			sql = "select num,id,pnum,pname,cnt,psize,price ";
			sql+= "from cart where num=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				dto = new CartDTO();
				
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setPnum(rs.getString("pnum"));
				dto.setPname(rs.getString("pname"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setPsize(rs.getString("psize"));
				dto.setPrice(rs.getInt("price"));

			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return dto;


	}

	

	public int deleteData(int num) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "delete cart where num=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}
	
	public int updateCntData(int num, int std) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {

			sql = "update cart set cnt=? where num=?";
 			
 			pstmt = conn.prepareStatement(sql);
 			
 			pstmt.setInt(1, std);
 			pstmt.setInt(2, num);
 			
 			result = pstmt.executeUpdate();
 			
 			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
		
		
	}
	
	public CartDTO checkData(String id, String pnum, String psize) {
		
		CartDTO dto = null;
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs=null;
		
		
		
		
		try {
			
			sql = "select num,id,pnum,pname,cnt,psize,price from cart where id like ? and pnum like ? and psize like ?";
 			
 			pstmt = conn.prepareStatement(sql);
 			
 			pstmt.setString(1, id);
 			pstmt.setString(2, pnum);
 			pstmt.setString(3, psize);
 			//서치해서결과가 없으면 어케되는거지..? 널이겠지뭐~
 			
 			rs = pstmt.executeQuery();
 			
 			while(rs.next()) {
 				
 				dto = new CartDTO();
 				
 				dto.setId(rs.getString("id"));
 				dto.setPnum(rs.getString("pnum"));
 				dto.setPname(rs.getString("pname"));
 				dto.setPrice(rs.getInt("price"));
 				dto.setPsize(rs.getString("psize"));
 				dto.setCnt(rs.getInt("cnt"));
 				dto.setNum(rs.getInt("num"));
 						
 			}
 			rs.close();
 			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return dto;
	}
	
	public int updateCartData(String id,String pnum,String psize,int newcnt) {
		
		int result=0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update cart set cnt=? where id like ? and pnum like ? and psize like ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, newcnt);
			pstmt.setString(2, id);
			pstmt.setString(3, pnum);
			pstmt.setString(4, psize);
			
			result=pstmt.executeUpdate();

 			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
		
	}
	
	public int countCart(String id) {
		
		int result=0;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql;

		try {

			sql = "select count(*) from cart where id like ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}



}
