<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 style="text-align: center;color:#F73D93">QUẢN LÝ ADMIN</h1>
<div style="margin-bottom: 20px">
    <a href="/btljava/superadmin/quanlyAM/form_AM" > <i class="fa-solid fa-circle-plus" > </i> TẠO MỚI </a>
</div>

<div class="container" >
    <form >
        <table class="table"style="text-align: center">

            <tr STYLE="text-align: CENTER;font-size: 15px" >
                <th>AVATAR</th>
                <th>Id </th>
                <th>Tên </th>
                <th>Tài Khoản</th>
                <th>Mật Khẩu</th>
                <th>Giới tính</th>
                <th>Chức Vụ</th>
                <th>Địa Chỉ</th>
                <th>Email</th>
                <th>Số Điện Thoại</th>
                <th>Ngày Sinh</th>
                <th>Active</th>

                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${dsAM}" var="c" >
                <tr style="font-size: 15px">
                    <c:if test="${c.userRole=='ROLE_ADMIN'}">
                        <c:if test="${c.active==true}">  
                            <td ><img src="${c.avatar}" style="width:30px" alt="avatar"></td>
                            <td>${c.idNguoiDung}</td>
                            <td>${c.tenNguoiDung}</td>
                            <td>${c.taiKhoan}</td>
                            <td style="max-width: 4rem; overflow-y: hidden ; overflow-x: scroll;">${c.matKhau}</td>
                            <td>${c.gioiTinh}</td>
                            <td style="max-width: 4rem; word-wrap: break-word">
                                <c:if test="${c.userRole=='ROLE_ADMIN'}">
                                    ADMIN
                                </c:if>
                               
                            </td>
                            <td style="max-width: 4rem; word-wrap: break-word;">${c.diaChi}
                            <td style="max-width: 6rem; word-wrap: break-word;">${c.email}</td>
                            <td style="max-width: 4rem; word-wrap: break-word;">${c.sdt}</td>
                            <td>${c.ngaySinh}</td>
                            <td >${c.active}</td>
                            <td>
                                <a class="btn btn-default"
                                   onclick="return confirm('Bạn có chắc bạn muốn xóa hồ sơ này không?');"
                                   href="${pageContext.request.contextPath}/admin/quanlyAM/admin/delete/${c.idNguoiDung}">
                                    <span class="fa fa-trash glyphicon glyphicon-trash"></span>
                                </a>
                            </td>
                        </c:if>
                    </c:if>
                </tr>
            </c:forEach>
        </table>

    </form>

</div>
