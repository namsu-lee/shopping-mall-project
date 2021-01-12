<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
  margin: 0;
  font-family: "Lato", sans-serif;
}

.sidebar {
  margin: 0;
  padding: 0;
  width: 200px;
  background-color: #f1f1f1;
  position: absolute;
  height: 100%;
  overflow: auto;
  float:left;
}

.sidebar a {
  display: block;
  color: black;
  padding: 16px;
  text-decoration: none;
}
 
.sidebar a.active {
 
  color: white;
}

.sidebar a:hover:not(.active) {
  background-color: #555;
  color: white;
}

div.content {
  margin-left: 200px;
  padding: 1px 16px;
  height: 1000px;
}

@media screen and (max-width: 700px) {
  .sidebar {
    width: 100%;
    height: auto;
    position: relative;
  }
  .sidebar a {float: left;}
  div.content {margin-left: 0;}
}

@media screen and (max-width: 400px) {
  .sidebar a {
    text-align: center;
    float: none;
  }
}

.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
</style>
</head>
<body>
<%@include file="/exclude/topnav.jsp" %>
<h2>Tabs</h2>
<p>Click on the buttons inside the tabed menu:</p>

<div class="tab">
  <button class="tablinks" onclick="#">베스트</button>
  <button class="tablinks" onclick="#">쿠폰/혜택</button>
  <button class="tablinks" onclick="#">기획전</button>
  <button class="tablinks" onclick="#">오늘장보기</button>
  <button class="tablinks" onclick="#">T공식대리점</button>
  <button class="tablinks" onclick="#">신상</button>
  <button class="tablinks" onclick="#">아우터</button>
  <button class="tablinks" onclick="#">상의</button>
  <button class="tablinks" onclick="#">셔츠/블라우스</button>
  <button class="tablinks" onclick="#">트레이닝</button>
  <button class="tablinks" onclick="#">베이직</button>
  <button class="tablinks" onclick="#">원피스</button>
  <button class="tablinks" onclick="#">스커트</button>
  <button class="tablinks" onclick="#">팬츠</button>
  <button class="tablinks" onclick="#">가방</button>
  <button class="tablinks" onclick="#">신발</button>
  <button class="tablinks" onclick="#">악세서리</button>
</div>


<div class="sidebar">
  <a href="#news"><strong>홍길동님</strong></a>
  <a href="#news"><strong>회원 정보</strong></a>
  <a href="#contact"> ㄴ 회원정보 변경/탈퇴</a>
  <a href="#about"> ㄴ 나의 배송지 관리</a>
</div>

<div class="content">
  <h2>Responsive Sidebar Example</h2>
  <p>This example use media queries to transform the sidebar to a top navigation bar when the screen size is 700px or less.</p>
  <p>We have also added a media query for screens that are 400px or less, which will vertically stack and center the navigation links.</p>
  <h3>Resize the browser window to see the effect.</h3>
</div>

</body>
</html>		