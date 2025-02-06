<%@page import="com.google.gson.Gson"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>DTD OCMS ADMIN</title>
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

<!-- Chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	String role = request.getAttribute("role") != null ? (String) request.getAttribute("role") : "N / A";
	String headerName = (role.equals("TEACHER")) ? "giảng viên" : "học viên";
	%>

	<div style="display: flex;">
		<%@include file="../../admin/components/sidebar.jsp"%>
		<div style="flex-grow: 1">
			<%@include file="../../admin/components/header.jsp"%>
			<div class="px-4 pt-3">
				<div
					style="display: flex; align-items: center; justify-content: space-between; margin-bottom: 18px;">
					<h2>Quản lý <%=headerName %></h2>
					<form action="#" method="post">
						<div style="display: flex; align-items: center;">
							<input type="text" class="form-control" id="searchInput"
								placeholder="Tìm kiếm">
							<button type="submit" class="btn btn-primary form-control"
								style="width: 160px; margin-left: 12px;"
								onclick="searchAccounts()">Tìm kiếm</button>
						</div>
				</div>
				<table class="table table-bordered table-striped align-middle">
					<thead class="table-dark">
						<tr>
							<th>ID</th>
							<th>Họ tên</th>
							<th>Email</th>
							<th>SĐT</th>
							<th>Ngày tạo</th>
							<th>Ngày cập nhật</th>
							<th class="text-center" style="width: 120px;">Trạng thái</th>
						</tr>
					</thead>
					<tbody id="accountTable">
						<%
						for (int i = 1; i <= 10; i++) {
						%>
						<tr>
							<td><%=i%></td>
							<td><%=i%></td>
							<td><%=i%></td>
							<td><%=i%></td>
							<td><%=i%></td>
							<td><%=i%></td>
							<td class="text-center">
								<button
									class="btn btn-sm <%=(true) ? "btn-success" : "btn-danger" %>"
									onclick="toggleAccountStatus(${account.id})">
									<%=(true) ? "Kích hoạt" : "Bị khóa"%>
								</button>
							</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>

				<%
				if (true) {
				%><nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<li class="page-item disabled"><a class="page-link" href="#"
							tabindex="-1" aria-disabled="true"><</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">></a></li>
					</ul>
				</nav>
				<%
				}
				%>
			</div>
		</div>
	</div>

	<script>
        // Giả lập hàm tìm kiếm (backend cần xử lý logic tìm kiếm thực tế)
        function searchAccounts() {
            const input = document.getElementById("searchInput").value.trim();
            alert("Tìm kiếm: " + input);
        }

        // Giả lập hàm chuyển trạng thái tài khoản (backend cần xử lý thực tế)
        function toggleAccountStatus(accountId) {
            const confirmed = confirm("Bạn có chắc muốn thay đổi trạng thái tài khoản ID: " + accountId + "?");
            if (confirmed) {
                // Gửi yêu cầu đến backend (dùng AJAX hoặc fetch API)
                alert("Đã thay đổi trạng thái tài khoản ID: " + accountId);
            }
        }
    </script>
</body>
</html>
