<%-- 
    Document   : datlichkham
    Created on : Aug 20, 2022, 4:59:45 PM
    Author     : ADMIN
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:if test="${okMg ==1 }" >
    <script>
        window.alert("xác nhận đặt lịch thành công!");
    </script>
</c:if>

<div class="py-5" style="background-image: url('https://static.pingendo.com/cover-stripes.svg'); background-position:left center; background-size: cover;">
    <div class="container">
        <div class="row">
            <div class="p-5 col-lg-6">
                <h1 style="font-family:Serif;  font-size: 50px ">Đặt lịch NGAY</h1>
                <c:url value="/datlichkham/lichkham" var="action"/>
                <form:form method="post" action="${action}" 
                           modelAttribute="PLK">
                    <div class="form-group" style="margin-top: 20px; display: flex">
                        <label style="width: 40%"> Chọn ngày khám</label>
                        <form:input type="date" class="form-control" path="ngayKham" id="ngayKham" name="ngayKham"  />
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
                    <div style="  visibility: hidden;display: none">
                        <form:select id="idBenhNhan" path="idBenhNhan" class="form-control" >
                            <option value="${currentUser.idNguoiDung}" > IDNGUOIDUNG </option>
                        </form:select>
                    </div>

                    <div class="form-group"> 
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
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
