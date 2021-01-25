<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../exclude/topnav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

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
	  background-color: #f1f1f1;
	  width:100%;
	  top: 0px;
	  right:0px;
	  z-index: 1;
	}
</style>
</head>
<body>
<div class="view">
<%@ include file="../../exclude/leftmenu.jsp" %>
	<div class="viewcon" style="float:right; width:80%">
	<c:forEach items="${ViewBoard}" var="board">
		<div class="title">${board.b_title}</div>
		<div class="nick">${board.nickname}</div>
		<div class="wdate">${board.b_wdate}</div>
		<hr>
		<div class="content">${board.b_content}</div>
		<hr>
	<div class="reply" style="width:100%;display: inline-block;">
	<table>
	<c:forEach items="${GetReply}" var="GetReply">
		<tr id="reply${GetReply.replynum }" >
			<td style="width:10%;">${GetReply.nickname}</td>
			<td style="width:55%;">${GetReply.replycontent}</td>
			<td style="width:15%;">${GetReply.replydate}</td>
			<td style="width:5%; position: relative; z-index: 0;">
				<button onclick="myFunction()" class="replybtn">수정</button>
				<div id="myDropdown" class="dropdown-content">
					<button  class="replybtn" onclick="location.href='/board/${cateid}/${b_num}/${GetReply.replynum}/updatedreply'">
					수정완료</button>
				</div>
			</td>
			<td style="width:5%;">
				<button  class="replybtn" onclick="location.href='/board/${cateid}/${b_num}/${GetReply.replynum}/deletereply'">
				삭제</button>
			</td>
		</tr>
	</c:forEach>
	</table>
		
	</div>
	<div class="replywrite" style="width:100%;">
		<form action="/board/${cateid}/${board.b_num}/wrotereply" method="post">
			<table style="width:100%;">
				<tr>
					<td style="width:80%; "><textarea name="replycontent" style="resize: none; width:95%; font-size:20px; padding:10px; " rows="1"></textarea></td>
					<td style="width:10%;"><button class="replybtn" type="submit" >댓글입력</button></td>
				</tr>
			</table>
		</form>
		</div>
	<div style="float:left;">
		<button  class="btn info" onclick="location.href='/board/${cateid}'">목록</button>
	</div>
	<div style="float:right;">
	<button  class="btn info" onclick="deleteconfirm()">글삭제</button>
	<button  class="btn info" onclick="location.href='/board/${cateid}/${board.b_num}/updateboard'">수정</button>
 	<button  class="btn info" onclick="location.href='/board/${cateid}/writeboard'">글쓰기</button>
 	
 	
 </div>
	</div>
	
</div>
<script>
function deleteconfirm(){ 
		var deletecon = confirm("삭제 하시겠습니까?")
		
		if(deletecon==true){
			document.location.href = "/board/${cateid}/${b_num}/deleteboard";
		}else if(deletecon==false){
			return false;
		
		}
	}
function myFunction() {
	  document.getElementById("myDropdown").classList.toggle("show");
	}
</script>
</c:forEach>
</body>
</html>