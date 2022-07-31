<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String cp= request.getContextPath(); 
	request.setCharacterEncoding("UTF-8");
%>

<jsp:usebean
<!DOCTYPE html>

<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>제발떠라...</title>
    <link rel="stylesheet" href="./source/reset.css" />
    <link rel="stylesheet" href="./source/style.css" />
    <script type="text/javascript">
    	function sendIt(){
    		
    		var f=document.myForm;
    		
    		f.action="<%=cp%>/cyworld/write.do";
    		f.submit();
    		
    	}
    </script>
  </head>
  <body>
  <form action="" name="myForm">
    <div class="background">
      <main>
        <section class="profile-section">
          <div class="profile-dot">
            <div class="profile-paper">
              <div class="profile-wrap">
                <div class="visitor-counter">
                  <p class="text-today">103</p>
                  <p class="text-total">13042</p>
                </div>
                <div class="profile">
                  <p class="text-today-is">
                    TODAY IS .. <i>⛱</i><span> 즐거움</span>
                  </p>
                  <img
                    class="profile-img"
                    src="./source/img/profile.jpeg"
                    alt="profile"
                  />
                  <div class="desc-wrap">
                    <p class="text-desc">
                      사람좋은 사람들 <br />
                      싸이월드<br />
                      ^-^
                    </p>
                    <a class="link-history" href="#">HISTORY</a>
                  </div>
                  <div class="info-wrap">
                    <a class="info-name" href="#">박수진</a>
                    <p class="text-email">jennie1234@nate.com</p>
                    <img src="./source/img/b+.png" alt="b+" />
                    <img src="./source/img/dotol.jpeg" alt="dotol" />
                  </div>
                </div>
                <div class="holder hd1"></div>
                <div class="holder hd2"></div>
                <div class="holder hd3"></div>
                <div class="holder hd4"></div>
              </div>
            </div>
          </div>
        </section>
        <section class="main-section">
          <div class="main-dot">
            <div class="main-paper">
              <div class="main-wrap">
                <div class="title-wrap">
                  <p class="title"><a href="#">사이좋은 사람들, 싸이월드</a></p>
                  <div class="link-wrap">
                    <a href="#"><span>일촌맺기</span></a>
                    <a href="#"><span>팬되기</span></a>
                    <p><a href="#">https://www.cyowrld.com/happy</a></p>
                  </div>
                </div>
                <div class="main">
                  <div class="post-wrap">
                    <div class="recent-post">
                      <h2>최근 게시물</h2>
                      <p class="text-video">
                        맘에드는 아이템은 소망상자에 넣어보세요
                      </p>
                      <p class="text-board">내 개성은 미니미로</p>
                      <p class="text-gallery">스킨, 메뉴효과 예약기능 좋아</p>
                      <p class="text-photo">더욱 편리해진 사용중 아이템</p>
                    </div>
                    <div class="menu-table">
                      <table>
                        <tr>
                          <td>쥬크박스<a href="#">0/12</a></td>
                          <td class="new-post">사진첩<a href="#">10/881</a></td>
                        </tr>
                        <tr>
                          <td class="new-post">방명록<a href="#">22/233</a></td>
                          <td>즐겨찾기<a href="#">0/3</a></td>
                        </tr>
                        <tr>
                          <td></td>
                          <td></td>
                        </tr>
                      </table>
                    </div>
                  </div>
                  <div class="mini-room-wrap">
                    <div class="nav-room-wrap">
                      <div class="nav-room">
                        <p>미니라이프</p>
                        <p class="checked">미니룸</p>
                        <p>미니라이프</p>
                      </div>
                      <p>싸이월드</p>
                    </div>
                    <img
                      class="img-miniroom"
                      src="./source/img/mini_room.gif"
                      alt="mini-room"
                    />
                    <div class="info-miniroom-wrap">
                      <div class="info-wrap-1">
                        <p>미니룸답글달기[15]</p>
                        <p>함께사진찍기</p>
                      </div>
                      <div class="info-wrap-2">
                        <p>미니룸수[16]</p>
                        <p>깜짝링크[0]</p>
                      </div>
                    </div>
                  </div>
                  <h2>일촌평</h2>
                  <div class="friends-say-section">
                    <label for="friends-say">friends say</label>
                    <input type="text" maxlength="15" style="width: 120px;" name="nickname" placeholder="nickname(닉네임)"/>
                    <input type="text" maxlength="15" style="width: 120px;" name="name" placeholder="name(이름)"/>
                    <input
                      type="text" name="message"
                      placeholder="일촌과 나누고 싶은 이야기를 남겨보세요~!"
                    />
                    <button onclick="sendIt()">확인</button>
                  </div>
                  <div class="friends-say-list">
                 		<c:forEach var="dto" items="${lists }" begin="1" end="5" step="1">
						<p>${dto.message }(${dto.nickname } <span>${name }</span>)</p>
						</c:forEach>
                  </div>
                </div>
              </div>
              <div class="menu-item mi-1 menu-checked">홈</div>
              <div class="menu-item mi-2">프로필</div>
              <div class="menu-item mi-3">다이어리</div>
              <div class="menu-item mi-4">쥬크박스</div>
              <div class="menu-item mi-5">사진첩</div>
              <div class="menu-item mi-6">게시판</div>
              <div class="menu-item mi-7">방명록</div>
            </div>
          </div>
        </section>
      </main>
      <aside>
        <button class="button-activate">친구추천</button><button>팬</button>
        <div class="recommend-img-wrap">
          <img src="./source/img/1.png" alt="" />
          <img src="./source/img/2.png" alt="" />
          <img src="./source/img/3.png" alt="" />
          <img src="./source/img/4.png" alt="" />
        </div>
        <div class="aside-table">
          <table>
            <tr>
              <td>댓글 <span>0</span></td>
              <td>스크랩 <span>331</span></td>
            </tr>
            <tr>
              <td>앱스 <span>551</span></td>
              <td>소망상자 <span>10</span></td>
            </tr>
          </table>
        </div>
        <p class="recommend-item"><span>추천아이템</span>추천BGM</p>
      </aside>
    </div>
    </form>
  </body>
</html>
