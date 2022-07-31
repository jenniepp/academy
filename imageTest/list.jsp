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
<table width="460" style="margin: auto;" >
	<tr><td class="title"  height="40" colspan="2">
	<b>이미지 게시판</b>
	</td></tr>
	
	<tr>
		
	</tr>
</table>

<br/><br/>

<table  style="margin: auto;" width="500">
	<tr>
	<td align="left" colspan="2"  width="165">
		total : ${dataCount } articles, ${totalPage }page / Now page is ${currentPage}
		</td>
		<td align="right" colspan="1" width="165">
		<input type="button" value="게시물 등록" onclick="location='<%=cp%>/image/write.do?pageNum=${pageNum }';"/>
		</td>
		</tr>

<c:forEach var="dto" items="${lists }" varStatus="status">
	<c:if test="${status.count%3 == '1'}">
	<tr>
	</c:if>
		<td width="155" align="left">
		<img src="${imagePath }/${dto.saveFileName}" width="160" height="200"/>
		<br/>${dto.subject }
		<a href="<%=cp%>/image/delete.do?num=${dto.num }&pageNum=${pageNum } ">삭제</a></td>
	<c:if test="${status.count%3 == '0'}">
	</tr>
	</c:if>	
</c:forEach>

<!-- 애초에 칸 3개짜리 테이블을 만들어노코 시작하면 해결됨. 선이든 뭐든 테이블로 규격을 짜자 공백도 하나의 큰 테이블인걸 잊지말자 -->

</table>


<center>
<table>
<tr><td>${pageIndexList} </td></tr>
</table>
</center>


</body>
</html>
