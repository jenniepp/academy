package Project;

public interface Movie {
	public void ascSortFutureMovie(); //상영예정작(개봉일 내림차순 정렬)
	public void presentMovie(); //현재상영작(가나다 내림차순 정렬)
	public void searchMovie(); //영화이름 검색
	public void descSortRank(); //영화순위(예매율 오름차순 정렬)
	void print(MovieVO movieVO);
	
	
}
