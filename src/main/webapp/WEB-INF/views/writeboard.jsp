<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../exclude/topnav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/ckeditor/ckeditor.js"></script>

<title>글쓰기 화면</title>

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
		<input type="hidden" name="memberid" value="${sessionScope.memberid}">
		<input type="hidden" name="nickname" value="${sessionScope.nickname}">
		<input type="text" name="b_title" id="b_title" size="40"placeholder="제목을 입력해주세요" onkeyup="chkword(this, 100)">
		게시물 권한 :	<select name="boardflag" id="select_${status.count}">
						<option value="a">A</option>
						<option value="b">B</option>
						<option value="c">C</option>
						<option value="d">D</option>
						<option value="f" selected>F</option>
					</select>
		<textarea id="b_content" name="b_content" ></textarea>
		<br>
		</form>
    	<button class="btn info" style="float:right" onclick="submitContents()">완료</button>
    	<button class="btn info" onclick="location.href='/board/${cateid}'">목록</button>
    </div>
</div>
<script>
CKEDITOR.replace('b_content',{
	height:400,
	autoGrow_minHeight : 400,
	filebrowserUploadUrl:'/imageupload.do'
});
function submitContents() {	
	var title = document.getElementById('b_title').value;

	for(var i=0; i<100; i++){ // 값이 들어간 길이 만큼 제목과 본문의 공백을 제거
		title = title.replace(" ","");
	}
	
	if(title != ""){ // 내용이 작성되어 있는 경우 submit() 한다. 
		document.forms[0].submit();
	}
	else if(title == ""){ // 작성 된 내용이 하나도 없을 경우 안내 메세지 창 출력
		alert("제목을 입력해주세요.");
	}
}

function chkword(obj, maxByte) {

	var strValue = obj.value;
	var strLen = strValue.length;
	var totalByte = 0;
	var len = 0;
	var oneChar = "";
	var str2 = "";

	for (var i = 0; i < strLen; i++) {
		oneChar = strValue.charAt(i);
		if (escape(oneChar).length > 4) {
			totalByte += 2;
		} else {
			totalByte++;
		}

		// 입력한 문자 길이보다 넘치면 잘라내기 위해 저장
		if (totalByte <= maxByte) {
			len = i + 1;
		}
	}

	// 넘어가는 글자는 자른다.
	if (totalByte > maxByte) {
		alert(maxByte + "자를 초과 입력 할 수 없습니다.");
		str2 = strValue.substr(0, len);
		obj.value = str2;
		chkword(obj, 4000);
	}
}
</script>
</body>
</html>