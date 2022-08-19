<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
	
	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
%>

아이디 : <%=userId%><br/>
비밀번호 : <%=userPwd%><br/>