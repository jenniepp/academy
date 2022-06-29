package Project;

public class DataVO {
	
	private String theater;
	private String date;
	private String movie;
	private String time;
	
	
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	@Override
	public String toString() {
		String str = String.format("%s %s %s %s", theater, date, time, movie);
		return str;
	}
	
	
}
