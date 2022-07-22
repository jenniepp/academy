<%@page import="java.sql.Connection"%>
<%@page import="com.board.BoardDAO"%>
<%@page import="com.util.DBConn"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<% 
	//num:고유번호 , pageNum페이지번호
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
	
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum=request.getParameter("pageNum");

	Connection conn=DBConn.getConnection();
	BoardDAO dao=new BoardDAO(conn);

	//int result = dao.updateData(dto);
	
	dao.deleteData(num);
	DBConn.close();
	
	response.sendRedirect("list.jsp?pageNum="+pageNum);
	
	
%>
