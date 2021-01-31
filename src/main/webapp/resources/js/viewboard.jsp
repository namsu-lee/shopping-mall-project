<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
//글 삭제
function deleteconfirm(){ 
		var deletecon = confirm("삭제 하시겠습니까?")
		
		if(deletecon==true){
			document.location.href = "/board/${cateid}/${b_num}/deleteboard";
		}else if(deletecon==false){
			return false;
		
		}
	}
//글자 수 확인
function submitWriteReply(cateid, b_num) {	
	var content = document.getElementById('replycontent').value;

	for(var i=0; i<100; i++){ // 값이 들어간 길이 만큼 제목과 본문의 공백을 제거
		content = content.replace(" ","");
	}
	if(content != ""){ // 내용이 작성되어 있는 경우 submit() 한다. 
		submitreply(cateid, b_num);
	}
	else if(content == ""){ // 작성 된 내용이 하나도 없을 경우 안내 메세지 창 출력
		alert("내용을 입력해주세요.");
	}
}
//댓글 enter키 입력
function enterkey(cateid, b_num) {
    if (window.event.keyCode == 13) {
         // 엔터키가 눌렸을 때 실행할 내용
         submitWriteReply(cateid, b_num);
    }
}
//댓글 불러오기
function showReplyList(){
	var url = "/GetReply";
	var paramData = {"b_num" : "${ViewBoard.b_num}"};
	var sessionid= "${sessionScope.memberid}";
	$.ajax({
        type: 'POST',
        url: url,
        data: paramData,
        dataType: 'json',
        success: function(result) {
           	var htmls = "";
           	htmls +='<table style="width:100%">';
		if(result.length < 1){
			htmls +="등록된 댓글이 없습니다.";
		} else {
		 $(result).each(function(){
		 	htmls += '<tr style="height:50px;vertical-align: middle;" name="reply'+this.replynum+'" id="reply'+this.replynum+'">';
		 	htmls += '<td style="width:10%;">'+this.nickname+'</td>';
		 	htmls +='<td style="width:55%;">'+this.replycontent+'</td>';
		 	htmls +='<td style="width:12%;">'+this.replydate+'</td>';
		 	if(this.memberid==sessionid){
		 		htmls +='<td style="width:5%; ">';
				htmls +='<button onclick="fn_editReply('+this.replynum+', \''+this.replycontent+'\')" class="replybtn">수정</button>';
				htmls +='</td>';
				htmls +='<td style="width:5%;">';
				htmls +='<button  class="replybtn" onclick="fn_deleteReply('+this.replynum+')">';
				htmls +='삭제</button>';
				htmls +='</td>';
		 	}else{
		 		htmls +='<td colspan="2" style="width:10%;"></td>';
		 	}
		 	htmls +='</tr>';
         	  });	//each end
		}
		htmls+='</table>';
		$("#replyList").html(htmls);
		//대댓글 토글
		 /* var acc = document.getElementsByClassName("accordion");
		var j;
	
		for (j = 0; j < acc.length; j++) {
		  acc[j].addEventListener("click", function() {
		    this.classList.toggle("active");
		    var panel = this.nextElementSibling;
		    if (panel.style.display === "block") {
		      panel.style.display = "none";
		    } else {
		      panel.style.display = "block";
		    } 
		  });
		} */
      }	   // Ajax success end
      
});	// Ajax end
}
$(document).ready(function(){
	showReplyList();
});

//댓글 입력
function submitreply(cateid, b_num){
	var replyContent = $('#replycontent').val();
	replyContent = replyContent.replaceAll("<", "&lt;");
	replyContent = replyContent.replaceAll(">", "&gt;");
	replyContent = replyContent.replaceAll("/b", "\/b");
	replyContent = replyContent.replaceAll("/n", "\/n");

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
		url: '/wrotereply?cateid='+cateid+'&b_num='+b_num
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();
			$('#replycontent').val('');
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}

//댓글 삭제
function fn_deleteReply(replynum){
	if (confirm("삭제하시겠습니까??") == true){    //확인
		
	}else{   //취소
	    return;
	}
	
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

//댓글 수정 창
function fn_editReply(replynum, replycontent){
	var htmls = "";
	htmls +='<tr style="height:50px;vertical-align: middle;" id="reply'+replynum+'">';
	htmls +='<form action="updatedreply('+replynum+')">';
 	htmls +='<td colspan="3" style="width:80%;">';
 	htmls +='<textarea name="editContent" id="editContent" class="form-control" ' 
 	htmls +='onkeyup="enterkeyupdate('+replynum+');" rows="1">';
	htmls += replycontent;
	htmls += '</textarea></td>';
	htmls +='</form>';
	htmls +='<td style="width:10%; ">';
	htmls +='<button type="button" style="padding-left:5%" onclick="fn_updateReply('+replynum+')" class="replybtn" >';
	htmls +='수정완료</button>';
	htmls +='</td>';
	htmls +='<td style="width:10%;">';
	htmls +='<button  class="replybtn" onClick="showReplyList()">';
	htmls +='취소</button>';
	htmls +='</td>';
	$('#reply' + replynum).replaceWith(htmls);
}
//댓글 수정 enter키 입력
function enterkeyupdate(replynum) {
    if (window.event.keyCode == 13) {
         // 엔터키가 눌렸을 때 실행할 내용
         fn_updateReply(replynum);
    }
}
//댓글 수정
function fn_updateReply(replynum){
	
	var content = document.getElementById('editContent').value;
	for(var i=0; i<100; i++){ // 값이 들어간 길이 만큼 제목과 본문의 공백을 제거
		content = content.replace(" ","");
	}
	if(content != ""){ // 내용이 작성되어 있는 경우 submit() 한다. 
	}
	else if(content == ""){ // 작성 된 내용이 하나도 없을 경우 안내 메세지 창 출력
		alert("내용을 입력해주세요.");
		return;
	}
	var replyEditContent = $('#editContent').val();
	var paramData = JSON.stringify({"replycontent": replyEditContent,
		"replynum" : replynum
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