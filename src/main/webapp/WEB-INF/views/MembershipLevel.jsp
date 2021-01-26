<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<script src="/resources/js/jquery-3.5.1.min.js"></script>
			<script src="/resources/js/MembershipLevel.js"></script>
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
				<c:forEach items="${list}" var="list" varStatus="status">
					<tr>
						<td id="td_${status.count}">${list.nickname}</td>
						<td>
							<select name="level" id="select_${status.count}">
								<c:choose>
									<c:when test="${list.membershipflag == a}">
										<option value="a" selected>A</option>
										<option value="b">B</option>
										<option value="c">C</option>
										<option value="d">D</option>
										<option value="f">F</option>
									</c:when>
									
									<c:when test="${list.membershipflag == b}">
										<option value="a">A</option>
										<option value="b" selected>B</option>
										<option value="c">C</option>
										<option value="d">D</option>
										<option value="f">F</option>
									</c:when>
									
									<c:when test="${list.membershipflag == c}">
										<option value="a">A</option>
										<option value="b">B</option>
										<option value="c" selected>C</option>
										<option value="d">D</option>
										<option value="f">F</option>
									</c:when>
									
									<c:when test="${list.membershipflag == d}">
										<option value="a">A</option>
										<option value="b">B</option>
										<option value="c">C</option>
										<option value="d" selected>D</option>
										<option value="f">F</option>
									</c:when>
									
									<c:otherwise>
										<option value="a">A</option>
										<option value="b">B</option>
										<option value="c">C</option>
										<option value="d">D</option>
										<option value="f" selected>F</option>
									</c:otherwise>
								</c:choose>
							</select>
						</td>
						<td>
							<button type="button" onclick="Msh(${status.count})">수정</button>
							<button type="button">정지</button>
							<button type="button">강퇴</button>
						</td>
					</tr>
				</c:forEach>
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
