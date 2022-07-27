package com.score;
//사용자가 입력한 데이터를 DB로 찾아가서 처리해주는 작업을 하는 클래스

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {

	private Connection conn;
	
	//생성자이기 떄문에 객체를 생성함과 동시에 위에
	//private Connection conn;에서 객체를 초기화 시키는 작업을 한 번에 한다.
 	public ScoreDAO(Connection conn) { 
 		//생성자 오버로딩, jsp에서는 의존성 주입이라 한다.
 		this.conn = conn;
 	}
	
 	//입력(write.jsp -> write_ok.jsp)
 	public int insertData(ScoreDTO dto) {
		
 		int result = 0;
 		//db acess
 		PreparedStatement pstmt = null;
 		//sql을 담을 변수 생성
 		String sql;
 		
 		try {
 			//반드시 한 칸 스페이스바를 눌러줘야 뒤에 value값과 연결이 되지 않는다.
			sql = "insert into score (hak,name,kor,eng,mat) ";
			sql+= "values(?,?,?,?,?)";
					
			//connection이 statement를 만든다.		
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getHak());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			
			//결과값 반환 result로 받을 준비를 함
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
 		
 		return result;
	
 	}
	
 	//전체데이터(list.jsp)
 	public List<ScoreDTO> getLists(){ //매개변수 없다. 전체 데이터 다 가져올것임
 		
 		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;
 		String sql;
 		
 		try {
			
 			sql = "select hak,name,kor,eng,mat, ";
 			sql+= "(kor+eng+mat) tot, (kor+eng+mat)/3 ave, ";
 			sql+= "rank() over (order by (kor+eng+mat) desc) rank ";
 			sql+= "from score";
 			
 			pstmt = conn.prepareStatement(sql);
 			
 			rs = pstmt.executeQuery();
 			//select이기 때문에 Query사용
 			
 			while(rs.next()) {
 				
 				ScoreDTO dto = new ScoreDTO();
 				
 				dto.setHak(rs.getString("hak"));
 				dto.setName(rs.getString("name"));
 				dto.setKor(rs.getInt("kor"));
 				dto.setEng(rs.getInt("eng"));
 				dto.setMat(rs.getInt("mat"));
 				dto.setTot(rs.getInt("tot"));
 				dto.setAve(rs.getInt("ave"));
 				dto.setRank(rs.getInt("rank"));
 						
 				lists.add(dto);
 			}
 			
 			pstmt.close();
 			rs.close();
 			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
 		
 		return lists;
 		
 	}
 	
 	public List<ScoreDTO> getLists(int start, int end){ //매개변수 없다. 전체 데이터 다 가져올것임
 		
 		List<ScoreDTO> lists = new ArrayList<ScoreDTO>();
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;
 		String sql;
 		
 		try {
 			
 			sql = "select * from (";
			sql += "select rownum rnum, data.* from (";
			sql +="select hak,name,kor,eng,mat, ";
			sql +="(kor+eng+mat) tot, (kor+eng+mat)/3 ave, ";
			sql+= "rank() over (order by (kor+eng+mat) desc) rank from score";
			sql +=" order by rank() over (order by (kor+eng+mat) desc)) data) ";
			sql +="where rnum>=? and rnum<=?";
			
 			
 			pstmt = conn.prepareStatement(sql);
 			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
 			
 			rs = pstmt.executeQuery();
 			//select이기 때문에 Query사용
 			
 			while(rs.next()) {
 				
 				ScoreDTO dto = new ScoreDTO();
 				
 				dto.setHak(rs.getString("hak"));
 				dto.setName(rs.getString("name"));
 				dto.setKor(rs.getInt("kor"));
 				dto.setEng(rs.getInt("eng"));
 				dto.setMat(rs.getInt("mat"));
 				dto.setTot(rs.getInt("tot"));
 				dto.setAve(rs.getInt("ave"));
 				dto.setRank(rs.getInt("rank"));
 						
 				lists.add(dto);
 			}
 			
 			pstmt.close();
 			rs.close();
 			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
 		
 		return lists;
 		
 	}
 	
 	//수정할 데이터 가져오기(update.jsp)
 	public ScoreDTO getReadData(String hak) {//매개변수가 학번
		
 		//학번을 검색했는데 없을 수도 있으니까
 		ScoreDTO dto = null;
 		PreparedStatement pstmt = null;
 		ResultSet rs = null;
 		String sql;
 		
 		try {
			
 			sql = "select hak,name,kor,eng,mat ";
 			sql+= "from score where hak=?";
 			
 			pstmt = conn.prepareStatement(sql);
 			
 			pstmt.setString(1, hak);
 			
 			rs = pstmt.executeQuery();
 			
 			if(rs.next()) {
 				//if문 안으로 들어왔다?데이터가 있다 -> 객체를 생성
 				dto = new ScoreDTO();
 				
 				dto.setHak(rs.getString("hak"));
 				dto.setName(rs.getString("name"));
 				dto.setKor(rs.getInt("kor"));
 				dto.setEng(rs.getInt("eng"));
 				dto.setMat(rs.getInt("mat"));
 				
 			}
 			
 			rs.close();
 			pstmt.close();
 			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
 		
 		return dto;
 		
	}
 	
 	//update한 값을 진짜 수정하게 만드는 데이터
 	//update.jsp -> update_ok.jsp 
 	public int updateData(ScoreDTO dto) { //국,영,수,학번 받을거라 ScoreDTO dto
		
 		int result = 0;
 		
 		PreparedStatement pstmt = null;
 		String sql = null;
 		
 		try {
			
 			//2번째부터 sql에 +를 안 붙이면 누적이 되지 않아 값이 출력X
 			sql = "update score set kor=?,eng=?,mat=? ";
 			sql+= "where hak=?";
 			
 			pstmt = conn.prepareStatement(sql);
 			
 			pstmt.setInt(1, dto.getKor());
 			pstmt.setInt(2, dto.getEng());
 			pstmt.setInt(3, dto.getMat());
 			pstmt.setString(4, dto.getHak());
 			
 			result = pstmt.executeUpdate();
 			
 			pstmt.close();
 			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
 		
 		return result;
 		
	}
 	
 	//삭제 (delete_ok.jsp)
 	public int deleteData(String hak) {
 		
 		int result = 0;
 		PreparedStatement pstmt = null;
 		String sql;
 		
 		try {
 			
 			sql = "delete score where hak=?";
 			
 			pstmt = conn.prepareStatement(sql);
 			
 			pstmt.setString(1, hak);
 			
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
 			sql="select nvl(count(*),0) from score ";

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
