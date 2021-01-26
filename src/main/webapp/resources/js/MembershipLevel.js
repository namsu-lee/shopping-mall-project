//닉네임과 바꿀값을 가져와야한다.
function Msh(no) {
	var nickname = $("#td_" + no).text();
	var membershipflag = $("#select_" + no + " option:selected").val();

	//alert(nickname);
	//alert(membershipflag);
	var data = { nickname: nickname, membershipflag: membershipflag}
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