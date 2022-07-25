<%@page import="com.guest.GuestDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
	
	int num = Integer.parseInt(request.getParameter("num"));
	//주소에 있는 num=**가 여기 num으로 들어가는 거임!!
	String pageNum=request.getParameter("pageNum");
	
	Connection conn = DBConn.getConnection();
	GuestDAO dao = new GuestDAO(conn);
	
	int result = dao.deleteData(num);
	
	DBConn.close();
	
	response.sendRedirect("guest.jsp");
			
%>