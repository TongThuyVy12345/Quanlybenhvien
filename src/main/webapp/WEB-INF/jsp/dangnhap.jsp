<%-- 
    Document   : dangnhap
    Created on : Aug 17, 2022, 9:03:39 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/dangnhap" var="action"/>

<c:if test="${param.accessDenied !=null}">
    <h1>Ban không có quyền truy cập
    </h1>
</c:if>
<c:if test="${param.error !=null}">
    <div class="alter alter-danger" >
        đã có lỗi xảy ra! Vui lòng quay lại sau
    </div>
</c:if>
<c:url value="/dangnhap" var="action"/>



<div class="py-5 text-center" style="	background-image: url(https://res.cloudinary.com/dbevamq2u/image/upload/v1661184988/background-dep-1_it1b7r.jpg);	background-size: cover;	background-position: top left;	background-repeat: repeat;">
    <div class="container">
        <div class="row" style="	background-image: url(../../4853433.jpg);	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
            <div class="mx-auto col-md-6 col-10 bg-white p-5">
                <h1 class="mb-4">Đăng nhập</h1>
                <form  action="${action}" method="POST" >
                    <div class="form-group" style="margin-top: 20px"> <input type="t" class="form-control" placeholder="Tên tài khoản" name="taiKhoan" id="taiKhoan"> </div>
                    <div class="form-group mb-3"  style="margin-top: 20px"> <input type="password" class="form-control" placeholder="Password"  name="matKhau"  id="matKhau"> <small class="form-text text-muted text-right">
                            <a  href="/btljava/dangky">Bạn chưa có tài khoản, đăng ký ngay</a>
                        </small> </div> <button type="submit"
                            value="Dang nhap" class="btn btn-primary" style="; ;background-position: top left;	background-size: 100%;	background-repeat: repeat;">Đăng nhập</button>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous" style=""></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous" style=""></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous" style=""></script>
