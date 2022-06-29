package Project;

import java.util.ArrayList;
import java.util.List;

public class MyPageVO {
	
	
	private String id;
	private String password;
	private String name;
	private String birth;
	private int point;
	private String level;
	private int moviecount;
	
	
	
	List<TicketVO> listsT1 = new ArrayList<>();
	List<String> listsT2 = new ArrayList<>();
	
	
	public List<TicketVO> getListsT1() {
		return listsT1;
	}
	public void setListsT1(List<TicketVO> listsT1) {
		this.listsT1 = listsT1;
	}
	public List<String> getListsT2() {
		return listsT2;
	}
	public void setListsT2(List<String> listsT2) {
		this.listsT2 = listsT2;
	}
	
	
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getLevel() {
		
		if(getPoint()>=50000 || getMoviecount()>=10) {
			level="플래티넘";
		}else if(getPoint()>=30000 || getMoviecount()>=3) {
			level="골드";
		}else  {
				level="베이직";
		}
		
		return level;
	}
	
	public int getMoviecount() {
		return moviecount;
	}
	public void setMoviecount(int moviecount) {
		this.moviecount = moviecount;
	}
	
	

}
