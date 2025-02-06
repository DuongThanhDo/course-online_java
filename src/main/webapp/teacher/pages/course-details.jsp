<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>DTD OCMS</title>
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
</head>
<body>
	<%@include file="../../teacher/components/header.jsp"%>

	<div class="container mt-4">
		<div
			style="display: flex; align-items: center; justify-content: space-between; margin: 20px 0;">
			<div style="display: flex; align-items: center;">
				<a class="btn" style="width: 60px;"
					href="${pageContext.request.contextPath}/teacher/course"><i
					class="fa-solid fa-arrow-left"></i></a>
				<h3>Chi tiết khóa học</h3>

			</div>
			<div>
				<c:if test="${Course.status != 0}">
					<a class="btn btn-outline-primary"
						href="${pageContext.request.contextPath}/teacher/course/student?course_id=${Course.course_id}">Danh
						sách sinh viên </a>
				</c:if>
				
				<c:if test="${CountLecture > 0 }">
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/teacher/course/content?course_id=${Course.course_id}"
						style="margin-left: 10px;">Nội dung khóa học</a>
				</c:if>
			</div>
		</div>
		<div>
			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">Tên khóa học:</label>
				<div class="col-sm-10">
					<p class="form-control">${Course.title}</p>
				</div>
			</div>

			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">Mô tả:</label>
				<div class="col-sm-10">
					<p class="form-control">${Course.description}</p>
				</div>
			</div>

			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">Danh mục:</label>
				<div class="col-sm-10">
					<p class="form-control">${Course.category}</p>

				</div>
			</div>

			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">Loại:</label>
				<div class="col-sm-10">
					<p class="form-control">${Course.type}</p>
				</div>
			</div>

			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">Giá:</label>
				<div class="col-sm-10">
					<p class="form-control">${Course.price}VNĐ</p>
				</div>
			</div>

			<div class="mb-3 row">
				<div class="col-sm-10 offset-sm-2"
					style="width: 180px; height: 180px;">
					<input id="inputPhoto" name="photo" type="hidden"
						value="${Course.photo}" /> <img id="Photo"
						src="${pageContext.request.contextPath}/${Course.photo != null ? Course.photo : 'assets/images/noImage.png' }"
						class="img img-bordered" style="width: 100%; height: 100%;" />
				</div>
			</div>
		</div>
	</div>

</body>
</html>
