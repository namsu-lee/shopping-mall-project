<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/js/jquery-3.5.1.min.js"></script>
<script src="/resources/js/ChattingBangList.js"></script>
<link href="/resources/css/ChattingBangList.css" rel="stylesheet">
<title>Insert title here</title>
<script>
	//bang_id=bbbbbbbb
	//채팅방 입장
	function winOpen(no) {
		var text = $("#btn_" + no).text();
		window.open("/chat?bang_id=" + text, "new",
				"width=500,height=800,top=100,left=100");
	}
</script>
</head>
<body>
	<div>
		<label id="title">채팅방 제목 : </label> <input type="text" id="titlechat"
			name="title">
		<button type="button" id="Make_ChattingBang"
			onclick="Make_ChattingBang()">방 만들기</button>
	</div>
	<h2>
		<strong>채팅방 목록</strong>
	</h2>
	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
	<table id="myTable">
		<tr class="header">
			<th style="width: 60%;">채팅 방</th>
			<th style="width: 20%;">  </th>
		</tr>
		<c:forEach items="${list}" var="list" varStatus="status">
			<tr>
				<td><a href="javascript:winOpen(<c:out value="${list.no}" />);" id="btn_<c:out value="${list.no}" />"><c:out value="${list.title}" /></a></td>
				<td>
					<button type="button" id="chat_modify_<c:out value="${list.no}" />" onclick="chat_modify(<c:out value="${list.no}" />)">수정</button>
					<button type="button" id="chat_remove_<c:out value="${list.no}" />" onclick="chat_remove(<c:out value="${list.no}" />)">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>