<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	int dan=Integer.parseInt(request.getParameter("dan"));
	//넘어오는 애는 String으로 넘어오니까 그걸 int로 변경 한 번 해주고 dan으로 받기
	
	String str1="";
	for(int i=1;i<10;i++){
	str1+= String.format("%d*%d=%d<br/>",dan,i,dan*i); //jsp에서 줄바꿀때 <br/>해주기
	}


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%for(int i=1;i<10;i++){
	String str= String.format("%d*%d=%d<br/>",dan,i,dan*i); //jsp에서 줄바꿀때 <br/>해주기

	out.print(str);
}

%>

<%=str1 %>


</body>
</html>