<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../exclude/topnav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>

<style>
.board{
     width:75%;
     margin:0px auto; 
}

.example{
margin-left:10px;
max-width:400px;
float:left;
}

form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 70%;
  background: #f1f1f1;
}

form.example button {
  float: left;
  width: 15%;
  padding: 5px;
  margin-left:5px;
  color: black;
  background-color:white;
  font-size: 17px;
  border: 1px solid grey;
  cursor: pointer;
  
}

form.example button:hover {
  background: #f1f1f1;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}

#myTable {
    border-collapse: collapse;
    width: 100%;
    border: 1px solid #ddd;
    font-size: 18px;
    margin-top:60px;
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
</style>
</head>
<body>
<div class="board">
<%@ include file="../../exclude/leftmenu.jsp" %>
	<div class="boardlist" style="float:right; width:80%;">
	
	<form class="example" action="#" >
	  <input type="text" placeholder="검색" name="search"> 
	  <button type="submit"><svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  		<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
		</svg>
	  </button>
	</form>
	<table id="myTable">
    <tr class="header">
			<th style="text-align: center; width:10%;">번호</th>
			<th style="width:40%;">제목</th>
			<th style="text-align: center; width:20%;">글쓴이</th>
			<th style="text-align: center; width:20%;">작성일</th>
			<th style="text-align: center; width:10%;">조회수</th>
    </tr>
    <c:forEach items="${GetBoardList}" var="list">
		<tr>
			<td style="text-align: center;">${list.b_num}</td>
			<td ><a href="/board/${cateid}/${list.b_num}"> ${list.b_title}</a></td>
			<td style="text-align: center;">${list.nickname}</td>
			<td style="text-align: center;">${list.b_wdate}</td>
			<td style="text-align: center;">${list.b_hit}</td>
		</tr>
	</c:forEach>
    
 </table>
 <div style="float:right;">
 	<button  class="btn info" onclick="location.href='/board/${cateid}/writeboard'">글쓰기</button>
 </div>
 	</div>
</div>
</body>
</html>