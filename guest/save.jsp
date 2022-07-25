<%@page import="com.guest.GuestDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="dto" class="com.guest.GuestDTO" scope="page"/>
<jsp:setProperty property="*" name="dto"/>

<%
	Connection conn = DBConn.getConnection();
	GuestDAO dao = new GuestDAO(conn);

	int maxNum = dao.getMaxNum();

	dto.setNum(maxNum + 1);
	dto.setIpaddr(request.getRemoteAddr());

	dao.insertData(dto);

	response.sendRedirect("guest.jsp");

	DBConn.close();
%>