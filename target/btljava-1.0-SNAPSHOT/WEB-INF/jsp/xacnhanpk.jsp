<%-- 
    Document   : xacnhanPK
    Created on : Aug 19, 2022, 3:35:39 PM
    Author     : ASUS
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${bug ==1 }" >
    <script>
        window.alert("xác nhận thành công!");
    </script>
</c:if>
<c:if test="${bug !=null && bug!=1}" >
    <script>
        window.alert(${bug});
    </script>
</c:if>
<h1 class="text-center text">XÁC NHẬN PHIẾU ĐĂNG KÍ KHÁM</h1>
<div class="container">
    <form method="post">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Tên bệnh nhân</th>
                <th>Bác sĩ</th>
                <th>Ngày Khám</th>
                <th>Xác nhận</th>
            </tr>

            <c:forEach items="${dsXacNhan}" var="c">
                <tr>
                    <td>${c.idPhieuKham}</td>
                    <td>${c.idBenhNhan.tenNguoiDung}</td>
                    <td>${c.idBacSi.tenNguoiDung}</td>
                    <td>${c.ngayKham}</td>
                    <td >
                        <input type="checkbox" name="${c.idPhieuKham}" value="${c.idPhieuKham}"/>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th><input type="submit" value="XÁC NHẬN" class="btn btn-danger"/></th>
            </tr>
        </table>
    </form>
</div>