<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../exclude/topnav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/ckeditor/ckeditor.js"></script>

<title>글수정 화면</title>

<style>
	.write{
	     width:75%;
	     margin:0px auto; 
	}
	.writecon{
	float:right; 
	width:80%;
	}
	#b_title{
	font-size:20px;
	padding:10px;
	}
	#cke_b_content{
	margin-top:30px;
	}
</style>
</head>
<body>
<div class="write">
<%@ include file="../../exclude/leftmenu.jsp" %>
	<div class="writecon">
		<form method="post" action="/board/${cateid}/wroteboard">
		
		<input type="text" name="b_title" id="b_title" size="40"placeholder="제목을 입력해주세요" value="${UpdateGetBoard.b_title} ">
		<textarea name="b_content" ></textarea>
		<br>
		<button class="btn info" onclick="location.href='/board/${cateid}'">목록</button>
    	<button class="btn info" style="float:right" type="submit">완료</button>
    	</form>
    </div>
</div>
<script>
CKEDITOR.replace('b_content',{
	height:400,
	autoGrow_minHeight : 400
});

CKEDITOR.instances.b_content.setData('${UpdateGetBoard.b_content}')

</script>
</body>
</html>