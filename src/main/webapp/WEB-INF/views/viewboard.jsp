<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../../exclude/topnav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ViewBoard.b_title}</title>
<script src="/resources/js/jquery-3.5.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<style>
	.view{
	     width:75%;
	     margin:0px auto; 
	}
	.viewcon *{
		margin:10px;
	}
	.title{
		font-size : 40px;
		
	}
	.nick{
	 	font-size : 20px;
	 	margin-left:15px;
	}
	.wdate{
	 	font-size : 15px;
	 	margin-left:15px;
	}
	.content{
	 	padding:10px;
	}
	.replybtn {
        color: dodgerblue;
        border: none;
        padding: 3px 3px;
        marin : 0;
        font-size: 16px;
        cursor: pointer;
        background-color:white;
    }

    .replybtn:hover {
        background: #2196F3;
        color: white;
    }
    .dropdown-content {
	  display: none;
	  position: absolute;
	  background-color: white;
	  min-width: 160px;
	  z-index: 1;
	  right:100%;
	  top:0px;
	  padding:5px;
	  width:1500%;
	}
	.dropdown{
	position: relative; 
	display: inline-block;
	z-index: 0;
	margin:0;
	padding:0;
	}
	.show {display: block;}
	
	#editContent{
	resize: none; 
	width:95%; 
	font-size:15px; 
	padding:10px; 
	}
</style>
</head>
<body>
<div class="view">
<%@ include file="../../exclude/leftmenu.jsp" %>
	<div class="viewcon" style="float:right; width:80%">
	
		<div class="title">${ViewBoard.b_title}</div>
		<div class="nick">${ViewBoard.nickname}</div>
		<div class="wdate">${ViewBoard.b_wdate}&nbsp;&nbsp;조회수 ${ViewBoard.b_hit}</div>
		<hr>
		<div class="content">${ViewBoard.b_content}</div>
		<hr>
	<div class="reply" style="width:100%;display: inline-block;">
	<table>
	<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
		<h6 class="border-bottom pb-2 mb-0">댓글 목록</h6>
		<div id="replyList"></div>
	</div> 
	</table>
		
	</div>
	<c:choose>
 	<c:when test="${sessionScope.memberid != null }">
 	
 	<!-- 댓글 입력 창 -->
	<div class="replywrite" style="width:100%;">
	<table style="width:100%;">
		<tr>
			<form id="writereply" name="writereply" action="submitreply()" method="post">
				<input type="hidden" name="memberid" id="memberid" value="${sessionScope.memberid}">
				<input type="hidden" name="nickname" id="nickname" value="${sessionScope.nickname}">
				<td style="width:80%; "><textarea name="replycontent" onkeyup="enterkey();" id="replycontent" style="resize: none; width:95%; font-size:20px; padding:10px; " rows="1"></textarea></td>
			</form>
			<td style="width:10%;"><button type="button" class="replybtn" onclick="submitWriteReply()" >댓글입력</button></td>
		</tr>
	</table>
</div>
</c:when> 
</c:choose>
	<div style="float:left;">
		<button  class="btn info" onclick="location.href='/board/${cateid}'">목록</button>
	</div>
	<div style="float:right;">
	<c:choose>
	
	<c:when test="${ViewBoard.memberid == sessionScope.memberid }">
		
			<button class="btn info" onclick="deleteconfirm()">글삭제</button>
			<button class="btn info" onclick="location.href='/board/${cateid}/${ViewBoard.b_num}/updateboard'">수정</button>
			<button class="btn info" onclick="location.href='/board/${cateid}/writeboard'">글쓰기</button>
		</c:when>
		<c:when test="${sessionScope.memberid != null }">
			<button class="btn info" onclick="location.href='/board/${cateid}/writeboard'">글쓰기</button>
			
		</c:when>
	</c:choose>
	</div>
</div>
<%@ include file="../../exclude/footer.jsp" %> 
</div>
<!-- <script src="/resources/js/viewboard.js"></script> -->
<%@ include file="/resources/js/viewboard.jsp" %>
</body>
</html>