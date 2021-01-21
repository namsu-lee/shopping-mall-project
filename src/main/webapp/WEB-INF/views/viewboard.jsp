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
	
</script>
</c:forEach>
</body>
</html>