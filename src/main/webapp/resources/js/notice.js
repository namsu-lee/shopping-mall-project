
//읽음 처리 했을때 실행되는 함수
function Read_Check(notice_no) {
	//alert(notice_no);
	if(!confirm("읽음 처리를 하시겠습니까?")) {
		return;		
	}
	
	var data = {notice_no : notice_no}
	
	$.ajax({
		url: "/changereadcheck",
		type:"POST",
		data:data,
		success:function(result) {
			$(result).find("HashMap").each(function() {
				if($(this).find("num").text() == 1) {
					alert("읽음 처리 했다.");
				}
				if($(this).find("num").text() == 0) {
					alert("서버 오류!!");
				}
				window.location.reload();
			});
		}
	});
}



//알람 삭제
function notice_delete(notice_no) {
	if(!confirm("알람을 삭제 하시겠습니까?")) {
		return;		
	}
	
	var data = {notice_no : notice_no}
	
	$.ajax({
		url: "/deletereadcheck",
		type:"POST",
		data:data,
		success:function(result) {
			$(result).find("HashMap").each(function() {
				if($(this).find("num").text() == 1) {
					alert("알람을 삭제하였습니다.");
					$("#tr_" + notice_no).remove();
					return;
				}
				if($(this).find("num").text() == 0) {
					alert("서버 오류!!");
				}
			});
		}
	});
}