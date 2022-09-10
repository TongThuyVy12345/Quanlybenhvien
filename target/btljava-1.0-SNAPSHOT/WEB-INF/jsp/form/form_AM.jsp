
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${errMg !=null}">
    <div class="alert alert-danger">
        ${errMg}
    </div>
</c:if>
<c:url value="/superadmin/quanlyam/form_AM" var="action"/>

<div class="text-center">
    <div class="container">
        <div class="row" style="	background-image: url(https://res.cloudinary.com/dbevamq2u/image/upload/v1662403736/1598090111aKoeZqEspwDKuV3_rlrlzt.jpg);	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
            <div class="mx-auto col-lg-6 col-10">
                <h1 style="text-align: center;color:#554994; font-size: 30px"> FORM SUPERADMIN &nbsp;</h1>
                <form:form method="post" action="${action}" enctype="multipart/form-data" 
                           modelAttribute="dsAMF">
                    <form:errors path="*" element="div" cssClass="alert alert-danger" />
                    <div class="form-group" style="margin-top: 20px"> <form:input type="text" class="form-control" id="tenNguoiDung" placeholder="Họ và Tên*" name="tenNguoiDung" path="tenNguoiDung"/>

                    </div>
                    <div class="form-group" style="margin-top: 20px;"><form:input type="text" class="form-control" id="taiKhoan" placeholder="Tên Tài Khoản*" name="taiKhoan"  path="taiKhoan"/></div>
                    <div class="form-group" style="margin-top: 20px" >
                        <form:select id="gioiTinh" path="gioiTinh" class="form-control">
                            <option value=" ">Giới tính</option>
                            <option value="Nam">Nam</option>
                            <option value="Nữ">Nữ</option>
                            <option value="Khác">Khác</option>
                        </form:select>
                        <form:errors path="gioiTinh"  element="div" cssClass="invalid-feedback" />
                    </div>
                    <div class="form-group" style="margin-top: 20px">
                        <form:select id="userRole" path="userRole" class="form-control">
                            <option value="ROLE_SUPERADMIN"> SUPERADMIN</option>
                            <option value="ROLE_ADMIN"> ADMIN</option>
                            <option value="ROLE_BACSI"> BÁC SĨ</option>
                            <option value="ROLE_YTA"> Y TÁ</option>
                            <option value="ROLE_NGUOIDUNG"> NGƯỜI DÙNG</option>
                        </form:select>
                        <form:errors path="userRole"  element="div" cssClass="invalid-feedback" />
                    </div>
                    <div class="form-group" style="margin-top: 20px"> <form:input type="text" class="form-control" id="diaChi" placeholder="Địa chỉ" path="diaChi" name="diaChi"/> </div>

                    <div class="form-group" style="margin-top: 20px; ">  <form:input type="text" class="form-control" id="sdt" placeholder="Phone" name="sdt" path="sdt"/> </div>
                    <div class="form-group" style="margin-top: 20px">  <form:input type="password" class="form-control" id="matKhau" placeholder="Mật Khẩu*" name="matKhau" path="matKhau"/> </div>

                    <div class="form-group" style="display:flex"> 
                        <div class="form-group" style="margin-top: 20px;width:35%"> <form:input type="date" class="form-control" id="ngaySinh" placeholder="Ngày sinh" path="ngaySinh" name="ngaySinh"/> </div>
                        <div class="form-group" style="margin: 20px 0 0 5px;width:65%"> <form:input type="text" class="form-control" id="email" placeholder="Email" path="email" name="email"/> </div>
                    </div>
                    <div class="form-group" style="margin-top: 20px"> <form:input type="file" class="form-control" id="avatar"  path="file" name="avatar"/> </div>
                    <div class="form-group" > 
                        <div class="form-floating" >
                            <input type="submit"
                                   value="Dang ky"class="btn btn-primary" style="margin: 20px 0px">
                        </div>
                    </div>
                </form:form>



            </div>
        </div>
    </div>
</div>
<div class="spinner-border text-secondary" id="myLoading" style="visibility: hidden"></div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>

