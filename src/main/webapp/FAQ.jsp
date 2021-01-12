<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./exclude/topnav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>FAQ</title>
<style>
	.FAQ{
	display:inline-block;
	position:fixed; 
    left:50%; 
    transform:translateX(-50%); 
    font-size : 40px;
    width:80%;
	}
	.tablink{
	font-size : 40px;
	background-color: #555;
    color: white;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    width: 16.6%;
	}
	.tablink:hover {
	}
	
	.FAQcategory{
	}
</style>
</head>
<body>
<br><br><br><br><br><br>
	<div class="FAQ">
		<button class="tablink" onclick="tab()">전체</button>
		<button class="tablink" onclick="tab()">입금</button>
		<button class="tablink" onclick="tab()">배송</button>
		<button class="tablink" onclick="tab()">교환/반품</button>
		<button class="tablink" onclick="tab()">주문/결제</button>
		<button class="tablink" onclick="tab()">기타</button>
		
		<br>
		<div class="FAQcategory">전체
			<div >
				전체
				<div>입니다</div>
			</div>
		</div>
		<div class="FAQcategory">입금
			<div>
				입금 했어요
					<div>네</div>
			</div>
		</div>
		<div class="FAQcategory">배송
			<div>
				왜 안와요
				<div>이제 가요</div>
			</div>
		</div>
		<div class="FAQcategory">교환/반품
			<div>
				반품좀
				<div>안돼요</div>
			</div>
		</div>
		<div class="FAQcategory">주문/결제
			<div>
				결제 안돼요
				<div>품절이네요</div>
			</div>
		</div>
		<div class="FAQcategory">기타
			<div>
				탈퇴 좀 요
				<div>탈퇴 안돼요</div>
			</div>
		</div>
	</div>
</body>
