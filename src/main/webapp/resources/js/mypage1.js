//사진 변경 버튼 클릭 후 사진을 변경하면 화면에 사진을 뿌려주는 함수.
function readInputFile(input) {
	if (input.files && input.files[0]) { 	//파일이 선택된 상태라면
		var reader = new FileReader();		// 파일을 읽기 위해서 객체 생성
		reader.onload = function(e) {		// 파일을 읽어들이기를 성공했을때 호출되는 이벤트
			$("#imgfile").html("<img src='" + event.target.result + "'>");	// event.target.result => 파일의 경로 + 이미지 이름
		}
		reader.readAsDataURL(input.files[0]);
	}
}


var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
var maxSize = 5242880;

//첨부파일을 이용한 웹 공격을 막기 위한 함수
function checkExtension(fileName, fileSize) {
	if (fileSize >= maxSize) {
		alert("파일 사이즈 초과");
		return false;
	}

	if (regex.test(fileName)) {
		alert("해당 종류의 파일은 업로드할 수 없습니다.");
		return false;
	}
	return true;
}
//파일이 존재하는지 여부를 알 수 있습니다.
//반환결과가 boolean으로 파일이 존재하면 참, 없으면 거짓을 반환


$(document).ready(function() {
	$("#uploadBtn").on("click", function(e) {
	var formData = new FormData();
	var inputFile = $("input[name='uploadFile']");
	var files = inputFile[0].files;
	console.log(files);

	//파일을 폼에 추가
	for (var i = 0; i < files.length; i++) {
		if (!checkExtension(files[i].name, files[i].size)) {
			return false;
		}
	}
	});
});






















