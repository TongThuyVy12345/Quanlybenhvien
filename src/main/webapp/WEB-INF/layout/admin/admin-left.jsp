<%-- 
    Document   : admin-left
    Created on : Sep 2, 2022, 12:40:33 AM
    Author     : ADMIN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar " >
    <div class="container-fluid">
        <ul class="navbar-nav"  >
           
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/quanlyND/nguoidung"/>"style="color:#FE83C6">Quản lý Người Dùng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/quanlyPK/phieukham"/>" style="color:#FE83C6">Quản lý Phiếu Khám</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/quanlyT/thuoc"/>" style="color:#FE83C6">Quản lý Thuốc</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/quanlyPKT/phieukhamthuoc"/>"style="color:#FE83C6">Quản lý Phiếu khám thuốc</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/quanlyLT/loaithuoc"/>" style="color:#FE83C6">Quản lý Loại Thuốc</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/thongke-nd"/>" style="color:#FE83C6">Thống kê Thống kê người dùng theo chức vụ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/admin/thongke-pk"/>" style="color:#FE83C6">Thống kê doanh thu theo từng phiếu khám</a>
            </li>
            <li class="nav-item" >
                <a class="nav-link" href="<c:url value="/admin/thongke-t"/>" style="color:#FE83C6" >Thống kê tần suất sử dụng thuốc theo tháng</a>
            </li>
        </ul>
    </div>
</nav>
