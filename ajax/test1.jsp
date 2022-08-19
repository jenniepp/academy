<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=cp%>/data/js/ajaxUtil.js"></script>

<script type="text/javascript">

	function sendIt() {
		
		//아작스 구현방법 1. 자스 2.제이쿼리 3.아작스로 아작스 구현

		//XMLHttpRequest 객체
       // xmlReq = new XMLHttpRequest(); 이렇게쓰면 크롬만 가능, 익플에선 오류남
        xmlHttp = createXMLHttpRequest(); //브라우저 모두 사용 가능
       
       var query = "";
       var su1 = document.getElementById("su1").value;
       var su2 = document.getElementById("su2").value;
       var oper = document.getElementById("oper").value;
       
       
     //get방식으로 데이터 전송(post로도 가능)
       
       query = "test1_ok.jsp?su1=" + su1 
    		   + "&su2=" + su2 + "&oper=" + oper;
       
       xmlHttp.onreadystatechange = callback //윗줄 쿼리 데이터 뿌릴 때 사용하는 함수 callback(이름 지정 가능)
       
       //비동기 방식으로 전송
       xmlHttp.open("GET",query,true); // true: 비동기 방식
       xmlHttp.send(null)
       
	}
	
	function callback() {
		
		if(xmlHttp.readyState==4) { //서버의 역할
			if(xmlHttp.status==200) {
				
				printData();
				
			}
		}
		
		
	}
	
	function printData() {
		//코딩이 길어진다면 여기에 저장해서 쓰면됨
		
		var result = xmlHttp.responseXML.getElementsByTagName("root")[0]; //태그 네임은 s가 붙고 	
		
		var out = document.getElementById("resultDIV");
		
		out.innerHTML = "";
		out.style.display = "";
		
		var value = result.firstChild.nodeValue;
		out.innerHTML = value;
		
		
	}

</script>


</head>
<body>

<input type="text" id="su1"/>
<select id="oper">
	<option value="hap">더하기</option>
	<option value="sub">빼기</option>
	<option value="mul">곱하기</option>
	<option value="div">나누기</option>
</select>


<input type="text" id="su2">
<input type="button" value=" = " onclick="sendIt();"/>
<br/>

<!-- 이 객체 안에 결과가 보인다 -->
<div id="resultDIV" style="display: none;"></div>




</body>
</html>
















