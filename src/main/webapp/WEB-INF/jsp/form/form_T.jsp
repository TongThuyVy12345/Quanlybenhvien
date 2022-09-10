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
<c:url value="/admin/quanlyT/form_T" var="action"/>

<div class="text-center">
    <div class="container">
        <div class="row" style="	background-image: url(https://res.cloudinary.com/dbevamq2u/image/upload/v1662403736/1598090111aKoeZqEspwDKuV3_rlrlzt.jpg);	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
            <div class="mx-auto col-lg-6 col-10">
                <h1 style="text-align: center;color:#554994"> FORM  THUỐC &nbsp;</h1>
                <form:form method="post" action="${action}" 
                           modelAttribute="dsT">
                    <form:errors path="*" element="div" cssClass="alert alert-danger" />
                    <div class="form-group" style="margin-top: 20px; display: flex">
                        <label style="width:50%"> Nhập tên thuốc</label>
                        <form:input type="text" class="form-control" id="tenThuoc" placeholder="Tên Thuốc" name="tenThuoc" path="tenThuoc"/>
                    </div>
                    <div class="form-group"  style="margin-top: 20px; display: flex">
                        <label style="width:50%"> Chọn cách dùng</label>
                        <form:select id="cachDung" path="cachDung" class="form-control">
                            <option value="Uống dạng viên" style="text-align: center">Uống dạng viên</option>
                            <option value="Pha loãng với nước"  style="text-align: center">Pha loãng với nước</option>
                            <option value="Lắc trước khi uống"  style="text-align: center">Lắc trước khi uống</option>
                            <option value="Tiêm"  style="text-align: center">Tiêm</option>
                            <option value="Truyền nước"  style="text-align: center">Truyền nước</option>

                        </form:select>

                    </div>
                    <div class="form-group" style="margin-top: 20px; display: flex">
                        <label style="width:50%;   overflow: hidden; height: 30px">Nhập giá thuốc</label>

                        <form:input type="text" class="form-control" id="gia" placeholder="Giá" name="gia" path="gia"/>
                    </div>
                    <div class="form-group" style="margin-top: 20px; display: flex">
                        <label style="width:50%;   overflow: hidden; height: 30px">Nhập loại thuốc</label>
                        <form:select id="idLoaiThuoc" path="idLoaiThuoc" class="form-control">
                             <c:forEach items="${dsLT}" var="c">
                                <option value="${c.idLoaiThuoc}">${c.tenLoaiThuoc}</option>
                            </c:forEach>
                        </form:select>
                        </div>

                        <div class="form-group" style="margin-top: 20px;"> 
                            <div class="form-floating" >
                                <input type="submit"
                                       value="SUBMIT"class="btn btn-primary" style="margin: 20px 0px">
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

