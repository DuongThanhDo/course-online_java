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
</head>
<body>
	<div style="display: flex;">
		<%@include file="../../admin/components/sidebar.jsp"%>
		<div style="flex-grow: 1">
			<%@include file="../../admin/components/header.jsp"%>
			<div class="px-4 pt-3">
				<div
					style="display: flex; align-items: center; justify-content: space-between; margin-bottom: 18px;">
					<h2>Quản lý người dùng</h2>
					<form action="${pageContext.request.contextPath}/admin/accounts"
						method="post">
						<div
							style="display: flex; align-items: center; justify-content: space-between; gap: 12px;">
							<input style="max-width: 400px" type="text" class="form-control"
								name="searchValue" value="${searchValue }"
								placeholder="Tìm kiếm"> <select class="form-select"
								name="role">
								<option value="">--Vai trò--</option>
								<option value="1">Giáo viên</option>
								<option value="2">Sinh viên</option>
							</select> <select class="form-select" name="locked">
								<option value="">--Trạng thái--</option>
								<option value="1">Đang khóa</option>
								<option value="0">Đang mở</option>
							</select>
							<button type="submit" class="btn btn-primary"
								style="min-width: 120px;">
								<i class="fa-solid fa-magnifying-glass"></i> Tìm kiếm
							</button>
						</div>
					</form>
				</div>
				<table class="table table-bordered table-hover align-middle">
					<thead class="table-active">
						<tr>
							<th style="width: 60px;">Mã</th>
							<th>Tên đăng nhập</th>
							<th>Họ tên</th>
							<th>Email</th>
							<th>Số điện thoại</th>
							<th>Địa chỉ</th>
							<th>Vai trò</th>
							<th>Trạng thái</th>
							<th class="text-center" style="width: 120px;">Hành động</th>
						</tr>
					</thead>
					<tbody id="accountTable">
						<c:if test="${Accounts == null || Accounts.isEmpty()}">
							<tr>
								<td colspan="9" class="text-center">Không có dữ liệu</td>
							</tr>
						</c:if>
						<c:forEach var="a" items="${Accounts }">
							<tr>
								<td>${a.user_id }</td>
								<td>${a.username }</td>
								<td>${a.full_name }</td>
								<td>${a.email }</td>
								<td>${a.phone }</td>
								<td>${a.address }</td>
								<td><c:choose>
										<c:when test="${a.role == 1}">
											<p>Giáo viên</p>
										</c:when>
										<c:otherwise>
											<p>Sinh viên</p>
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${a.locked == true}">
											<p style="color: red">Đang khóa</p>
										</c:when>
										<c:otherwise>
											<p style="color: green">Đang mở</p>
										</c:otherwise>
									</c:choose></td>
								<td class="text-center"><c:choose>
										<c:when test="${a.locked == true}">
											<a class="btn btn-success"
												href="${pageContext.request.contextPath}/admin/accounts?unlock=${a.user_id}"
												onclick="return confirm('Xác nhận mở khóa người dùng có mã là ${a.user_id}')">
												Mở
											</a>
										</c:when>
										<c:otherwise>
											<a class="btn btn-danger"
												href="${pageContext.request.contextPath}/admin/accounts?lock=${a.user_id}"
												onclick="return confirm('Xác nhận khóa người dùng có mã là ${a.user_id}')">
												Khóa
											</a>
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<c:if test="${pageCount > 1}">
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<c:forEach var="p" begin="1" end="${pageCount}">
								<c:choose>
									<c:when test="${p == currentPage}">
										<li class="page-item active"><a class="page-link"
											href="#">${p}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="${pageContext.request.contextPath}/admin/accounts?page=${p}&searchValue=${searchValue}">${p}</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</nav>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
