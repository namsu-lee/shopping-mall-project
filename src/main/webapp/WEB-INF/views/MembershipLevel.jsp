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
								<option value="a" <c:if test="${list.membershipflag eq 'a'}"> selected</c:if>>A</option>
								<option value="b" <c:if test="${list.membershipflag eq 'b'}"> selected</c:if>>B</option>
								<option value="c" <c:if test="${list.membershipflag eq 'c'}"> selected</c:if>>C</option>
								<option value="d" <c:if test="${list.membershipflag eq 'd'}"> selected</c:if>>D</option>
								<option value="f" <c:if test="${list.membershipflag eq 'f'}"> selected</c:if>>F</option>
							</select>
							<button type="button" onclick="Msh(${status.count})">수정</button>
						</td>
						<td>
							<c:choose>
								<c:when test="${list.stopflag eq 'g'}">
									<button type="button" id="stop_${status.count}" onclick="Stop(${status.count})">정지</button>
								</c:when>
								<c:otherwise>
									<button type="button" id="stop_cancel_${status.count}" onclick="Stop_Cancel(${status.count})">정지 취소</button>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>
			<button type="button" onclick="#">뒤로가기</button>
	</body>
	<script>
function myFunction() {
	
	var input, filter, table, tr, td, i, txtValue;
	
	input  = document.getElementById("myInput");
	filter = input.value.toUpperCase();
	table  = document.getElementById("myTable");
	tr     = table.getElementsByTagName("tr");
	
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[0];
    	if (td) {
			
    		txtValue = td.textContent || td.innerText;
			
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			}
			else {
				tr[i].style.display = "none";
			}
		}       
	}
}
</script>
</html>
