<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>****게시판****</title>


<link rel="stylesheet" type="text/css" href="/springwebmybatis/resources/css/style.css"/>
<link rel="stylesheet" type="text/css" href="/springwebmybatis/resources/css/article.css"/>

</head>
<body>

<div id="bbs">
	<div id="bbs_title">
	게  시  판
	</div>
	
	<div id="bbsArticle">
	
		<div id="bbsArticle_header">
			게시물 제목
		</div>
		<div class="bbsArticle_bottomLine">
			<dl>
			<dt>작성자</dt>
			<dd>${dto.name }</dd>
			<dt>줄수</dt>
			<dd>${lineSu }</dd>
			</dl>
		</div>
		
		<div class="bbsArticle_bottomLine">
			<dl>
			<dt>등록일</dt>
			<dd>${dto.created }</dd>
			<dt>조회수</dt>
			<dd>${dto.hitCount }</dd>
			</dl>
		</div>
		
		<div id="bbsArticle_content">
			<table width="600" border="0">
			<tr>
				<td style="padding: 20px 80px 20px 62px;" valign="top"
				height="200">${dto.content }</td>
			</tr>
			</table>
		</div>
	</div>
	
	<div class="bbsArticle_noLine" style="test-align : right;">
		from : ${dto.ipAddr }
	</div>
	
	<div id="bbsArticle_footer">
		<div id="leftFooter">
		<input type="button" value="수정" class="btn2" 
		onclick="location='<%=cp%>/updated.action?num=${dto.num }&${params }';"/>
		<input type="button" value="삭제" class="btn2" 
		onclick="location='<%=cp%>/deleted_ok.action?num=${dto.num }&${params }';"/>
		</div>
		<div id="rightfooter">
		<input type="button" value="리스트" class="btn2" onclick="location='<%=cp%>/list.action?${params }';"/>
		</div>

</div>

</body>
</html>