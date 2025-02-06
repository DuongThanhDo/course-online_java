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
	<c:if test="${message != null}">
		<script>
			alert('<c:out value="${message}" />');
		</script>
	</c:if>
	<%@include file="../../teacher/components/header.jsp"%>

	<div class="container mt-4">
		<div
			style="display: flex; align-items: center; justify-content: space-between; margin-bottom: 18px;">
			<div style="display: flex; align-items: center;">
				<a class="btn" style="width: 60px;"
					href="${pageContext.request.contextPath}/teacher/course?detail=${Course.course_id}"><i
					class="fa-solid fa-arrow-left"></i></a>
				<h3>Danh sách sinh viên</h3>
			</div>
			<form
				action="${pageContext.request.contextPath}/teacher/course/student"
				method="post">
				<div class="input-group">
					<input style="max-width: 400px" type="text" class="form-control"
						name="searchValue" placeholder="Tìm kiếm" value="${searchValue }">
					<button type="submit" class="btn btn-primary">
						<i class="fa-solid fa-magnifying-glass"></i>
					</button>
				</div>
			</form>
		</div>
		<table class="table table-bordered table-hover align-middle">
			<thead class="table-active">
				<tr>
					<th>Tên Học Viên</th>
					<th>Số điện thoại</th>
					<th>Email</th>
					<th>Địa chỉ</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="rc" items="${RegisterCourses }">
				<tr>
				    <td>${rc.full_name != null && !rc.full_name.isEmpty() ? rc.full_name : 'N/A'}</td>
				    <td>${rc.phone != null && !rc.phone.isEmpty() ? rc.phone : 'N/A'}</td>
				    <td>${rc.email != null && !rc.email.isEmpty() ? rc.email : 'N/A'}</td>
				    <td>${rc.address != null && !rc.address.isEmpty() ? rc.address : 'N/A'}</td>
				</tr>
				</c:forEach>
				<c:if
					test="${RegisterCourses == null || RegisterCourses.isEmpty() }">
					<tr>
						<td colspan="4" class="text-center">Không tìm thấy dữ liệu</td>
					</tr>
				</c:if>
			</tbody>
		</table>
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
										href="${pageContext.request.contextPath}/teacher/course/student?page=${p}&search=${searchValue}">${p}</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</nav>
			</c:if>
		</div>
	</div>

</body>
</html>