<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	
    
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

<div style="width:15%; float:left;">
<c:forEach items="${selectList}" var="cate">

	<c:choose>
	    <c:when test="${cate.categroup eq 'Y'}">
	        <hr>
	            ${cate.catename}
	        <hr>
	    </c:when>
	    <c:when test="${cate.categroup eq 'n'}">
	         <button class="default">${cate.catename}</button>
	    </c:when>
	</c:choose>
</c:forEach>

       
    </div> 