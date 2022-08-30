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
	@Qualifier("boardDAO") //boardDAO�� ��Ȯ�ϰ� ������� ���ټ�����.
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
		//��ü ������ ���ϱ�
		int totalPage = myPage.getPageCount(numPerPage, dataCount);
		if(currentPage>totalPage) {
			currentPage = totalPage; //������ ������ ������ �߻��� ���� ������ ����
		}
		
		int start = (currentPage-1)*numPerPage+1;
		int end = currentPage*numPerPage; //���� ������ rnum�� ���۰� ������ ���س���. �̰� �� �� 12345/678910 �̰� ���� �ݺ������� �ҷ������� ������ ���� ���Ϸ��� ����
		
		List<BoardDTO> lists=
				dao.getList(start, end, searchKey, searchValue);
		//���س� start�� end ������ �ѹ��� ��Ÿ�� ��ŭ ����Ʈ�� ��������
		
		String param ="";
		if(searchValue!=null&&!searchValue.equals("")) {
			param="searchKey="+searchKey;
			param+="&searchValue="+URLEncoder.encode(searchValue, "UTF-8");
			
		}
		String listUrl = cp+"/list.action";
		
		if(!param.equals("")) {
			//param�� ���̶�� �� �˻��� ���ߴٴ� ��
			listUrl +="?"+param;
		}
		String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
		String articleUrl = cp+"/article.action?pageNum="+currentPage;
		
		if(!param.equals("")) {
			articleUrl +="&"+param;
		}
		
		//�������� ������(4���� �����͸� �� �Ʒ���url�ּҷ� ����.
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
		
		//��ƼŬ�� �׳� �����͸� �ѷ��ִ� ����
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue!=null && !searchValue.equals("")) {
			searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value���� �ѱ��� ���� �ֱ⶧���� �� ���ڴ� ���ִ°� ����. �����սô�
		}
		
		dao.updateHitCount(num);
		BoardDTO dto = dao.getReadData(num); //�ϳ��� �����͸� �о�;��ؼ� �׳� dto�� �д´�.
		
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
//		request.setAttribute("params", param); //���������� ���Ǵ� ���� �����̸��� param�� �־ �����̸��� param���� �����ָ� ������ �߻��Ѵ�!!��������
//		request.setAttribute("lineSu", lineSu); 
//		request.setAttribute("pageNum", pageNum); 
//		
//		return "bbs/article";
		
		ModelAndView mav = new ModelAndView();
		
		//ModelAndView���� ������ �ѱ�� ��
		mav.addObject("dto",dto);
		mav.addObject("params", param);
		mav.addObject("lineSu", lineSu);
		mav.addObject("pageNum", pageNum);
		
		//ModelAndView ������ ��� �Ѿ��
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
			searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value���� �ѱ��� ���� �ֱ⶧���� �� ���ڴ� ���ִ°� ����. �����սô�
		}
		
		BoardDTO dto = dao.getReadData(num); //�ϳ��� �����͸� �о�;��ؼ� �׳� dto�� �д´�.
		
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
		request.setAttribute("searchKey", searchKey);//searchkey�� �������� �Ѱܺ���!
		request.setAttribute("searchValue", searchValue);
		
		
		return "bbs/updated";
		
	}
	
	@RequestMapping(value = "/updated_ok.action", method = {RequestMethod.POST,RequestMethod.GET})
	public String update_ok(BoardDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String pageNum = request.getParameter("pageNum");
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue!=null && !searchValue.equals("")) {
			searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value���� �ѱ��� ���� �ֱ⶧���� �� ���ڴ� ���ִ°� ����. �����սô�
		}
		
		//������������ dto�� ������ �ϳ��ϳ� �޾��� �ʿ䰡 ����. ���� �ڵ� �� ����. jsp�� �޸� �������� dto��ü�� �ѱ�� �ڵ����� �Ѿ��
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
			searchValue =URLDecoder.decode(searchValue,"UTF-8"); //value���� �ѱ��� ���� �ֱ⶧���� �� ���ڴ� ���ִ°� ����. �����սô�
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
