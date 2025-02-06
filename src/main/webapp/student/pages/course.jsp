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

<style>
.card-hover div img {
	transition: all 0.3s ease;
}

.card-hover:hover {
	box-shadow: 0 5px 10px #ccc;
	transition: all 0.3s ease;
}

.card-hover:hover div img {
	transform: scale(1.1);
}
</style>
</head>
<body>
	<%@include file="../../student/components/header.jsp"%>

	<div class="container" style="margin-top: 40px">
		<div
			style="display: flex; align-items: center; justify-content: space-between; margin-bottom: 40px;">
			<h2>Khóa học</h2>

			<form action="${pageContext.request.contextPath}/student/course"
				method="post">
				<div class="input-group">
					<input style="width: 500px" type="text" class="form-control"
						name="searchValue" placeholder="Tìm kiếm">
					<button type="submit" class="btn btn-primary">
						<i class="fa-solid fa-magnifying-glass"></i>
					</button>
				</div>
			</form>

			<form action="${pageContext.request.contextPath}/student/course"
				method="post" id="filterForm">
				<select name="categoryValue" class="form-select"
					onchange="document.getElementById('filterForm').submit();">
					<option value="">-- Danh mục --</option>
					<c:forEach var="ca" items="${Categories }">
						<c:choose>
							<c:when
								test="${categoryValue != null && categoryValue == ca.category_id }">
								<option value="${ca.category_id }" selected>${ca.title }</option>
							</c:when>
							<c:otherwise>
								<option value="${ca.category_id }">${ca.title }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</form>
		</div>

		<div class="row" style="min-height: 342px;">
			<c:if test="${Courses == null || Courses.isEmpty()}">
				<div
					style="width: 100%; height: 400px; display: flex; align-items: center; justify-content: center;">
					<p style="font-size: 32px;">Không có khóa học nào</p>
				</div>
			</c:if>
			<c:forEach var="c" items="${Courses }">
				<div class="col-md-3" style="margin-bottom: 28px;">
					<div class="card card-hover">
						<div style="width: 100%; height: 200px; overflow: hidden;">
							<img style="width: 100%; height: 100%; object-fit: cover"
								src="${pageContext.request.contextPath}/${c.photo != null ? c.photo : 'assets/images/noImage.png' }"
								class="card-img-top" alt="Course A">
						</div>
						<div class="card-body">
							<h5 class="card-title">${c.title }</h5>
							<p class="card-text">${c.description }</p>
							<a
								href="${pageContext.request.contextPath}/student/course?detail=${c.course_id }"
								class="btn btn-primary">Xem chi tiết</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<div
			style="display: flex; flex-direction: column; align-items: center;">
			<c:if test="${pageCount > 1}">
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<c:forEach var="p" begin="1" end="${pageCount}">
							<c:choose>
								<c:when test="${p == currentPage}">
									<li class="page-item active"><a class="page-link" href="#">${p}</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath}/student/course?page=${p}&search=${searchValue}">${p}</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</nav>
			</c:if>
		</div>
	</div>

	<%@include file="../../student/components/footer.jsp"%>
</body>
</html>
