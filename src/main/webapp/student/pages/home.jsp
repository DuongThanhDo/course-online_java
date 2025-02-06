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
.promo-section {
	background-color: #e6f0ff;
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 40px 0;
	margin: 0 auto 40px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.promo-section .container {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.promo-title {
	font-size: 40px;
	line-height: 56px;
	color: #333;
	margin-bottom: 24px;
}

.promo-subtitle {
	font-size: 16px;
	color: #555;
	margin-bottom: 20px;
}

.promo-price {
	font-size: 24px;
	font-weight: 500;
	color: #333;
	margin-bottom: 32px;
}

.promo-btn {
	background-color: #007bff;
	color: white;
	border: none;
	padding: 12px 24px;
	border-radius: 8px;
	font-size: 18px;
	text-decoration: none;
}

.promo-btn:hover {
	background-color: #0056b3;
}

.promo-image {
	max-width: 50%;
	text-align: right;
}

.promo-image img {
	max-width: 90%;
	border-radius: 12px;
}

.feature-section {
	background-color: #f9fafc;
	padding: 40px 20px;
	border-radius: 12px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.feature-section h2 {
	font-size: 2rem;
	font-weight: bold;
	color: #333;
	margin-bottom: 30px;
}

.feature-section i {
	color: #007bff;
	transition: transform 0.3s ease, color 0.3s ease;
}

.feature-section i:hover {
	transform: scale(1.2);
	color: #0056b3;
}

.feature-section h5 {
	font-size: 1.3rem;
	font-weight: 600;
	color: #444;
	margin-top: 15px;
	margin-bottom: 10px;
}

.feature-section p {
	font-size: 1rem;
	color: #666;
	line-height: 1.5;
}

.cta-section {
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 60px 0;
	background-color: #F8F9FA;
	gap: 40px;
	margin: 100px 0;
}

.image-container {
	flex: 1;
	max-width: 30%;
	height: 300px;
	display: flex;
	justify-content: center;
	align-items: center;
	display: flex;
}

.image-container img {
	width: 100%;
	height: 100%;
	object-fit: cover;
	border-radius: 8px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}

.text-container {
	flex: 1;
	max-width: 40%;
	padding: 20px;
}

.text-container h1 {
	font-size: 2rem;
	color: #2a57d3;
	line-height: 1.5;
}

.text-container p {
	font-size: 1rem;
	color: #333;
	margin: 20px 0;
}

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
<script
	src="https://www.gstatic.com/dialogflow-console/fast/messenger/bootstrap.js?v=1"></script>

</head>
<body>
	<%@include file="../../student/components/header.jsp"%>

	<div class="promo-section">
		<div class="container">
			<div class="">
				<h1 class="promo-title">Chào mừng đến với DTD Online Learning</h1>
				<p class="promo-subtitle">Học tập và phát triển kỹ năng với
					những khóa học chất lượng nhất.</p>
				<p class="promo-subtitle">Nâng cao kiến thức, đạt được mục
					tiêu của bạn.</p>
				<p class="promo-price">Khám phá hàng trăm khóa học miễn phí và
					trả phí</p>
				<a href="${pageContext.request.contextPath}/student/course"
					class="promo-btn">Khám phá khóa học</a>
				<p class="mt-3" style="color: #0056D2">Tham gia ngay hôm nay để đạt được mục tiêu của
					bạn!</p>
			</div>
			<div class="promo-image mt-4">
				<img
					src="https://d3njjcbhbojbot.cloudfront.net/api/utilities/v1/imageproxy/https://images.ctfassets.net/wp1lcwdav1p1/DMFk42PH8L9y9MeQ5xc7I/c55cade640bb097b0e5429b780ff7c98/redesigned-hero-image.png?auto=format%2Ccompress&dpr=1"
					alt="DTD Online Learning">
			</div>
		</div>
	</div>

	<div class="container feature-section"
		style="margin-bottom: 80px; margin-top: 80px;">
		<h2 class="text-center mb-4">Tại sao chọn chúng tôi?</h2>
		<div class="row">
			<div class="col-md-4 text-center">
				<i style="color: #4b5e72"
					class="fas fa-chalkboard-teacher fa-3x mb-3"></i>
				<h5>Giảng viên phong phú</h5>
				<p>Các khóa học được dẫn dắt bởi giảng viên đến từ khắp nơi trên
					thế giới.</p>
			</div>
			<div class="col-md-4 text-center">
				<i style="color: #4b5e72" class="fas fa-clock fa-3x mb-3"></i>
				<h5>Linh hoạt thời gian</h5>
				<p>Bạn có thể học mọi lúc, mọi nơi, phù hợp với lịch trình cá
					nhân của mình.</p>
			</div>
			<div class="col-md-4 text-center">
				<i style="color: #4b5e72" class="fas fa-certificate fa-3x mb-3"></i>
				<h5>Chứng chỉ giá trị</h5>
				<p>Hoàn thành khóa học để nhận chứng chỉ giúp bạn khẳng định bản
					thân.</p>
			</div>
		</div>
	</div>

	<div style="padding: 50px 100px; background-color: #F8F9FA">
		<h2 class="text-center" style="margin-bottom: 40px;">Khóa học nổi
			bật</h2>
		<div class="row">
			<c:forEach var="cHot" items="${CourseHot }">
				<div class="col-md-3">
					<div class="card card-hover">
						<div style="width: 100%; height: 200px; overflow: hidden;">
							<img style="width: 100%; height: 100%; object-fit: cover"
								src="${pageContext.request.contextPath}/${cHot.photo != null ? cHot.photo : 'assets/images/noImage.png' }"
								class="card-img-top" alt="Course A">
						</div>
						<div class="card-body">
							<h5 class="card-title">${cHot.title }</h5>
							<p class="card-text">${cHot.description }</p>
							<a
								href="${pageContext.request.contextPath}/student/course?detail=${cHot.course_id }"
								class="btn btn-primary">Xem chi tiết</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<section class="cta-section">
		<div class="image-container">
			<img
				src="https://i.pinimg.com/736x/eb/07/92/eb079231159a8569f28c79cebb379460.jpg"
				alt="as">
		</div>
		<div class="text-container">
			<h1>Chào mừng đến với Công ty DTD!</h1>
			<p>Công ty DTD tự hào là một trong những đơn vị hàng đầu trong
				lĩnh vực cung cấp giải pháp công nghệ hiện đại. Với đội ngũ chuyên
				gia giàu kinh nghiệm và tận tâm, chúng tôi cam kết mang đến các sản
				phẩm và dịch vụ chất lượng, đáp ứng mọi nhu cầu của khách hàng.</p>
			<p>Hãy cùng chúng tôi xây dựng một tương lai bền vững và phát
				triển!</p>
			<a href="#" class="btn btn-primary">Tìm hiểu thêm</a>
		</div>
	</section>
	<df-messenger intent="WELCOME" chat-title="DTD BOT"
		agent-id="7bf3ba96-9f9e-4955-bd40-30d1346e4611" language-code="vi"></df-messenger>
	<%@include file="../../student/components/footer.jsp"%>
</body>
</html>
