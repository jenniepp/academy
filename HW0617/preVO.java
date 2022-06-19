package pre;

public class preVO {//1. vo에 변수설정 해주기
	
	private String memberCode;
	private String name;
	private String birth;
	private String lastDate;
	private int point;
	
	
	
	
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
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
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	@Override
	public String toString() {

		if(memberCode==null||memberCode.equals("")) {	
			return null;				
		}else {

			String str=String.format("%5s %5s %5s %5s %5d",memberCode,name,birth,lastDate,point);

			return str;
		}

	}
	
	
}