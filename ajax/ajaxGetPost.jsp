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

<script type="text/javascript">

	var XmlHttp;
	
	function getXmlHttpRequest(){
		
		if(window.ActiveXObject){
			
			try {
				XmlHttp = new ActiveXObject("Msxnl2.XMLHTTP");
			} catch(e){
				XmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}else {
			XmlHttp = new XMLHttpRequest();
		}	
		
	}
	
	function ajaxRequestGet(){
		
		var data = document.myForm.greeting.value;
		
		if(data==""){
			alert("데이터 입력");
			document.myForm.greeting.focus();
			return
		}
		//alert(data);
		XmlHttp.open("GET","ajaxGetPost_ok.jsp?greeting="+data,true);
		XmlHttp.onreadystatechange = viewMessage;
		//갔다가 돌아올 함수이름이 viewMessage 내맘대로 설정가능 !
		XmlHttp.send(null);
	
	}
	
	function ajaxRequestPost(){
		//post방법은 이렇게 데이터를 옮긴다
		
		var data = document.myForm.greeting.value;
		
		if(data==""){
			alert("데이터 입력");
			document.myForm.greeting.focus();
			return
		}
		
		XmlHttp.open("POST","ajaxGetPost_ok.jsp",true);
		XmlHttp.setRequestHeader("content-type",
				"application/x-www-form-urlencoded");
		XmlHttp.onreadystatechange = viewMessage;
		//갔다가 돌아올 함수이름이 viewMessage 내맘대로 설정가능 !
		XmlHttp.send("greeting="+data);
		
	}
	
	function viewMessage(){
		//위에서 말한 viewMessage
		
		var divE =document.getElementById("printDIV");
		
		if(XmlHttp.readyState ==1 ||
				XmlHttp.readyState ==2 ||
				XmlHttp.readyState ==3){
			//서버가 데이터를 완벽하게 넘기면 그거 4 즉, 1,2,3이냐는 거는 아직 데이터가 안넘어왔을때 ㅇㅇ
			divE.innerHTML = "<img src = './image/processing.gif' width='50' height='50'/>";
			
		}else if(XmlHttp.readyState==4){
			//서버가 데이터를 넘긴 상태
			divE.innerHTML= XmlHttp.responseText;
		}else {
			divE.innerHTML = "<font color = 'red'>" + XmlHttp.status + "에러발생" + "</font>";
		}
		
	}
	
	
	window.onload = function(){
		getXmlHttpRequest();
	}

</script>
</head>
<body>

<form action="" name="myForm">

<input type="text" name="greeting"/>
<input type="button" value="get전송" onclick="ajaxRequestGet();"/>
<input type="button" value="post전송" onclick="ajaxRequestPost();"/>
</form>

<div id="printDIV" style="border: 1px solid blue; width: 50%;"></div>

</body>
</html>