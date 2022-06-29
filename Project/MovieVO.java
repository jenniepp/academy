package Project;

public class MovieVO {

	String futureMovie;
	String fmDay;
	String presentMovie;
	Double per;
	Double grade;
	String pmDay;
	
	public String getFutureMovie() {
		return futureMovie;
	}
	public void setFutureMovie(String futureMovie) {
		this.futureMovie = futureMovie;
	}
	public String getFmDay() {
		return fmDay;
	}
	public void setFmDay(String fmDay) {
		this.fmDay = fmDay;
	}
	public String getPresentMovie() {
		return presentMovie;
	}
	public void setPresentMovie(String presentMovie) {
		this.presentMovie = presentMovie;
	}
	public Double getPer() {
		return per;
	}
	public void setPer(Double per) {
		this.per = per;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public String getPmDay() {
		return pmDay;
	}
	public void setPmDay(String pmDay) {
		this.pmDay = pmDay;
	}

	@Override
	public String toString() {
		
		String str = String.format("영화명: %-14s \t 예매율: %4s%%   평점: %3.2g점   개봉일: %3s",
			presentMovie,per,grade,pmDay);
		return str;
	}
	
}
