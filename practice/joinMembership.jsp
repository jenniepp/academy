<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습용 회원가입창</title>

<!-- 사용할 css파일 연결하기 -->
<link rel="stylesheet" href="styleFile.css">
<!-- 사용할 javascript파일 연결하기 -->
<script src="./naverjs.js"></script>
<script type="text/javascript">
	function sendIt(){
		
		var f= document.myForm;
		
		f.action = "<%=cp%>/practice/memberPage.jsp";
		f.submit(); //submit()의 역할이 데이터를 가지고 넘어가는거
	}

</script>


</head>
<body onload="options();">

<div id="wrap">

	
<!-- id, pwd 입력폼 만들기 -->
<form action="" name="myForm">
	<table>
		<tr><td>
		<h4>아이디</h4>
		</td></tr>
		<tr><td>
			<input class="box_style" type="text" name="userId" minlegth="4"; maxlength="12";>
		</td></tr>
		
		<tr><td>
		<h4>비밀번호</h4>
		</td></tr>
		<tr><td>
			<input class="box_style" type="password" name="userPwd" minlegth="4"; maxlength="12";>
		</td></tr>
		
		
		<tr><td>
		<h4>비밀번호 재확인</h4>
		</td></tr>
		<tr><td>
			<input class="box_style" type="password" name="userPwd1" minlegth="4"; maxlength="12";>
			<br/>
		</td></tr>
		
		<tr><td>
		<h4>이름</h4>
		</td></tr>
		<tr><td>
			<input class="box_style" type="text" name="userName">
		</td></tr>
		
		<tr><td>
		<h4>생년월일</h4>
		</td></tr>
		<tr><td>
			<input type="text" class="box_birth_style" name="year" placeholder="년(4자)" maxlength="4";>
			<select name="month" class="box_birth_style" readonly="readonly" ></select>
			<input type="text" class="box_birth_style"  name="day" placeholder="일" maxlength="2">
		</td></tr>
		
		<tr><td>
		<h4>성별</h4>
		</td></tr>
		<tr><td>
			<select class="box_style" name="gender">
			</select>
			
		</td></tr>
		
		<tr><td>
		<h4>본인 확인 이메일 <span class="choice"  style="font-size: 9px;
	color: #8C8C8C;">(선택)</span></h4>
		</td></tr>
		<tr><td>
			<input class="box_style" type="text" name="email" placeholder="선택입력">
		</td></tr>
		
		<tr><td>
		<h4>휴대전화</h4>
		</td></tr>
		<tr><td>
			<select name="tel1" class="box_style" readonly="readonly"  style="margin-bottom: 10px"></select>
			<input class="box_style" type="text" name="tel2" placeholder="전화번호입력">
			<br/><br/>
		</td></tr>
	
	
	<tr>
	<td style="color:#ffffff ; background: #47C83E ; text-align: center;" class="box_style"
	 onclick="sendIt()">가 입 하 기
		<br/><br/>
	</td></tr>


<tr>
	<td align="center"><font size="2">
	<br/>
	<a href="https://policy.naver.com/rules/service.html">이용약관</a>
	<a href="https://policy.naver.com/policy/privacy.html"><b>개인정보처리방침</b></a>
	<a href="https://policy.naver.com/rules/disclaimer.html">책임의 한계와 법적고지</a>
	<a href="https://help.naver.com/support/service/main.help?serviceNo=532&_membership_p.membership_p.membership_26&from=alias">회원정보 고객센터</a>
	</font>
</td>
</tr>
	
	</table>
	</form>
		
</div>

</body>

</html>