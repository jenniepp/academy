package com.score;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConn;
import com.util.MyPage;

public class ScoreServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {

		//여기서 rd.forward()는 rd의 메소드 임. 위에 forward는 우리가 지정해서 만들어준 메소드
		RequestDispatcher rd=req.getRequestDispatcher(url);
		rd.forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String cp = req.getContextPath();
		String uri= req.getRequestURI();

		Connection conn=DBConn.getConnection();
		ScoreDAO dao=new ScoreDAO(conn);

		MyPage myPage = new MyPage();

		String url;

			//list.do에 전체 데이터 뽑아내서 출력해주기
		if(uri.indexOf("list.do")!=-1) {
			
			String pageNum = req.getParameter("pageNum");
			int currentPage =1;
			if(pageNum!=null) {
				currentPage = Integer.parseInt(pageNum);
			}
			
			int dataCount = dao.getDataCount();
			
			int numPerPage=3;
			//전체 페이지 구하기
			int totalPage = myPage.getPageCount(numPerPage, dataCount);
			if(currentPage>totalPage) {
				currentPage = totalPage; //마지막 페이지 삭제때 발생할 오류 방지를 위해
			}
			
			int start = (currentPage-1)*numPerPage+1;
			int end = currentPage*numPerPage; //내가 가져올 rnum의 시작과 끝값을 구해낸것. 이게 다 그 12345/678910 이거 숫자 반복문으로 불러오려고 시작점 끝점 구하려는 행위
			
			
			List<ScoreDTO> lists=dao.getLists(start, end);
			
			req.setAttribute("lists", lists);
			
			String listUrl = cp+"/sung/list.do";
			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
			String articleUrl = cp+"/sung/list.do?pageNum="+currentPage;
			
			req.setAttribute("lists", lists);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("articleUrl", articleUrl);
			req.setAttribute("dataCount", dataCount);
			
			url="/scoreTest/list.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("delete_ok.do")!=-1) {
			//링크가 deleted_ok.do가 됐을때 아래를 실행해라~ 이거니까 실제로 delete_ok.do에서는 실행할 내용이 없음. 즉 필요없음
			
			String hak = req.getParameter("hak");
			
			dao.deleteData(hak);
			
			url=cp+"/sung/list.do";
			resp.sendRedirect(url);
			//포워드랑 리다이렉트 구분어케함? jsp이외의코드가 있는곳은 포워드/아니면 리다이렉트 = 그래서 우리가 ok로끝나는 애들 다 리다이랙트라고 느낀것
			
		}else if(uri.indexOf("write.do")!=-1) {
			
			url="/scoreTest/write.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("write_ok.do")!=-1) {
			
			ScoreDTO dto = new ScoreDTO(); // 1.dto객체생성
			
			dto.setHak(req.getParameter("hak")); //4.이제값들 다 하나씩 불러서 넣어주기
			dto.setName(req.getParameter("name"));
			dto.setKor(Integer.parseInt(req.getParameter("kor")));
			dto.setEng(Integer.parseInt(req.getParameter("eng")));
			dto.setMat(Integer.parseInt(req.getParameter("mat")));
			
			dao.insertData(dto); //dao에 미리만들어둔 sql문 메소드 불러와서 넣기
			
			url=cp+"/sung/list.do";
			resp.sendRedirect(url); //6.리다이랙트 해주기
			
			
		}else if (uri.indexOf("update.do")!=-1) {
			
			String hak = req.getParameter("hak");
			
			ScoreDTO dto = dao.getReadData(hak); //하나의 데이터를 읽어와야해서 그냥 dto로 읽는다.
			
			
			if(dto==null) {
				url=cp+"/sung/list.do";
				resp.sendRedirect(url);
			}
			
			req.setAttribute("dto", dto);
			
			url="/scoreTest/update.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("update_ok.do")!=-1) {
			
			int hak = Integer.parseInt(req.getParameter("hak"));
			
			ScoreDTO dto = new ScoreDTO();
			
			dto.setHak(req.getParameter("hak")); //4.이제값들 다 하나씩 불러서 넣어주기
			dto.setName(req.getParameter("name"));
			dto.setKor(Integer.parseInt(req.getParameter("kor")));
			dto.setEng(Integer.parseInt(req.getParameter("eng")));
			dto.setMat(Integer.parseInt(req.getParameter("mat")));
			
			dao.updateData(dto);
			
			url=cp+"/sung/list.do";
			resp.sendRedirect(url);
		}
		
		
			
			
		}
		
	}



