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
<title>(가짜)상품 상세 페이지</title>
<script type="text/javascript">
	function sendIt(){
		
		var f= document.myForm;
		
		f.action = "<%=cp%>/shopmoody/cart_insert.do";
		f.submit();
	}

</script>
</head>
<body>

<form action="" name="myForm">
<table>

<c:choose>
	<c:when test="${empty sessionScope.memberInfo.id }">
		<b>로그인하면 새로운 세상이 보닙니다.</b><br/><br/>
	</c:when>
	<c:otherwise>
	

<tr>
<td>serialNo.<input type="text" name="pnum"></td>
<td>products<input type="text" name="pname"/></td>



<br/>
<br/>
<td>사이즈<input type="text" name="psize"></td>
<td>가격<input type="text" name="price"/></td>
<td>개수<input type="text" name="cnt"/></td>
</tr>
<tr><td>
<input type="button" value="입력" onclick="sendIt();">

	${sessionScope.memberInfo.name }님 반갑습니당<br/><br/>	
	</c:otherwise>

</c:choose>


</table>
</form>

</body>
</html>