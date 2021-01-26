<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">

<div style="float:right; width:100%; margin-top:30px;right:0px;"> 
<hr>
오늘 방문자 수 : ${TodayCount }<br>
전체 방문자 수 : ${TotalCount }<br>현재 접속 아이디 :
<c:forEach items="${list}" var="list">
 ${list},
</c:forEach>
 <br>
접속자 수 : ${size }<br>
</div>
