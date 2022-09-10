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
<c:url value="/admin/quanlyPK/form_PK" var="action"/>

<div class="text-center">
    <div class="container">
        <div class="row" style="	background-image: url(https://res.cloudinary.com/dbevamq2u/image/upload/v1662403736/1598090111aKoeZqEspwDKuV3_rlrlzt.jpg);	background-position: top left;	background-size: 100%;	background-repeat: repeat;">

            <div class="mx-auto col-lg-6 col-10">
                <h1 style="text-align: center;color:#554994; font-size: 30px">PHIẾU KHÁM&nbsp;</h1>
                <form:form method="post" action="${action}" 
                           modelAttribute="dsPKF">
                    <form:errors path="*" element="div" cssClass="alert alert-danger" />
               
                    <div class="form-group" style="display: flex">
                        <label style="width: 40%; ">Chọn bệnh Nhân</label>
                        <form:select id="idBenhNhan" path="idBenhNhan" class="form-control">
                            <c:forEach items="${dsND}" var="c">
                                <c:if test="${c.userRole=='ROLE_NGUOIDUNG'}">
                                    <option value="${c.idNguoiDung}" style="text-align: center">${c.tenNguoiDung}</option>
                                </c:if>
                            </c:forEach>
                        </form:select>
                        <form:errors path="idBenhNhan"  element="div" cssClass="invalid-feedback" />
                    </div>
                    <div class="form-group" style="margin-top: 20px; display: flex">
                        <label style="width: 40%"> Chọn bác sĩ</label>
                        <form:select id="idBacSi" path="idBacSi" class="form-control">
                            <c:forEach items="${dsND}" var="c">
                                <c:if test="${c.userRole=='ROLE_BACSI'}">
                                    <option value="${c.idNguoiDung}" style="text-align: center">${c.tenNguoiDung}</option>
                                </c:if>
                            </c:forEach>
                        </form:select>
                        <form:errors path="idBacSi"  element="div" cssClass="invalid-feedback" />
                    </div>

                    <div class="form-group"style="margin-top: 20px; display: flex" >
                        <label style="width: 40%" >Xác nhận bởi y tá</label>
                        <form:select id="xacNhanBoiYTa" path="xacNhanBoiYTa" class="form-control">
                            <c:forEach items="${dsND}" var="c">
                                <c:if test="${c.userRole=='ROLE_YTA'}">
                                    <option value="${c.idNguoiDung}" style="text-align: center">${c.tenNguoiDung}</option>
                                    <option value=""  style="text-align: center">Rỗng</option>
                                </c:if>

                            </c:forEach>
                        </form:select>
                        <form:errors path="xacNhanBoiYTa"  element="div" cssClass="invalid-feedback" />
                    </div>
                    <div class="form-group" style="margin-top: 20px; display: flex">
                        <label style="width: 40%"> Chọn ngày khám</label>
                        <form:input type="date" class="form-control" path="ngayKham" id="ngayKham" name="ngayKham"  />
                    </div>
                    

                    <div class="form-group" style="margin-top: 20px">
                        <form:input type="text" class="form-control" id="trieuChung" placeholder="Triệu chứng" name="trieuChung" path="trieuChung"/>
                    </div>
                    <div class="form-group" style="margin-top: 20px">
                        <form:input type="text" class="form-control" id="ketLuan" placeholder="Kết luận" name="ketLuan" path="ketLuan"/>
                    </div>
                    <div class="form-group" style="margin-top: 20px; display: flex">
                        <label for="sel1" class="form-label" style="width:40% ">Thanh toán</label>
                        <form:select id="isThanhToan" path="isThanhToan" class="form-control">
                            <option value="0" style="text-align: center">Chưa</option>
                            <option value="1" style="text-align: center">Rồi</option>
                        </form:select>
                        <form:errors path="isThanhToan"  element="div" cssClass="invalid-feedback" />
                    </div>

                    <div class="form-group" style="margin-top: 20px" >

                        <form:input type="text" class="form-control" id="tienKham" placeholder="Tiền Khám" name="tienKham" path="tienKham"/>
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

