<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 style="text-align: center;color:#F73D93">QUẢN LÝ PHIẾU KHÁM THUỐC</h1>
<div style="margin-bottom: 20px">
    <a href="/btljava/admin/quanlyPKT/form_PKT" > <i class="fa-solid fa-circle-plus" > </i> TẠO MỚI </a>
</div>
<div class="container">
    <form >
        <table class="table" style="text-align: center">
            <tr STYLE="text-align: CENTER">
                <th>ID</th> 
                <th>ID Phiếu Khám</th>
                <th>Thuốc</th>
                <th>Số Lượng</th>
                <th>Giá</th>
                <th></th>
                <th></th>

            </tr>

                <c:forEach items="${dsPKT}" var="c">

                    <tr>
                 
                            <td>${c.idPhieuKhamThuoc}</td> 
                            <td>${c.idPhieuKham}</td>
                            <td>${c.idThuoc}</td>
                            <td>${c.soLuong}</td>
                            <td> <fmt:formatNumber value="${c.giaThuoc}" type = "currency"/></td>

                       

                    </tr>
                </c:forEach>
        </table>

    </form>

</div>