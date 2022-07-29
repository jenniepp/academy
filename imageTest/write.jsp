
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이미지 업로드화면(첫화면)</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/imageTest/data/style.css"/>
<script type="text/javascript" src="<%=cp%>/imageTest/data/image.js"></script>

</head>
<body>

<br/><br/>
<table  style="margin: auto;">
	<tr><td class="title" width="500" height="40" align="center" >
	<b>이미지 게시판</b>
	</td></tr>
</table>

<br/><br/>
<form name="myForm" action="" method="post"
enctype="multipart/form-data">

<table class="content" width="500"  style="margin: auto;">
	<tr>
		<td class="style1" height="25" width="100" >
		제&nbsp;&nbsp;&nbsp;&nbsp;목</td>
		<td>
			<input type="text" name="subject">
		</td>
	</tr>

	<tr>
		<td class="style1" height="25" width="100" >
		파&nbsp;&nbsp;&nbsp;&nbsp;일</td>
		<td>
			<input type="file" name="upload" value="찾아보기"/><br/>
			
		</td>
	</tr>
</table>

<br/><br/>
	
<table style="margin: auto;">
	<tr><td>
		<input class="btn2" type="submit" value="등록하기" onclick="sendIt();"/>
		<input class="btn2" type="button" value="다시입력" onclick="location='<%=cp%>/image/write.do';"/>
		<input class="btn2" type="button" value="작성취소" onclick="location='<%=cp%>/image/list.do';"/>
	</td></tr>
</table>


</form>


</body>
</html>