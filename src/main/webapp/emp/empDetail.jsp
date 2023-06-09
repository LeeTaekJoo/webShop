<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원상세보기</title>
<%-- ${}: getAttribute() 
	${emp} <%=request.getAttribute("emp") %>
	${emp.employee_id}		<%=request.getAttribute("emp") %>
--%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
#container {
	width: 50%;
	margin: 0 auto;
}
input[name='email'],
input[name='department_id'],
input[name='job_id'],
input[name='salary'],
input[name='hire_date'],
input[name='manager_id']{
	background-color: pink;
}
</style>


</head>
<body>
	<div id="container">
		<h1>직원상세보기</h1>
		<%@include file="../common/Header.jsp" %>
		<!-- http://localhost:9999/ -->
		<form method="post"
			action="<%=request.getContextPath()%>/emp/empDetail.do" class="mb-3">
			<table>
				<tr class="form-floating">
					<td><label for="employee_id">직원번호</label></td>
					<td><input class="form-control" type="number"
						name="employee_id" id="employee_id" value="${emp.employee_id}"></td>
				</tr>
				<tr>
					<td>firstName</td>
					<td><input type="text" name="first_name"
						value="${emp.first_name}" maxlength="20"></td>
				</tr>
				<tr>
					<td>LastName</td>
					<td><input type="text" name="last_name"
						value="${emp.last_name}" required="required"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="${emp.email}"
						required="required"></td>
				</tr>
				<tr>
					<td>phone</td>
					<td><input type="tel" name="phone_number"
						value="${emp.phone_number}"></td>
				</tr>
				<tr>
					<td>salary</td>
					<td><input type="number" name="salary" value="${emp.salary}"></td>
				</tr>
				<tr>
					<td>부서</td>
					<td><input type="number" name="department_id"
						value="${emp.department_id}"></td>
				</tr>
				<tr>
					<td>메니져</td>
					<td><input type="number" name="manager_id"
						value="${emp.manager_id}"></td>
				</tr>
				<tr>
					<td>커미션</td>
					<td><input type="text" name="commission_pct"
						value="${emp.commission_pct}"></td>
				</tr>
				<tr>
					<td>입사일</td>
					<td><input type="date" name="hire_date"
						value="${emp.hire_date}" required="required"></td>
				</tr>
				<tr>
					<td>직급</td>
					<td><input type="text" name="job_id" required="required"
						value="${emp.job_id}"></td>
				</tr>
				<tr style="text-align: center;">
					<td colspan="2"><input type="submit" value="직원정보수정"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
