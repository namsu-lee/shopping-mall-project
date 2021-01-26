<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport"
			content="width=device-width, initial-scale=1">
			<style>
				* {
				box-sizing: border-box;
				}

				#myInput {
				background-image: url('/css/searchicon.png');
				background-position: 10px 10px;
				background-repeat: no-repeat;
				width: 100%;
				font-size: 16px;
				padding: 12px 20px 12px 40px;
				border: 1px solid #ddd;
				margin-bottom: 12px;
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
			</style>
	</head>
	<body>

		<h2>Membership Level</h2>
		<!-- onkeyup="myFunction()" -->
		<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
			<table id="myTable">
				<tr class="header">
					<th style="width:20%;">Nick</th>
					<th style="width:50%;">Level</th>
					<th style="width:30%;">*</th>
				</tr>
				<tr>
					<td>Alfreds Futterkiste</td>
					<td>
						<select name="level">
							<option value="a" selected>A</option>
							<option value="b">B</option>
							<option value="c">C</option>
							<option value="d">D</option>
							<option value="f">F</option>
						</select>
					</td>
					<td>
						<button>수정</button>
						<button>정지</button>
						<button>강퇴</button>
					</td>
				</tr>
				<tr>
					<td>Berglunds snabbkop</td>
					<td>
						<select name="level">
							<option value="a">A</option>
							<option value="b">B</option>
							<option value="c" selected>C</option>
							<option value="d">D</option>
							<option value="f">F</option>
						</select>
					</td>
					<td>
						<button>수정</button>
						<button>정지</button>
						<button>강퇴</button>
					</td>
				</tr>
				<tr>
					<td>Island Trading</td>
					<td>
						<select name="level">
							<option value="a">A</option>
							<option value="b">B</option>
							<option value="c">C</option>
							<option value="d" selected>D</option>
							<option value="f">F</option>
						</select>
					</td>
					<td>
						<button>수정</button>
						<button>정지</button>
						<button>강퇴</button>
					</td>
				</tr>
				<tr>
					<td>Koniglich Essen</td>
					<td>
						<select name="level">
							<option value="a">A</option>
							<option value="b">B</option>
							<option value="c">C</option>
							<option value="d">D</option>
							<option value="f" selected>F</option>
						</select>
					</td>
					<td>
						<button>수정</button>
						<button>정지</button>
						<button>강퇴</button>
					</td>
				</tr>
				<tr>
					<td>Laughing Bacchus Winecellars</td>
					<td>
						<select name="level">
							<option value="a">A</option>
							<option value="b">B</option>
							<option value="c" selected>C</option>
							<option value="d">D</option>
							<option value="f">F</option>
						</select>
					</td>
					<td>
						<button>수정</button>
						<button>정지</button>
						<button>강퇴</button>
					</td>
				</tr>
				<tr>
					<td>Magazzini Alimentari Riuniti</td>
					<td>
						<select name="level">
							<option value="a" selected>A</option>
							<option value="b">B</option>
							<option value="c">C</option>
							<option value="d">D</option>
							<option value="f">F</option>
						</select>
					</td>
					<td>
						<button>수정</button>
						<button>정지</button>
						<button>강퇴</button>
					</td>
				</tr>
				<tr>
					<td>North/South</td>
					<td>
						<select name="level">
							<option value="a">A</option>
							<option value="b">B</option>
							<option value="c">C</option>
							<option value="d">D</option>
							<option value="f" selected>F</option>
						</select>
					</td>
					<td>
						<button>수정</button>
						<button>정지</button>
						<button>강퇴</button>
					</td>
				</tr>
				<tr>
					<td>Paris specialites</td>
					<td>
						<select name="level">
							<option value="a" selected>A</option>
							<option value="b">B</option>
							<option value="c">C</option>
							<option value="d">D</option>
							<option value="e">F</option>
						</select>
					</td>
					<td>
						<button>수정</button>
						<button>정지</button>
						<button>강퇴</button>
					</td>
				</tr>
			</table>
			<button type="button" onclick="#">뒤로가기</button>
	</body>
	<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
</html>
