<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../exclude/topnav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>FAQ</title>
<style>
.tab{
  position:fixed; 
  left:50%; 
  transform:translateX(-50%); 
  width:80%;
}

.tablink {
  float : left;
  background-color: black;
  color: white;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  font-size: 17px;
  width: 25%;
}

.tablink:hover {
  background-color: gray;
}

/* Style the tab content */
.tabcontent {
  margin-top:50px;
  position:fixed; 
  left:50%; 
  transform:translateX(-50%); 
  width: 80%;
  color: black;
  display: none;
  padding: 50px;
  text-align: center;
}


/* 아코디언 */
.accordion {
  background-color: #eee;
  color: #444;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
  transition: 0.4s;
}

.active, .accordion:hover {
  background-color: #ccc; 
}

.panel {
  padding: 0 18px;
  display: none;
  background-color: white;
  overflow: hidden;
  text-align:left;
}


</style>


</head>
<body>

<div class="tab">
<button class="tablink" onclick="catechange('cate1', this)" id="defaultOpen">카테고리1</button>
<button class="tablink" onclick="catechange('cate2', this)">카테고리2</button>
<button class="tablink" onclick="catechange('cate3', this)">카테고리3</button>
<button class="tablink" onclick="catechange('cate4', this)">카테고리4</button>
</div>

<div id="cate1" class="tabcontent">
  <button class="accordion">질문 1</button>
	<div class="panel">
  		<p>답변입니다1.</p>
	</div>
<button class="accordion">질문 2</button>
<div class="panel">
  <p>답변입니다2.</p>
</div>

<button class="accordion">질문 3</button>
<div class="panel">
  <p>답변입니다3.</p>
</div>

</div>

<div id="cate2" class="tabcontent">
   <button class="accordion">질문 1</button>
	<div class="panel">
  		<p>답변입니다1.</p>
	</div>
<button class="accordion">질문 2</button>
<div class="panel">
  <p>답변입니다2.</p>
</div>

<button class="accordion">질문 3</button>
<div class="panel">
  <p>답변입니다3.</p>
</div>
</div>

<div id="cate3" class="tabcontent">
   <button class="accordion">질문 1</button>
	<div class="panel">
  		<p>답변입니다1.</p>
	</div>
<button class="accordion">질문 2</button>
<div class="panel">
  <p>답변입니다2.</p>
</div>

<button class="accordion">질문 3</button>
<div class="panel">
  <p>답변입니다3.</p>
</div>
</div>

<div id="cate4" class="tabcontent">
   <button class="accordion">질문 1</button>
	<div class="panel">
  		<p>답변입니다1.</p>
	</div>
<button class="accordion">질문 2</button>
<div class="panel">
  <p>답변입니다2.</p>
</div>

<button class="accordion">질문 3</button>
<div class="panel">
  <p>답변입니다3.</p>
</div>
</div>

<script>
function catechange(cate,elmnt) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].style.backgroundColor = "";
  }
  document.getElementById(cate).style.display = "block";
  elmnt.style.backgroundColor = "gray";

}
// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();


//아코디언
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}
</script>
</body>
