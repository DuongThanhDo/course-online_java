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
.custom-accordion-button {
	background-color: transparent;
}

.custom-accordion-button:not(.collapsed) {
	background-color: white;
}
</style>

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
		<div class="row" style="height: 86vh;">
			<div class="col-sm-7" style="padding-right: 20px">

				<c:choose>
					<c:when test="${Course.course_id == null }">
						<h3>Tạo mới khoá học</h3>
					</c:when>
					<c:otherwise>
						<h3>Sửa thông tin khoá học</h3>
					</c:otherwise>
				</c:choose>


				<form
					action="${pageContext.request.contextPath}/teacher/course/save"
					method="post" enctype="multipart/form-data">
					<input type="hidden" name="course_id" value="${Course.course_id}" />

					<div class="mb-3 row">
						<label class="col-sm-2 col-form-label">Tên khóa học:</label>
						<div class="col-sm-10">
							<input name="title" value="${Course.title}" type="text"
								required="required" class="form-control"  />
						</div>
					</div>

					<div class="mb-3 row">
						<label class="col-sm-2 col-form-label">Mô tả:</label>
						<div class="col-sm-10">
							<textarea name="description" type="text" class="form-control">${Course.description}</textarea>
						</div>
					</div>

					<div class="mb-3 row">
						<label class="col-sm-2 col-form-label">Danh mục:</label>
						<div class="col-sm-10">
							<select class="form-select" name="category_id"
								required="required">
								<option value="">-- Chọn danh mục --</option>
								<c:forEach var="ca" items="${Categories }">
									<c:choose>
										<c:when test="${Course.category_id == ca.category_id }">
											<option value="${ca.category_id }" selected>${ca.title }</option>
										</c:when>
										<c:otherwise>
											<option value="${ca.category_id }">${ca.title }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>

						</div>
					</div>

					<div class="mb-3 row">
						<label class="col-sm-2 col-form-label">Loại:</label>
						<div class="col-sm-10">
							<select class="form-select" name="type_id" required="required">
								<option value="">-- Chọn loại --</option>
								<c:forEach var="ty" items="${Types }">
									<c:choose>
										<c:when test="${Course.type_id == ty.type_id }">
											<option value="${ty.type_id }" selected>${ty.type_name }</option>
										</c:when>
										<c:otherwise>
											<option value="${ty.type_id }">${ty.type_name }</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="mb-3 row">
						<label class="col-sm-2 col-form-label">Giá:</label>
						<div class="col-sm-10">
							<input name="price" value="${Course.price}" type="number"
								required="required" class="form-control" />
						</div>
					</div>

					<div class="mb-3 row">
						<label class="col-sm-2 col-form-label">Ảnh minh họa:</label>
						<div class="col-sm-10">
							<input type="file" name="uploadPhoto" accept="image/*"
								class="form-control" value="${Course.photo }"
								onchange="document.getElementById('Photo').src = window.URL.createObjectURL(this.files[0])" />

						</div>
					</div>

					<div class="mb-3 row">
						<div class="col-sm-10 offset-sm-2" style="width: 200px;">
							<input id="inputPhoto" name="photo" type="hidden"
								value="${Course.photo}" /> <img id="Photo"
								src="${pageContext.request.contextPath}/${Course.photo != null ? Course.photo : 'assets/images/noImage.png' }"
								class="img img-bordered" style="width: 100%;" />
						</div>
					</div>

					<div class="mb-3 row">
						<div class="col-sm-10 offset-sm-2">
							<c:choose>
								<c:when test="${Course.course_id == null }">
									<button type="submit" class="btn btn-primary" name="save"
										value="create">Lưu dữ liệu</button>
								</c:when>
								<c:otherwise>
									<button type="submit" class="btn btn-primary" name="save"
										value="update">Lưu dữ liệu</button>
								</c:otherwise>
							</c:choose>
							<a href="${pageContext.request.contextPath}/teacher/course"
								class="btn btn-secondary"> Quay lại </a>
						</div>
					</div>
				</form>
			</div>
			<c:if test="${Course.course_id != null}">
				<div class="col-sm-5" style="">
					<h5 style="margin-top: 12px">Danh sách chương</h5>
					<div class="accordion accordion-flush chapters"
						id="accordionPanelsStayOpenExample">
						<a
							style="width: 100%; display: flex; justify-content: center; padding: 12px 0;"
							class="dropdown-item" href="#" data-bs-toggle="modal"
							data-bs-target="#createChapterModal"> + Thêm chương mới </a>
						<c:forEach var="chap" items="${Chapters }" varStatus="statusChap">
							<div class="accordion-item">
								<h2 class="accordion-header"
									id="panelsStayOpen-heading${chap.chapter_id }"
									style="display: flex;">
									<button
										style=""
										class="accordion-button collapsed custom-accordion-button"
										type="button" data-bs-toggle="collapse"
										data-bs-target="#panelsStayOpen-collapse${chap.chapter_id }"
										aria-expanded="false"
										aria-controls="panelsStayOpen-collapse${chap.chapter_id }">${statusChap.index + 1}<span>. ${chap.title }</span>
									</button>

									<div
										style="display: flex; align-items: center; gap: 20px; font-size: 18px">
										<a class="dropdown-item" style="color: blue" href="#"
											data-bs-toggle="modal"
											data-bs-target="#editChapterModal${chap.chapter_id }"><i
											class="fa-regular fa-pen-to-square"></i></a>
										<!-- Modal cho edit chapter -->
										<div class="modal fade"
											id="editChapterModal${chap.chapter_id }" tabindex="-1"
											aria-labelledby="editChapterModalLabel${chap.chapter_id }"
											aria-hidden="true">
											<div class="modal-dialog modal-dialog-centered">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title"
															id="editChapterModalLabel${chap.chapter_id }">Chỉnh
															sửa chương mới</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body content-modal">
														<form
															action="${pageContext.request.contextPath}/teacher/course/chapter"
															method="post" style="font-weight: 400">
															<input type="hidden" name="course_id"
																value="${Course.course_id }"> <input
																type="hidden" name="save" value="update"> <input
																type="hidden" name="chapter_id"
																value="${chap.chapter_id }">
															<div class="mb-4 row">
																<label class="col-sm-3 col-form-label">Tên
																	chương:</label>
																<div class="col-sm-9">
																	<input class="form-control" type="text"
																		name="chapterName" value="${chap.title }" />
																</div>
															</div>


															<div>
																<button type="button" class="btn btn-secondary"
																	data-bs-dismiss="modal">Hủy</button>
																<button id="editChapterConfirm" type="submit"
																	class="btn btn-primary">Xác nhận</button>
															</div>
														</form>
													</div>
												</div>
											</div>
										</div>

										<a style="color: red" href="#" data-bs-toggle="modal"
											data-bs-target="#deleteChapterModal${chap.chapter_id }">
											<i class="fa-regular fa-trash-can"></i>
										</a>
										<!-- Modal cho delete chapter -->
										<div class="modal fade"
											id="deleteChapterModal${chap.chapter_id }" tabindex="-1"
											aria-labelledby="deleteChapterModalLabel${chap.chapter_id }"
											aria-hidden="true">
											<div class="modal-dialog modal-dialog-centered">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title"
															id="deleteChapterModalLabel${chap.chapter_id }">Xác
															nhận xóa chương</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body content-modal">
														<p style="font-weight: 400">
															Bạn chắc chắn muốn xóa chương có tên là "<strong>${chap.title }</strong>"
															không!
														</p>
													</div>
													<div class="modal-footer">
														<form
															action="${pageContext.request.contextPath}/teacher/course/chapter"
															method="post">
															<input type="hidden" name="course_id"
																value="${Course.course_id }"> <input
																type="hidden" name="save" value="delete"> <input
																type="hidden" name="chapter_id"
																value="${chap.chapter_id }">
															<div>
																<button type="button" class="btn btn-secondary"
																	data-bs-dismiss="modal">Hủy</button>
																<button id="deleteChapterConfirm" type="submit"
																	class="btn btn-primary">Xác nhận</button>
															</div>
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>
								</h2>
								<div id="panelsStayOpen-collapse${chap.chapter_id }"
									class="accordion-collapse collapse"
									aria-labelledby="panelsStayOpen-heading${chap.chapter_id }">
									<a
										href="${pageContext.request.contextPath}/teacher/course/lecture?create=${chap.chapter_id }"
										class="btn" style="width: 100%">+ Thêm bài giảng</a>
									<div style="padding-left: 40px">
										<c:forEach var="lec" items="${Lectures }"
											varStatus="statusLec">
											<c:if test="${chap.chapter_id == lec.chapter_id }">
												<div
													style="display: flex; align-items: start; justify-content: end; padding-top: 12px; border-top: 1px solid #F1F1F1;">
													<p style="width: 80%; margin-left: 20px;">${statusLec.index + 1}<span>. ${lec.title }</span></p>
													<div
														style="display: flex; align-items: start; gap: 20px; margin: 0 20px">
														<a style="color: blue"
															href="${pageContext.request.contextPath}/teacher/course/lecture?update=${chap.chapter_id }&lecture_id=${lec.lecture_id }">
															<i class="fa-regular fa-pen-to-square"></i>
														</a> <a style="color: red"
															href="${pageContext.request.contextPath}/teacher/course/lecture?update=${chap.chapter_id }&lecture_id=${lec.lecture_id }"
															data-bs-toggle="modal"
															data-bs-target="#deleteLectureModal${chap.chapter_id }${lec.lecture_id }">
															<i class="fa-regular fa-trash-can"></i>
														</a>

														<!-- Modal cho delete lecture -->
														<div class="modal fade"
															id="deleteLectureModal${chap.chapter_id }${lec.lecture_id }"
															tabindex="-1"
															aria-labelledby="deleteLectureModalLabel${chap.chapter_id }${lec.lecture_id }"
															aria-hidden="true">
															<div class="modal-dialog modal-dialog-centered">
																<div class="modal-content">
																	<div class="modal-header">
																		<h5 class="modal-title"
																			id="deleteLectureModalLabel${chap.chapter_id }${lec.lecture_id }">Xác
																			nhận xóa bài giảng</h5>
																		<button type="button" class="btn-close"
																			data-bs-dismiss="modal" aria-label="Close"></button>
																	</div>
																	<div class="modal-body content-modal">
																		<p style="font-weight: 400">
																			Bạn chắc chắn muốn xóa bài giảng có tên là "<strong>${lec.title }</strong>"
																			trong chương "<strong>${chap.title }</strong>" không!
																		</p>
																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-secondary"
																			data-bs-dismiss="modal">Hủy</button>
																		<a id="deleteChapterConfirm" href="${pageContext.request.contextPath}/teacher/course/lecture/delete?lecture_id=${lec.lecture_id }"
																			class="btn btn-primary">Xác nhận</a>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</c:if>
										</c:forEach>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:if>
		</div>
	</div>


	<!-- Modal cho create chapter -->
	<div class="modal fade" id="createChapterModal" tabindex="-1"
		aria-labelledby="createChapterModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="createChapterModalLabel">Tạo
						chương mới</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body content-modal">
					<form
						action="${pageContext.request.contextPath}/teacher/course/chapter"
						method="post">
						<input type="hidden" name="course_id" value="${Course.course_id }">
						<input type="hidden" name="save" value="add">
						<div class="mb-4 row">
							<label class="col-sm-3 col-form-label">Tên chương:</label>
							<div class="col-sm-9">
								<input class="form-control" type="text" name="chapterName"
									required />
							</div>
						</div>


						<div>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Hủy</button>
							<button id="createChapterConfirm" type="submit"
								class="btn btn-primary">Xác nhận</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
