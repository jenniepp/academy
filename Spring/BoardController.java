package com.jdbc.springweb;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jdbc.dao.BoardDAO;
import com.jdbc.dto.BoardDTO;
import com.jdbc.util.MyPage;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardDAO") //boardDAO를 정확하게 들고오라고 해줄수있음.
	BoardDAO dao;
	
	@Autowired
	MyPage myPage;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	/*
	@RequestMapping(value = "/created.action",method = RequestMethod.GET)
	public String created() throws Exception{
		
		return "/bbs/created";
	}*/
	
	@RequestMapping(value="/created.action")
	public ModelAndView created() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbs/created");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/created_ok.action", method = {RequestMethod.POST,RequestMethod.GET})
	public String created_ok(BoardDTO dto, 
			HttpServletRequest request) throws Exception{
		
		int maxNum = dao.getMaxNum();
		
		dto.setNum(maxNum+1);
		dto.setIpAddr(request.getRemoteAddr());
		
		dao.insertData(dto);
		
		return "redirect:/list.action";
		
	}
	
	@RequestMapping(value = "/list.action", method = {RequestMethod.POST,RequestMethod.GET})
	public String list(HttpServletRequest request) throws Exception{
		
		String cp = request.getContextPath();
		
		String pageNum = request.getParameter("pageNum");
		int currentPage =1;
		if(pageNum!=null) {
			currentPage = Integer.parseInt(pageNum);
		}
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue==null) {
			searchKey = "subject";
			searchValue = "";
			
		}else {
			if(request.getMethod().equalsIgnoreCase("GET")) {
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
		String listUrl = cp+"/list.action";
		
		if(!param.equals("")) {
			//param이 널이라는 건 검색을 안했다는 거
			listUrl +="?"+param;
		}
		String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
		String articleUrl = cp+"/article.action?pageNum="+currentPage;
		
		if(!param.equals("")) {
			articleUrl +="&"+param;
		}
		
		//포워딩할 데이터(4개의 데이터를 그 아래줄url주소로 보냄.
		request.setAttribute("lists", lists);
		request.setAttribute("pageIndexList", pageIndexList);
		request.setAttribute("articleUrl", articleUrl);
		request.setAttribute("dataCount", dataCount);
		
		return "bbs/list";
		
	}
	
//	@RequestMapping(value = "/article.action", method = {RequestMethod.POST,RequestMethod.GET})
//	public String article(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
	@RequestMapping(value = "/article.action", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView article(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String cp = request.getContextPath();
		
		//아티클은 그냥 데이터를 뿌려주는 역할
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue!=null && !searchValue.equals("")) {
			searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value값은 한글일 수도 있기때문에 늘 디코더 해주는게 좋다. 유의합시다
		}
		
		dao.updateHitCount(num);
		BoardDTO dto = dao.getReadData(num); //하나의 데이터를 읽어와야해서 그냥 dto로 읽는다.
		
		if(dto==null) {
//			String url=cp+"bbs/list.action";
//			response.sendRedirect(url);
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/list.action");
			
			return mav;
				
		}
		
		int lineSu=dto.getContent().split("\n").length; 
		dto.setContent(dto.getContent().replaceAll("\r", "<br/>"));
		
		String param = "pageNum="+pageNum;
		
		if(searchValue!=null && !searchValue.equals("")) {
			param +="&searchKey="+searchKey;
			param +="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
			
		}
		
//		request.setAttribute("dto", dto);
//		request.setAttribute("params", param); //내부적으로 사용되는 서블릿 변수이름에 param이 있어서 변수이름을 param으로 맞춰주면 오류가 발생한다!!쓰지말장
//		request.setAttribute("lineSu", lineSu); 
//		request.setAttribute("pageNum", pageNum); 
//		
//		return "bbs/article";
		
		ModelAndView mav = new ModelAndView();
		
		//ModelAndView에서 데이터 넘기는 법
		mav.addObject("dto",dto);
		mav.addObject("params", param);
		mav.addObject("lineSu", lineSu);
		mav.addObject("pageNum", pageNum);
		
		//ModelAndView 데이터 들고 넘어가라
		mav.setViewName("bbs/article");
		
		return mav;
		
	}
	
	@RequestMapping(value = "/updated.action", method = {RequestMethod.POST,RequestMethod.GET})
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String cp = request.getContextPath();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue!=null && !searchValue.equals("")) {
			searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value값은 한글일 수도 있기때문에 늘 디코더 해주는게 좋다. 유의합시다
		}
		
		BoardDTO dto = dao.getReadData(num); //하나의 데이터를 읽어와야해서 그냥 dto로 읽는다.
		
		if(dto==null) {
			String url=cp+"/bbs/list.action";
			response.sendRedirect(url);
		}
		
		String param = "pageNum="+pageNum;
		
		if(searchValue!=null && !searchValue.equals("")) {
			param +="&searchKey="+searchKey;
			param +="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
			
		}
		
		
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("params", param);
		request.setAttribute("searchKey", searchKey);//searchkey를 수동으로 넘겨보자!
		request.setAttribute("searchValue", searchValue);
		
		
		return "bbs/updated";
		
	}
	
	@RequestMapping(value = "/updated_ok.action", method = {RequestMethod.POST,RequestMethod.GET})
	public String update_ok(BoardDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String pageNum = request.getParameter("pageNum");
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue!=null && !searchValue.equals("")) {
			searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value값은 한글일 수도 있기때문에 늘 디코더 해주는게 좋다. 유의합시다
		}
		
		//스프링에서는 dto의 데이터 하나하나 받아줄 필요가 없다. 관련 코딩 다 지움. jsp와 달리 스프링은 dto자체를 넘기면 자동으로 넘어옴
		dao.updateData(dto);
		
		String param = "pageNum="+pageNum;
		
		if(searchValue!=null && !searchValue.equals("")) {
			
			param +="&searchKey="+searchKey;
			param +="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
			
		}
		
		return "redirect:/list.action?"+param;
		
	}
	
	@RequestMapping(value = "/deleted_ok.action", method = {RequestMethod.POST,RequestMethod.GET})
	public String deleded_pk(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue!=null && !searchValue.equals("")) {
			searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value값은 한글일 수도 있기때문에 늘 디코더 해주는게 좋다. 유의합시다
		}
		
		String param = "pageNum="+pageNum;
		
		if(searchValue!=null && !searchValue.equals("")) {
			
			param +="&searchKey="+searchKey;
			param +="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
			
		}
		dao.deleteData(num);
		
		return "redirect:/list.action?"+param;
	}
	
	
	
	
	

}
