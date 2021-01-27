<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTPYE html lang="ko">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 마이페이지 css -->
<link rel="stylesheet" type="text/css" href="/resources/css/mypage.css" />
<!-- jQuery -->
<script src="/resources/js/jquery-3.5.1.min.js"></script>
<!-- 마이페이지 js -->
<script src="/resources/js/mypage1.js"></script>
<script src="/resources/js/mypage2.js"></script>
<link href="/resources/css/mypage.css" rel="stylesheet">
<title>마이 페이지</title>
</head>
<body>
	<!-- 마이페이지 -->
	<div class="container">
		<form id="form" name="form" action="/mypage/uploadAjaxAction"
			method="post" enctype="multipart/form-data">
			<div id="imgfile">
				<img src='<c:out value="${ filePath }"/>'>
			</div>
			<div class="filebox">
				<!-- 여기부터 go -->
				<label for="file">사진 변경</label> <input type="file" id="file"
					name="uploadFile" accept=".gif, .jpg, .png"
					onchange="readInputFile(event.target)">
			</div>
			<br />
			<br />
			<br />
			<!-- <label for="nick">닉네임</label> <input type="text" id="nick" name="nick" placeholder="홍길동" value=""> -->

			<button type="submit" id="uploadBtn"
				style="background-color: #9E9D99; color: white; padding: 12px 20px; border: none; border-radius: 4px; cursor: pointer;">저장</button>
			<button type="button" onclick="history.back()">뒤로가기</button>
			<!-- <button type="button" class="PasswordChange" onclick="PasswordChange()">비밀번호 변경</button> -->
			<button type="button" onclick="Withdrawal()">회원탈퇴</button>
		</form>
		<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
		<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
		<br /> <br /> <br />
	</div>

</body>
</html>