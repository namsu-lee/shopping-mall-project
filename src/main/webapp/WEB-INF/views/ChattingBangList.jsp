<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/js/jquery-3.5.1.min.js"></script>
<script src="/resources/js/ChattingBangList.js"></script>
<title>Insert title here</title>
</head>
	<body>
		<div>
			<label id="title">채팅방 제목 : </label>
			<input type="text" id="titlechat" name="title">
			<button type="button" id="Make_ChattingBang" onclick="Make_ChattingBang()">방 만들기</button>
		</div>
		<hr>
		<c:forEach items="${list}" var="list" varStatus="status">
		
			<button type="button" id="btn_${status.count}" onclick="winOpen(${status.count})"><c:out value="${list}"/></button>
			<hr>
		</c:forEach>
		<div id="chtting_list_box">
			
		</div>
	</body>	
</html>