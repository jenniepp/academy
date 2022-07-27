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

import com.board.BoardDAO;
import com.board.BoardDTO;
import com.util.DBConn;
import com.util.MyPage;

public class BoardServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		
	}
	
	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
		
		//여기서 rd.forward()는 rd의 메소드 임. 위에 forward는 우리가 지정해서 만들어준 메소드
		RequestDispatcher rd=req.getRequestDispatcher(url);
		rd.forward(req, resp);
		
		//여기까지가 데이터를 get방식이든 post방식이든 받아 올 수 있게 만든 코드
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String cp = req.getContextPath();
		String uri= req.getRequestURI();
		
		Connection conn=DBConn.getConnection();
		BoardDAO dao=new BoardDAO(conn);
		
		MyPage myPage = new MyPage();
		
		String url;
		//여기까지가 데이터를 get방식이든 post방식이든 받아 올 수 있게 만든 코드
		
		//이게 뭐냐면 created.jsp면 0 아니면 -1뜰거니까 주소가 created.jsp라면 실행해라~
		if(uri.indexOf("created.do")!=-1) {
			
			url="/boardTest/created.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("created_ok.do")!=-1) {
			
			BoardDTO dto = new BoardDTO(); // 1.dto객체생성
			int maxNum = dao.getMaxNum(); //2.maxnum 불러오기
			
			dto.setNum(maxNum+1); //3.우리 값중에 비어있는 num을 데이터 다 부르기 전에 채워주기
			dto.setSubject(req.getParameter("subject")); //4.이제값들 다 하나씩 불러서 넣어주기
			dto.setName(req.getParameter("name"));
			dto.setEmail(req.getParameter("email"));
			dto.setPwd(req.getParameter("pwd"));
			dto.setContent(req.getParameter("content"));
			dto.setIpAddr(req.getRemoteAddr()); //5.ip는 ip불러오는 메소드 사용해서 넣어주기
			
			dao.insertData(dto); //dao에 미리만들어둔 sql문 메소드 불러와서 넣기
			
			url=cp+"/bbs/list.do";
			resp.sendRedirect(url); //6.리다이랙트 해주기
			
			
		}else if(uri.indexOf("list.do")!=-1) {
			
			String pageNum = req.getParameter("pageNum");
			int currentPage =1;
			if(pageNum!=null) {
				currentPage = Integer.parseInt(pageNum);
			}
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue==null) {
				searchKey = "subject";
				searchValue = "";
				
			}else {
				if(req.getMethod().equalsIgnoreCase("GET")) {
					searchValue = URLDecoder.decode(searchValue,"UTF-8");
				}
			}
			
			int dataCount = dao.getDataCount(searchKey, searchValue);
			
			int numPerPage=5;
			//전체 페이지 구하기
			int totalPage = myPage.getPageCount(numPerPage, dataCount);
			if(currentPage>totalPage) {
				currentPage = totalPage; //마지막 페이지 삭제때 발생할 오류 방지를 위해
			}
			
			int start = (currentPage-1)*numPerPage+1;
			int end = currentPage*numPerPage; //내가 가져올 rnum의 시작과 끝값을 구해낸것. 이게 다 그 12345/678910 이거 숫자 반복문으로 불러오려고 시작점 끝점 구하려는 행위
			
			List<BoardDTO> lists=
					dao.getList(start, end, searchKey, searchValue);
			//구해낸 start와 end 가지고 한번에 나타낼 만큼 리스트로 꺼내오기
			
			String param ="";
			if(searchValue!=null&&!searchValue.equals("")) {
				param="searchKey="+searchKey;
				param+="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
				
			}
			String listUrl = cp+"/bbs/list.do";
			
			if(!param.equals("")) {
				//param이 널이라는 건 검색을 안했다는 거
				listUrl +="?"+param;
			}
			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
			String articleUrl = cp+"/bbs/article.do?pageNum="+currentPage;
			
			if(!param.equals("")) {
				articleUrl +="&"+param;
			}
			
			//포워딩할 데이터(4개의 데이터를 그 아래줄url주소로 보냄.
			req.setAttribute("lists", lists);
			req.setAttribute("pageIndexList", pageIndexList);
			req.setAttribute("articleUrl", articleUrl);
			req.setAttribute("dataCount", dataCount);
			
			url="/boardTest/list.jsp";
			forward(req, resp, url);
			
		}else if (uri.indexOf("article.do")!=-1) {
			
			//아티클은 그냥 데이터를 뿌려주는 역할
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue!=null && !searchValue.equals("")) {
				searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value값은 한글일 수도 있기때문에 늘 디코더 해주는게 좋다. 유의합시다
			}
			
			dao.updateHitCount(num);
			BoardDTO dto = dao.getReadData(num); //하나의 데이터를 읽어와야해서 그냥 dto로 읽는다.
			
			if(dto==null) {
				url=cp+"/bbs/list.do";
				resp.sendRedirect(url);
			}
			
			int lineSu=dto.getContent().split("\n").length; 
			dto.setContent(dto.getContent().replaceAll("\r", "<br/>"));
			
			String param = "pageNum="+pageNum;
			
			if(searchValue!=null && !searchValue.equals("")) {
				param +="&searchKey="+searchKey;
				param +="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
				
			}
			
			req.setAttribute("dto", dto);
			req.setAttribute("params", param); //내부적으로 사용되는 서블릿 변수이름에 param이 있어서 변수이름을 param으로 맞춰주면 오류가 발생한다!!쓰지말장
			req.setAttribute("lineSu", lineSu); 
			req.setAttribute("pageNum", pageNum); 
			
			
			url="/boardTest/article.jsp";
			forward(req, resp, url);
			
		}else if (uri.indexOf("updated.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue!=null && !searchValue.equals("")) {
				searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value값은 한글일 수도 있기때문에 늘 디코더 해주는게 좋다. 유의합시다
			}
			
			BoardDTO dto = dao.getReadData(num); //하나의 데이터를 읽어와야해서 그냥 dto로 읽는다.
			
			if(dto==null) {
				url=cp+"/bbs/list.do";
				resp.sendRedirect(url);
			}
			
			String param = "pageNum="+pageNum;
			
			if(searchValue!=null && !searchValue.equals("")) {
				param +="&searchKey="+searchKey;
				param +="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
				
			}
			
			
			req.setAttribute("dto", dto);
			req.setAttribute("pageNum", pageNum);
			req.setAttribute("params", param);
			req.setAttribute("searchKey", searchKey);//searchkey를 수동으로 넘겨보자!
			req.setAttribute("searchValue", searchValue);
			
			
			url="/boardTest/updated.jsp";
			forward(req, resp, url);
			
		}else if(uri.indexOf("updated_ok.do")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue!=null && !searchValue.equals("")) {
				searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value값은 한글일 수도 있기때문에 늘 디코더 해주는게 좋다. 유의합시다
			}
			
			BoardDTO dto = new BoardDTO();
			
			dto.setNum(Integer.parseInt(req.getParameter("num")));
			dto.setSubject(req.getParameter("subject"));
			dto.setName(req.getParameter("name"));
			dto.setEmail(req.getParameter("email"));
			dto.setPwd(req.getParameter("pwd"));
			dto.setContent(req.getParameter("content"));
			
			dao.updateData(dto);
			
			String param = "pageNum="+pageNum;
			
			if(searchValue!=null && !searchValue.equals("")) {
				
				param +="&searchKey="+searchKey;
				param +="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
				
			}
			
			
			
			url=cp+"/bbs/list.do?"+param;
			resp.sendRedirect(url);
		}else if(uri.indexOf("delete_ok")!=-1) {
			
			int num = Integer.parseInt(req.getParameter("num"));
			String pageNum = req.getParameter("pageNum");
			
			String searchKey = req.getParameter("searchKey");
			String searchValue = req.getParameter("searchValue");
			
			if(searchValue!=null && !searchValue.equals("")) {
				searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value값은 한글일 수도 있기때문에 늘 디코더 해주는게 좋다. 유의합시다
			}
			
			String param = "pageNum="+pageNum;
			
			if(searchValue!=null && !searchValue.equals("")) {
				
				param +="&searchKey="+searchKey;
				param +="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
				
			}
			
			url=cp+"/bbs/list.do?"+param;
			resp.sendRedirect(url);
			
			dao.deleteData(num);
			
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	

}
