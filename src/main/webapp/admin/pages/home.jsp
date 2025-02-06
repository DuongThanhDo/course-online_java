<%@page import="com.google.gson.Gson"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>DTD OCMS ADMIN</title>
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
	<div style="display: flex;">
		<%@include file="../../admin/components/sidebar.jsp"%>

		<div style="flex-grow: 1">
			<%@include file="../../admin/components/header.jsp"%>
			<div class="p-4">
				<h2 class="mb-2">Tổng quan</h2>
				<div class="row mb-4">
					<div class="col-md-3">
						<div class="stat-card">
							<h3>Người dùng</h3>
							<p>
								<i class="fas fa-users"></i> ${countUser }
							</p>
						</div>
					</div>
					<div class="col-md-3">
						<div class="stat-card">
							<h3>Khóa học</h3>
							<p>
								<i class="fas fa-book"></i> ${countCourse }
							</p>
						</div>
					</div>
					<div class="col-md-3">
						<div class="stat-card">
							<h3>Danh mục</h3>
							<p>
								<i class="fas fa-th-list"></i> ${countCategory }
							</p>
						</div>
					</div>
					<div class="col-md-3">
						<div class="stat-card">
							<h3>Loại khóa học</h3>
							<p>
								<i class="fas fa-book-open"></i> ${countType }
							</p>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="dashboard-card">
							<h5>Thêm danh mục mới</h5>
							<p>Tạo sự đa dạng khóa học cho giảng viên.</p>
							<a href="${pageContext.request.contextPath}/admin/categories?add=true" class="btn btn-outline-success">Thêm
								danh mục</a>
						</div>
					</div>

					<div class="col-md-6">
						<div class="dashboard-card">
							<h5>Thêm loại mới</h5>
							<p>Giúp giảng viên có nhiều phương pháp dạy hơn.</p>
							<a href="${pageContext.request.contextPath}/admin/types?add=true" class="btn btn-outline-success">Thêm loại</a>
						</div>
					</div>
				</div>

				<div style="margin: 12px 0 12px 0;">
					<div style="display: flex; justify-content: space-between; align-items: center;">
                    <h5>Người dùng mới</h5>

                    <a href="${pageContext.request.contextPath}/admin/accounts" class="btn btn-link" style="color: gray;">Xem người dùng</a>
                </div>
					<table class="table table-bordered table-hover align-middle">
						<thead class="table-active">
							<tr>
								<th>ID</th>
								<th>Username</th>
								<th>Họ và Tên</th>
								<th>Email</th>
								<th>Số điện thoại</th>
								<th>Địa chỉ</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${NewUsers == null || NewUsers.isEmpty()}">
								<tr>
									<td colspan="6" class="text-center">Không có dữ liệu</td>
								</tr>
							</c:if>
							<c:forEach var="user" items="${NewUsers}">
								<tr>
									<td>${user.user_id}</td>
									<td>${user.username}</td>
									<td>${user.full_name}</td>
									<td>${user.email}</td>
									<td>${user.phone}</td>
									<td>${user.address}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
