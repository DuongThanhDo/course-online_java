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
body {
	width: 100vw;
	height: 100vh;
	overflow: hidden;
}

p {
	padding: 0;
	margin: 0;
}

.header {
	display: flex;
	align-items: center;
	justify-content: space-between;
	background-color: #34495e;
	color: white;
	padding: 8px 12px;
}

.navbar-left {
	display: flex;
	align-items: center;
	font-size: 18px;
	font-weight: 600;
	gap: 10px;
	font-weight: 600;
}

.navbar-right {
	display: flex;
	font-size: 14px;
	align-items: center;
	gap: 12px;
	padding-right: 12px;
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

.sidebar-menu {
	box-shadow: 4px 0 10px rgba(0, 0, 0, 0.1);
	border-right: 0.5px solid rgba(0, 0, 0, 0.2);
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
	height: 92vh;
	overflow-y: auto;
	padding: 0;
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

.note-form {
	width: 83.5%;
	background-color: white;
	padding: 20px 100px;;
	display: none;
	margin-top: 20px;
	position: fixed;
	border-top: solid 1px rgba(0, 0, 0, 0.2);
	bottom: 0;
	right: 0;
	bottom: 0;
}

.note-list {
	position: fixed;
	top: 0;
	right: -500px;
	width: 500px;
	max-height: 100vh;
	overflow-y: auto;
	padding: 10px;
	border: 1px solid #ccc;
	background-color: #f9f9f9;
	height: 100%;
	background-color: white;
	box-shadow: -2px 0 5px rgba(0, 0, 0, 0.2);
	padding: 20px;
	transition: right 0.3s ease;
	overflow-y: auto;
	z-index: 50;
}

.note-list-overlay {
	position: fixed;
	top: 0;
	left: 0;
	width: 100vw;
	height: 100vh;
	background: rgba(0, 0, 0, 0.3);
	opacity: 0;
	visibility: hidden;
	transition: all 0.3s ease;
}

.note-list.show {
	right: 0;
}

.note-list-overlay.show {
	opacity: 1;
	visibility: visible;
}

.action-note i {
	color: grey;
	transition: all 0.3s ease;
}

.action-note:hover i {
	color: black;
}
</style>

<script>
	function displayTime() {
		var video = document.getElementById('myVideo');
		var currentTime = video.currentTime;

		var minutes = Math.floor(currentTime / 60);
		var seconds = Math.floor(currentTime % 60);
		if (seconds < 10) {
			seconds = '0' + seconds;
		}

		var timeDisplayElements = document
				.querySelectorAll('.currentTimeDisplay');
		timeDisplayElements.forEach(function(element) {
			element.innerHTML = minutes + ":" + seconds;
		});
	}

	function showNoteForm() {
		var video = document.getElementById('myVideo');
		video.pause();
		var currentTime = document.querySelector('.currentTimeDisplay').innerText;
		document.getElementById('noteTime').value = currentTime;
		document.getElementById('noteForm').style.display = 'block';
	}

	function hideNoteForm() {
		document.getElementById('noteForm').style.display = 'none';
		var video = document.getElementById('myVideo');
		video.play();
	}

	function saveNote() {
		var video = document.getElementById('myVideo');
		var currentTime = video.currentTime;

		document.getElementById('noteTime').value = currentTime;

		document.getElementById('noteFormSave').submit();
	}

	function start(time) {
		var video = document.getElementById('myVideo');

		video.currentTime = time;
		if (time != 0) {
			video.play();
		}
	}

	function showNoteList() {
		document.getElementById('noteList').classList.add('show');
		document.querySelector('.note-list-overlay').classList.add('show');
	}

	function hideNoteList() {
		document.getElementById('noteList').classList.remove('show');
		document.querySelector('.note-list-overlay').classList.remove('show');
	}
	
	function formatTime(seconds) {
	    let minutes = Math.floor(seconds / 60);
	    let remainingSeconds = seconds % 60;
	    if (remainingSeconds < 10) remainingSeconds = '0' + remainingSeconds;
	    if (minutes < 10) minutes = '0' + minutes;
	    return minutes + ':' + remainingSeconds;
	}
</script>
</head>
<body>
	<div class="header">
		<div class="navbar-left">
			<a class="btn color-white"
				href="${pageContext.request.contextPath}/student/my-course"><</a>
			<p>DTD</p>
			<p>${Course.title }</p>
		</div>

		<div class="navbar-right">
			<p class="btn color-white" onclick="showNoteList()">
				<i class="fas fa-sticky-note"></i> Ghi chú
			</p>
		</div>
	</div>
	<div class="px-2">
		<div class="row">
			<div class="col-sm-2 sidebar-menu">
				<p style="padding: 12px; font-weight: 500; font-size: 20px;">Nội
					dung khóa học</p>
				<div class="accordion accordion-flush chapters"
					id="accordionPanelsStayOpenExample">
					<c:forEach var="c" items="${Chapters }" varStatus="statusChap">
						<div class="accordion-item">
							<h2 class="accordion-header"
								id="panelsStayOpen-heading${c.chapter_id }">
								<button style="font-weight: 500; display: flex; align-items: flex-start;"
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
													href="${pageContext.request.contextPath}/student/course/content?course_id=${Course.course_id}&chapter_id=${c.chapter_id }&lecture_id=${l.lecture_id }">${statusLec.index + 1}<span>.
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
				<!-- <p class="btn btn-light QandA">
					<i class="fas fa-question-circle"></i> Hỏi đáp
				</p> -->
				<div>
					<div
						style="width: 100%; height: 80vh; background-color: black; padding: 2px 100px">
						<video id="myVideo"
							style="width: 100%; height: 100%; ${Lecture.video != null ? 'display: block;' : 'display: none;' }"
							controls ontimeupdate="displayTime()"
							onloadedmetadata="start(${TimeVideo != null ? TimeVideo : 0 })">
							<source
								src="${pageContext.request.contextPath}/${Lecture.video != null ? Lecture.video : 'assets/images/noImage.png' }"
								type="video/mp4">
						</video>
					</div>
					<div style="padding: 0 100px">
						<div class="d-flex align-items-center justify-content-between">
							<p style="font-size: 32px; font-weight: 500; margin: 36px 0;">${Lecture.title }</p>
							<button class="btn btn-light" style="margin-right: 40px;"
								onclick="showNoteForm()">
								+ Thêm ghi chú tại: <span class="currentTimeDisplay">0:00</span>
							</button>
						</div>
						<div>
							<pre>${Lecture.content}</pre>
						</div>
					</div>

					<div id="noteForm" class="note-form">
						<form
							action="${pageContext.request.contextPath}/student/course/note/save"
							method="POST" id="noteFormSave">
							<input type="hidden" name="course_id"
								value="${Course.course_id }" /> <input type="hidden"
								name="chapter_id" value="${Lecture.chapter_id }" /> <input
								type="hidden" name="lecture_id" value="${Lecture.lecture_id }" />
							<div class="mb-3">
								<label for="noteContent" class="form-label"
									style="font-size: 20px; font-weight: 500;"> Thêm ghi
									chú tại <span class="currentTimeDisplay"
									style="background-color: #0d6efd; color: white; padding: 0 8px; border-radius: 4px;">0:00</span>
								</label>
								<textarea class="form-control" id="noteContent"
									name="noteContent" rows="3"
									style="min-height: 100px; max-height: 300px;"></textarea>
							</div>
							<input type="hidden" id="noteTime" name="noteTime" value="0">
							<div class="d-flex justify-content-end">
								<button type="button" class="btn btn-primary me-2"
									onclick="saveNote()">Lưu ghi chú</button>
								<button type="button" class="btn btn-secondary"
									onclick="hideNoteForm()">Hủy</button>
							</div>
						</form>
					</div>
					<div id="noteList" class="note-list ${OpenNote != null ? "show" : "" }">
						<div
							class="note-list-header d-flex justify-content-between align-items-center">
							<h5>Danh sách ghi chú</h5>
							<button class="btn btn-close" onclick="hideNoteList()"></button>
						</div>
						<ul id="noteItems" class="list-group list-group-flush">
							<c:if test="${Notes == null || Notes.isEmpty()}">
								<div
									style="width: 100%; height: 80vh; display: flex; align-items: center; justify-content: center; flex-direction: column;">
									<strong>Bạn chưa có ghi chú nào</strong>
									<p>Hãy ghi chép để nhớ những gì bạn đã học!</p>
								</div>
							</c:if>
							<c:forEach var="note" items="${Notes}">
								<li class="list-group-item">
									<form action="${pageContext.request.contextPath}/student/course/note/save" method="POST">
									<input type="hidden" name="note_id" value="${note.note_id }">
									<input type="hidden" name="course_id" value="${Course.course_id }">
									<input type="hidden" name="chapter_id" value="${Chapter.chapter_id }">
									<input type="hidden" name="lecture_id" value="${Lecture.lecture_id }">
									<div
										style="width: 100%; display: flex; justify-content: space-between; align-items: center;">
										<p style="margin-top: 16px;">
											<a
												class="btn btn-outline-success"
												href="${pageContext.request.contextPath}/student/course/content?course_id=${note.course_id }&chapter_id=${note.chapter_id }&lecture_id=${note.lecture_id }&time=${note.timestamp }">
												<script>
						                document.write(formatTime(${note.timestamp}));
						            </script>
											</a>
										</p>
										<div>
											<button type="submit" class="btn action-note" onclick="return confirm('Cập nhật ghi chú')"><i class="fas fa-edit"></i></button>
											<a href="${pageContext.request.contextPath}/student/course/note/save?delete=${note.note_id }&course_id=${Course.course_id }&chapter_id=${Chapter.chapter_id }&lecture_id=${Lecture.lecture_id }" class="btn action-note" onclick="return confirm('Xác nhận xóa ghi chú')"><i class="fas fa-trash-alt"></i></a>
										</div>
									</div>
									<textarea name="content" style="width: 100%; margin: 16px 0; padding: 16px; background-color: #f7f8fa; border-radius: 4px;" rows="2">${note.content}</textarea>
									</form>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div class="note-list-overlay ${OpenNote != null ? "show" : "" }" onclick="hideNoteList()"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
