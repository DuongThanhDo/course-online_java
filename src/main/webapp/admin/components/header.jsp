<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style>
.header-nav {
	padding: 13px;
    background-color: #34495e;
    border-bottom: 1px solid #1abc9c;
}
</style>
<% boolean sttLogin = false; String username = ""; if
(session.getAttribute("login") == null) { session.setAttribute("login",
false); } else { sttLogin = (boolean) session.getAttribute("login");
username = (String) session.getAttribute("username"); } %>
<nav class="navbar navbar-expand-sm navbar-dark header-nav">
	<div class="container-fluid">
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav me-auto"></ul>
			<ul class="navbar-nav me-2">
				<% if(!sttLogin) {%>
				<!-- <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/notification"><i class="fa-solid fa-bell"></i> Thông báo</a></li> -->
				<div class="dropdown dropstart" style="margin-left: 16px; display: flex; align-items: center;">
					<a href="#"
						id="dropdownMenuLink" data-bs-toggle="dropdown"
						aria-expanded="false"> <img
						style="width: 31px; height: 31px; border-radius: 100px;"
						alt="avatar"
						src="https://i.pinimg.com/736x/ad/4d/39/ad4d39691e21a7d805eaca3b90ab8554.jpg">
					</a>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item" href="#" data-bs-toggle="modal"
							data-bs-target="#logoutModal"><i class="fa-solid fa-arrow-right-from-bracket"></i> Đăng xuất
						</a></li>
					</ul>
				</div>
				<% } else {%>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">Đăng nhập</a></li> <%
				} %>
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
				<h5 class="modal-title" id="logoutModalLabel">Xác nhận đăng xuất</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">Bạn có chắc chắn đăng xuất không?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Hủy</button>
				<a href="${pageContext.request.contextPath}/login" class="btn btn-primary">Xác nhận</a>
			</div>
		</div>
	</div>
</div>