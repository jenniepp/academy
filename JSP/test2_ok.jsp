<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");

	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
	String userName = request.getParameter("userName");
	String gender = request.getParameter("gender");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String[] hobby = request.getParameterValues("hobby"); //여러개 선택 가능하니까
	String agreeChk = request.getParameter("agreeChk");
	String memo = request.getParameter("memo");
	
	String str="";
	if(hobby!=null){
		for(String temp : hobby){
			str+=temp+" ";
		} //취미 여러개 선택했으니까 그거를 다 출력할수있게 배열로 해야함
	}
	
	memo=memo.replaceAll("\n", "<br/>");
%>

<!DOCTYPE html PUBLIC "-//W3 C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

아이디=<%=userId %><br/>
패스워드=<%=userPwd %><br/>
이름:<%=userName %><br/>
성별:<%=gender %><br/>
전화:<%=tel1 %>-<%=tel2 %>-<%=tel3 %><br/>
취미:<%=str %><br/>
동의:<%=agreeChk %><br/>
메모:<%=memo %>


</body>
</html>