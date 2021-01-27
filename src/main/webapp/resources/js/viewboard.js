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
		submitreply();
	}
	else if(content == ""){ // 작성 된 내용이 하나도 없을 경우 안내 메세지 창 출력
		alert("내용을 입력해주세요.");
	}
}

/* 댓글 수정 */
function submitUpdateReply(replynum) {	
	var content = document.getElementById('replycontent'+replynum).value;

	for(var i=0; i<100; i++){ // 값이 들어간 길이 만큼 제목과 본문의 공백을 제거
		content = content.replace(" ","");
	}
	if(content != ""){ // 내용이 작성되어 있는 경우 submit() 한다. 
		updatedreply+replynum.submit();
	}
	else if(content == ""){ // 작성 된 내용이 하나도 없을 경우 안내 메세지 창 출력
		alert("내용을 입력해주세요.");
		
	}
}

function replydel(cateid, b_num, replynum){
	if (confirm("삭제하시겠습니까??") == true){    //확인
		location.href = "/board/"+cateid+"/"+b_num+"/"+replynum+"/deletereply";
	}else{   //취소
	    return;
	}
}

function enterkey() {
    if (window.event.keyCode == 13) {
         // 엔터키가 눌렸을 때 실행할 내용
         submitWriteReply();
    }
}

