<%@page import="com.util.MyPage"%>
<%@page import="java.util.List"%>
<%@page import="com.guest.GuestDAO"%>
<%@page import="com.util.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.guest.GuestDTO"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
	
	Connection conn = DBConn.getConnection();
	GuestDAO dao=new GuestDAO(conn);
	
	MyPage myPage=new MyPage(); //페이징 페이지 mypage를 쓰려고
	
	
	
	//-------------------페이징처리 코드들 rnum관련된거 다 페이징처리 관련임 삭제하지말자!!
	String pageNum = request.getParameter("pageNum");
	int currentPage=1;
	
	//처음 실행을 검사
	if(pageNum!=null){
		currentPage=Integer.parseInt(pageNum);
	}
	
	//전체 데이터 갯수 구하기
		int dataCount = dao.getDataCount();
		
		//하나의 페이지에 보여줄 데이터 갯수
		int numPerPage = 5;
		
		int totalPage = myPage.getPageCount(numPerPage, dataCount);
		
		//삭제시 페이지수가 줄었을 때 처리
		if(currentPage>totalPage){
			currentPage=totalPage;
		}
		
		//데이터 베이스에서 가져올 rownum의 시작과 끝
		int start = (currentPage-1)* numPerPage+1;
		int end = currentPage*numPerPage;
		
		List<GuestDTO> lists=dao.getLists(start,end);
		
		//페이징처리
		
		
		String listUrl="guest.jsp";
		
		String pageIndexList = myPage.pageIndexList(currentPage, totalPage, listUrl);
				
		DBConn.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>

<link rel="stylesheet" type="text/css" href="<%=cp %>/guest/data/style.css">
<script type="text/javascript" src="<%=cp %>/guest/data/guest.js"></script>
<script type="text/javascript">
    function isDelete(num)  {
		if (confirm("위 자료를 삭제하시겠습니까 ?")) {
			 location.href="<%=cp%>/guest/delete.jsp?num=" + num; 
		}
    }
</script>

</head>
<body>

<table  style="margin: auto;">
	<tr><td class="title" width="500" height="40" align="center" >
	<b>방 명 록 (JSP)</b>
	</td></tr>
</table>


<form name="myForm" action="" method="get">
<table class="content" width="500"  style="margin: auto;">
	<tr>
		<td class="style1" height="25" width="100" >작성자</td>
		<td>
		<input type="text" name="name"></td>
	</tr>
	
	<tr>
		<td class="style1" height="25" width="100" >E-mail</td>
		<td>
		<input type="text" name="email"></td>
	</tr>
	
	<tr>
		<td class="style1" height="25" width="100">홈페이지</td>
		<td>
		<input type="text" height="25" value="http://" name="homepage"/></td>
	</tr>
	
	<tr>
		<td class="style1">내&nbsp;&nbsp;&nbsp;&nbsp;용</td>
		<td valign="top" style="padding-left:10px;"> 
        <textarea name="content" cols="60" rows="7" class="boxTA"></textarea>
      </td>
		
	</tr>
</table>

<table width="560" border="0" cellspacing="0" cellpadding="3"  style="margin: auto;">
     <tr align="center"> 
      <td height="40">
        <input type="button" value=" 등록하기 " onclick="sendIt();" class="btn1"/>
        <input type="reset"  value=" 다시입력 " onclick="document.myForm.name.focus();" class="btn1"/>
      </td>
    </tr>
  </table>
</form>

<table width="560" style="margin: auto;">

	<%if(lists.isEmpty()){ //여기서 dataCount가 0인지 아닌지로 판단해줘도 된다.%>
	<tr height="50" style="border-top: 2px; border-color:#cccccc; ">
		<td class="style1" align="center">
		등록된 자료가 없습니다.
		</td>
	</tr> <%} else { %>

	<%for(GuestDTO dto : lists){ %>
	<tr height="50" style="border-top: 2px; border-color:#cccccc; ">
		<td class="style1">
		<b>No <%=dto.getNum() %>. <%=dto.getName() %>(<%=dto.getEmail()%>)</b>
		<br/>작성일 : <%=dto.getCreated() %> (<%=dto.getIpaddr() %>)
		<span onclick="isDelete(<%=dto.getNum()%>)" style="cursor: pointer">삭제</span>
		</td>
	</tr>
	
	<tr style= "margin-top: 10px;" height="30">
		<td><%=dto.getContent() %>
		</td></tr>
	<%} }%>
	
	<tr><td align="center"><%=pageIndexList %></td></tr>
</table>



</body>
</html>