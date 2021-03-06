<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.info {
        color: dodgerblue;
        border: none;
        padding: 14px 28px;
        font-size: 16px;
        cursor: pointer;
        display: inline-block;
        background-color:white;
    }

    .info:hover {
        background: #2196F3;
        color: white;
    }
    .default{
          border: none;
          background-color: inherit;
          padding: 5px 28px;
          font-size: 16px;
          cursor: pointer;
          display: inline-block;
          color: black;
        }
        
    .default:hover {background: #eee;}
</style>

<div style="width:15%; float:left; min-width:157px;">
<c:if test="${membershipflag eq 'm'}">
	<button  class="btn info" onclick="location.href='/category'">카테고리 수정</button>
</c:if>	
        <br>
<c:forEach items="${selectList}" var="cate">

	<c:choose>
	    <c:when test="${cate.categroup eq 'Y'}">
	        <hr>
	            ${cate.catename}
	        <hr>
	    </c:when>
	    <c:when test="${cate.categroup eq 'N'}">
	         <button class="default" onclick="location.href='/board/${cate.cateid}'">${cate.catename}</button><br>
	    </c:when>
	</c:choose>
</c:forEach>
</div> 