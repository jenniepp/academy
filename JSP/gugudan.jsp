<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

function sendIt(){
	
	const f= document.myForm;
	
	if(!f.dan.value){
		alert("단을 입력하세요");
		f.dan.focus(); //마우스 커서 이동시키는 거 focus();
		return;
	}
	f.action="gugudan_ok.jsp"; //action에 저 주소를 넣어라 =이동해라
	f.submit(); //submit이 action을 찾아가는 명령어라 작동뒤에 꼭 써줘야지 페이지가 넘어감
	
}

</script>

</head>
<body>

<form action="" method="post" name="myForm">

단:<input type="text" name="dan"/><br/>
<input type="button" value="결과" onclick="sendIt();">




</form>

</body>
</html>