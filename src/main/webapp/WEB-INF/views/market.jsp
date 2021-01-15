<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
  box-sizing: border-box;
}

.row {
  
  margin-right:-15px;
}
  
.column1 {
  float: left;
  width: 50%;
  padding: 5px;
}

.column2 {
  float: left;
  width: 50%;
  padding: 5px;
  position:fixed;
}


/* Clearfix (clear floats) */
.row::after {
  content: "";
  clear: both;
  display: table;
}

.table1 {
  border-collapse: collapse;
  border-spacing: 0;
  width: 50%;
  border: 1px solid #ddd;
  position:absolute;
  top:400px;
  left:120px;
}

.table2 {
  margin-left:20px;
  border-collapse: collapse;
  border-spacing: 0;
  width: 45%;
  border: 1px solid #ddd;
  position:absolute;
  top:400px;
  left:1100px;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
.middle{
	position:relative;
	bottom:24px;
}
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

</style>
</head>
<body>
	<div class="row">
		<div class="column1">
			<table class="table1">
				<tr>
					<th><input type="radio" name="all" id="all"></th>
					<th>�ֹ���ǰ����</th>
					<th>����</th>
					<th>����</th>
					<th></th>
				</tr>
			
				<tr>
					<td><input type="radio" name="all" id="all" class="middle"><img src="black.jpg" style="width:60px; height:60px;"></td>
					<td>
						<span><font background-color="gray">�Ϲݹ��</font></span><br/>
						<span><font background-color="gray">���Ż� UCLA ��ġ ������ ������(T)</font></span><br/>
						<span><font background-color="gray">�׷��� / ONE SIZE</font></span><br/>
					</td>
					<td>
						<strong>����</strong>&nbsp;<span><input type="text" value="1" name="count_1" id="count_1" size="1px;" readonly></span>
									&nbsp;<button type="button" onclick="Count_Plus(1)">����</button>
										  <button type="button" onclick="Count_Minus(1)">����</button>
					</td>
					<td><font id="price_1">15,000</font><font>��</font></td>
					<td><button>x</button></td>
				</tr>
			
				<tr>
					<td><input type="radio" name="all" id="all" class="middle"><img src="lightblue.jpg" style="width:60px; height:60px;"></td>
					<td>
						<span><font background-color="gray">�Ϲݹ��</font></span><br/>
						<span><font background-color="gray">���Ż� UCLA ��ġ ������ ������(T)</font></span><br/>
						<span><font background-color="gray">�׷��� / ONE SIZE</font></span><br/>
					</td>
					<td>
						<strong>����</strong>&nbsp;<span><input type="text" value="1" name="count_2" id="count_2" size="1px;" readonly></span>
									&nbsp;<button type="button" onclick="Count_Plus(2)">����</button>
										  <button type="button" onclick="Count_Minus(2)">����</button>
					</td>
					<td><font id="price_2">24,000</font><font>��</font></td>
					<td><button>x</button></td>
				</tr>
			
				<tr>
					<td><input type="radio" name="all" id="all" class="middle"><img src="pink.jpg" style="width:60px; height:60px;"></td>
					<td>
						<span><font background-color="gray">�Ϲݹ��</font></span><br/>
						<span><font background-color="gray">���Ż� UCLA ��ġ ������ ������(T)</font></span><br/>
						<span><font background-color="gray">�׷��� / ONE SIZE</font></span><br/>
					</td>
					<td>
						<strong>����</strong>&nbsp;<span><input type="text" value="1" name="count_3" id="count_3" size="1px;" readonly></span>
									&nbsp;<button type="button" onclick="Count_Plus(3)">����</button>
										  <button type="button" onclick="Count_Minus(3)">����</button>
					</td>
					<td><font id="price_3">36,000</font><font>��</font></td>
					<td><button>x</button></td>
				</tr>
				<tr>
					<td><input type="radio" name="all" id="all" class="middle"><img src="pink.jpg" style="width:60px; height:60px;"></td>
					<td>
						<span><font background-color="gray">�Ϲݹ��</font></span><br/>
						<span><font background-color="gray">���Ż� UCLA ��ġ ������ ������(T)</font></span><br/>
						<span><font background-color="gray">�׷��� / ONE SIZE</font></span><br/>
					</td>
					<td>
						<strong>����</strong>&nbsp;<span><input type="text" value="1" name="count_4" id="count_4" size="1px;" readonly></span>
									&nbsp;<button type="button" onclick="Count_Plus(4)">����</button>
										  <button type="button" onclick="Count_Minus(4)">����</button>
					</td>
					<td><font id="price_4">17,000</font><font>��</font></td>
					<td><button>x</button></td>
				</tr>
				<tr>
					<td><input type="radio" name="all" id="all" class="middle"><img src="pink.jpg" style="width:60px; height:60px;"></td>
					<td>
						<span><font background-color="gray">�Ϲݹ��</font></span><br/>
						<span><font background-color="gray">���Ż� UCLA ��ġ ������ ������(T)</font></span><br/>
						<span><font background-color="gray">�׷��� / ONE SIZE</font></span><br/>
					</td>
					<td>
						<strong>����</strong>&nbsp;<span><input type="text" value="1" name="count_4" id="count_4" size="1px;" readonly></span>
									&nbsp;<button type="button" onclick="Count_Plus(4)">����</button>
										  <button type="button" onclick="Count_Minus(4)">����</button>
					</td>
					<td><font id="price_4">17,000</font><font>��</font></td>
					<td><button>x</button></td>
				</tr>
				<tr>
					<td><input type="radio" name="all" id="all" class="middle"><img src="pink.jpg" style="width:60px; height:60px;"></td>
					<td>
						<span><font background-color="gray">�Ϲݹ��</font></span><br/>
						<span><font background-color="gray">���Ż� UCLA ��ġ ������ ������(T)</font></span><br/>
						<span><font background-color="gray">�׷��� / ONE SIZE</font></span><br/>
					</td>
					<td>
						<strong>����</strong>&nbsp;<span><input type="text" value="1" name="count_4" id="count_4" size="1px;" readonly></span>
									&nbsp;<button type="button" onclick="Count_Plus(4)">����</button>
										  <button type="button" onclick="Count_Minus(4)">����</button>
					</td>
					<td><font id="price_4">17,000</font><font>��</font></td>
					<td><button>x</button></td>
				</tr>
				<tr>
					<td><input type="radio" name="all" id="all" class="middle"><img src="pink.jpg" style="width:60px; height:60px;"></td>
					<td>
						<span><font background-color="gray">�Ϲݹ��</font></span><br/>
						<span><font background-color="gray">���Ż� UCLA ��ġ ������ ������(T)</font></span><br/>
						<span><font background-color="gray">�׷��� / ONE SIZE</font></span><br/>
					</td>
					<td>
						<strong>����</strong>&nbsp;<span><input type="text" value="1" name="count_4" id="count_4" size="1px;" readonly></span>
									&nbsp;<button type="button" onclick="Count_Plus(4)">����</button>
										  <button type="button" onclick="Count_Minus(4)">����</button>
					</td>
					<td><font id="price_4">17,000</font><font>��</font></td>
					<td><button>x</button></td>
				</tr>
				<tr>
					<td><input type="radio" name="all" id="all" class="middle"><img src="black.jpg" style="width:60px; height:60px;"></td>
					<td>
						<span><font background-color="gray">�Ϲݹ��</font></span><br/>
						<span><font background-color="gray">���Ż� UCLA ��ġ ������ ������(T)</font></span><br/>
						<span><font background-color="gray">�׷��� / ONE SIZE</font></span><br/>
					</td>
					<td>
						<strong>����</strong>&nbsp;<span><input type="text" value="1" name="count_1" id="count_1" size="1px;" readonly></span>
									&nbsp;<button type="button" onclick="Count_Plus(1)">����</button>
										  <button type="button" onclick="Count_Minus(1)">����</button>
					</td>
					<td><font id="price_1">15,000</font><font>��</font></td>
					<td><button>x</button></td>
				</tr>.
				<tr>
					<td><hr style="border: solid 1px gray;"></td>
					<td><hr style="border: solid 1px gray;"></td>
					<td><hr style="border: solid 1px gray;"></td>
					<td><hr style="border: solid 1px gray;"></td>
					<td><hr style="border: solid 1px gray;"></td>
				</tr>
				<!--
				<tr>
					<td></td>
					<td><font>01. �ֹ��� ����</font></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>�̸�</th>
					<td><input type="text"></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>�ּ�</th>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				-->
			</table>
			
		</div>
		
		<div class="column2">
			<table class="table2">
			<tr>
				<th><font>�����ݾ�</font></th>
				<th></th>
				<th></th>
			</tr>
			<tr>
				<td><font size="2">�� ��ǰ�ݾ�</font></td>
				<td><strong><font color="pink" size="5" id="total">12,000</font></strong><strong><font color="pink" size="5">��</font></strong></td>
				<td></td>
			</tr>
			<tr>
				<td><font size="2">��ۺ�</font></td>
				<td><strong><font color="gray" size="2">0</font></strong><strong><font color="gray" size="2">��</font></strong></td>
				<td></td>
			</tr>
			<tr>
				<td><font size="2">���αݾ�</font></td>
				<td><strong><font color="gray" size="2">0</font></strong><strong><font color="gray" size="2">��</font></strong></td>
				<td></td>
			</tr>
			<tr>
				<td><button style="background-color:pink; height:40px;">��ǰ �ֹ��ϱ�</button></td>
				<td></td>
				<td></td>
			</tr>
			</table>
		</div>
		
	</div>
	
	
	
	
	<script>
		//���� �� ���� ����
			function Count_Plus(i) {
				//alert(i);
				var num   = document.getElementById("count_" + i).value;			//��ǰ�� ����
				var price = document.getElementById("price_" + i).innerText;		//��ǰ�� ����
				var total = document.getElementById("total").innerText;				//�� ��ǰ�� �ݾ�
				//alert(price);
				alert(total);
				
				price = Number(price.replace(",", ""));
				var pri = 23500;	// pri���� ��� ����Ǿ��ִ� ��ǰ�� ������ ���;��Ѵ�. ������ ���Ƿ� ��
				price = pri + price;
				
				var result = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');

				
				num = Number(num) + 1;
				if(num == 101) {
					alert("�ִ� ������ �ʰ��Ͽ����ϴ�.");
					return;
				}
				
				document.getElementById("count").value = num;
				document.getElementById("total").innerText = result;
			}
			
			//���� �� ���� ����
			function Count_Minus() {
				var num = document.getElementById("count").value;			//����
				var price = document.getElementById("total").innerText;		//����
				
				
				price = Number(price.replace(",", ""));				
				var pri = 23500;	// pri���� ��� ����Ǿ��ִ� ��ǰ�� ������ ���;��Ѵ�. ������ ���Ƿ� ��
				price = price - pri;
				
				var result = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');

				num = Number(num) - 1;
				if(num == 0) {
					return;
				}
				document.getElementById("count").value = num;
				document.getElementById("total").innerText = result;
			}
	</script>
</body>
</html>