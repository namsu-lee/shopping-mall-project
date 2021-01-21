
// 비밀번호 변경 버튼을 누르면 실행되는 함수.
function PasswordChange()	{
	window.open("Changepassword.jsp","비밀번호 변경","width=600px,height=400px");
}

// 회원탈퇴 버튼을 누르면 실행되는 함수.
function Withdrawal()	{
	var check = confirm("정말 회원탈퇴를 하시겠습니까?");
	if(check == true)	{
	}
	else	{
		return;
	}
	$.ajax({
		url:"#",
		type:"POST",
		success:function(result)	{
			var json = JSON.parse(result);
			if(json.length == 0)	{
				alert("다시 회원탈퇴를 해주세요.");
			}
			if(json[0]["result"] == 1)	{
				alert("정상적으로 회원탈퇴가 되었습니다.");
				location.href="Main.jsp";
			}
			if(json[0]["result"] == -1)	{
				alert("다시 회원탈퇴를 해주세요.");
			}
		}
	});
}



//마이페이지 수정해주는 함수.
function Modify()	{
	//찍어보자
	var check = confirm("수정하시겟습니까?");
	if(check == true)	{
	}
	
	if(check == false)	{
		return false;
	}
	var data = new FormData(form);	//ajax로 파일 전송시 FormData객체 생성 후 form을 넣어줘야한다.
	$.ajax({
		url:"Mypage",
		type:"POST", // data: "param1=aaaa&param2=zzzz,
		enctype: "multipart/form-data",
		contentType : false,
		processData : false,
		data:data,		//data:"id=" + <%= id %>
		success:function(result)	{
			var json = JSON.parse(result);
			if(json.length == 0)	{
			}
		}
	});
}
