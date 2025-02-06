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

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- fontawesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
body {
	width: 100vw;
	height: 100vh;
	overflow: hidden;
}

p {
	padding: 0;
	margin: 0;
}

.navbar-left {
	display: flex;
	align-items: center;
	font-size: 18px;
	font-weight: 600;
	gap: 10px;
	font-weight: 600;
}

.color-white {
	color: white;
}

.QandA {
	color: #0d6efd;
	background-color: white;
	padding: 8px 12px;
	border-radius: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	position: fixed;
	bottom: 20px;
	right: 32px;
}

.chapters {
	height: 82vh;
	overflow-y: auto;
}

.chapters::-webkit-scrollbar-track {
	border-radius: 10px;
	background-color: #F5F5F5;
}

.chapters::-webkit-scrollbar {
	width: 8px;
	background-color: #F5F5F5;
}

.chapters::-webkit-scrollbar-thumb {
	border-radius: 10px;
	background-color: rgba(0, 0, 0, 0.05);
}

.custom-accordion-button {
	background-color: transparent;
}

.custom-accordion-button:not(.collapsed) {
	background-color: white;
}

.content {
	height: 90vh;
	overflow-y: auto;
}

.content::-webkit-scrollbar-track {
	border-radius: 10px;
	background-color: #F5F5F5;
}

.content::-webkit-scrollbar {
	width: 12px;
	background-color: #F5F5F5;
}

.content::-webkit-scrollbar-thumb {
	border-radius: 10px;
	background-color: rgba(0, 0, 0, 0.2);
}

.lecture {
	font-size: 14px;
	padding: 12px 0 12px 26px;
	transition: all 0.3s ease;
	cursor: pointer;
}

.lecture a {
	text-decoration: none;
	color: black;
}

.lecture:hover {
	background-color: rgba(0, 0, 0, 0.05);
}

.act {
	background-color: rgba(0, 0, 0, 0.05);
	transition: all 0.3s ease;
}

.content {
	
}
</style>
</head>
<body>
	<%@include file="../../teacher/components/header.jsp"%>
	<div class="px-2">
		<div class="row">
			<div class="col-sm-2">
				<div class="navbar-left">
					<a class="btn" style="width: 30px;"
						href="${pageContext.request.contextPath}/teacher/course?detail=${Course.course_id}"><i
						class="fa-solid fa-arrow-left"></i></a>
					<p>${Course.title }</p>
				</div>
				<p style="padding: 12px; font-weight: 500; font-size: 16px;">Nội
					dung khóa học</p>
				<div class="accordion accordion-flush chapters"
					id="accordionPanelsStayOpenExample">
					<c:forEach var="c" items="${Chapters }" varStatus="statusChap">
						<div class="accordion-item">
							<h2 class="accordion-header"
								id="panelsStayOpen-heading${c.chapter_id }">
								<button
									style="font-weight: 500; display: flex; align-items: flex-start;"
									class="accordion-button collapsed custom-accordion-button"
									type="button" data-bs-toggle="collapse"
									data-bs-target="#panelsStayOpen-collapse${c.chapter_id }"
									aria-expanded="false"
									aria-controls="panelsStayOpen-collapse${c.chapter_id }">
									${statusChap.index + 1 }<span>. ${c.title }</span>
								</button>
							</h2>
							<div id="panelsStayOpen-collapse${c.chapter_id }"
								class="accordion-collapse collapse ${c.chapter_id == Chapter.chapter_id ? 'show' : '' }"
								aria-labelledby="panelsStayOpen-heading${c.chapter_id }">
								<div>
									<c:forEach var="l" items="${Lectures }" varStatus="statusLec">

										<c:if test="${c.chapter_id == l.chapter_id }">
											<div
												class="lecture ${l.lecture_id == Lecture.lecture_id ? 'act' : '' }">
												<a
													href="${pageContext.request.contextPath}/teacher/course/content?course_id=${Course.course_id}&chapter_id=${c.chapter_id }&lecture_id=${l.lecture_id }">${statusLec.index + 1}<span>.
														${l.title }</span></a>
											</div>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-sm-10 content" style="position: relative;">
				<div
					style="width: 100%; height: 83vh; background-color: black; padding: 0 100px;">
					<video id="myVideo" style="width: 100%; height: 100%; ${Lecture.video != null ? 'display: block;' : 'display: none;' }" controls
						ontimeupdate="displayTime()">
						<source
							src="${pageContext.request.contextPath}/${Lecture.video != null ? Lecture.video : 'assets/images/noImage.png' }"
							type="video/mp4">
					</video>
				</div>
				<div style="padding: 0 100px">
					<div class="d-flex align-items-center justify-content-between">
						<p style="font-size: 32px; font-weight: 500;">${Lecture.title }</p>
					</div>
					<div>
						<p>${Lecture.content }</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
