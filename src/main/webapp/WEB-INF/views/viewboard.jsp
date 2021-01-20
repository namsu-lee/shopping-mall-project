<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../exclude/topnav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<style>
	.view{
	     width:75%;
	     margin:0px auto; 
	}
	.viewcon *{
		margin:10px;
	}
	.title{
		font-size : 40px;
		
	}
	.nick{
	 	font-size : 20px;
	 	margin-left:15px;
	}
	.wdate{
	 	font-size : 15px;
	 	margin-left:15px;
	}
	.content{
	 	padding:10px;
	}
</style>
</head>
<body>
<div class="view">
<%@ include file="../../exclude/leftmenu.jsp" %>
	<div class="viewcon" style="float:right; width:80%">
	<c:forEach items="${ViewBoard}" var="board">
		<div class="title">${board.b_title}</div>
		<div class="nick">${board.nickname}</div>
		<div class="wdate">${board.b_wdate}</div>
		<hr>
		<div class="content">${board.b_content}</div>
		<hr>
	</c:forEach>
	</div>
</div>
</body>
</html>