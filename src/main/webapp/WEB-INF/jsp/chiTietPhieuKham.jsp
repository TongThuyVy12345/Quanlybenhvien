<%-- 
    Document   : chiTietPhieuKham
    Created on : Sep 8, 2022, 7:51:37 PM
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
<h1 class="text-center">CHI TIẾT PHIẾU KHÁM</h1>
<h2 class="text-center">THÔNG TIN NGƯỜI DÙNG</h2>
<table class="table">
    <tr>
        <th>Tên bệnh nhân: ${benhnhan.tenNguoiDung} </th>
        <th>Ngày sinh: ${benhnhan.ngaySinh}</th>
    </tr>
    <tr>
        <th>Giới tính: ${benhnhan.gioiTinh}</th>
        <th>SDT: 0${benhnhan.sdt}</th>
    </tr>
</table>
<hr align="right" size="5px">
<h2 class="text-center">THÔNG TIN PHIẾU KHÁM</h2>
<table class="table">
    <tr>
        <th>Ngày Kham: ${ttphieukham.ngayKham} </th>
        <th>Bác Sĩ: ${ttphieukham.idBacSi.tenNguoiDung}</th>
    </tr>

    <tr><th>Triệu chứng : ${ttphieukham.trieuChung}</th></tr>
    <tr><th>Kết Luận : ${ttphieukham.ketLuan}</th></tr>
</table>
<hr align="right" size="5px">
<h2 class="text-center">THÔNG TIN THUỐC VÀ TIỀN KHÁM</h2>
<table class="table">
    <tr><th colspan="3"><h2 class="text-center"> Thuốc</h1></th></tr>
    <tr>
        <th>id </th>
        <th>thuốc</th>
        <th>số lượng</th>
        <th>Giá</th>
    </tr>
    <c:forEach items="${dsthuoc}" var="i">
        <tr>
            <th>${i.idThuoc.idThuoc} </th>
            <th>${i.idThuoc.tenThuoc}</th>
            <th>${i.soLuong}</th>
            <th>${i.giaThuoc}</th>
        </tr>
    </c:forEach>
        <tr>
        <th></th>
        <th></th>
        <th>Tiền khám: ${ttphieukham.tienKham}</th>
        <th>Tổng tiền: ${tongtien}</th>
    </tr>
</table>


