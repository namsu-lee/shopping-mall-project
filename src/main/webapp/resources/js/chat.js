//채팅방에 들어가자마자 "클라이언트단 소켓" 생성
	$.ajax({
		url:"/chat/ClientSocketOpen",
		type:"POST",
		success:function(result) {
			alert(result);
			
		}
	});
	
	
	
//사용자가 입력한 값 채팅 서버에 보냄