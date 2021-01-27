<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">

<style>
	.group-list{
	background-color:#E6E6E6; 
	overflow-x:hidden; 
	overflow-y:auto; 
	width:130px; 
	padding:5px; 
	height:130px;
	}
	.group-list::-webkit-scrollbar{
	width: 10px;
	}
	.group-list::-webkit-scrollbar-thumb {
    background-color: #BDBDBD;
    border-radius: 10px;
  }
</style>

<div style="float:right; width:100%; margin-top:30px; margin-bottom:30px; right:0px;"> 
<hr>
<div style="float:left;">
    접속 인원 ${size }명
  <div>
      <ul class="group-list" >
      <c:forEach items="${list}" var="list">
		<li style="list-style:none;"> ${list}</li> 
	  </c:forEach>
	  </ul>
  </div>
</div>
<div style="float:left; margin-left:30px;">
    <div>오늘 ${TodayCount }</div> <div>전체 ${TotalCount }</div>
</div>

</div>

