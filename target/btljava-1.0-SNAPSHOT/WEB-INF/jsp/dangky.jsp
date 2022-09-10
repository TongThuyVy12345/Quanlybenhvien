<%-- 
    Document   : dangnhap
    Created on : Aug 17, 2022, 9:03:39 PM
    Author     : ADMIN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${errMg !=null}">
    <div class="alert alert-danger">
        ${errMg}
    </div>
</c:if>
<c:url value="/dangky" var="action"/>

<div class="text-center">
    <div class="container">
        <div class="row" style="	background-image: url(https://res.cloudinary.com/dbevamq2u/image/upload/v1661184988/background-dep-1_it1b7r.jpg);	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
            <div class="mx-auto col-lg-6 col-10">
                <h1>ĐĂNG KÝ THÀNH VIÊN&nbsp;</h1>
                <p class="mb-3">Phòng Khám Đa Khoa An Khang - Đơn Vị Tiên Phong Áp Dụng Công Nghệ Thông Tin Và Kỹ Thuật Cao Vào Khám, Chữa Bệnh.</p>
                <form:form method="post" action="${action}" enctype="multipart/form-data" 
                           modelAttribute="nguoidung" >
                    <form:errors path="*" cssClass="alter alter-danger" element="div"/>

                    <div class="form-group" style="margin-top: 20px"> <form:input type="text" class="form-control" id="tenNguoiDung" placeholder="Họ và Tên*" name="tenNguoiDung" path="tenNguoiDung" />
                        <form:errors path="tenNguoiDung" cssClass="alter alter-danger" element="div"/>
                        <div class="form-group" style="margin-top: 20px;"><form:input type="text" class="form-control  is-invalid" id="taiKhoan" placeholder="Tên Tài Khoản*" name="taiKhoan"  path="taiKhoan" />
                            <form:errors path="taiKhoan" cssClass="alter alter-danger" element="div"/>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 20px; ">  <form:input type="tel" class="form-control" id="sdt" placeholder="Phone" name="sdt" path="sdt" pattern="[0-9]{10}"
                                title="Vui lòng nhập số điện thoại đủ 10 số"/> </div>
                    <div class="form-group" style="display: flex ;margin-top: 20px; ">  <form:input type="password" class="form-control is-invalid" id="matKhau" placeholder="Mật Khẩu*" name="matKhau" path="matKhau" 
                               /> </div>
                    <div class="form-group" style="display: flex ;margin-top: 20px; ">  <form:input type="password" class="form-control is-invalid" id="confirm-matKhau" placeholder="Nhập lại mật khẩu*" name="confirmmatKhau" path="confirmmatKhau"   
                              /> </div>

                    <div class="form-group" style="display:flex"> 
                        <div class="form-group" style="margin: 20px 10px 0 0;width:50%"> <form:input type="date" class="form-control" id="ngaySinh" placeholder="Ngày sinh" path="ngaySinh" name="ngaySinh"/> </div>
                        <div class="form-group" style="margin: 20px 10px 0 0;;width:50%">

                            <form:select id="gioiTinh" path="gioiTinh" class="form-control">
                                <option value=" " style="text-align: center">Giới tính</option>
                                <option value="Nam" style="text-align: center">Nam</option>
                                <option value="Nữ" style="text-align: center">Nữ</option>
                                <option value="Khác" style="text-align: center">Khác</option>
                            </form:select>
                            <form:errors path="gioiTinh"  element="div" cssClass="invalid-feedback" />
                        </div>

                    </div>
                    <div class="form-group" style="margin-top: 20px"> <form:input type="text" class="form-control" id="email" placeholder="Email" path="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
                                title="Vui lòng nhập đúng định dạng Email Vd: A@gmail.com"/> </div>

                    <div class="form-group" style="margin-top: 20px"> <form:input type="text" class="form-control" id="diaChi" placeholder="Địa chỉ" path="diaChi" name="diaChi"/> </div>


                    <div class="form-group" style="margin-top: 20px ;"> <form:input type="file" class="form-control" id="avatar"  path="file" name="avatar"/> </div>

                    <div class="form-group" style="margin-top: 20px;"> 
                        <div class="form-floating" >
                            <input type="submit"
                                   value="Dang ky"class="btn btn-primary" style="margin: 20px 0px">
                        </div>
                    </div>
                </form:form>



            </div>
        </div></div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>

