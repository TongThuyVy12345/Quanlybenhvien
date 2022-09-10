<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 style="text-align: center;color:#F73D93">QUẢN LÝ  THUỐC </h1>
<div style="margin-bottom: 20px">
    <a href="/btljava/admin/quanlyT/form_T" > <i class="fa-solid fa-circle-plus" > </i> TẠO MỚI </a>
</div>
<div class="container">
    <form >
        <table class="table" STYLE="text-align: CENTER">
            <tr>

                <th>ID </th>
                <th>Tên Thuốc</th>
                <th>Loại Thuốc</th>
                <th>Cách Dùng</th>
                <th>Giá</th>
                <th>Active</th>
                <th></th>
                <th></th>

            </tr>

            <c:forEach items="${dsTGet}" var="c">
                <tr>
                    <c:if test="${c.active==true}">                    
                        <td>${c.idThuoc}</td>
                        <td>${c.tenThuoc}</td>
                        <td>
                            ${c.idLoaiThuoc}
                        </td>
                        <td>${c.cachDung}</td>
                        <td>${c.gia}</td>
                        <td>${c.active}</td>
                        <td>
                            <a class="btn btn-default"
                               onclick="return confirm('Bạn có chắc bạn muốn xóa hồ sơ này không?');"
                               href="${pageContext.request.contextPath}/admin/quanlyT/thuoc/delete/${c.idThuoc}">
                                <span class="fa fa-trash glyphicon glyphicon-trash"></span>
                            </a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>

    </form>

</div>
