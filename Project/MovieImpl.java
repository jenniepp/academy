package Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class MovieImpl implements Movie{

	Scanner sc = new Scanner(System.in);

	String[] futureMovieArr = {"헤어질 결심","미친능력","고스트랜드","보통의 용기","컴온컴온","토르:러브앤썬더",};
	String[] fmDayArr = {"06/29","06/29","06/29","06/30","06/30","07/06"};
	String[] presentMovieArr = {"마녀part2","브로커","범죄도시2","버즈라이트이어","쥬라기월드:도미니언","탑건:매버릭"};
	Double[] perArr = {6.7, 1.5, 6.5, 0.7, 0.2, 43.1};
	Double[] gradeArr = {8.2,8.1,9.7,8.6,8.4,9.8};
	String[] pmDayArr = {"06/15","06/08","05/18","06/15","06/01","06/22"};

	private List<MovieVO> plists = new ArrayList<>();
	private List<MovieVO> flists = new ArrayList<>();

	int i,j,k,n;

	public MovieImpl() {

		for(i=0;i<presentMovieArr.length;i++) {

			MovieVO vo = new MovieVO();
			vo.setPresentMovie(presentMovieArr[i]);
			vo.setPer(perArr[i]);
			vo.setGrade(gradeArr[i]);
			vo.setPmDay(pmDayArr[i]);

			plists.add(vo);
		}

		MovieArr();
	}

	public void MovieArr() {

		for(i=0;i<futureMovieArr.length;i++) {

			MovieVO vo = new MovieVO();
			vo.setFutureMovie(futureMovieArr[i]);
			vo.setFmDay(fmDayArr[i]);

			flists.add(vo);
		}
	}

	@Override
	public void ascSortFutureMovie() {

		for(int i=0;i<futureMovieArr.length;i++) {
			System.out.printf("상영예정작: %7s \t개봉일: %4s\n",futureMovieArr[i],fmDayArr[i]);

		}
	}

	@Override
	public void presentMovie() {
		for(int i=0;i<presentMovieArr.length;i++) {
			System.out.printf("현재상영작: %10s\t예매율: %s%% \t평점: %.2g  개봉일: %4s\n",
					presentMovieArr[i],perArr[i],gradeArr[i],pmDayArr[i]);

		}
	}

	@Override
	public void searchMovie() {
		System.out.print("검색 할 영화의 이름을 입력하시오."); 
		String name = sc.next();

		boolean result = false;

		Iterator<MovieVO> pit = plists.iterator();
		while(pit.hasNext()) {

			MovieVO vo = pit.next();

			if(name.equals(vo.getPresentMovie())) {

				System.out.println(vo.toString());
				result = true;
				return;

			} 
		}

		Iterator<MovieVO> fit = flists.iterator();
		while(fit.hasNext()) {

			MovieVO vo1 = fit.next();

			if(name.equals(vo1.getFutureMovie())) {
				result = true;
				print(vo1);
				return;
			}

		}

			if (!result) {

				System.out.println("영화가 존재하지 않습니다.");
			}
	
	}

	@Override
	public void descSortRank() {
		int su;
		System.out.println("1.예매율순 2.평점순");
		su = sc.nextInt();

		switch(su) {

		case 1:
			Comparator<MovieVO> comp = new Comparator<MovieVO>() {

				@Override
				public int compare(MovieVO o1, MovieVO o2) {
					return o1.getPer()<o2.getPer()?1:-1;
				}

			}; 
			Collections.sort(plists, comp);

			Iterator<MovieVO> it1 = plists.iterator();
			while(it1.hasNext()) {
				for(int i=0;i<presentMovieArr.length;i++) {
					MovieVO vo = it1.next();
					System.out.print("[영화순위 "+(i+1)+"위] ");
					System.out.println(vo.toString());
				}
			}

			break;

		case 2:
			Comparator<MovieVO> comp1 = new Comparator<MovieVO>() {

				@Override
				public int compare(MovieVO o1, MovieVO o2) {
					return (o1.getGrade()<o2.getGrade()?1:-1);
				}

			}; Collections.sort(plists, comp1);

			Iterator<MovieVO> it2 = plists.iterator();

			while(it2.hasNext()) {

				for(int i=0;i<presentMovieArr.length;i++) {
					MovieVO vo = it2.next();
					System.out.print("[영화순위 "+ (i+1) + "위] ");
					System.out.println(vo.toString());
				}
			}
			break;

		default:
			System.out.println("숫자를 잘못 입력하였습니다.");
			break;
		}
	}

	@Override
	public void print(MovieVO movieVO) {

		MovieVO vo = movieVO;

		System.out.printf("영화명: %s 개봉일: %s",vo.getFutureMovie(),vo.getFmDay() );
	}

}