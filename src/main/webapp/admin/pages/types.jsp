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
	<c:if test="${message != null}">
		<script>
			alert('<c:out value="${message}" />');
		</script>
	</c:if>
	<div style="display: flex;">
		<%@include file="../../admin/components/sidebar.jsp"%>
		<div style="flex-grow: 1">
			<%@include file="../../admin/components/header.jsp"%>
			<div class="px-4 pt-3">
				<div
					style="display: flex; align-items: center; justify-content: space-between; margin-bottom: 18px;">
					<h2>Quản lý loại</h2>
					<form action="${pageContext.request.contextPath}/admin/types" method="post">
						<div class="input-group">
							<input style="max-width: 400px" type="text" class="form-control"
								name="searchValue" value="${searchValue }" placeholder="Tìm kiếm">
							<button type="submit" class="btn btn-primary">
								<i class="fa-solid fa-magnifying-glass"></i>
							</button>
						</div>
					</form>
					<a href="${pageContext.request.contextPath}/admin/types?add=true"
						class="btn btn-primary">+ Bổ sung</a>
				</div>
				<table class="table table-bordered table-hover align-middle">
					<thead class="table-active">
						<tr>
							<th>Mã loại</th>
							<th>Tên loại</th>
							<th>Mô tả</th>
							<th class="text-center" style="width: 120px;">Hành động</th>
						</tr>
					</thead>
					<tbody id="accountTable">
						<c:if test="${Types == null || Types.isEmpty()}">
							<tr>
								<td colspan="4" class="text-center">Không có dữ liệu</td>
							</tr>
						</c:if>
						<c:forEach var="t" items="${Types }">
							<tr>
								<td>${t.type_id }</td>
								<td>${t.type_name }</td>
								<td>${t.type_description }</td>
								<td class="text-center"><a
									href="${pageContext.request.contextPath}/admin/types?update=${t.type_id}"><i
										class="fa-regular fa-pen-to-square"></i></a> <a
									style="margin-left: 12px; color: red"
									href="${pageContext.request.contextPath}/admin/types?delete=${t.type_id}"
									onclick="return confirm('Xác nhận xóa loại có mã là ${t.type_id}')"><i
										class="fa-regular fa-trash-can"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div
					style="display: flex; flex-direction: column; align-items: center;">
					<c:if test="${pageCount > 1}">
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<c:forEach var="p" begin="1" end="${pageCount}">
									<c:choose>
										<c:when test="${p == currentPage}">
											<li class="page-item active"><a class="page-link"
												href="#">${p}</a></li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a class="page-link"
												href="${pageContext.request.contextPath}/admin/types?page=${p}&search=${searchValue}">${p}</a>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
						</nav>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
