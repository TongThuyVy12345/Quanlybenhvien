<%-- 
    Document   : header
    Created on : Aug 16, 2022, 10:23:18 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)"><img style="width: 150px"src="https://res.cloudinary.com/dbevamq2u/image/upload/v1660663754/medcomis-banner_tp7aqw.png" alt="logone"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/btljava">Trang Chủ</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="datlichkham/lichkham">Đặt lịch khám</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="https://www.akclinic.com.vn/an-khang-clinic">Giới thiệu phòng khám</a>
                </li>
                <c:if test="${pageContext.request.userPrincipal.name==null}">
                    <li style="padding:6px 10px" class="nav-item">
                        <a  class="nav-link-check" href="<c:url value="/dangnhap"/>">
                            <i class="fa fa-user"></i>Đăng Nhập
                        </a>
                    </li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name!=null}">

                    <li style="padding:6px 10px" class="nav-item">
                        <a  class="nav-link-check" href="<c:url value="/"/>">
                            <i class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}
                        </a>
                    </li>

                    <li style="padding:6px 10px" class="nav-item">
                        <a  class="nav-link-check" href="<c:url value="/logout"/>">
                            <i class="fa fa-user"></i>Đăng xuất
                        </a>
                    </li>
                </c:if>
                <c:if  test="${currentUser.userRole.equals('ROLE_ADMIN')}">
                    <li style="padding:6px 10px" class="nav-item">
                        <a class="nav-link-check" href="<c:url value="/admin/quanlyPK/phieukham"/>">
                            <i class="fa-sharp fa-solid fa-chart-simple"></i>
                            Vào trang quản lý
                        </a>
                    </li>

                </c:if>
                <c:if  test="${currentUser.userRole.equals('ROLE_SUPERADMIN')}">
                    <li style="padding:6px 10px" class="nav-item">
                        <a class="nav-link-check" href="<c:url value="/admin/quanlyPK/phieukham"/>">
                            <i class="fa-sharp fa-solid fa-chart-simple"></i>
                            Vào trang quản lý
                        </a>
                    </li>
                    <li style="padding:6px 10px" class="nav-item">
                        <a class="nav-link-check" href="<c:url value="/superadmin/quanlyAM/admin"/>">
                            <i class="fa-sharp fa-solid fa-chart-simple"></i>
                            QL ADMIN
                        </a>
                    </li>
                </c:if>
                <c:if  test="${currentUser.userRole.equals('ROLE_BACSI')}">
                    <li style="padding:6px 10px" class="nav-item">
                        <a class="nav-link-check" href="<c:url value="/bacsi/lichkham"/>">
                            <i class="fa-regular fa-user"></i>                         
                            Vào trang bác sĩ
                        </a>
                    </li>
                </c:if>
                <c:if  test="${currentUser.userRole.equals('ROLE_YTA')}">
                    <li style="padding:6px 10px" class="nav-item">
                        <a class="nav-link-check" href="<c:url value="/phieukham/xacnhan"/>">
                            <i class="fa-regular fa-user"></i>
                            Vào trang y tá
                        </a>
                    </li>
                    <li style="padding:6px 10px" class="nav-item">
                        <a class="nav-link-check" href="<c:url value="/phieukham/thanhtoan"/>">
                            <i class="fa-regular fa-user"></i>
                            Vào trang thanh toán
                        </a>
                    </li>
                </c:if>




            </ul>

        </div>
    </div>
</nav>