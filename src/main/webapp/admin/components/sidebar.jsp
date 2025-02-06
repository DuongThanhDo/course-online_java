<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
  body {
    margin: 0;
    font-family: "Roboto", Arial, sans-serif;
  }

  .sidebar {
    width: 240px;
    height: 100vh;
    background-color: #2c3e50;
    color: #ecf0f1;
    display: flex;
    flex-direction: column;
    box-shadow: 2px 0 10px rgba(0, 0, 0, 0.5);
  }

  .sidebar-header {
    font-size: 22px;
    font-weight: bold;
    text-align: center;
    padding: 12px 0;
    background-color: #34495e;
    border-bottom: 1px solid #1abc9c;
    text-transform: uppercase;
  }

  .sidebar-list {
    list-style: none;
    padding: 0;
    margin: 0;
  }

  .sidebar-item {
    margin: 0;
    position: relative;
  }

  .sidebar-link {
    text-decoration: none;
    color: #ecf0f1;
    display: block;
    padding: 15px 20px;
    font-size: 16px;
    transition: 0.3s ease-in-out;
    border-left: 3px solid transparent;
    cursor: pointer;
  }

  .sidebar-link:hover {
    background-color: #1abc9c;
    color: #2c3e50;
    border-left: 3px solid #16a085;
    padding-left: 25px;
  }

  /* Mũi tên */
  .arrow {
  	position: absolute;
  	top: 18px;
	right: 20px;
    transition: transform 0.3s ease-in-out;
  }
  .dropdown {
    display: none;
    list-style: none;
    padding-left: 20px;
  }

  .dropdown .sidebar-link {
    padding: 10px 20px;
    font-size: 14px;
  }

  .sidebar-item.open .dropdown {
    display: block;
  }

  .sidebar-item.open .arrow {
    transform: rotate(90deg);
  }

  .sidebar-footer {
    margin-top: auto;
    padding: 15px 20px;
    font-size: 14px;
    text-align: center;
    background-color: #34495e;
    border-top: 1px solid #1abc9c;
    color: #bdc3c7;
  }

  .sidebar-footer a {
    text-decoration: none;
    color: #1abc9c;
    font-weight: bold;
  }

  .sidebar-footer a:hover {
    color: #16a085;
  }
</style>

<div class="sidebar">
  <div class="sidebar-header">DTD Admin</div>
  <ul class="sidebar-list">
    <li class="sidebar-item">
      <a class="sidebar-link" href="${pageContext.request.contextPath}/admin/home">Trang chủ</a>
    </li>
    <li class="sidebar-item open">
      <span class="sidebar-link" onclick="toggleDropdownAcc(this)">Quản lý người dùng
        <i class="fa-solid fa-chevron-right arrow"></i>
      </span>
      <ul class="dropdown">
        <li><a class="sidebar-link" href="${pageContext.request.contextPath}/admin/accounts">Quản lý người dùng</a></li>
      </ul>
    </li>
    <li class="sidebar-item open">
      <span class="sidebar-link" onclick="toggleDropdownCourse(this)">Quản lý khóa học
        <i class="fa-solid fa-chevron-right arrow"></i>
      </span>
      <ul class="dropdown">
        <li><a class="sidebar-link" href="${pageContext.request.contextPath}/admin/courses">Quản lý khóa học</a></li>
        <li><a class="sidebar-link" href="${pageContext.request.contextPath}/admin/categories">Quản lý danh mục</a></li>
        <li><a class="sidebar-link" href="${pageContext.request.contextPath}/admin/types">Quản lý loại</a></li>
      </ul>
    </li>
    <li class="sidebar-item">
      <a class="sidebar-link" href="#">Khiếu nại báo cáo</a>
    </li>
  </ul>
  <div class="sidebar-footer">
    © 2024 <a href="#">DTD Course</a>
  </div>
</div>

<script>
  // Hàm toggle cho dropdown "Quản lý tài khoản"
  function toggleDropdownAcc(element) {
    const parent = element.parentElement;
    parent.classList.toggle('open');
  }

  // Hàm toggle cho dropdown "Quản lý khóa học"
  function toggleDropdownCourse(element) {
    const parent = element.parentElement;
    parent.classList.toggle('open');
  }
</script>

