package com.imageTest;

import java.io.File;
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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.DBConn;
import com.util.FileManager;
import com.util.MyPage;

public class ImageTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//우리가 url이랑 데이터 같이 보내줄 때 포워드하거나 리다이랙트 하는데 포워드는 우리가 정의한 메소드를 쓸거라 이렇게 정의하는 것
	protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	//우리는 get방식이나 post방식 중 하나를 선택할 건데 이때 코드를 두번에 나눠 쓰지 않기 위해서 get방식으로 오면 post메소드로 보내서 그방식대로 운영해라~ 라는 메소드임
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	//get방식에서 안쓴 코드를 여기다 다 몰아 쓰는 것. 가상의 주소를 가지고 이렇게 이렇게 행동해라~ 라고 하기위해서
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		Connection conn = DBConn.getConnection();
		ImageTestDAO dao = new ImageTestDAO(conn);

		String cp = request.getContextPath();
		String uri = request.getRequestURI();

		String url;

		//파일 저장 경로 설정 : 여기까지의 코드가 잘 이해가지않음.. 아래 두줄 뭔뜻임?
		String root = getServletContext().getRealPath("/");
		String path = root + "pds" + File.separator + "imageFile";
		//System.out.println(root + ", "+path);
		
		File f= new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}

		
		if(uri.indexOf("write.do")!=-1) {

			url = "/imageTest/write.jsp";
			forward(request, response, url);
			
		}else if(uri.indexOf("write_ok.do")!=-1) {
			//등록하기 버튼 누르면 write_ok로 온다.

			String encType = "UTF-8"; //한글파일도 읽어주려고 쓰는 인코딩코드
			int maxSize = 10*1024*1024; //사이즈 제한 주기

			//여기 3줄 이해안감 왜 필요한거?
			MultipartRequest mr =
					new MultipartRequest(request, path, maxSize, encType,
							new DefaultFileRenamePolicy());
			
			//이건 또 뭐하는 과정인거..? 하 이거 한줄 뭐하는 거야..?
			if(mr.getFile("upload")!=null) {

				ImageTestDTO dto = new ImageTestDTO();
				int maxNum = dao.getMaxNum();

				dto.setNum(maxNum + 1);
				dto.setSubject(mr.getParameter("subject"));
				dto.setSaveFileName(mr.getFilesystemName("upload"));
				dto.setOriginalFileName(mr.getOriginalFileName("upload"));

				dao.insertData(dto);
			}

			url = cp+ "/image/list.do";
			response.sendRedirect(url);
			
			
		
			
		}else if(uri.indexOf("list.do")!=-1) {
			
			MyPage myPage = new MyPage();
			
			//이미지 불러올 imagePath만들어 주기
			String imagePath = cp + "/pds/imageFile";
			
			
			//하 이건 또 뭐임 ㅅㅂ 어따쓰는거지?
			//request.setAttribute("deletePath", deletePath);
			
			String pageNum = request.getParameter("pageNum");
			int currentPage =1;
			if(pageNum!=null) {
				currentPage = Integer.parseInt(pageNum);
			}
			
			int numPerPage=9;
			int dataCount = dao.getDataCount();
			//전체 페이지 구하기
			int totalPage = myPage.getPageCount(numPerPage, dataCount);
			if(currentPage>totalPage) {
				currentPage = totalPage; //마지막 페이지 삭제때 발생할 오류 방지를 위해
			}
			
			int start = (currentPage-1)*numPerPage+1;
			int end = currentPage*numPerPage; //내가 가져올 rnum의 시작과 끝값을 구해낸것. 이게 다 그 12345/678910 이거 숫자 반복문으로 불러오려고 시작점 끝점 구하려는 행위
			
			List<ImageTestDTO> lists=
					dao.getLists(start, end);
			//구해낸 start와 end 가지고 한번에 나타낼 만큼 리스트로 꺼내오기
			
			String listUrl = cp+"/image/list.do";
			String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
			
			request.setAttribute("imagePath", imagePath);
			request.setAttribute("lists", lists);
			request.setAttribute("pageIndexList", pageIndexList);
			request.setAttribute("dataCount", dataCount);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", currentPage);

			
			url = "/imageTest/list.jsp";
			forward(request, response, url);
			
		}else if(uri.indexOf("delete.do")!=-1) {
			
			int num = Integer.parseInt(request.getParameter("num"));
			
			ImageTestDTO dto = dao.getReadData(num);


			FileManager.doFileDelete(dto.getSaveFileName(), path);
			
			dao.deleteData(num);
			
			url = cp+ "/image/list.do";
			response.sendRedirect(url);
			
			
			
			
			
		}
		
	
	
	}







	}
