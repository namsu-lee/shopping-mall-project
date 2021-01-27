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
<script src="/resources/js/viewboard.js"></script>
<script>
//댓글 불러오기
function showReplyList(){
	var url = "${pageContext.request.contextPath}/GetReply";
	var paramData = {"b_num" : "${ViewBoard.b_num}"};
	var sessionid= "${sessionScope.memberid}";
	$.ajax({
        type: 'POST',
        url: url,
        data: paramData,
        dataType: 'json',
        success: function(result) {
           	var htmls = "";
		if(result.length < 1){
			htmls +="등록된 댓글이 없습니다.";
		} else {
                    $(result).each(function(){
                    	htmls += '<tr style="height:50px;vertical-align: middle;" id="reply'+this.replynum+'">';
                    	htmls += '<td style="width:10%;">'+this.nickname+'</td>';
                    	htmls +='<td style="width:55%;">'+this.replycontent+'</td>';
                    	htmls +='<td style="width:15%;">'+this.replydate+'</td>';
                    	if(this.memberid==sessionid){
                    		htmls +='<td style="width:5%; ">';
                   			htmls +='<div class="dropdown">';
               				htmls +='<button onclick="myFunction()" class="replybtn">수정</button>';
                  			htmls +='<div id="myDropdown" class="dropdown-content">';
                  			htmls +='<form action="updatedreply('+this.replynum+')">';
                  			htmls +='<textarea rows="1" style="width:100%;resize:none;" name="replycontent" id="replycontent"></textarea>';
                  			htmls +='</form>';
                  			htmls +='<button type="button" onclick="submitUpdateReply()" class="replybtn" >';
                  			htmls +='수정완료</button>';
                  			htmls +='</div>';
                  			htmls +='</div>';
                  			htmls +='</td>';
                  			htmls +='<td style="width:5%;">';
                  			htmls +='<button  class="replybtn" onclick="fn_deleteReply('+this.replynum+')">';
                  			htmls +='삭제</button>';
                  			htmls +='</td>';
                  			htmls +='</tr>';
                    	}else{
                    		htmls +='<td colspan="2" style="width:10%;"></td>';
                    	}
                    	htmls +='</tr>';
                });	//each end
		}
		$("#replyList").html(htmls);
        }	   // Ajax success end
	});	// Ajax end
}
$(document).ready(function(){
	showReplyList();
});

//댓글 입력
function submitreply(){
	
	var replyContent = $('#replycontent').val();
	var replyReg_id = $('#memberid').val();
	var nickname = $('#nickname').val();
	var paramData = JSON.stringify({"replycontent": replyContent
			, "memberid": replyReg_id
			, "nickname" : nickname
			, "b_num":'${ViewBoard.b_num}'
	});
	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};
	$.ajax({
		url: '/wrotereply'
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();
			$('#replycontent').val('');
			$('#memberid').val('');
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}
//댓글 삭제
function fn_deleteReply(replynum){
	$.ajax({
		url: "/deletereply"
		, data : {"replynum": replynum}
		, type : 'POST'
		, success: function(result){
			showReplyList();
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}

//댓글 수정
function fn_updateReply(rid, reg_id){
	var replyEditContent = $('#replycontent').val();
	var paramData = JSON.stringify({"content": replyEditContent
	});
	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};
	$.ajax({
		url: "/updatedreply"
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
            console.log(result);
			showReplyList();
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}
</script>

</body>
</html>