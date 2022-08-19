<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
	
	String greeting = request.getParameter("greeting");
	
	
%>
<!--  데이터 읽을 필요 없음 받기만 하면됨 -->

<%="server: " + greeting %>