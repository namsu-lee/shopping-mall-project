<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../exclude/topnav.jsp" %>
 <title>카테고리 수정</title>
 <script src="/resources/js/jquery-3.5.1.min.js"></script>
    <style>
	body{
		overflow-y:auto;
	    height:100%;
	}
    #myTable {
    border-collapse: collapse;
    width: 100%;
    border: 1px solid #ddd;
    font-size: 18px;
    }

    #myTable th, #myTable td {
    text-align: left;
    padding: 12px;
    }

    #myTable tr {
    border-bottom: 1px solid #ddd;
    }

    #myTable tr.header, #myTable tr:hover {
    background-color: #f1f1f1;
    }
    .submit{
        border: none;
        background-color: inherit;
        padding: 14px 28px;
        font-size: 16px;
        cursor: pointer;
        display: inline-block;
        color:blue;
    }
    .submit:hover {background: #eee;}
    .category{
	     width:75%;
	    margin:0px auto;
     }
    </style>
<div class="category">
	<form id="frm1" name="frm1" class="frm1" method="POST" action="/category/insert">
		<div style="display: inline-block;">
			
			<div style="float: left; margin: 10px;">
				카테고리 순서<br> <input type="number" name="catesort" id="catesort">
			</div>
			<div style="float: left; margin: 10px;">
				카테고리 이름<br> <input type="text" name="catename" id="catename" onkeyup="chkword(this, 100)">
			</div>
			<div style="float: left; margin: 10px;">
				글쓰기 권한<br> 
			<input type="checkbox" name="cateauth" value="M" checked> 관리자 <br> 
			<input type="checkbox" name="cateauth" value="A"> A <br> 
			<input type="checkbox" name="cateauth" value="B"> B <br> 
			<input type="checkbox" name="cateauth" value="C"> C <br> 
			<input type="checkbox" name="cateauth" value="D"> D <br> 
			<input type="checkbox" name="cateauth" value="F"> F <br>
			</div>
			<div style="float: left; margin: 10px;">
				그룹여부<br> 
			<select name="categroup">
				<option value="Y">예
				<option value="N" selected>아니오
			</select>
			</div>
			<br>
		</div>
		<br>
		<br>
	</form>
	<button class="submit" onclick='btn_click("frm1");'>추가</button>
	<br><br>
<table id="myTable">
    <tr class="header">
      <th style="width:8%;">카테고리 순서</th>
      <th style="width:15%;">카테고리 이름</th>
      <th style="width:15%;">글쓰기 권한</th>
      <th style="width:5%;">그룹여부</th>
      <th style="width:7%;"> </th>
      <th style="width:7%;"> </th>
    </tr>
    
<c:forEach items="${selectList}" var="cate">
	<tr id="cateedit${cate.cateid}" name="cateedit${cate.cateid}">
      <td>${cate.catesort}</td>
      <td>${cate.catename}</td>
      <td>${cate.cateauth}</td>
      <td>${cate.categroup}</td>
      <td><button type="button" class="submit" onclick='fn_editcate(${cate.cateid}, ${cate.catesort}, "${cate.catename}", "${cate.cateauth}", "${cate.categroup}")'>수정</button></td>
      <td>
      	<button type="button" class="submit" onclick='del("${cate.cateid}");'>삭제</button>
      </td>
    </tr>
</c:forEach>
    
 </table>
 </div>
 <script>
//카테고리 입력
function btn_click(frmid){      
	var sort = document.getElementById('catesort').value;
	var name = document.getElementById('catename').value;

	for(var i=0; i<100; i++){ // 값이 들어간 길이 만큼 제목과 본문의 공백을 제거
		sort = sort.replace(" ","");
		name = name.replace(" ","");
	}
	
	if(sort != "" && name !=""){ // 내용이 작성되어 있는 경우 submit() 한다. 
		document.getElementById(frmid).submit();
	}
	else if(sort == ""){ // 작성 된 내용이 하나도 없을 경우 안내 메세지 창 출력
		alert("순서를 입력해주세요.");
	}else if(name == ""){
		alert("이름을 입력해주세요.");
	}
}


//삭제
function del(i) {
	if (confirm("삭제하시겠습니까??") == true){    //확인
		
	}else{   //취소
	    return;
	}
	
	var a = "/category/delete?i="+i ;
	location.href=a;
}
function chkword(obj, maxByte) {

	var strValue = obj.value;
	var strLen = strValue.length;
	var totalByte = 0;
	var len = 0;
	var oneChar = "";
	var str2 = "";

	for (var i = 0; i < strLen; i++) {
		oneChar = strValue.charAt(i);
		if (escape(oneChar).length > 4) {
			totalByte += 2;
		} else {
			totalByte++;
		}

		// 입력한 문자 길이보다 넘치면 잘라내기 위해 저장
		if (totalByte <= maxByte) {
			len = i + 1;
		}
	}

	// 넘어가는 글자는 자른다.
	if (totalByte > maxByte) {
		alert(maxByte + "자를 초과 입력 할 수 없습니다.");
		str2 = strValue.substr(0, len);
		obj.value = str2;
		chkword(obj, 4000);
	}
}

//카테고리 수정 창
function fn_editcate(cateid, catesort, catename, cateauth, categroup){
	var htmls = "";
	htmls +='<tr id="cateedit'+cateid+'" name="cateedit'+cateid+'">'; 	
	htmls +='<td colspan="4"><form id="edit'+cateid+'" name="edit'+cateid+'" method="POST" action="/categoryedit/'+cateid+'"><table style="padding:0;border:0px; width:100%;"><tr><td style="width:18.60465116%;"><input type="number" name="catesort" id="catesort" value=\''+catesort+'\'>';
	htmls +='<td style="width:34.88372093%;"><input type="text" name="catename" id="catename" onkeyup="chkword(this, 100)" value=\''+catename+'\'></td>';
	htmls +='<td style="width:34.88372093%;">';
	htmls += '<input type="checkbox" name="cateauth" ';
	if (cateauth.indexOf('M')!=-1) {
		htmls +='checked';
	}
	htmls += ' value="M"> 관리자 <br>';
	htmls +='<input type="checkbox" name="cateauth" ';
	if (cateauth.indexOf('A')!=-1) {
		htmls +='checked';
	}
	htmls += ' value="A"> A <br>';
	htmls +='<input type="checkbox" name="cateauth" ';
	if (cateauth.indexOf('B')!=-1) {
		htmls +='checked';
	}
	htmls +=' value="B"> B <br>';
	htmls +='<input type="checkbox" name="cateauth" ';
	if (cateauth.indexOf('C')!=-1) {
		htmls +='checked';
	}
	htmls +=' value="C"> C <br>';
	htmls +='<input type="checkbox" name="cateauth" ';
	if (cateauth.indexOf('D')!=-1) {
		htmls +='checked';
	}
	htmls += ' value="D"> D <br>';
	htmls +='<input type="checkbox" name="cateauth" ';
	if (cateauth.indexOf('F')!=-1) {
		htmls +='checked';
	}
	htmls += ' value="F"> F <br></td>';
	htmls +='<td style="width:11.62790698%;"><select name="categroup">';
	//
	htmls +='<option value="Y"';
	if (categroup.indexOf('Y')!=-1) {
		htmls +='selected';
	}
	htmls +='>예';
	htmls +='<option value="N"';
	if (categroup.indexOf('N')!=-1) {
		htmls +='selected';
	}
	htmls +=' >아니오';
	htmls +='</select></td></tr></table></form>';				
	htmls +='';
	htmls +='<td><button type="button" class="submit" onclick="editEvent('+cateid+', \'edit'+cateid+'\')">수정완료</button></td>';
	htmls +='<td>';
	htmls +='<button type="button" class="submit" onclick="editcancle('+cateid+', '+catesort+', \''+catename+'\', \''+cateauth+'\', \''+categroup+'\')">취소</button>';
	htmls +='</td>';
	
	htmls +='</td>';
	htmls +='</tr>';
	
	$('#cateedit' + cateid).replaceWith(htmls);
}

//카테고리 취소 창
function editcancle(cateid, catesort, catename, cateauth, categroup){
	var htmls = "";
	htmls +='<tr id="cateedit'+cateid+'" name="cateedit'+cateid+'">';
	htmls +='<td>'+catesort+'</td>';
	htmls +='<td>'+catename+'</td>';
	htmls +='<td>'+cateauth+'</td>';
	htmls +='<td>'+categroup+'</td>';
	htmls +='<td><button type="button" class="submit" onclick="fn_editcate(\''+cateid+'\', \''+catesort+'\', \''+catename+'\', \''+cateauth+'\', \''+categroup+'\')">수정</button>';
	htmls +='<td>';
	htmls +='<button type="button" class="submit" onclick="del('+cateid+');">삭제</button>';
	htmls +='</td>';
	htmls +='</tr>';
	$('#cateedit' + cateid).replaceWith(htmls);

}

//카테고리 수정
function editEvent(cateid, catename){     
	//var document.getElementById(catename)
	var name = $("#"+catename).find("#catename").val();
	var sort = $("#"+catename).find("#catesort").val();
	for(var i=0; i<100; i++){ // 값이 들어간 길이 만큼 제목과 본문의 공백을 제거
		sort = sort.replace(" ","");
		name = name.replace(" ","");
	}
	if(sort != "" && name !=""){ // 내용이 작성되어 있는 경우 submit() 한다. 
		document.getElementById(catename).submit();
	}
	else if(sort == ""){ // 작성 된 내용이 하나도 없을 경우 안내 메세지 창 출력
		alert("순서를 입력해주세요.");
	}else if(name == ""){
		alert("이름을 입력해주세요.");
	}
}
</script>