<%@page import="com.google.gson.Gson"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>DTD OCMS TEACHER</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha384-k6RqeWeci5ZR/Lv4MR0sA0FfDOMqL9w1e3Z24G4M5rQQX9zZc4QR1XkqM8FNh9"
	crossorigin="anonymous">

<!-- fontawesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- Chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<style>
.dashboard-card {
	background-color: #fff;
	border-radius: 10px;
	padding: 20px;
	margin: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.stat-card {
	text-align: center;
	padding: 20px;
	border: 1px solid #ddd;
	border-radius: 8px;
	background-color: #f9f9f9;
}

.chart-container {
	position: relative;
	height: 50vh;
	width: 100%;
	margin: auto;
}
</style>
</head>
<body>
	<%@include file="../../teacher/components/header.jsp"%>

	<div class="container mt-4">
		<div class="row mb-4">
			<div class="col-md-6">
				<div class="stat-card">
					<h3>Khóa học</h3>
					<p>
						<i class="fas fa-book"></i> ${countCourse }
					</p>
				</div>
			</div>
			<div class="col-md-6">
				<div class="stat-card">
					<h3>Học viên mới</h3>
					<p>
						<i class="fas fa-book-open"></i> ${countStudentNew }
					</p>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="dashboard-card">
					<h5>Thêm khóa học</h5>
					<p>Tạo khóa học nâng cao trình độ học viên.</p>
					<a
						href="${pageContext.request.contextPath}/teacher/course?create=true"
						class="btn btn-outline-success">Thêm khóa học</a>
				</div>
			</div>

			<div class="col-md-6">
				<div class="dashboard-card">
					<h5>Chấp nhận sinh viên</h5>
					<p>Cho phép sinh viên vào lớp nhằm nâng cao trình độ.</p>
					<a
						href="${pageContext.request.contextPath}/teacher/manager-student"
						class="btn btn-outline-success">Tới danh sách</a>
				</div>
			</div>
		</div>

		<div style="margin: 20px 0 12px 0;">
			<div
				style="display: flex; justify-content: space-between; align-items: center;">
				<h5>Học viên đăng ký</h5>

				<a href="${pageContext.request.contextPath}/teacher/manager-student"
					class="btn btn-link" style="color: gray;">Xem danh sách</a>
			</div>
			<table class="table table-bordered table-hover align-middle">
				<thead class="table-active">
					<tr>
						<th>Tên Học Viên</th>
						<th>Khóa Học Muốn Tham Gia</th>
						<th>Ngày Gửi Yêu Cầu</th>
					</tr>
				</thead>
				<tbody>
					<c:if
						test="${NewStudentRegister == null || NewStudentRegister.isEmpty()}">
						<tr>
							<td colspan="3" class="text-center">Không có sinh viên đăng ký</td>
						</tr>
					</c:if>
					<c:forEach var="student" items="${NewStudentRegister}">
						<tr>
							<td>${student.full_name != null && !student.full_name.isEmpty() ? student.full_name : 'N/A'}</td>
							<td>${student.title }</td>
							<td class="text-center">${student.created_at }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
