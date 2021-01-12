<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>�α���</title>
	<style>
			*{
				text-align: center;
				background-color:#F4F4F4;
			}
			
			section{
				height : 90vh;
				overflow:auto;
			}
			footer {           
				height : 5vh;
				border-top:1px solid gray;
			}
			footer > div {           
				padding:25px;
				font-size:small;
			}
			.login{
				position:absolute;
				top:10px;
				right:10px;
			}
			.login a{
				padding:10px;
			}
			#id, #password {
				margin:0px;
				height:40px;
				width: 300px;
				cursor:pointer;
				text-align:left;
				font-size: 15px;
				border:solid 1px #DDDDDD;
				background-color:white;
			}
			
			#checkbox {
				margin-bottom:9px;
			}
			
			
			a{
				color:black;
				text-decoration:none;
			}
			
			#submitButton {
				color:#fff;
				background:#f43142;
				border-color:#f43412;
				height:40px;
				width: 305px;
				border: none;
				color:white;
				font-size:18px;
				cursor:pointer;
			}
			
			#naverButton {
				color:#fff;
				background:#19CE60;
				border-color:#19CE60;
				height:40px;
				width: 305px;
				border: none;
				color:white;
				font-size:18px;
				cursor:pointer;
			}
		</style>
</head>
<body>
	<section>
			<article style="margin-top:13%">
				<h2><a href="login.html"><img src="#" style="width:80px; height:80px;"></a></h2>
				<form action="#" method="post">
					<input type="text" name="id" id="id" placeholder="���̵�"><br>
					<input type="password" name="password" id="password" placeholder="��й�ȣ�� 6�� �̻� ~ 20�� ����"></br>
					<button type="submit" id="submitButton">�α���</button><br>
					<input type="checkbox" name="checkbox" id="checkbox">�ڵ� �α���
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;
					<a href="register.html"><small>ȸ������</small></a>
					<br>
					<br>
					<button type="button" id="naverButton" onclick="#">���̹��� �����ϱ�</button>
				</form>
			</article>
		</section>
		<footer>
			<div>
				(��)�����ڵ� 
			</div>
		</footer>
</body>
</html>