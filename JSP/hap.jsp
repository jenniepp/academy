<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- http://192.168.16.3:8080/study/day1/hap_ok.jsp?su1=456&su2= -->
<form action="hap_ok.jsp" name="myForm" method="post">

수1: <input type="text" name="su1"/><br/>
수2: <input type="text" name="su2"/><br/>
이름: <input type="text" name="name"/><br/>  
<input type="submit" value="결과"/><br/>

 
</form>

<a href="hap_ok.jsp?su1=100&su2=200&name=suzi">GET방식</a>
<a href="hap_ok.jsp?su1=100&su2=200&name=수지">GET방식2</a>

</body>
</html>

<!-- 

MIME [Multipurpose Internet Mail Extensions]의 종류
메세지의 내용이 어떤 형식인지 알려주기위해 정의한 인터넷 표준

text/plain : 일반 텍스트문서
text/html : HTML 문서 
text/css  :CSS 문서
text/xml : XML 문서
image/jpeg,image/png : JPEG파일, PNG파일 
video/mpeg,audio/mp3 : MPEG 비디오파일, MP3 음악파일
application/zip : zip 압축파일

 -->