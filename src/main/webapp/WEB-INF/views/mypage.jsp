<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTPYE html lang="ko">
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- 네비바 css -->
		<link rel="stylesheet" type="text/css" href="nav.css" />
		<!-- 마이페이지 css -->
		<link rel="stylesheet" type="text/css" href="mypage.css" />
		<!-- jQuery -->
		<script src="/resources/js/jquery-3.5.1.min.js"></script>
		<!-- 마이페이지 js -->
		<script src="/resources/js/mypage.js"></script>
		<link href="/resources/css/mypage.css" rel="stylesheet">
		<title>마이 페이지</title>
	</head>
<body>
<%@ include file="../../exclude/topnav.jsp" %>
	<!-- 마이페이지 -->
	<div class="container">
		<form id="form" name="form" action="Mypage" method="post" enctype="multipart/form-data">
			<div id="imgfile">
				<img src="black.jpg">
			</div>
			<div class="filebox">
				<label for="file">사진 변경</label> <input type="file" id="file" name="file" accept=".gif, .jpg, .png" onchange="readInputFile(event.target)">
			</div>

			<label for="nick">닉네임</label> <input type="text" id="nick" name="nick" placeholder="홍길동" value=""> 
				
			<button type="button" onclick="Modify()">저장</button>
			<button type="button" onclick="history.back()">뒤로가기</button>
			<!-- <button type="button" class="PasswordChange" onclick="PasswordChange()">비밀번호 변경</button> -->
			<button type="button" onclick="Withdrawal()">회원탈퇴</button>
		</form>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		
	</div>
	
</body>
</html>