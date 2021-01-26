//닉네임과 바꿀값을 가져와야한다.
function Msh(no) {
	var nickname = $("#td_" + no).text();
	var membershipflag = $("#select_" + no + " option:selected").val();

	//alert(nickname);
	//alert(membershipflag);
	var data = {nickname:nickname, membershipflag: membershipflag}
	$.ajax({
		url:"/Membershipmodify",
		type:"POST",
		data:data,
		success:function(result) {
			alert("과연" + result);
		}
	});
}