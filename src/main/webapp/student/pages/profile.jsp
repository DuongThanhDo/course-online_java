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
	<%@include file="../../student/components/header.jsp"%>

	<div class="container mt-4" style="margin-bottom: 24px">
		<form action="${pageContext.request.contextPath}/student/profile/save" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-sm-3 d-flex flex-column align-items-center">
					<h4>Ảnh đại diện</h4>
					<div
						style="width: 200px; height: 200px; border-radius: 999px; overflow: hidden; border: 1px dashed blue; margin-bottom: 20px">

						<input id="inputPhoto" name="profile_picture_url" type="hidden"
							value="${profile.profile_picture_url}" /> 
						<c:choose>
							<c:when test="${empty profile.profile_picture_url}">
								<img id="Photo" alt="------- No avatar ------"
									src="${pageContext.request.contextPath}/assets/images/noImage.png"
									class="img img-bordered"
									style="width: 100%; height: 100%; object-fit: cover; object-fit: center" />
							</c:when>
							<c:otherwise>
								<img id="Photo" alt="------- No avatar ------"
									src="${pageContext.request.contextPath}/${profile.profile_picture_url}"
									class="img img-bordered"
									style="width: 100%; height: 100%; object-fit: cover; object-fit: center" />
							</c:otherwise>
						</c:choose>
					</div>
					<c:if test="${edit}">
						<div class="input-group mb-3">
							<input type="file" name="uploadPhoto" accept="image/*" class="input-group-text" value="${profile.profile_picture_url }"
								onchange="document.getElementById('Photo').src = window.URL.createObjectURL(this.files[0])" />
						</div>
					</c:if>
				</div>

				<div class="col-sm-9">
					<h4 class="mb-3">Thông tin cá nhân</h4>
					<input type="hidden" name="profile_id"
						value="${profile.profile_id }" /> <input type="hidden"
						name="user_id" value="${profile.user_id }" />
					<div class=" d-flex flex-column align-items-end gap-2">
						<div class="input-group mb-3">
							<span class="input-group-text">Họ tên</span> <input type="text"
								required="required" class="form-control" name="full_name"
								value="${profile.full_name }" ${edit ? "" : "disabled"} />
						</div>

						<div class="input-group mb-3">
							<span class="input-group-text">Email</span> <input type="email"
								required="required" class="form-control" name="email"
								value="${profile.email }" ${edit ? "" : "disabled"} />
						</div>

						<div class="input-group mb-3">
							<span class="input-group-text">Số điện thoại</span> <input
								type="number" class="form-control" name="phone"
								value="${profile.phone }" ${edit ? "" : "disabled"} />
						</div>

						<div class="input-group mb-3">
							<span class="input-group-text">Ngày sinh</span> <input
								type="date" class="form-control" name="date_of_birth"
								value="${profile.date_of_birth }"
								${edit ? "" : "disabled"} />
						</div>

						<div class="input-group mb-3">
							<span class="input-group-text">Địa chỉ</span> <input type="text"
								class="form-control" value="${profile.address }" name="address"
								${edit ? "" : "disabled"} />
						</div>

						<div class="input-group mb-4" style="align-content: end">
							<span class="input-group-text">Bio</span>
							<textarea class="form-control" style="height: 200px;" name="bio"
								${edit ? "" : "disabled"}>${profile.bio }</textarea>
						</div>

						<c:choose>
							<c:when test="${!edit}">
								<a
									href="${pageContext.request.contextPath}/student/profile?action=EDIT"
									class="btn btn-primary">Chỉnh sửa</a>
							</c:when>
							<c:otherwise>
								<div class="d-flex align-items-center gap-4">
									<button type="submit" class="btn btn-success">Lưu thay đổi</button>
									<a
										href="${pageContext.request.contextPath}/student/profile?action=CANCEL"
										class="btn btn-danger">Hủy</a>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
