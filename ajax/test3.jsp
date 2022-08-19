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
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	$("#saveButton").click(function(){
		
		var value1 = $("#userId").val();
		var value2 = $("#userPwd").val();
		
		//get
		$.get("test3_ok.jsp",{userId:value1,userPwd:value2},function(args){
			//비동기방식 함수. 앞에꺼 실행 잘하고 나면 function을 실행해
			$("#resultDIV").html(args);
		})
		//post
		//#.post("test3_ok.jsp",{userId:value1:value2},function(args){
			//비동기방식 함수. 앞에꺼 실행 잘하고 나면 function을 실행해
		//	#("#resultDIV").html(args);
		//})
	});
	
	$("#clearButton").click(function(){
		
		$("resultDIV").empty;
	});
	
});

</script>
</head>
<body>

아이디 :<input type="text" id="userId"/>
비밀번호 : <input type="text" id="userPwd"/>

<button id="saveButton">전송</button>
<button id="clearButton">지우기</button>
<br/><br/>
<div id="resultDIV"></div>

</body>
</html>