//bang_id=bbbbbbbb
//채팅방 입장
function winOpen(i) {
	var text = $("#btn_" + i).text();
	window.open("/chat?bang_id=" + text, "new", "width=500,height=800,top=100,left=100");
}


//채팅방 만들기
function Make_ChattingBang() {
	var title = $("#titlechat").val();
	if(title == "") {
		alert("공백은 입력안됩니다.");
		return;	
	}
	if(!confirm("채팅방을 게설하시겠습니까?")) {
		return;
	}
	var data = {title : title}
	$.ajax({
		url:"/MakeChattingBang",
		type:"POST",
		data:data,
		success:function(result) {
			//<HashMap><num>0</num></HashMap>
			$(result).find("HashMap").each(function() {
				if($(this).find("num").text() == 1) {
					alert("채팅방을 만드는데 오류가 발생했습니다. 관리자에게 문의해주세요..");
				}
				if($(this).find("num").text() == 0) {
					var output = "";
					output += "<button>"+ data.title +"</button>";
					/*$("#title").val("");
					$("#chtting_list_box").html(output);*/
					alert("채팅방을 게설하였습니다.");
					window.location.reload();
				}
			});
		}
	});
}