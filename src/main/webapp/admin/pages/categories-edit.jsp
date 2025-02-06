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
					<c:choose>
						<c:when test="${c.category_id == 0}">
							<h2>Thêm thông tin danh mục</h2>
						</c:when>
						<c:otherwise>
							<h2>Sửa thông tin danh mục</h2>
						</c:otherwise>
					</c:choose>
				</div>
				<form action="${pageContext.request.contextPath}/admin/categories/save"
					method="post">
					<input type="hidden" name="category_id" class="form-control"
						value="${c.category_id}">
					<div class="mb-3">
						<label for="title" class="form-label">Tên danh mục</label> <input
							type="text" class="form-control" id="title" name="title"
							value="${c.title }">
					</div>
					<div class="mb-3">
						<label for="description" class="form-label">Mô tả</label> <input
							type="text" class="form-control" id="description"
							name="description" value="${c.description }">
					</div>
					<div>
						<c:choose>
							<c:when test="${c.category_id == 0}">
								<button type="submit" class="btn btn-primary" name="save"
									value="add">Lưu thông tin</button>
							</c:when>
							<c:otherwise>
								<button type="submit" class="btn btn-primary" name="save"
									value="update">Lưu thông tin</button>
							</c:otherwise>
						</c:choose>
						<a style="margin-left: 12px;" href="${pageContext.request.contextPath}/admin/categories"
							class="btn btn-outline-primary">Quay lại</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
