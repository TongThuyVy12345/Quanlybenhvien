<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 style="text-align: center; color:#F73D93">QUẢN LÝ PHIẾU KHÁM</h1>
<div style="margin-bottom: 20px">
    <a href="/btljava/admin/quanlyPK/form_PK" > <i class="fa-solid fa-circle-plus" > </i> TẠO MỚI </a>
</div>
<div class="container">
    <form >
        <table class="table">
            <tr STYLE="text-align: CENTER">
                <th>Id</th>
                <th>Tên bệnh nhân</th>
                <th>Bác sĩ</th>
                <th>Ngày Khám</th>
                <th>Triệu chứng</th>
                <th>Kết luận</th>
                <th>Tổng Tiền</th>
                <th>Xác nhận thanh toán</th>
                <th>Active</th>
                <th></th>
                <th></th>


            </tr>

            <c:forEach items="${dsPK}" var="c">
                <tr STYLE="text-align: CENTER">
                    <c:if test="${c.active==true}">  
                        <td>${c.idPhieuKham}</td>
                        <td>${c.idBenhNhan}</td>
                        <td>${c.idBacSi}</td>
                        <td  >${c.ngayKham}</td>
                        <td>${c.trieuChung}</td>
                        <td>${c.ketLuan}</td>
                        <td> <fmt:formatNumber value="${c.tienKham}" type = "currency"/></td>
                        <td>${c.isThanhToan}</td>
                        <td>${c.active}</td>
                        <td>
                            <a class="btn btn-default"
                               onclick="return confirm('Bạn có chắc bạn muốn xóa hồ sơ này không?');"
                               href="${pageContext.request.contextPath}/admin/quanlyPK/phieukham/delete/${c.idPhieuKham}">
                                <span class="fa fa-trash glyphicon glyphicon-trash"></span>
                            </a>
                        </td>

                    </c:if>
                </tr>

            </c:forEach>
        </table>

    </form>

</div>
