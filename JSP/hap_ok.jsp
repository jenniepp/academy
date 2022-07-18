<%@ page contentType="text/html; charset=UTF-8"%>

<%

request.setCharacterEncoding("UTF-8");

String s1=request.getParameter("su1");
String s2=request.getParameter("su2");
String s3=request.getParameter("name");

int sum=0;

int n1=Integer.parseInt(s1);
int n2=Integer.parseInt(s2);

sum=n1+n2; 

String name=s3;


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

결과 : <%=n1 %>+<%=n2 %>=<%=sum %><br/>
이름: <%=name %><br/>





</body>
</html>