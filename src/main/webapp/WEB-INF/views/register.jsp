<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- �׺�� css -->
  <link rel="stylesheet" type="text/css" href="./css/nav.css" />
  <!-- ä�ù� ����Ʈ css -->
  <link rel="stylesheet" type="text/css" href="./css/chatlist.css" />
  <!-- ȸ������ css -->
  <link rel="stylesheet" type="text/css" href="./css/register.css" />
  
  <!-- �����ȣ js -->
  <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
  <script src="./js/jquery-3.5.1.min.js"></script>
  <!-- ȸ������������ js -->
  <script src="./js/register.js"></script>
  <title>ȸ������</title>

</head>
<body>    
  <div class="container">
  <!-- ���� ���� -->
  <div class="leftem" style="width:25%; height: 94%; float: left; background-color: white;">
  </div>
  <!-- ���Ծ�� -->
  <div class="centerre" style="width:50%; height: 100%; float: left;">
    <form action="register" name="form" id="form" method="post">
      <div class="container">
        <h1>ȸ������</h1>
        <hr>
		<!-- ���̵� -->
		<label for="id"><b>���̵� *</b></label><button type="button" onclick="idcheck()" class="registerbtn" style="width:200px; margin-left:8px;">���̵� �ߺ�Ȯ��</button>
        <input type="text" placeholder="���̵� �Է����ּ���" name="id" id="id" required>
		
		<!-- ��й�ȣ -->
        <label for="password"><b>��й�ȣ *</b></label>
        <input type="password" placeholder="��й�ȣ�� �Է����ּ���" name="password" id="password" required>
		
		<!-- ��й�ȣ Ȯ�� -->
        <label for="confirmPassword"><b>��й�ȣ Ȯ�� *</b></label>
        <input type="password" placeholder="��й�ȣ�� �ѹ� �� �Է����ּ���" name="confirmPassword" id="confirmPassword" required>
		
		<!-- �г��� -->
		<label for="nick"><b>�г��� *</b></label><button type="button" onclick="idcheck()" class="registerbtn" style="width:200px; margin-left:8px;">�г��� �ߺ�Ȯ��</button>
        <input type="text" placeholder="�г����� �Է����ּ���" name="nick" id="nick" required>
		
		<!-- �̸��� -->
		<label for="email"><b>�̸��� *</b></label>
        <input type="hidden" name="sender" id="sender" value="gudxo1226@naver.com">
        <input type="email" placeholder="�̸����� �Է����ּ���" name="email" id="email" required style="float:left;">
		<button type="button" class="registerbtn" onclick="EmailCheck()" style="width:200px;">�̸��� ����</button><br/>
		<div id="div1">
		<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@ �̸��� Ȯ�� �޼��� �ѷ��ִ°� @@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
		</div>
		<label for="checkbox"><b>������ ���� ����</b></label>
		<input type="checkbox" name="checkbox" id="checkbox"></br>
		</br>
		<label for="address"><b>�ּ�</b></label><br/>
		<input type="text" id="sample6_postcode" placeholder="�����ȣ" style="width:200px;">
		<input type="button" onclick="sample6_execDaumPostcode()" value="�����ȣ ã��" class="registerbtn" style="width:200px;"><br/>
		<input type="text" id="sample6_address" placeholder="�ּ�" style="width:200px;">
		<input type="text" id="sample6_detailAddress" placeholder="���ּ�" style="width:200px;">
		<input type="text" id="sample6_extraAddress" placeholder="�����׸�" style="width:200px;">
		<input type="hidden" id="address" name="address" value="">
		<br/>
		<label for="phone"><b>��ȭ��ȣ *</b></label><br/>
		<select name="phone1" id="phone1">	<!--  input hidden  -->
			<option value="010" selected>010</option>
			<option value="011">011</option>
			<option value="012">012</option>
			<option value="013">013</option>
			<option value="014">014</option>
			<option value="015">015</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="018">018</option> 
			<option value="019">019</option>
		</select> 
		<input type="text" style="width:100px; margin-right:5px;" name="phone2" id="phone2" size="5" maxlength="4" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"><strong>-</strong><input type="text" style="width:100px; margin-left:5px;" name="phone3" id="phone3" size="5" maxlength="4" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></h3>
		<input type="hidden" id="phone" name="phone" value="">
        <hr>

        <button type="submit" class="registerbtn">ȸ������</button>
      </div>
      
      <div class="container signin">
        <p> ���̵� �̹� �����Ű���? <a href="login.html">�α���</a></p>
      </div>
    </form>
</div>

</div>
</body>
</html>

<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!! -->