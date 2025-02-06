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
		<c:choose>
			<c:when test="${Lecture.lecture_id == null }">
				<h3>Tạo mới bài giảng</h3>
			</c:when>
			<c:otherwise>
				<h3>Sửa thông tin bài giảng</h3>
			</c:otherwise>
		</c:choose>

		<form
			action="${pageContext.request.contextPath}/teacher/course/lecture/save"
			method="post" enctype="multipart/form-data" style="margin-top: 32px;">
			<input type="hidden" name="chapter_id" value="${Chapter.chapter_id}" />
			<input type="hidden" name="lecture_id" value="${Lecture.lecture_id}" />

			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">Tên bài giảng:</label>
				<div class="col-sm-10">
					<input name="title" value="${Lecture.title}" type="text"
						required="required" class="form-control" autofocus />
				</div>
			</div>

			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">Nội dung:</label>
				<div class="col-sm-10">
					<textarea name="content" class="form-control">${Lecture.content}</textarea>
				</div>
			</div>

			<div class="mb-3 row">
				<label class="col-sm-2 col-form-label">Video bài giảng:</label>
				<div class="col-sm-10">
					<input type="file" name="uploadVideo" accept="video/*"
						class="form-control" onchange="previewVideo(this)" />
				</div>
			</div>

			<div class="mb-3 row">
				<div class="col-sm-10 offset-sm-2" style="width: 400px;">
					<input id="inputVideo" name="video" type="hidden"
						value="${Lecture.video}" />
					<video id="Video" controls class="img img-bordered"
						style="width: 100%; ${Lecture.video != null ? 'display: block;' : 'display: none;'}">
						<source
							src="${pageContext.request.contextPath}/${Lecture.video != null ? Lecture.video : 'No video'}"
							type="video/mp4" />
					</video>

				</div>
			</div>
			<div class="mb-3 row">
				<div class="col-sm-10 offset-sm-2">
					<c:choose>
						<c:when test="${Lecture.lecture_id == null }">
							<button type="submit" class="btn btn-primary" name="save"
								value="create">Lưu dữ liệu</button>
						</c:when>
						<c:otherwise>
							<button type="submit" class="btn btn-primary" name="save"
								value="update">Lưu dữ liệu</button>
						</c:otherwise>
					</c:choose>
					<a href="${pageContext.request.contextPath}/teacher/course?update=${Chapter.course_id}"
						class="btn btn-secondary"> Quay lại </a>
				</div>
			</div>
		</form>

	</div>

	<script>
		function previewVideo(input) {
			const video = document.getElementById('Video');
			const file = input.files[0];

			if (file) {
				const objectURL = URL.createObjectURL(file);
				video.style.display = 'block';
				video.src = objectURL;
			}
		}
	</script>

</body>
</html>
