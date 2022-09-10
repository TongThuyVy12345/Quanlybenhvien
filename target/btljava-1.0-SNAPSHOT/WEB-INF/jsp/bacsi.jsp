<%-- 
    Document   : bacsi
    Created on : Aug 27, 2022, 8:49:30 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div class="container">
    <h1 class="text-center">THÔNG TIN NGƯỜI DÙNG</h1>
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
    <h2 class="text-center">Tiền sử bệnh án</h2>
    <table class="table table-striped">
        <tr>
            <th>Ngày khám</th>
            <th>Chuẩn đoán</th>
            <th>Thông tin</th>
        </tr>
        <c:forEach  items="${benhAns}"  var="benhAn">
            <tr>
                <th>${benhAn.ngayKham} </th>
                <th>${benhAn.ketLuan}</th>
                <th><a href="<c:url value="/phieukham/${benhAn.idPhieuKham}" />" class="btn btn-primary">Xem chi tiet</a></th>
            </tr>
        </c:forEach>
    </table>
    <hr align="right" size="5px">
    <form class="form-group" method="post">
        <h2 class="text-center">Chuẩn đoán bệnh</h2>
        <table class="table">
            <tr>
            <div class="form-floating">
                <textarea class="form-control" name="trieuChung" id="trieuChung" style="height: 200px"></textarea>
                <label for="trieuChung">Triệu chứng bệnh</label>
            </div>
            </tr>
            <tr>
            <div class="form-floating">
                <input type="text" class="form-control is-invalid" name="ketLuan" id="ketLuan">
                <label for="ketLuan">Kết luận</label>
            </div>
            </tr>
        </table>
        <input type="submit" value="XÁC NHẬN" class="btn btn-danger"/>
    </form>
    <hr align="right" size="5px">
    <h2 class="text-center">Tìm thuốc</h2>

    <table class="table">
        <tr>
            <th>
                <form>
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" name="timTheoTen" placeholder="tìm theo tên" title="tìm theo tên">
                        <button class="btn btn-outline-secondary" type="submit" >tìm</button>
                    </div>
                </form>

            </th>
            <th>
                <form>
                    <div class="input-group mb-3">
                        <input type="number" class="form-control" name="timTheoID" placeholder="tìm theo ID" title="tìm theo ID">
                        <button class="btn btn-outline-secondary" type="submit" >tìm</button>
                    </div>
                </form>

            </th>
        </tr>
    </table>


    <hr align="right" size="5px">
    <table class="table">
        <tr>
            <th>ID thuốc </th>
            <th>Tên thuốc</th>
            <th>Thêm thuốc</th>
        </tr>
        <c:forEach  items="${getThuocByName}"  var="i">
            <tr>
                <th>${i.idThuoc}</th>
                <th name="thuoc${i.idThuoc}" value="${i.idThuoc}">${i.tenThuoc}</th>
                <th><a href="#" class="btn-primary btn" onclick="themThuoc(${i.idThuoc}, '${i.tenThuoc}', ${i.idLoaiThuoc.idLoaiThuoc})">thêm thuốc</a></th>
            </tr>
        </c:forEach>
        <c:if test="${getThuocByID.idThuoc> 0}">
            <tr>
                <th>${getThuocByID.idThuoc}</th>
                <th name="thuoc${getThuocByID.idThuoc}" value="${getThuocByID.idThuoc}">${getThuocByID.tenThuoc}</th>
                <th><a href="#" class="btn-primary btn" onclick="themThuoc(${getThuocByID.idThuoc}, '${getThuocByID.tenThuoc}', ${getThuocByID.idLoaiThuoc.idLoaiThuoc})">thêm thuốc</a></th>
            </tr>
        </c:if>
    </table>
    <hr align="right" size="5px">
    <div>${dsThuoc}</div>
    <form class="form-group " method="post">
        <table class="table table-striped" name="thongTinThuoc">
            <tr><th colspan="4"><h2 class="text-center"> Thuốc</h1></th></tr>
            <tr>
                <th>id </th>
                <th>thuốc</th>
                <th>số lượng</th>
                <th>Xóa</th>
            </tr>
            <c:if test="${dsThuoc.size()<=0} || ${dsThuoc==null}">
                <tr>
                    <th class="text-center text-danger" colspan="4">  Hãy thêm thuốc</th>
                </tr>
            </c:if>
            <c:forEach items="${dsThuoc}" var="i">
                <tr>
                    <th>${i.idThuoc} </th>
                    <th name="${i.idThuoc}" value="${i.idThuoc}">${i.tenThuoc}</th>
                    <th><input type="number" value="1" name="${i.idThuoc}"/></th>
                    <th><input type="button" value="Xóa" class="btn btn-danger" onclick="xoaThuoc(${i.idThuoc})"/></th>
                </tr>
            </c:forEach>

        </table>
        <input type="submit" value="XÁC NHẬN" class="btn btn-danger"/>

    </form>
</div>
<script src="<c:url value="/js/bacsi-yta.js" />"></script>
