<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../exclude/topnav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/ckeditor/ckeditor.js"></script>

<title>메인 화면 수정</title>

<style>
	.write{
	     width:75%;
	     margin:0px auto; 
	}
	.writecon{
	float:right; 
	width:80%;
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
		<form method="post" action="/mainupdated">
		
		<textarea name="m_content" ></textarea>
		<br>
    	<button class="btn info" style="float:right" type="submit">완료</button>
    	</form>
    	
    </div>
</div>
<input type="hidden" id="test" value="<c:out value='${ UpdateGetMain.m_content}' />">
<script>
CKEDITOR.replace('m_content',{
	height:400,
	autoGrow_minHeight : 400,
	filebrowserUploadUrl:'/imageupload.do'
});
var test = document.getElementById("test").value;
CKEDITOR.instances.b_content.setData(test);
</script>
</body>
</html>