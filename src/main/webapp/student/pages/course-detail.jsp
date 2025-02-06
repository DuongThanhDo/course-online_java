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

	<div class="container mt-4">
		<div class="row">
			<div class="col-sm-8">
				<div style="margin-bottom: 32px;">
					<h1 style="margin-bottom: 12px; padding: 0">
						<a class="btn" style="font-size: 32px;" href="javascript:void(0);" onclick="window.history.back();"><</a>
						${Course.title }
					</h1>

					<p>${Course.description }</p>
				</div>

				<div>
					<h4 style="margin-bottom: 12px; font-size: 24px;">Nội dung
						khóa học</h4>

					<div class="accordion accordion-flush"
						id="accordionPanelsStayOpenExample">

						<c:forEach var="c" items="${Chapters }" varStatus="statusChap">
							<div class="accordion-item">
								<h2 class="accordion-header"
									id="panelsStayOpen-heading${c.chapter_id }"
									style="display: flex; align-items: center;">
									<button style="font-size: 20px; font-weight: 500;"
										class="accordion-button collapsed custom-accordion-button"
										type="button" data-bs-toggle="collapse"
										data-bs-target="#panelsStayOpen-collapse${c.chapter_id }"
										aria-expanded="false"
										aria-controls="panelsStayOpen-collapse${c.chapter_id }">
										${statusChap.index + 1 }<span>. ${c.title }</span>
									</button>
								</h2>
								<div id="panelsStayOpen-collapse${c.chapter_id }"
									class="accordion-collapse collapse show"
									aria-labelledby="panelsStayOpen-heading${c.chapter_id }">
									<div>
										<c:forEach var="l" items="${Lectures }" varStatus="statusLec">
											<c:if test="${c.chapter_id == l.chapter_id }">
												<div style="border-bottom: 1px solid #f7efed">
													<p style="margin: 16px 0 0 28px; padding-bottom: 16px">
														<i style="color: #4b5e72;" class="fa-solid fa-circle-play"></i>
														${statusLec.index + 1}<span>. ${l.title } 
													</p>
												</div>
											</c:if>
										</c:forEach>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

			</div>
			<div class="col-sm-4"
				style="display: flex; align-items: center; flex-direction: column;">
				<div
					style="width: 80%; height: 200px; background-color: black; border-radius: 10px; overflow: hidden;">
					<video id="myVideo" style="width: 100%; height: 100%; outline: none"
						controls="controls">
						<source
							src="${pageContext.request.contextPath}/${Lectures[0].video }"
							type="video/mp4">
					</video>
				</div>

				<p style="color: #f3744f; margin: 18px 0; font-size: 40px;">Miễn
					phí</p>

				<c:choose>
					<c:when test="${statusRegister == 0}">
						<button class="btn btn-warning">Đang chờ duyệt</button>
					</c:when>
					<c:otherwise>
						<a class="btn btn-primary"
							href="${pageContext.request.contextPath}/student/course/register?registerCourse=${Course.course_id }"
							onclick="return confirm('Xác nhận đăng ký học!')">Đăng ký học</a>
					</c:otherwise>
				</c:choose>



				<div style="margin: 32px 0">
					<p>
						<i class="fa-solid fa-film"></i> Tổng số ${Lectures.size() } bài
						học
					</p>
					<p>
						<i class="fa-solid fa-book-open"></i> Tổng số ${Chapters.size() }
						chương học
					</p>
					<p>
						<i class="fa-solid fa-clock"></i> Học mọi lúc mọi nơi
					</p>
				</div>
			</div>
		</div>
	</div>

	<%@include file="../../student/components/footer.jsp"%>
</body>
</html>
