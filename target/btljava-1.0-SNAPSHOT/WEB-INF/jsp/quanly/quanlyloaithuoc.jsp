<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 style="text-align: center;color:#F73D93">QUẢN LÝ LOẠI THUỐC</h1>
<div style="margin-bottom: 20px">
    <a href="/btljava/admin/quanlyLT/form_LT" > <i class="fa-solid fa-circle-plus" > </i> TẠO MỚI </a>
</div>
<div class="container">
    <form action="<c:url value="/btljava/admin/quanlyLT"/>">
        <label for="gsearch">TÌM KIẾM </label>
        <input type="text" name="kw" placeholder="nhận tên loại thuốc" >
        <input type="submit" value="Submit" class="btn btn-success">
    </form>
    <form>
        <table class="table">
            <tr STYLE="text-align: CENTER">
                <th>ID </th>
                <th>Tên Loại Thuốc</th>
                <th></th>
                <th></th>

            </tr>
            <c:forEach items="${dsLT}" var="c" >
                <tr STYLE="text-align: CENTER">
                    <c:if test="${c.active==true}"> 
                        <td>${c.idLoaiThuoc}</td>
                        <td>${c.tenLoaiThuoc}</td>
                        <td>
                            <a class="btn btn-default"
                               onclick="return confirm('Bạn có chắc bạn muốn xóa hồ sơ này không ?');"
                               href="${pageContext.request.contextPath}/admin/quanlyLT/loaithuoc/delete/${c.idLoaiThuoc}">
                                <span class="fa fa-trash glyphicon glyphicon-trash"></span>
                            </a>
                        </td>
                        <td>
                            <a class="btn btn-default"
                               onclick="return confirm('Bạn có chắc bạn muốn sửa hồ sơ này?');"
                               href="${pageContext.request.contextPath}/loaithuoc/update/${c.idLoaiThuoc}">
                                <span class="fa-solid fa-pen-to-square"></span>
                            </a>
                        </td>
                    </c:if>
                </tr>

            </c:forEach>
        </table>

    </form>

</div>
