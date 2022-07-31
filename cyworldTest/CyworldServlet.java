package com.cyworld;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imageTest.ImageTestDTO;
import com.util.DBConn;

public class CyworldServlet extends HttpServlet {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		Connection conn = DBConn.getConnection();
		CyworldDAO dao = new CyworldDAO(conn);

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
			
		
			GuestDTO dto= new GuestDTO();
			int maxNum = dao.getMaxNum();
			
			dto.setNum(maxNum + 1);
			dto.setMessage(request.getParameter("message"));
			dto.setName(request.getParameter("name"));
			dto.setNickname(request.getParameter("nickname"));
			
			dao.insertComment(dto);
			
		url = cp+ "/cyworld/list.do";
		response.sendRedirect(url);
		
	}else if(uri.indexOf("list.do")!=-1) {
		
		List<GuestDTO> lists=dao.getlists();
		request.setAttribute("lists", lists);
		
		url = "/cyworldTest/main.jsp";
		forward(request, response, url);
		
		
	}



}
}