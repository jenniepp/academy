<%@page import="com.util.DBConn"%>
<%@page import="com.board.BoardDAO"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="dto" class="com.board.BoardDTO" scope="page"/>
<jsp:setProperty property="*" name="dto"/>

<%

	String pageNum=request.getParameter("pageNum");

	Connection conn=DBConn.getConnection();
	BoardDAO dao=new BoardDAO(conn);

	//int result = dao.updateData(dto);
	
	dao.updateData(dto);
	
	response.sendRedirect("list.jsp?pageNum="+pageNum);

%>

