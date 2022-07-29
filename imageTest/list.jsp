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
<title>이미지 리스트(두번째)</title>

<link rel="stylesheet" type="text/css" href="<%=cp%>/imageTest/data/style.css"/>
<script type="text/javascript" src="<%=cp%>/imageTest/data/image.js"></script>

</head>
<body>

<br/><br/>
<table  style="margin: auto;">
	<tr><td class="title" height="40" align="center" >
	<b>이미지 게시판</b>
	</td></tr>
	<br/>
	<tr>
		<td align="right" colspan="4">
		<input type="button" value="게시물 등록" onclick="location='<%=cp%>/image/write.do';"/>
		</td>
	</tr>
</table>

<br/><br/>

<table  style="margin: auto;">
<c:forEach var="dto" items="${lists }" varStatus="status">
	<c:if test="${status.count%3 == '1'}">
	<tr>
	</c:if>
		<td align="center" width="185">
		<img src="${imagePath }/${dto.saveFileName}" width="180" height="180"/>
		<br/>${dto.subject } 삭제</td>
	<c:if test="${status.count%3 == '0'}">
	</tr>
	</c:if>	
</c:forEach>
	

</table>

<br/><br/>
<center>
<table>
<tr><td>${pageIndexList}</td></tr>
</table>
</center>


</body>
</html>
