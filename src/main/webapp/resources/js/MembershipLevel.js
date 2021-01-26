//닉네임과 바꿀값을 가져와야한다.
function Msh(no) {
	var nickname = $("#td_" + no).text();
	var membershipflag = $("#select_" + no + " option:selected").val();

	//alert(nickname);
	//alert(membershipflag);
	var data = { nickname: nickname, membershipflag: membershipflag }
	$.ajax({
		url: "/Membershipmodify",
		type: "POST",
		data: data,
		success: function(result) {
			$(result).find("HashMap").each(function() {
				if ($(this).find("num").text() == 1) {
					alert("수정 하였습니다.");
					$("#select_" + no + " option:selected").val();
				}
				if ($(this).find("num").text() == 0) {
					alert("수정에 실패했다.");
				}
			});
		}
	});
}


//정지 기능
function Stop(no) {
	var nickname = $("#td_" + no).text();
	//alert(nickname);
	var data = { nickname: nickname }

	$.ajax({
		url: "/Membershipstop",
		type: "POST",
		data: data,
		success: function(result) {
			$(result).find("HashMap").each(function() {
				if ($(this).find("num").text() == 1) {
					alert("해당 사용자를 정지시켰습니다.");
					window.location.reload();
					//$("#stop_" + no).text("정지 취소");
				}
				if ($(this).find("num").text() == 0) {
					alert("정지를 못했어요...");
				}
			});
		}
	});
}


//정지 취소
function Stop_Cancel(no) {
	
	var nickname = $("#td_" + no).text();
	var data = { nickname: nickname }
	
	$.ajax({
		url: "/stopcancelmember",
		type: "POST",
		data: data,
		success: function(result) {
			$(result).find("HashMap").each(function() {
				if ($(this).find("num").text() == 1) {
					alert("해당 사용자의 정지를 풀었습니다.");
					window.location.reload();
				}
				if ($(this).find("num").text() == 0) {
					alert("정지 해지를 못했어요...");
				}
			});
		}
	});
}

















