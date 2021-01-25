<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
div .paginator {
	text-align: center; 
}

.table > tbody > tr > td > p {
	padding-top: 10px;
}

.btn {
	float: right;
	margin-bottom: 20px;
}
</style>
<body>
		<!-- header -->
<%-- 		<%@ include file="/view/header.jsp" %> --%>
		
		<section>
		<h3>알림</h3>
		<!-- board list -->
		<div class="notilist"></div>
		<table class="table">
			<thead>
				<tr>
					<th width="10%" nowrap>번호</th>
					<th>내용</th>
				</tr>
			</thead>
			<!-- @@@@@@ -->
				<tr>
					<td colspan="2">새로운 알림이 없습니다.</td>
				</tr>
				<tbody>
					<tr class="active">
						<td width="10%" nowrap><p>3</p></td>
						<td><p><a href="/user.do?user=${noti.anotherMemberId }">홍길동</a> 님이 
							<a href="/board/read.do?no=${noti.articleNo }" onclick="readNoti(${noti.number});" >
							5번째 글</a>에 
							<strong>댓글</strong>을 남겼습니다.</p> 
							<small><i>하루전</i></small> 
							<small style="float: right; margin-left: 10px">
							<a href="noti.do" onclick="deleteNoti(${noti.number});">삭제</a></small>
							<small style="float: right;">읽음</small>
						</td>
					</tr>
					
					<tr class="active">
						<td width="10%" nowrap><p>2</p></td>
						<td><p><a href="/user.do?user=${noti.anotherMemberId }">홍길동</a> 님이 
							<a href="/board/read.do?no=${noti.articleNo }" onclick="readNoti(${noti.number});" >
							3번째 글</a>에 
							<strong>댓글</strong>을 남겼습니다.</p> 
							<small><i>하루전</i></small> 
							<small style="float: right; margin-left: 10px">
							<a href="noti.do" onclick="deleteNoti(${noti.number});">삭제</a></small>
							<small style="float: right;">안읽음</small>
						</td>
					</tr>
					
					<tr class="active">
						<td width="10%" nowrap><p>1</p></td>
						<td><p><a href="/user.do?user=${noti.anotherMemberId }">홍길동</a> 님이 
							<a href="/board/read.do?no=${noti.articleNo }" onclick="readNoti(${noti.number});" >
							3번째 글</a>에 
							<strong>댓글</strong>을 남겼습니다.</p> 
							<small><i>하루전전</i></small> 
							<small style="float: right; margin-left: 10px">
							<a href="noti.do" onclick="deleteNoti(${noti.number});">삭제</a></small>
							<small style="float: right;">안읽음</small>
						</td>
					</tr>
				</tbody>
		</table>
		
		</section>
	</div>

</body>
</html>