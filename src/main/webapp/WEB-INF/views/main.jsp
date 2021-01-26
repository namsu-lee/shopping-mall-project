<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../exclude/topnav.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카페 메인</title>
</head>
<body>
	
<style>

.main{
     width:75%;
     margin:0px auto;
}
</style>

<div class="main">
	<%@ include file="../../exclude/leftmenu.jsp" %>
	<div style="width: 80%; float:right;">
        <button class="btn info" onclick="location.href='/mainupdate'">메인화면 수정</button>
        <br>
		${UpdateGetMain.m_content }
    </div>   
    <%@ include file="../../exclude/footer.jsp" %> 
</div>
<!--Start of Tawk.to Script-->
<script type="text/javascript">
	var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
	(function(){
		var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
		s1.async=true;
		s1.src='https://embed.tawk.to/600ade7ea9a34e36b96f3d6a/1esl7a88r';
		s1.charset='UTF-8';
		s1.setAttribute('crossorigin','*');
		s0.parentNode.insertBefore(s1,s0);
	})();
</script>
<!--End of Tawk.to Script-->
</body>

</html>