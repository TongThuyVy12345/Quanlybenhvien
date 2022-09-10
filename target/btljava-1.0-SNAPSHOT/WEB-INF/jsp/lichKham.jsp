<%-- 
    Document   : LichKham
    Created on : Sep 4, 2022, 7:57:10 PM
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
<h1 class="text-center">LỊCH KHÁM</h1>
<div class="container">
    <form method="post">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Tên bệnh nhân</th>
                <th>Ngày Khám</th>
                <th>Thông tin</th>
            </tr>

            <c:forEach items="${dsPhieuKham}" var="c">
                <tr>
                    <td>${c.idPhieuKham}</td>
                    <td>${c.idBenhNhan}</td>
                    <td>${c.ngayKham}</td>
                    <td><a href="<c:url value="lichkham/${c.idPhieuKham}" />" class="btn btn-primary"> Thông tin chi tiết</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>

</div>