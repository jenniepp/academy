package com.imageTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fileTest.FileTestDTO;
import com.guest.GuestDTO;

public class ImageTestDAO {


	private Connection conn= null;

	public ImageTestDAO(Connection conn) {
		this.conn=conn;

		//이거 뭐라하냐 오버라이딩 생성자? 그거해서 시작하자마자 커넥션되게 만들기
	}
	

	public int getMaxNum() {

		int maxNum=0;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select nvl(max(num),0) from imageTest";

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
	
	
	public void insertData(ImageTestDTO dto) {
		//DTO타입의 dto 매개변수를 받아서 이 메소드를 실행하겠다~
		
		PreparedStatement pstmt = null; 
		String sql; //일단 선언만 하고 시작
		
		try {
			
			sql="insert into imageTest (num,subject,saveFileName,originalFileName) values (?,?,?,?)";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getSaveFileName());
			pstmt.setString(4, dto.getOriginalFileName());
			
			pstmt.executeUpdate();
			//여기서 execute업데이트랑 쿼리랑 구분은 어케하나요!?
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public List<ImageTestDTO> getlists(){

		List<ImageTestDTO> lists=new ArrayList<ImageTestDTO>();

		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql;

		try {

			sql="select num,subject,saveFileName,originalFileName ";
			sql+="from imageTest order by num desc";

			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				ImageTestDTO dto = new ImageTestDTO();

				dto.setNum(rs.getInt("num"));
				dto.setSubject(rs.getString("subject"));
				dto.setSaveFileName(rs.getString("saveFileName"));
				dto.setOriginalFileName(rs.getString("originalFileName"));

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
	
	List<ImageTestDTO> getLists(int start,int end){ //매개변수 없다. 전체 데이터 다 가져올것임

		List<ImageTestDTO> lists = new ArrayList<ImageTestDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null; //전체데이터를 가져올때 쓰는거. 한행씩 불러올 수 있다는 장점이 있다. 
		String sql;

		try {
			
			sql = "select * from (select rownum rnum, data.* ";
			sql +="from (select num,subject,saveFileName,originalFileName ";
			sql +="from imageTest order by num desc) data) ";
			sql +="where rnum>=? and rnum<=?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();
			//select이기 때문에 rs랑 Query사용

			while(rs.next()) {

				ImageTestDTO dto = new ImageTestDTO();	//list만들어서 거기에 값넣는 반복문

				dto.setNum(rs.getInt("num"));
				dto.setSubject(rs.getString("subject"));
				dto.setSaveFileName(rs.getString("saveFileName"));
				dto.setOriginalFileName(rs.getString("originalFileName"));
				

				lists.add(dto);	//한 행씩 값을 리스트에 저장하는 거. 안그러면 뭉탱이로 안돌아댕김
			}

			pstmt.close();	//connection 사용한건 다 사용뒤에 close해주기!!
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return lists;

	}
	
	public int getDataCount() {
		
		int dataCount = 0;

		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql;

		try {

			
			sql="select nvl(count(*),0) from imageTest ";

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


}
