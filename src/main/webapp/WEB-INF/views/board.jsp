<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ include file="../../exclude/topnav.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
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
	
	<form class="example" action="/board/${cateid}" method="get" >
	  <input type="text" placeholder="검색" name="keyword"> 
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
			<td ><a href="/board/${cateid}/${list.b_num}"> 
				<c:choose>
				<c:when test="${param.keyword == null}">
				${list.b_title} 
				</c:when>
				<c:when test="${param.keyword != null}">
					 <c:set var="highlight" value="<label style='background-color:yellow'> 
					 ${param.keyword}
					 </label>" />
					${fn:replace(list.b_title, param.keyword , highlight )} 
				</c:when>
				</c:choose>
			</a></td>
			<td style="text-align: center;">
				<c:choose>
				<c:when test="${param.keyword == null}">
				${list.nickname} 
				</c:when>
				<c:when test="${param.keyword != null}">
					 <c:set var="highlight" value="<label style='background-color:yellow'> 
					 ${param.keyword}
					 </label>" />
					${fn:replace(list.nickname, param.keyword , highlight )} 
				</c:when>
				</c:choose>
			</td>
			<td style="text-align: center;">${list.b_wdate}</td>
			<td style="text-align: center;">${list.b_hit}</td>
		</tr>
	</c:forEach>
 </table>
 <c:choose>
 <c:when test="${sessionScope.memberid != null }">
	 <div style="float:right;">
	 	<button  class="btn info" onclick="location.href='/board/${cateid}/writeboard'">글쓰기</button>
	 </div>
 </c:when> 
 </c:choose>
<!-- 검색어 변수로 받아오기 -->
<c:if test='${param.keyword != null}'>
	<c:set var="pagekeyword" value="&keyword=${param.keyword}" />
</c:if>
<div style="margin-top:30px; margin-left:40%;">

<!-- pagination{s} -->
<div id="paginationBox">
	<ul class="pagination">
		<c:if test="${pagination.prev}">
			<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
		</c:if>
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
			<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a></li>
		</c:forEach>
		<c:if test="${pagination.next}">
			<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.range}', 
			'${pagination.range}', '${pagination.rangeSize}')" >Next</a></li>
		</c:if>
	</ul>
</div>
		
</div> 	
</div>
</div>
<script>
//이전 버튼 이벤트
function fn_prev(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		var url = "${pageContext.request.contextPath}/board/${cateid}";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		location.href = url;
	}

//페이지 번호 클릭
function fn_pagination(page, range, rangeSize, searchType, keyword) {
	var url = "${pageContext.request.contextPath}/board/${cateid}";
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	location.href = url;	
}

//다음 버튼 이벤트
function fn_next(page, range, rangeSize) {
	var page = parseInt((range * rangeSize)) + 1;
	var range = parseInt(range) + 1;
	var url = "${pageContext.request.contextPath}/board/${cateid}";
	url = url + "?page=" + page;
	url = url + "&range=" + range;
	location.href = url;
}
</script>
</body>
</html>