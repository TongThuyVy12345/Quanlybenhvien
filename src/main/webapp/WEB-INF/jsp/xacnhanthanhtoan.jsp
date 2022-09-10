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

<h1 class="text-center">XÁC NHẬN THANH TOÁN</h1>
<div class="container">
    <form method="post">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Tên bệnh nhân</th>
                <th>Bác sĩ</th>
                <th>Ngày Khám</th>
                <th>Tổng Tiền</th>
                <th>Thanh toán tiền mặt</th>
                <th>Thanh toán momo</th>
            </tr>

            <c:forEach items="${dsThanhToan}" var="c">
                <tr>
                    <td>${c.idPhieuKham}</td>
                    <td>${c.idBenhNhan}</td>
                    <td>${c.idBacSi}</td>
                    <td>${c.ngayKham}</td>
                    <td>
                    <fmt:formatNumber value="${c.tienKham}" type = "currency"/>
                   </td>
                    <th><button type="submit" name="idPhieuKham" value="${c.idPhieuKham}"/>Tiền Mặt</th>
                    <th><button type="reset"/>MOMO</th>
                </tr>
            </c:forEach>
        </table>
    </form>

</div>