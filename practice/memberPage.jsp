<%@page import="com.join.JoinDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.join.JoinDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<jsp:useBean id="dto" class="com.join.JoinDTO" scope="page"></jsp:useBean>
<!-- dto라는 객체가 중복되어도 dto가 이 페이지를 벗어나지 않게 하기 위해서 적어주어야 한다. -->
<jsp:setProperty property="*" name="dto"/>

<% 
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
	
	Connection conn = DBConn.getConnection();
	JoinDAO dao = new JoinDAO(conn);
	//ScoreDAO dao = new ScoreDAO(DBConn.geConnection()); 로 쓰기도 한다.
	
	int result = dao.insertData(dto);
	
	DBConn.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>작성한 회원가입 정보</title>
</head>
<body>
	작성한 회원가입 정보 한번 더 뜨고 게시판으로 가는 버튼 만들기
	



</body>
</html>