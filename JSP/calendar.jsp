<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
	
	Calendar cal = Calendar.getInstance();
	
	int nowYear = cal.get(Calendar.YEAR);
	int nowMonth = cal.get(Calendar.MONTH)+1;
	int nowDay = cal.get(Calendar.DAY_OF_MONTH);
	
	
	//클라이언트가 넘긴 데이터
	String strYear = request.getParameter("year");
	String strMonth = request.getParameter("month");
	
	//달력에 표시할 년,월
	int year=nowYear;
	int month=nowMonth;
	
	if(strYear!=null){
		year=Integer.parseInt(strYear);
		
	}
	if(strMonth!=null){
		month=Integer.parseInt(strMonth);
	}
	
	int preYear=year,preMonth=month-1;
	if(preMonth<1){
		preYear=year-1;
		preMonth=12;
	}
	
	int nextYear=year, nextMonth=month+1;
	if(nextMonth>12){
		nextYear=year+1;
		nextMonth=1;
	}
	
	//표시할 달력
	cal.set(year,month-1,1);
	int startDay =1;
	int endDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	//year년 month월 1의 요일수
	int week=cal.get(Calendar.DAY_OF_WEEK);
	
	year=2022;
	
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>만년달력</title>

<script type="text/javascript">

	function inputYear(){
		
	
			
			
			
			
		}
		
		
		
	}
	
	function change(){
		
		var f = document.myForm;
		f.submit();
	}
		
		
	}
	
	function stdMonth(){
		
		var f = document.myForm;
		var nowMonth= cal.get(Calendar.MONTH)+1;
		var stdm=document.myForm.getElementById("checkMonth");
		
	}





</script>

<style type="text/css">

body{
	font-size: 10pt;
}

td{
	font-size: 10pt;

}

a{
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
<br/><br/>

<form action="" name="myForm">
<table align="center" width="210" cellpadding="2" cellspacing="1">
<tr>
	<td align="center">
	
	<a href="calendar.jsp"><img src="./Image/today.JPG" width='30' align="left">
	</a>
	
	<b>&nbsp;

	2022년&nbsp;&nbsp;
	
	<select name="checkMonth" onchange="change();">
	
	<%
	for (int i=1;i<=12;i++){
		out.print("<option value='"+i+"'>"+i+"</option>"); 
	}
	
	%></select>월</b>

	
	</td>
</tr>
</table>



<table align="center" width="210" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
<tr>
	<td bgcolor="#e6e4e6" align="center"><font color="red">일</font></td>
	<td bgcolor="#e6e4e6" align="center">월</td>
	<td bgcolor="#e6e4e6" align="center">화</td>
	<td bgcolor="#e6e4e6" align="center">수</td>
	<td bgcolor="#e6e4e6" align="center">목</td>
	<td bgcolor="#e6e4e6" align="center">금</td>
	<td bgcolor="#e6e4e6" align="center"><font color="blue">토</font></td>
</tr>

<%

	int newLine=0;

	out.print("<tr height='20'>"); //body에 찍어주란느 거 out.print
	
	for(int i=1;i<week;i++){
		
		out.print("<td bgcolor='#ffffff'>&nbsp;</td>");
		newLine++;
	}
	
	for(int i=startDay;i<=endDay;i++){
		
		//토일요일 색 지정. 오늘날짜 배경색 지정
		String fontColor = (newLine==0)?"red":(newLine==6)?"blue":"black";
		String bgColor = (nowYear==year)&&(nowMonth==month)&&(nowDay==i)?"e6e4e6":"#ffffff";
	
			out.print("<td align='center' bgcolor='"+bgColor+"'><font color='"
				+fontColor+"'>"+i+"</font></td>");	
	
			
			newLine++;
			
			if(newLine==7&&i!=endDay){
				out.print("</tr><tr height='20'>");
				newLine=0;
			}
	}
	
	while(newLine>0&&newLine<7){
		out.print("<td bgcolor='#ffffff'>&nbsp;</td>");
		newLine++;
	}
	
	out.print("</tr>");


%>
	
</table>
</form>

</body>
</html>