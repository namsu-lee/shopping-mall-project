<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">

<div style="float:right; width:100%; margin-top:30px; margin-bottom:30px; right:0px;"> 
<hr>
<div>
    접속 인원 ${size }명
  <div>
      <c:forEach items="${list}" var="list">
		 ${list} 
	  </c:forEach>
  </div>
</div>
<div>
    <div>오늘 ${TodayCount }</div> <div>전체 ${TotalCount }</div>
</div>

</div>
