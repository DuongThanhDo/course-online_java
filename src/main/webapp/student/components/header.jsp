<%@page import="profileModel.Profile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
boolean sttLogin = false;
String username = "";
String avatar = "";
if (session.getAttribute("login") == null) {
	session.setAttribute("login", false);
} else {
	sttLogin = (boolean) session.getAttribute("login");
	username = (String) session.getAttribute("username");
	String profile_image = (String) session.getAttribute("profile_image");

	avatar = ( profile_image == null || profile_image.equals(""))? "assets/images/noImage.png" : profile_image;
}
%>
<style>
.header-nav {
	background-color: #34495e;
}
</style>
<nav class="navbar navbar-expand-md header-nav navbar-light bg-light" style="box-shadow: 0 8px 10px -6px rgba(0, 0, 0, 0.2);">
	<div class="container">
		<a class="navbar-brand"
			href="${pageContext.request.contextPath}/student/home"><h3>Học
			viên</h3></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav me-auto">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/student/home">Trang
						chủ</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/student/course">Khóa
						học</a></li>
				<!-- <li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/student/teacher">Giảng
						viên</a></li> -->
			</ul>
			<ul class="navbar-nav me-2">
				<%
				if (!sttLogin) {
				%>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/student/my-course">Khóa
						học của tôi</a></li>
				<div class="dropdown dropstart"
					style="margin-left: 16px; display: flex; align-items: center;">
					<a href="#" id="dropdownMenuLink" data-bs-toggle="dropdown"
						aria-expanded="false"> <img
						style="width: 30px; height: 30px; border-radius: 100px;"
						alt="avatar"
						src="${pageContext.request.contextPath}/<%= (avatar != "") ? avatar : "assets/images/noImage.png"%>">
					</a>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item"
							href="${pageContext.request.contextPath}/student/profile">Thông
								tin cá nhân</a></li>
						<li><a class="dropdown-item" href="#" data-bs-toggle="modal"
							data-bs-target="#logoutModal"><i
								class="fa-solid fa-arrow-right-from-bracket"></i> Đăng xuất </a></li>
					</ul>
				</div>
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/login.jsp">Đăng nhập</a></li>
				<%
				}
				%>
			</ul>
		</div>
	</div>
</nav>

<!-- Modal cho logout -->
<div class="modal fade" id="logoutModal" tabindex="-1"
	aria-labelledby="logoutModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="logoutModalLabel">Xác nhận đăng
					xuất</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">Bạn có chắc chắn đăng xuất không?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Hủy</button>
				<a href="${pageContext.request.contextPath}/login"
					class="btn btn-primary">Xác nhận</a>
			</div>
		</div>
	</div>
</div>