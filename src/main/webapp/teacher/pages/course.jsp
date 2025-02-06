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

<style type="text/css">
.course-item {
	transition: all 0.3s ease;
}

.course-item:hover {
	border-color: #2563EC;
	transform: scale(1.02);
	animation-delay: 250ms;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}
</style>
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	function setCourseId(element) {
		const courseId = element.getAttribute("data-course-id");
		document.querySelector(".content-modal").innerHTML = "Bạn có chắc sẽ xóa khóa học có id là <strong>"
				+ courseId + "</strong> ?";
		document.getElementById("deleteConfirm").href = "${pageContext.request.contextPath}/teacher/course/delete?course_id="
				+ courseId;
	}
</script>
</head>
<body>
	<c:if test="${message != null}">
		<script>
			alert('<c:out value="${message}" />');
		</script>
	</c:if>
	<%@include file="../../teacher/components/header.jsp"%>

	<div class="container mt-4">
		<div
			style="display: flex; align-items: center; gap: 30px; margin: 24px 0;">
			<h2>Quản lý khóa học</h2>

			<form action="${pageContext.request.contextPath}/teacher/course"
				method="post" style="flex-grow: 1">
				<div
					style="display: flex; align-items: center; justify-content: end; gap: 40px">
					<div>
						<input style="max-width: 400px" type="text" class="form-control"
							name="searchValue" value="${searchValue }" placeholder="Tìm kiếm">
					</div>
					<div>
						<select class="form-select" name="category">
							<option value="">--Danh mục--</option>
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
					</div>
					<div>
						<select class="form-select" name="type">
							<option value="">--Loại--</option>
							<c:forEach var="ty" items="${Types }">
								<c:choose>
									<c:when test="${typeValue != null && typeValue == ty.type_id }">
										<option value="${ty.type_id }" selected>${ty.type_name }</option>
									</c:when>
									<c:otherwise>
										<option value="${ty.type_id }">${ty.type_name }</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div>
						<select class="form-select" name="status">
							<option value="">-- Trạng thái --</option>
							<option value="0" ${(statusValue == 0) ? "selected" : ""}>Khởi
								tạo</option>
							<option value="1" ${(statusValue == 1) ? "selected" : ""}>Đã
								đăng</option>
							<option value="2" ${(statusValue == 2) ? "selected" : ""}>Cập
								nhật</option>
							<option value="-1" ${(statusValue == -1) ? "selected" : ""}>Bị
								khóa</option>
						</select>
					</div>
					<button type="submit" class="btn btn-primary form-control"
						style="width: 100px">Tìm kiếm</button>
				</div>
			</form>
			<a
				href="${pageContext.request.contextPath}/teacher/course?create=true"
				class="btn btn-success" style="width: 100px">+ Tạo</a>
		</div>

		<div class="row">
			<c:if test="${Courses == null || Courses.isEmpty()}">
				<div
					style="width: 100%; height: 400px; display: flex; align-items: center; justify-content: center;">
					<p style="font-size: 32px;">Không có khóa học nào</p>
				</div>
			</c:if>
			<c:forEach var="c" items="${Courses }">
				<div class="col-sm-4">
					<div class="card shadow-sm course-item mb-4">
						<div class="card-header bg-white"
							style="display: flex; align-items: start; justify-content: space-between; min-height: 76px;">
							<h4>
								<span style="color: ${(c.status == 1) ? " #12DD19" : (c.status==
									2) ? "orange" : (c.status==-1)?"red" : "blue"}; font-size: 18px;">
									<i class="fa-solid fa-square-check"></i>
								</span>
								${c.title}
							</h4>

							<div
								style="display: flex; align-items: center; justify-content: space-between;">
								<c:if test="${c.status != 1 && c.status != -1 }">
									<a
										href="${pageContext.request.contextPath}/teacher/course?post=${c.course_id}"
										class="btn btn-outline-success">Đăng</a>
								</c:if>
								<div class="dropdown dropstart" style="margin-left: 16px;">
									<a class="btn" href="#" id="dropdownMenuLink"
										data-bs-toggle="dropdown" aria-expanded="false"><i
										class="fa-solid fa-ellipsis-vertical"></i> </a>

									<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
										<li><a class="dropdown-item" style="color: grey"
											href="${pageContext.request.contextPath}/teacher/course?detail=${c.course_id}"><i
												style="margin-bottom: 4px;" class="fa-regular fa-eye"></i>
												Xem chi tiết </a></li>
										<c:if test="${c.status != -1 }">
											<li><a style="color: blue" class="dropdown-item"
												href="${pageContext.request.contextPath}/teacher/course?update=${c.course_id}"><i
													style="margin-bottom: 4px;"
													class="fa-regular fa-pen-to-square"></i> Sửa khóa học</a></li>
										</c:if>
										<c:if test="${c.status == 0 }">
											<li><a class="dropdown-item" style="color: red" href="#"
												data-bs-toggle="modal" data-bs-target="#courseModal"
												data-course-id="${c.course_id }" onclick="setCourseId(this)">
													<i style="margin-bottom: 4px;"
													class="fa-regular fa-trash-can"></i> Xóa khóa học
											</a></li>
										</c:if>
									</ul>
								</div>
							</div>
						</div>
						<div class="card-body">
							<div class="row">
								<div class="col-sm-4"
									style="width: 120px; height: 110px; overflow: hidden; border-radius: 4px;">
									<img
										style="width: 100%; height: 100%; object-fit: cover; object-position: center;"
										alt="image"
										src="${pageContext.request.contextPath}/${c.photo != null ? c.photo : 'assets/images/noImage.png' }">
								</div>
								<div class="col-sm-8">
									<ul class="list-group list-group-flush">
										<li class="list-group-item"><i class="fa-solid fa-tags"></i>
											${c.category }</li>
										<li class="list-group-item"><i
											class="fa-solid fa-bookmark"></i> ${c.type }</li>
										<li class="list-group-item"><i
											class="fa-solid fa-money-bill-wave"></i> <span
											style="font-weight: 500;">${c.price}</span> VNĐ</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

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
									href="${pageContext.request.contextPath}/teacher/course?page=${p}&searchValue=${searchValue}">${p}</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</nav>
		</c:if>
	</div>
	<!-- Modal cho delete course -->
	<div class="modal fade" id="courseModal" tabindex="-1"
		aria-labelledby="courseModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="courseModalLabel">Xác nhận xóa
						khóa học</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body content-modal"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Hủy</button>
					<a id="deleteConfirm" href="loginController"
						class="btn btn-primary">Xác nhận</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
