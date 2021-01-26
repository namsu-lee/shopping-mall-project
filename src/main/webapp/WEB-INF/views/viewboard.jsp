<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<c:forEach items="${GetReply}" var="GetReply">
		<tr id="reply${GetReply.replynum }" >
			<td style="width:10%;">${GetReply.nickname}</td>
			<td style="width:55%;">${GetReply.replycontent}</td>
			<td style="width:15%;">${GetReply.replydate}</td>
			<c:choose>
			<c:when test="${GetReply.memberid == sessionScope.memberid}">
			<td style="width:5%; ">
			<div class="dropdown">
				<button onclick="myFunction()" class="replybtn">수정</button>
				<div id="myDropdown" class="dropdown-content">
					<form action="/board/${cateid}/${b_num}/${GetReply.replynum}/updatedreply">
					<textarea rows="1" style="width:100%;resize:none;" name="replycontent"></textarea>
					<button type="submit"  class="replybtn" >
					수정완료</button>
					</form>
				</div>
			</div>
			</td>
			<td style="width:5%;">
				<button  class="replybtn" onclick="location.href='/board/${cateid}/${b_num}/${GetReply.replynum}/deletereply'">
				삭제</button>
			</td>
			</c:when>
			</c:choose>
		</tr>
	</c:forEach>
	</table>
		
	</div>
	<c:choose>
 	<c:when test="${sessionScope.memberid != null }">
	<div class="replywrite" style="width:100%;">
		
			
			<table style="width:100%;">
				<tr>
					<form id="writereply" name="writereply" action="/board/${cateid}/${ViewBoard.b_num}/wrotereply" method="post">
						<input type="hidden" name="memberid" value="${sessionScope.memberid}">
						<input type="hidden" name="nickname" value="${sessionScope.nickname}">
						<td style="width:80%; "><textarea name="replycontent" id="replycontent" style="resize: none; width:95%; font-size:20px; padding:10px; " rows="1"></textarea></td>
					</form>
					<td style="width:10%;"><button class="replybtn" onclick="submitWriteReply()" >댓글입력</button></td>
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
	
function submitWriteReply() {	
	var content = document.getElementById('replycontent').value;

	for(var i=0; i<100; i++){ // 값이 들어간 길이 만큼 제목과 본문의 공백을 제거
		content = content.replace(" ","");
	}
	if(content != ""){ // 내용이 작성되어 있는 경우 submit() 한다. 
		document.writereply.submit();
	}
	else if(content == ""){ // 작성 된 내용이 하나도 없을 경우 안내 메세지 창 출력
		alert("내용을 입력해주세요.");
	}
}
</script>

</body>
</html>