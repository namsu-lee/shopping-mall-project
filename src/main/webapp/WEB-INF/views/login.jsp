<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${ sessionScope.memberid != null }">
	<script>alert("잘못된 접근입니다."); location.href="/"; </script>
</c:if>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>로그인</title>

	<style>
			*{
				text-align: center;
				background-color:#F4F4F4;
			}
			
			section{
				height : 90vh;
				overflow:auto;
			}
			footer {           
				height : 5vh;
				border-top:1px solid gray;
			}
			footer > div {           
				padding:25px;
				font-size:small;
			}
			.login{
				position:absolute;
				top:10px;
				right:10px;
			}
			.login a{
				padding:10px;
			}
			#id, #password {
				margin:0px;
				height:40px;
				width: 300px;
				cursor:pointer;
				text-align:left;
				font-size: 15px;
				border:solid 1px #DDDDDD;
				background-color:white;
			}
			
			#Auto_Login {
				margin-bottom:9px;
			}
			
			#Auto_ID {
				margin-bottom:9px;
			}
			
			
			a{
				color:black;
				text-decoration:none;
			}
			
			#submitButton {
				color:#fff;
				background:#9E9D99;
				border-color:#9E9D99;
				height:40px;
				width: 305px;
				border: none;
				color:white;
				font-size:18px;
				cursor:pointer;
			}
			
			#naverButton {
				color:#fff;
				background:#19CE60;
				border-color:#19CE60;
				height:40px;
				width: 305px;
				border: none;
				color:white;
				font-size:18px;
				cursor:pointer;
			}
		</style>
</head>
<body>
	<section>
			<article style="margin-top:13%">
				<h2><a href="/login"><img src="/resources/image/ezen.jpg" style="width:80px; height:80px;"></a></h2>
				<form action="/loginok" method="post">
							<!-- 여기서부터 시작 -->
							<input type="text" name="memberid" id="id" placeholder="아이디" value="${ Auto_ID }"><br>

				
					<input type="password" name="password" id="password" placeholder="비밀번호는 6자 이상 ~ 20자 이하"></br>
					<button type="submit" id="submitButton">로그인</button><br>
					<input type="checkbox" name="Auto_Login" id="Auto_Login">자동 로그인
					<input type="checkbox" name="Auto_ID" id="Auto_ID">아이디 저장
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="/signup/register"><small>회원가입</small></a>
					<br>
					<br>
					<a href="${url}" id="naverButton">네이버로 시작하기</a>
				</form>
			</article>
		</section>
		<footer>
			<div>
				(주)ezen 
			</div>
		</footer>
</body>
</html>