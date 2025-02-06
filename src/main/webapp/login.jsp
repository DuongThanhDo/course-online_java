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
	<!-- Login 4 - Bootstrap Brain Component -->
	<section class="p-3 p-md-4 p-xl-5 container" style="height: 100vh;">
		<div class="container">
			<div class="card border-light-subtle shadow-sm">
				<div class="row g-0">
					<div class="col-12 col-md-6">
						<img class="img-fluid rounded-start w-100 h-100 object-fit-cover"
							loading="lazy"
							src="https://i.pinimg.com/564x/80/d5/8e/80d58e29ce84e0af34d3f58f5e9f75e8.jpg"
							alt="BootstrapBrain Logo">
					</div>
					<div class="col-12 col-md-6">
						<div class="card-body p-3 p-md-4 p-xl-5">
							<div class="row">
								<div class="col-12">
									<div
										class="mb-5 d-flex justify-content-between align-content-center">
										<h3>Đăng nhập</h3>

										<a
											style="text-decoration: none; color: black; font-weight: 600; font-size: 32px;"
											href="home.jsp">DTD</a>
									</div>
								</div>
							</div>
							<form action="${pageContext.request.contextPath}/login" method="post">
								<div class="row gy-3 gy-md-4 overflow-hidden">
									<div class="col-12">
										<label for="username" class="form-label">Tên đăng nhập <span
											class="text-danger">*</span></label> <input type="text"
											class="form-control" name="username" id="username"
											placeholder="Nhập tên đăng nhập..." required>
									</div>
									<div class="col-12">
										<label for="password" class="form-label">Mật khẩu <span
											class="text-danger">*</span></label> <input type="password"
											class="form-control" name="password" placeholder="Nhập mật khẩu..." id="password" value=""
											required>
									</div>
									<div class="col-12" style="margin-top: 50px">
										<div class="d-grid">
											<button class="btn bsb-btn-xl btn-primary" type="submit" name="btnLogin">Đăng nhập</button>
										</div>
									</div>
								</div>
							</form>
							<div class="row">
								<div class="col-12">
									<hr class="mt-5 mb-4 border-secondary-subtle">
									<div
										class="d-flex gap-2 gap-md-4 flex-column flex-md-row justify-content-md-end">
										<a href="${pageContext.request.contextPath}/register"
											class="link-secondary text-decoration-none text-primary">Tạo tài khoản mới</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>