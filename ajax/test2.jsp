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
$(function(){
	
	$("#sendButton").click(function(){
		
		var param = "subject=" +$("#subject").val()+
					"&content=" + $("#content").val();
		
		$.ajax({
			
			type:"post",
			url:"test2_ok.jsp",
			data:param,
			dataType:"xml",
			success:function(args){
				//성공하면 여기로 들어가라-함수이름은 내맘대로 해주면 됨
				
				$(args).find("status").each(function(){
					alert($(this).text());
				});
				//status가 몇갠지 모르지만 다 찾아. > 반복문 다찾으면 다음 함수를 실행해
				
				var str = "";
				$(args).find("record").each(function(){
					 var id = $(this).attr("id");
					 var subject = $(this).find("subject").text();
					 var content = $(this).find("content").text();
					 
					 str += "id="+id + "subject="+subject +"content="+content+"<br/>";
					 
				});
				
				$("#resultDIV").html(str);
			},
			beforeSend:showRequest,
			error:function(e){
				//실패하면 여기로 들어가라-함수이름은 내맘대로 해주면 됨
				alert(e.responseText);
			}
		});
	});
	
});

function showRequest(){
	
	var flag = true;
	
	if(!$("#subject").val()){
		alert("제목을 입력하세요.");
		$("#subject").focus();
		return false;
	}
	
	if(!$("#content").val()){
		alert("내용을 입력하세요.");
		$("#content").focus();
		return false;
	}
	
	return flag;
}

</script>
</head>
<body>
제목 : <input type="text" id="subject"/><br/>
내용 : <input type="text" id="content"/><br/>
<input type="button" value="보내기" id="sendButton"/>

<div id="resultDIV"></div>

</body>
</html>