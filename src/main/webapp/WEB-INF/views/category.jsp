<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../../exclude/topnav.jsp" %>
 <title>게시판 목록 수정</title>
    <style>
	body{
		overflow-y:auto;
	    height:100%;
	}
    #myTable {
    border-collapse: collapse;
    width: 100%;
    border: 1px solid #ddd;
    font-size: 18px;
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
    .submit{
        border: none;
        background-color: inherit;
        padding: 14px 28px;
        font-size: 16px;
        cursor: pointer;
        display: inline-block;
        color:blue;
    }
    .submit:hover {background: #eee;}
    .category{
	     width:75%;
	    margin:0px auto;
     }
    </style>
<div class="category">
	<form id="frm1" class="frm1" method="POST" action="/category">
		<div style="display: inline-block;">
			
			<div style="float: left; margin: 10px;">
				카테고리 순서<br> <input type="number" name="catesort">
			</div>
			<div style="float: left; margin: 10px;">
				카테고리 이름<br> <input type="text" name="catename">
			</div>
			<div style="float: left; margin: 10px;">
				글쓰기 권한<br> 
			<input type="checkbox" name="cateauth" value="M" checked> 관리자 <br> 
			<input type="checkbox" name="cateauth" value="A"> A <br> 
			<input type="checkbox" name="cateauth" value="B"> B <br> 
			<input type="checkbox" name="cateauth" value="C"> C <br> 
			<input type="checkbox" name="cateauth" value="D"> D <br> 
			<input type="checkbox" name="cateauth" value="F"> F <br>
			</div>
			<div style="float: left; margin: 10px;">
				그룹여부<br> 
			<select name="categroup">
				<option value="Y">예
				<option value="N" selected>아니오
			</select>
			</div>
			<br>
		</div>
		<br>
		<br>
		<button type="submit" class="submit" onclick='btn_click("insert");'>추가</button>
	</form>
	<br><br>
<table id="myTable">
    <tr class="header">
      <th style="width:8%;">카테고리 순서</th>
      <th style="width:25%;">카테고리 이름</th>
      <th style="width:15%;">글쓰기 권한</th>
      <th style="width:5%;">그룹여부</th>
      <th style="width:7%;"> </th>
    </tr>
    
<c:forEach items="${selectList}" var="cate">
	<tr>
      <td>${cate.catesort}</td>
      <td>${cate.catename}</td>
      <td>${cate.cateauth}</td>
      <td>${cate.categroup}</td>
      <td>
      	<button type="button" class="submit" onclick='del("${cate.cateid}");'>삭제</button>
      </td>
    </tr>
</c:forEach>
    
 </table>
 </div>
 <script>
    function btn_click(str){                             
        if(str=="insert"){
        	frm1.action="/category/insert"; 
        }
    }
    
    function del(i) {
    	var a = "/category/delete?i="+i ;
    	location.href=a;
    }
    
</script>