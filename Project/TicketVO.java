package Project;

public class TicketVO {
	
	private String seat[];
	private int inwon;
	private int pay;
	private int tot;

	
	
	public String[] getSeat() {
		return seat;
	}
	public void setSeat(String[] seat) {
		this.seat = seat;
	}
	public int getInwon() {
		return inwon;
	}
	public void setInwon(int inwon) {
		this.inwon = inwon;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getTot() {
		return inwon * 10000;
	}

}
